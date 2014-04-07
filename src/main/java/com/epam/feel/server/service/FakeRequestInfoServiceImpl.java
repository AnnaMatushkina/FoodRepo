/**
 * 
 */
package com.epam.feel.server.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.epam.feel.shared.WebAppConstants;
import com.epam.feel.shared.dto.ClientDTO;
import com.epam.feel.shared.dto.ExtendedRequestDTO;
import com.epam.feel.shared.dto.ExtendedRequestGroupDTO;
import com.epam.feel.shared.dto.GroupRequestDTO;
import com.epam.feel.shared.dto.MenuDTO;
import com.epam.feel.shared.dto.RequestDTO;
import com.epam.feel.shared.dto.RequestDetailsDTO;
import com.epam.feel.shared.enums.GroupStatus;
import com.epam.feel.shared.enums.RequestStatus;
import com.epam.feel.shared.excel.Cell;
import com.epam.feel.shared.exception.EstimatedRequestDetailsException;
import com.epam.feel.shared.exception.RequestCantBeSavedException;
import com.epam.feel.shared.exception.RequestHasGroupException;
import com.epam.feel.shared.service.ClientInfoService;
import com.epam.feel.shared.service.MenuInfoService;
import com.epam.feel.shared.service.RequestInfoService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * Fake service to generate information about client's orders.
 * 
 * @author Evgeny_Kincharov
 */
public class FakeRequestInfoServiceImpl extends RemoteServiceServlet implements RequestInfoService {

    private static final long serialVersionUID = 8721180643006402020L;

    private final static Logger LOG = LoggerFactory.getLogger(FakeRequestInfoServiceImpl.class);

    private static final int REQUESTS_COUNT = 5;
    private static final int DISHES_IN_ORDER = 2;
    private List<GroupRequestDTO> resultGroups = new ArrayList<GroupRequestDTO>();

    @Autowired
    private ClientInfoService clientService;
    @Autowired
    private MenuInfoService menuService;

    @Autowired
    private HttpServletRequest request;

    private List<ExtendedRequestDTO> generateOrders(ClientDTO client) {
        List<ExtendedRequestDTO> result = new ArrayList<ExtendedRequestDTO>();
        List<MenuDTO> listMenu = menuService.getLastMenus(null, null);
        // LastElement !!!Only for Fake service (All RequestDTOs must be linked on MenuDTO in real
        // life)
        MenuDTO menu = listMenu.get(listMenu.size() - 1);
        for (int i = 0; i < REQUESTS_COUNT; i++) {
            Date dateRequest = new Date();
            ExtendedRequestDTO order = new ExtendedRequestDTO(Long.valueOf(i), dateRequest, RequestStatus.values()[i
                % RequestStatus.values().length], client, menu.getMenuName());
            List<RequestDetailsDTO> details = new ArrayList<RequestDetailsDTO>();
            for (int j = 0; j < DISHES_IN_ORDER; j++) {
                details.add(new RequestDetailsDTO((long) (i * DISHES_IN_ORDER + j), (i + j) % 3 + 1, order, menu
                    .getMenuDetails().get((i + j) % menu.getMenuDetails().size())));
            }
            order.setRequestDetails(details);
            result.add(order);
        }
        return result;
    }

    /**
     * Gets all active requests for current client from DB
     */
    @Override
    public List<RequestDTO> getActiveRequests(Long clientId) {
        LOG.debug("Run: client: {}", clientId);
        return new ArrayList<RequestDTO>(generateOrders(clientService.getCurrentClient()));
    }

    @Override
    public RequestDTO makeRequest(RequestDTO requestDTO) {
        LOG.debug("Run: requestDTO: {}", requestDTO);
        RequestDTO request = requestDTO;
        request.setClient(null);
        request.setCreateDate(new Date());
        Random rnd = new Random();
        request.setId((long) (rnd.nextFloat() * 1000));
        return request;
    }

    private List<ExtendedRequestDTO> getAllRequests() {
        LOG.debug("Run");
        ClientDTO client = clientService.getCurrentClient();
        return generateOrders(client);
    }

    private RequestDTO deleteRequest(Long requestId, String reason) {
        LOG.debug("Run: request: {}", requestId);
        RequestDTO request = generateOrders(clientService.getCurrentClient()).get(0);
        request.setStatus(RequestStatus.DELETED);
        return request;
    }

    /**
     * Completes request
     */
    @Override
    public RequestDTO completeRequest(Long requestId) {
        LOG.debug("Run: request: {}", request);
        RequestDTO request = generateOrders(clientService.getCurrentClient()).get(0);
        request.setStatus(RequestStatus.PERFORMED);
        return request;
    }

    /**
     * Sets status for request group as delivered
     */
    @Override
    public ExtendedRequestGroupDTO completeGroupRequests(Long groupId) {
        ExtendedRequestGroupDTO group = getAllGroupRequests().get(0);
        group.setStatus(GroupStatus.PERFORMED);
        return group;
    }

    /**
     * Removes request group from DB
     */
    @Override
    public void deleteGroupRequests(Long groupId, String reason) {
        LOG.debug("Run: group: {}", groupId);
        ExtendedRequestGroupDTO group = getAllGroupRequests().get(0);
        resultGroups.remove(group);
        group.setStatus(GroupStatus.DELETED);
        resultGroups.add(group);
    }

    /**
     * Accept request group from DB
     */
    @Override
    public void acceptGroupRequests(Long groupId) {
        ExtendedRequestGroupDTO group = getAllGroupRequests().get(0);
        LOG.debug("Run: group: {}", group);
        resultGroups.remove(group);
        group.setStatus(GroupStatus.ACCEPTED);
        resultGroups.add(group);
    }

    private List<ExtendedRequestGroupDTO> getAllGroupRequests() {
        ExtendedRequestGroupDTO group = new ExtendedRequestGroupDTO(new GroupRequestDTO(0l, new Date(),
            GroupStatus.DRAFT, new ArrayList<RequestDTO>(generateOrders(clientService.getCurrentClient()))));
        List<ExtendedRequestGroupDTO> resultGroups = new ArrayList<ExtendedRequestGroupDTO>(1);
        resultGroups.add(group);
        return resultGroups;
    }

    /**
     * Edit request group
     */
    @Override
    public RequestDTO editRequest(RequestDTO request, String reason) {
        LOG.debug("Run: request: {}", request);
        request.setStatus(RequestStatus.IN_PROCESS);
        return request;
    }

    /**
     * Accepts request
     */
    @Override
    public RequestDTO acceptRequest(Long requestId) {
        LOG.debug("Run: request: {}", request);
        RequestDTO request = generateOrders(clientService.getCurrentClient()).get(0);
        double currentPersonalAccount = request.getClient().getBalance();
        double bill = request.getCost();
        if (currentPersonalAccount >= bill) {
            double totalBalance = currentPersonalAccount - bill;
            request.setStatus(RequestStatus.PAID);
            request.getClient().setBalance(totalBalance);
        } else {
            request.setStatus(RequestStatus.ACCEPTED);
        }
        return request;
    }

    @Override
    public Boolean getRequestsForUser(MenuDTO menu) {
        LOG.debug("Run: menu: {}", menu);
        return true;
    }

    @Override
    public void exportGroupToExcel(List<Cell> cells) {
        ClientDTO client = clientService.getCurrentClient();
        request.getSession().setAttribute(WebAppConstants.EXPORT_EXCEL_SESSION_PARAM + client.getEmail(), cells);
    }

    @Override
    public ExtendedRequestGroupDTO getStatusOfGroup(Long requestId) {
        return null;
    }

    @Override
    public RequestDTO payRequest(Long requestId) {
        return null;
    }

    private Integer getAllRequestsCount() {
        return REQUESTS_COUNT;
    }

    public Integer getActiveRequestsCount(ClientDTO clientDTO) {
        return getAllGroupRequestsCount();
    }

    @Override
    public Integer getAllGroupRequestsCount() {
        return getAllGroupRequests().size();
    }

    @Override
    public Integer getRequestsForUserDateCount(Date dateStart, Date dateEnd) {
        return getAllRequestsCount();
    }

    @Override
    public List<ExtendedRequestGroupDTO> getAllGroupRequests(int startRow, int maxRows, Map<String, Boolean> orderList) {
        List<ExtendedRequestGroupDTO> requests = getAllGroupRequests();
        int end = Math.min(startRow + maxRows, requests.size());
        return new ArrayList<ExtendedRequestGroupDTO>(requests.subList(startRow, end));
    }

    private List<ExtendedRequestDTO> getAllRequests(int startRow, int maxRows, Map<String, Boolean> orderList) {
        List<ExtendedRequestDTO> requests = getAllRequests();
        int end = Math.min(startRow + maxRows, requests.size());
        return new ArrayList<ExtendedRequestDTO>(requests.subList(startRow, end));
    }

    @Override
    public List<ExtendedRequestDTO> getRequestsForUserDate(Date dateStart, Date dateEnd, int startRow, int maxRows,
        Map<String, Boolean> orderList) {
        return getAllRequests(startRow, maxRows, orderList);
    }

    @Override
    public List<ExtendedRequestDTO> getRequestsByDishName(int startRow, int maxRows, String dishName,
        Map<String, Boolean> orderList) {
        return getAllRequests(startRow, maxRows, orderList);
    }

    @Override
    public Integer getRequestsByDishNameCount(String dishName) {
        return getAllRequestsCount();
    }

    @Override
    public boolean makeRequestGroupByMenu(Long menuId) {
        return false;
    }

    @Override
    public Integer getActiveRequestsByMenuCount(Long menuId) {
        return 0;
    }

    @Override
    public List<RequestDTO> getActiveRequestsByMenu(int startRow, int maxRows, Long menuId,
        Map<String, Boolean> orderList) {
        return getActiveRequests(null);
    }

    @Override
    public RequestDTO tryToDeleteRequest(Long id, boolean force, String reason) throws RequestHasGroupException {
        return deleteRequest(id, reason);
    }

    @Override
    public RequestDTO tryToDeclineRequest(Long id, boolean force, String reason) throws RequestHasGroupException {
        LOG.debug("Run: request: {}", request);
        RequestDTO request = generateOrders(clientService.getCurrentClient()).get(0);
        request.setStatus(RequestStatus.DECLINED);
        return request;
    }

    @Override
    public RequestDTO deleteRequest(Long id) {
        return deleteRequest(id, null);
    }

    @Override
    public RequestDTO editRequest(RequestDTO requestDTO) throws EstimatedRequestDetailsException,
        RequestCantBeSavedException {
        return editRequest(requestDTO, null);
    }
}
