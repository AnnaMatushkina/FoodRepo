package com.epam.feel.shared.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.epam.feel.shared.dto.ExtendedRequestDTO;
import com.epam.feel.shared.dto.ExtendedRequestGroupDTO;
import com.epam.feel.shared.dto.MenuDTO;
import com.epam.feel.shared.dto.RequestDTO;
import com.epam.feel.shared.excel.Cell;
import com.epam.feel.shared.exception.EstimatedRequestDetailsException;
import com.epam.feel.shared.exception.RequestCantBeSavedException;
import com.epam.feel.shared.exception.RequestHasGroupException;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Interface for getting order information.
 * 
 * @author Evgeny_Kincharov
 */
@RemoteServiceRelativePath ("springGwtServices/requestinfoservice")
public interface RequestInfoService extends RemoteService {

    public List<RequestDTO> getActiveRequests(Long clientId);

    public RequestDTO makeRequest(RequestDTO requestDTO) throws EstimatedRequestDetailsException;

    public RequestDTO editRequest(RequestDTO request, String reason) throws EstimatedRequestDetailsException;

    public RequestDTO acceptRequest(Long requestId);

    public RequestDTO payRequest(Long requestId);

    public RequestDTO completeRequest(Long requestId);

    public Boolean getRequestsForUser(MenuDTO menuDTO);

    public void exportGroupToExcel(List<Cell> cells);

    public Integer getAllGroupRequestsCount();

    public Integer getRequestsForUserDateCount(Date dateStart, Date dateEnd);

    public List<ExtendedRequestGroupDTO> getAllGroupRequests(int startRow, int maxRows, Map<String, Boolean> orderList);

    public List<ExtendedRequestDTO> getRequestsForUserDate(Date dateStart, Date dateEnd, int startRow, int maxRows,
        Map<String, Boolean> orderList);

    public List<ExtendedRequestDTO> getRequestsByDishName(int startRow, int maxRows, String dishName,
        Map<String, Boolean> orderList);

    public Integer getRequestsByDishNameCount(String dishName);

    public boolean makeRequestGroupByMenu(Long menuId);

    public Integer getActiveRequestsByMenuCount(Long menuId);

    public ExtendedRequestGroupDTO completeGroupRequests(Long groupId);

    public void deleteGroupRequests(Long groupId, String reason);

    public void acceptGroupRequests(Long groupId);

    public ExtendedRequestGroupDTO getStatusOfGroup(Long requestId);

    public List<RequestDTO> getActiveRequestsByMenu(int startRow, int maxRows, Long menuId,
        Map<String, Boolean> orderList);

    public RequestDTO tryToDeleteRequest(Long id, boolean force, String reason) throws RequestHasGroupException;

    public RequestDTO tryToDeclineRequest(Long id, boolean force, String reason) throws RequestHasGroupException;

    public RequestDTO deleteRequest(Long id);

    public RequestDTO editRequest(RequestDTO requestDTO) throws EstimatedRequestDetailsException,
        RequestCantBeSavedException;

}
