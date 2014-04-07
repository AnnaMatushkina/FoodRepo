package com.epam.feel.server.service;

import static com.epam.feel.server.IEpamFeelMessages.MESSAGES;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import com.epam.feel.server.dao.ClientDao;
import com.epam.feel.server.dao.MenuDao;
import com.epam.feel.server.dao.RequestDao;
import com.epam.feel.server.model.Account;
import com.epam.feel.server.model.Client;
import com.epam.feel.server.model.ExtendedRequestGroup;
import com.epam.feel.server.model.Menu;
import com.epam.feel.server.model.MenuDetails;
import com.epam.feel.server.model.Request;
import com.epam.feel.server.model.RequestGroup;
import com.epam.feel.server.notification.EventType;
import com.epam.feel.server.notification.IEventQueue;
import com.epam.feel.server.notification.impl.EventGroupRequestDTO;
import com.epam.feel.server.notification.impl.EventRequestDTO;
import com.epam.feel.server.util.DTOToEntity;
import com.epam.feel.server.util.EntityToDTO;
import com.epam.feel.server.util.HistoryUtils;
import com.epam.feel.shared.WebAppConstants;
import com.epam.feel.shared.dto.AccountDTO;
import com.epam.feel.shared.dto.ClientDTO;
import com.epam.feel.shared.dto.ExtendedRequestDTO;
import com.epam.feel.shared.dto.ExtendedRequestGroupDTO;
import com.epam.feel.shared.dto.GroupRequestDTO;
import com.epam.feel.shared.dto.MenuDTO;
import com.epam.feel.shared.dto.OperationDTO;
import com.epam.feel.shared.dto.RequestDTO;
import com.epam.feel.shared.dto.RequestDetailsDTO;
import com.epam.feel.shared.dto.TransactionDTO;
import com.epam.feel.shared.enums.GroupStatus;
import com.epam.feel.shared.enums.OperationType;
import com.epam.feel.shared.enums.RequestStatus;
import com.epam.feel.shared.enums.TransactionType;
import com.epam.feel.shared.excel.Cell;
import com.epam.feel.shared.exception.EstimatedRequestDetailsException;
import com.epam.feel.shared.exception.RequestCantBeSavedException;
import com.epam.feel.shared.exception.RequestHasGroupException;
import com.epam.feel.shared.service.ClientInfoService;
import com.epam.feel.shared.service.HistoryInfoService;
import com.epam.feel.shared.service.RequestInfoService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * Interface for getting order information.
 * 
 * @author Artem_Tumasov
 */

@SuppressWarnings ("deprecation")
public class RequestInfoServiceImpl extends RemoteServiceServlet implements RequestInfoService, HasRequestDaoSetter {
    private static final long serialVersionUID = -8772398442456771835L;

    private final static Logger LOG = LoggerFactory.getLogger(RequestInfoServiceImpl.class);

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private RequestDao dao;

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private ClientInfoService clientService;

    @Autowired
    private HistoryInfoService historyService;

    @Autowired
    private IEventQueue eventProcessor;

    public RequestInfoServiceImpl() {}

    private OperationDTO createOperation(OperationType type, String text) {
        return HistoryUtils.createOperation(type, clientService.getCurrentClient().getName(), text);
    }

    private TransactionDTO createTransaction(AccountDTO account, Double value, TransactionType type) {
        return HistoryUtils.createTransaction(account, clientService.getCurrentClient().getName(), value, type);
    }

    @Override
    public List<ExtendedRequestDTO> getRequestsByDishName(int startRow, int maxRows, String dishName,
        Map<String, Boolean> orderList) {
        LOG.debug("Gets requests by dish name {}; startRow {}; maxRows {}", new Object[] {dishName, startRow, maxRows});
        if (StringUtils.hasText(dishName)) {
            return EntityToDTO.convertExtendedRequestList(dao.getRequestsByDishName(startRow, maxRows, dishName.trim(),
                orderList));
        } else {
            return EntityToDTO.convertExtendedRequestList(dao.getAllRequests(startRow, maxRows, orderList));
        }
    }

    @Override
    public Integer getRequestsByDishNameCount(String dishName) {
        LOG.debug("Gets count of requests by dish name {}", dishName);
        if (StringUtils.hasText(dishName)) {
            return dao.getRequestsByDishNameCount(dishName);
        } else {
            return dao.getAllRequestsCount();
        }
    }

    /**
     * Gets all active requests for client from DB
     */
    @Override
    public List<RequestDTO> getActiveRequests(Long clientId) {
        LOG.debug("Gets all active requests for client from DB: clientDTO: {}", clientId);
        Client client = clientDao.getClient(clientId);
        List<RequestStatus> requestStatusList = new ArrayList<RequestStatus>();
        requestStatusList.add(RequestStatus.ACCEPTED);
        requestStatusList.add(RequestStatus.IN_PROCESS);

        return EntityToDTO.convertRequestList(dao.getRequests(client, requestStatusList));
    }

    @Override
    public List<ExtendedRequestDTO> getRequestsForUserDate(Date dateStart, Date dateEnd, int startRow, int maxRows,
        Map<String, Boolean> orderList) {
        LOG.debug("Gets requests for user: date: {}", new Date[] {dateStart, dateEnd});
        Client client = DTOToEntity.convertClient(clientService.getCurrentClient());
        if (dateStart == null) {
            dateStart = new Date(0l);
        }
        if (dateEnd == null) {
            dateEnd = new Date();
        }
        return EntityToDTO.convertExtendedRequestList(dao.getRequestsClientDate(client, dateStart, dateEnd, startRow,
            maxRows, orderList));
    }

    @Override
    public Integer getRequestsForUserDateCount(Date dateStart, Date dateEnd) {
        LOG.debug("Gets count of requests for user: date: {}", new Date[] {dateStart, dateEnd});
        Client client = DTOToEntity.convertClient(clientService.getCurrentClient());
        if (dateStart == null) {
            dateStart = new Date(0l);
        }
        if (dateEnd == null) {
            dateEnd = new Date();
        }
        return dao.getRequestsClientDateCount(client, dateStart, dateEnd);
    }

    @Override
    public Boolean getRequestsForUser(MenuDTO menuDTO) {
        LOG.debug("Get requests for current user: menuDTO: {}", menuDTO);
        Client client = DTOToEntity.convertClient(clientService.getCurrentClient());
        Menu menu = DTOToEntity.convertMenu(menuDTO);
        return dao.getRequests(menu, client);
    }

    /**
     * Makes request of client
     * 
     * @throws EstimatedRequestDetailsException
     */
    @Transactional (readOnly = false)
    @Override
    public RequestDTO makeRequest(RequestDTO requestDTO) throws EstimatedRequestDetailsException {
        LOG.debug("Makes request of client: requestDTO: {}", requestDTO);
        RequestDTO request = saveRequest(requestDTO);
        historyService.saveOperation(createOperation(OperationType.REQUEST_CHANGED,
            MESSAGES.makingRequest(String.valueOf(request.getId()))));
        return request;
    }

    /**
     * Edit request
     * 
     * @throws EstimatedRequestDetailsException
     */
    @Transactional (readOnly = false)
    @Override
    public RequestDTO editRequest(RequestDTO requestDTO, String reason) throws EstimatedRequestDetailsException {
        LOG.debug("Edit request: requestDTO: {}", requestDTO);
        RequestDTO request = saveRequest(requestDTO);
        historyService.saveOperation(createOperation(OperationType.REQUEST_CHANGED,
            MESSAGES.editingRequest(String.valueOf(request.getId()))));
        if (reason != null) {
            eventProcessor.push(new EventRequestDTO(request, EventType.CHANGED, reason, clientService
                .getCurrentClient().getEmail()));
        }
        return request;
    }

    /**
     * Edit request
     * 
     * @throws EstimatedRequestDetailsException
     *             , RequestCantBeSavedException
     */
    @Override
    public RequestDTO editRequest(RequestDTO requestDTO) throws EstimatedRequestDetailsException,
        RequestCantBeSavedException {
        LOG.debug("Edit request: requestDTO: {}", requestDTO);

        List<RequestGroup> list = dao
            .getGroupForRequest(DTOToEntity.convertRequest(requestDTO, requestDTO.getClient()));

        RequestGroup group = list.isEmpty() ? null : list.iterator().next();
        if (group == null || group.getStatus() == GroupStatus.DRAFT) {
            if (requestDTO.getStatus() == RequestStatus.DECLINED) {
                requestDTO.setStatus(RequestStatus.IN_PROCESS);
            }
            if (RequestStatus.IN_PROCESS == requestDTO.getStatus()) {
                if (requestDTO.getRequestDetails().isEmpty()) {
                    throw new RequestCantBeSavedException(RequestCantBeSavedException.Type.EMPTY_REQUEST);
                } else {
                    return editRequest(requestDTO, null);
                }
            } else {
                throw new RequestCantBeSavedException(RequestCantBeSavedException.Type.NOT_IN_PROCESS_REQUEST);
            }
        } else {
            throw new RequestCantBeSavedException(RequestCantBeSavedException.Type.REGISTRED_REQUEST);
        }

    }

    private RequestDTO saveRequest(RequestDTO requestDTO) throws EstimatedRequestDetailsException {
        ClientDTO clientDTO = requestDTO.getClient();
        if (clientDTO == null) {
            // if new
            clientDTO = clientService.getCurrentClient();
        }
        for (RequestDetailsDTO requestDetails : requestDTO.getRequestDetails()) {
            MenuDetails details = DTOToEntity.convertMenuDetails(requestDetails.getMenuDetails());
            Request request = DTOToEntity.convertRequest(requestDTO, clientDTO);
            final int count = requestDetails.getCount();
            final int max = details.getMaxCount();

            if (max != MenuDetails.UNESTIMATABLE_COUNT) {
                final int already_requested = dao.getRequestedMenuDetails(details, request).intValue();

                if (max < count + already_requested) {
                    throw new EstimatedRequestDetailsException(requestDetails.getMenuDetails(), max - already_requested);
                }
            }
        }

        Request request = DTOToEntity.convertRequest(requestDTO, clientDTO);

        return EntityToDTO.convertRequest(dao.saveRequest(request), clientDTO);
    }

    /**
     * Accepts request
     */
    @Transactional (readOnly = false)
    @Override
    public RequestDTO acceptRequest(Long requestId) {
        LOG.debug("Accepts request: requestDTO: {}", requestId);
        Request request = dao.getRequest(requestId);
        request.setStatus(RequestStatus.ACCEPTED);
        Account oldAccount = new Account(request.getClient());
        Account account = moveMoney(oldAccount, request.getCost());
        request.getClient().setBalance(account.getBalance());
        request.getClient().setAdvance(account.getAdvance());

        RequestDTO requestDTO = EntityToDTO.convertRequest(dao.saveRequest(request));

        historyService.saveOperation(createOperation(OperationType.REQUEST_CHANGED,
            MESSAGES.acceptingRequest(String.valueOf(requestDTO.getId()))));
        historyService.saveTransaction(createTransaction(EntityToDTO.convertAccount(oldAccount), -request.getCost(),
            TransactionType.PAY_FOR_REQUEST));
        return requestDTO;
    }

    /**
     * Pay request
     */
    @Transactional (readOnly = false)
    @Override
    public RequestDTO payRequest(Long requestId) {
        LOG.debug("Pays request: requestDTO: {}", requestId);
        Request request = dao.getRequest(requestId);
        request.setStatus(RequestStatus.PAID);
        Client client = request.getClient();
        Double cost = request.getCost();
        Double advance = client.getAdvance();
        client.setAdvance(advance - cost);
        clientDao.saveClient(client);

        RequestDTO requestDTO = EntityToDTO.convertRequest(dao.saveRequest(request));

        historyService.saveOperation(createOperation(OperationType.REQUEST_CHANGED,
            MESSAGES.paymentForRequest(String.valueOf(requestDTO.getId()))));
        return requestDTO;
    }

    @Override
    public RequestDTO tryToDeleteRequest(Long id, boolean deleteGroup, String reason) throws RequestHasGroupException {
        Request request = dao.getRequest(id);
        List<RequestGroup> list = dao.getGroupForRequest(request);
        if (list.isEmpty()) {
            return deleteRequest(id, reason);
        } else if (deleteGroup) {
            deleteRequestFromGroup(list.get(0).getId(), id, reason);
            return deleteRequest(id, reason);
        } else {
            throw new RequestHasGroupException();
        }
    }

    @Transactional (readOnly = false)
    @Override
    public RequestDTO deleteRequest(Long id) {
        Request request = dao.getRequest(id);
        List<RequestGroup> list = dao.getGroupForRequest(request);
        if (!list.isEmpty()) {
            deleteRequestFromGroup(list.get(0).getId(), id);
        }
        return deleteRequest(id, null);
    }

    @Transactional (readOnly = false)
    @Override
    public RequestDTO tryToDeclineRequest(Long id, boolean deleteGroup, String reason) throws RequestHasGroupException {
        Request request = dao.getRequest(id);
        List<RequestGroup> list = dao.getGroupForRequest(request);
        if (list.isEmpty()) {
            return declineRequest(id, reason);
        } else if (deleteGroup) {
            deleteRequestFromGroup(list.get(0).getId(), id, reason);
            return declineRequest(id, reason);
        } else {
            throw new RequestHasGroupException();
        }
    }

    private RequestDTO declineRequest(Long id, String reason) {
        RequestDTO requestDTO = EntityToDTO.convertRequest(dao.getRequest(id));
        LOG.debug("Declines request: requestDTO: {}", requestDTO);
        requestDTO.setStatus(RequestStatus.DECLINED);

        ClientDTO clientDTO = requestDTO.getClient();
        Request request = DTOToEntity.convertRequest(requestDTO, clientDTO);
        request = dao.saveRequest(request);
        clientDTO = EntityToDTO.convertClient(request.getClient());
        RequestDTO result = EntityToDTO.convertRequest(request, clientDTO);

        historyService.saveOperation(createOperation(OperationType.REQUEST_CHANGED,
            MESSAGES.decliningRequest(String.valueOf(result.getId()))));

        eventProcessor.push(new EventRequestDTO(requestDTO, EventType.DECLINED, reason, clientService
            .getCurrentClient().getEmail()));
        return result;
    }

    private RequestDTO deleteRequest(Long id, String reason) {
        Request request = dao.getRequest(id);
        RequestDTO requestDTO = EntityToDTO.convertRequest(deleteRequest(request));

        if (StringUtils.hasText(reason))
            eventProcessor.push(new EventRequestDTO(EntityToDTO.convertRequest(request), EventType.DELETED, reason,
                clientService.getCurrentClient().getEmail()));
        return requestDTO;
    }

    private Request deleteRequest(Request request) {
        LOG.debug("Removes request: requestDTO: {}", request);
        if (request.getStatus() == RequestStatus.ACCEPTED) {
            Account oldAccount = new Account(request.getClient());
            Account account = moveMoney(oldAccount, -request.getCost());
            request.getClient().setBalance(account.getBalance());
            request.getClient().setAdvance(account.getAdvance());
            clientDao.saveClient(request.getClient());
            historyService.saveTransaction(createTransaction(EntityToDTO.convertAccount(oldAccount), request.getCost(),
                TransactionType.PAYBACK));
        } else if (request.getStatus() == RequestStatus.PAID) {
            // getting fresh account from persistence context
            Client client = request.getClient();
            Account account = new Account(client);
            Double balance = client.getBalance();
            balance += request.getCost();
            client.setBalance(balance);
            clientDao.saveClient(client);
            historyService.saveTransaction(createTransaction(EntityToDTO.convertAccount(account), request.getCost(),
                TransactionType.PAYBACK));
        }
        request.setStatus(RequestStatus.DELETED);
        request = dao.saveRequest(request);

        historyService.saveOperation(createOperation(OperationType.REQUEST_CHANGED,
            MESSAGES.removingRequest(String.valueOf(request.getId()))));
        return request;
    }

    private void deleteRequestFromGroup(Long id, Long requestId, String reason) {
        RequestGroup group = innerDeleteRequestFromGroup(id, requestId, false);
        deleteRequestGroupWithoutDeletingRequests(group, reason);
    }

    private void deleteRequestFromGroup(Long id, Long requestId) {
        innerDeleteRequestFromGroup(id, requestId, true);
    }

    private RequestGroup innerDeleteRequestFromGroup(Long groupId, Long requestId, boolean deleteGroupIfEmpty) {
        LOG.debug("Deletes request from group : requestDTO: {}", requestId);
        RequestGroup requestGroup = dao.getRequestGroup(groupId);
        Iterator<Request> iterator = requestGroup.getRequests().iterator();
        while (iterator.hasNext()) {
            Request request = iterator.next();
            if (request.getId().equals(requestId)) {
                iterator.remove();
                break;
            }
        }
        if (deleteGroupIfEmpty && requestGroup.getRequests().isEmpty()) {
            dao.removeRequestGroup(requestGroup);
            return null;
        }
        requestGroup = dao.saveRequestGroup(requestGroup);
        historyService.saveOperation(createOperation(OperationType.REQUEST_CHANGED,
            MESSAGES.removingRequest(String.valueOf(requestId))));
        return requestGroup;
    }

    /**
     * Completes request
     */
    @Transactional (readOnly = false)
    @Override
    public RequestDTO completeRequest(Long id) {
        RequestDTO requestDTO = EntityToDTO.convertRequest(dao.getRequest(id));
        return completeRequest(requestDTO);
    }

    private RequestDTO completeRequest(RequestDTO requestDTO) {
        LOG.debug("Completes request: requestDTO: {}", requestDTO);
        requestDTO.setStatus(RequestStatus.PERFORMED);
        ClientDTO clientDTO = requestDTO.getClient();
        Request request = DTOToEntity.convertRequest(requestDTO, clientDTO);
        request = dao.saveRequest(request);
        clientDTO = EntityToDTO.convertClient(request.getClient());
        RequestDTO result = EntityToDTO.convertRequest(request, clientDTO);

        historyService.saveOperation(createOperation(OperationType.REQUEST_CHANGED,
            MESSAGES.complitingRequest(String.valueOf(result.getId()))));
        eventProcessor.push(new EventRequestDTO(requestDTO, EventType.PERFORMED, clientService.getCurrentClient()
            .getEmail()));
        return result;
    }

    @Override
    public List<ExtendedRequestGroupDTO> getAllGroupRequests(int startRow, int maxRows, Map<String, Boolean> orderList) {
        LOG.debug("Gets all group requests from DB startRow {}; maxRows {}", new Integer[] {startRow, maxRows});
        return EntityToDTO.convertExtendedRequestGroupList(dao.getAllRequestGroups(startRow, maxRows, orderList));
    }

    @Override
    public Integer getAllGroupRequestsCount() {
        LOG.debug("Gets count of group requests from DB");
        return dao.getAllRequestGroupsCount();
    }

    @Transactional (readOnly = false)
    @Override
    public void acceptGroupRequests(Long groupId) {
        LOG.debug("Accept group request in DB: group: {}", groupId);
        RequestGroup group = dao.getRequestGroup(groupId);
        group.setStatus(GroupStatus.ACCEPTED);
        GroupRequestDTO dto = payGroupRequests(new ExtendedRequestGroupDTO(EntityToDTO.convertRequestGroup(group)));
        dao.saveRequestGroup(DTOToEntity.convertRequestGroup(dto));
        historyService.saveOperation(createOperation(OperationType.REQUEST_GROUP_CHANGED,
            MESSAGES.acceptingRequest(String.valueOf(groupId))));
    }

    private ExtendedRequestGroupDTO payGroupRequests(ExtendedRequestGroupDTO group) {
        LOG.debug("Pay group requsts: group {}", group);
        ExtendedRequestGroupDTO result = group;
        Map<Long, ClientDTO> clients = new HashMap<Long, ClientDTO>();
        List<RequestDTO> requestList = new ArrayList<RequestDTO>();
        for (RequestDTO requestDTO : group.getRequests()) {
            if (requestDTO.getStatus() == RequestStatus.ACCEPTED) {
                requestDTO = payRequest(requestDTO.getId());
                long clientId = requestDTO.getClient().getId();
                if (clients.containsKey(clientId)) {
                    requestDTO.setClient(clients.get(clientId));
                }
                clients.put(requestDTO.getClient().getId(), requestDTO.getClient());
                requestList.add(requestDTO);
            }
        }
        return result;
    }

    /**
     * Sets status for request group as delivered
     */
    @Transactional (readOnly = false)
    @Override
    public ExtendedRequestGroupDTO completeGroupRequests(Long groupId) {
        LOG.debug("Sets status for request group as delivered: group: {}", groupId);
        RequestGroup rg = dao.getRequestGroup(groupId);
        ExtendedRequestGroupDTO group = new ExtendedRequestGroupDTO(EntityToDTO.convertRequestGroup(rg));
        for (RequestDTO req : group.getRequests()) {
            completeRequest(req);
        }
        group.setStatus(GroupStatus.PERFORMED);
        dao.saveRequestGroup(DTOToEntity.convertRequestGroup(group));

        historyService.saveOperation(createOperation(OperationType.REQUEST_GROUP_CHANGED,
            MESSAGES.deliveringRequestGroup(String.valueOf(groupId))));
        return group;
    }

    /**
     * Removes request group
     */
    @Transactional (readOnly = false)
    @Override
    public void deleteGroupRequests(Long groupId, String reason) {
        LOG.debug("Removes request group: group: {}", groupId);
        RequestGroup requestGroup = dao.getRequestGroup(groupId);
        deleteRequestGroup(requestGroup, reason);
    }

    private void deleteRequestGroupWithoutDeletingRequests(RequestGroup requestGroup, String reason) {
        deleteRequestGroup(requestGroup, false, reason);
    }

    private void deleteRequestGroup(RequestGroup requestGroup, String reason) {
        deleteRequestGroup(requestGroup, true, reason);
    }

    private void deleteRequestGroup(RequestGroup requestGroup, boolean canDeleteRequests, String reason) {
        if (requestGroup.getStatus() != GroupStatus.DRAFT && reason != null) {
            historyService.saveOperation(createOperation(OperationType.REQUEST_GROUP_CHANGED,
                MESSAGES.removingRequestGroup(String.valueOf(requestGroup.getId()))));
            if (canDeleteRequests) {
                if (requestGroup.getStatus() == GroupStatus.ACCEPTED) {
                    for (Request request : requestGroup.getRequests()) {
                        deleteRequest(request);
                    }
                }
                eventProcessor.push(new EventGroupRequestDTO(EntityToDTO.convertRequestGroup(requestGroup),
                    EventType.DELETED, reason, clientService.getCurrentClient().getEmail()));
            }
        }
        dao.removeRequestGroup(requestGroup);
    }

    @Override
    public void exportGroupToExcel(List<Cell> cells) {
        ClientDTO client = clientService.getCurrentClient();
        request.getSession().setAttribute(WebAppConstants.EXPORT_EXCEL_SESSION_PARAM + client.getEmail(), cells);
    }

    @Override
    public ExtendedRequestGroupDTO getStatusOfGroup(Long requestId) {
        Request request = dao.getRequest(requestId);
        List<RequestGroup> list = dao.getGroupForRequest(request);
        if (list.isEmpty())
            return null;
        List<GroupRequestDTO> groupRequestDTOs = EntityToDTO.convertRequestGroupList(list);
        return new ExtendedRequestGroupDTO(groupRequestDTOs.get(0));
    }

    private Account moveMoney(Account oldAccount, Double value) {
        Account account = oldAccount.clone();
        Double balance = account.getBalance();
        Double advance = account.getAdvance();
        balance -= value;
        advance += value;
        account.setBalance(balance);
        account.setAdvance(advance);
        return clientDao.saveAccount(account);
    }

    @Transactional (readOnly = false)
    @Override
    public boolean makeRequestGroupByMenu(Long menuId) {
        return makeRequestGroupByMenu(menuDao.getMenu(menuId));
    }

    private boolean makeRequestGroupByMenu(Menu menu) {
        ExtendedRequestGroup extendedRequestGroup = dao.getActiveGroupRequestsByMenu(menu);
        RequestGroup requestGroup = extendedRequestGroup != null ? new RequestGroup(extendedRequestGroup) : null;
        if (requestGroup != null) {
            dao.removeRequestGroup(requestGroup);
        }
        requestGroup = makeRequestGroup(menu);
        if (requestGroup == null) {
            return false;
        } else {
            assert !requestGroup.getRequests().isEmpty();
            dao.saveRequestGroup(requestGroup);
            return true;
        }
    }

    private RequestGroup makeRequestGroup(Menu menu) {
        List<Request> requests = dao.getActiveRequestsByMenuDetails(menu.getMenuDetails());
        if (requests.isEmpty()) {
            return null;
        }
        return new RequestGroup(new Date(), GroupStatus.DRAFT, new HashSet<Request>(requests));
    }

    @Override
    public List<RequestDTO> getActiveRequestsByMenu(int startRow, int maxRows, Long menuId,
        Map<String, Boolean> orderList) {
        LOG.debug("Gets active requests by menu from DB stratRow {}; maxRow {}; menuId {}", new Object[] {startRow,
                maxRows, menuId});
        Menu menu = menuDao.getMenu(menuId);
        return EntityToDTO.convertRequestList(dao.getActiveRequestsByMenuDetails(startRow, maxRows,
            menu.getMenuDetails(), orderList));
    }

    @Override
    public Integer getActiveRequestsByMenuCount(Long menuId) {
        LOG.debug("Gets count of active request by menu from DB");
        Menu menu = menuDao.getMenu(menuId);
        return dao.getActiveRequestsByMenuDetailsCount(menu.getMenuDetails());
    }

    @Override
    @Deprecated
    public void setRequestDao(RequestDao dao) {
        this.dao = dao;
    }

}
