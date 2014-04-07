package com.epam.feel.shared.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.epam.feel.shared.dto.ExtendedRequestDTO;
import com.epam.feel.shared.dto.ExtendedRequestGroupDTO;
import com.epam.feel.shared.dto.MenuDTO;
import com.epam.feel.shared.dto.RequestDTO;
import com.epam.feel.shared.excel.Cell;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * GWT-RPC service asynchronous (client-side) interface.
 * 
 * @see com.epam.feel.shared.service.RequestInfoService
 */
public interface RequestInfoServiceAsync {

    void getActiveRequests(Long clientId, AsyncCallback<List<RequestDTO>> callback);

    void makeRequest(RequestDTO requestDTO, AsyncCallback<RequestDTO> callback);

    void editRequest(RequestDTO request, String reason, AsyncCallback<RequestDTO> callback);

    void acceptRequest(Long requestId, AsyncCallback<RequestDTO> callback);

    void payRequest(Long requestId, AsyncCallback<RequestDTO> callback);

    void completeRequest(Long requestId, AsyncCallback<RequestDTO> callback);

    void completeGroupRequests(Long groupId, AsyncCallback<ExtendedRequestGroupDTO> callback);

    void deleteGroupRequests(Long groupId, String reason, AsyncCallback<Void> callback);

    void getRequestsForUser(MenuDTO menuDTO, AsyncCallback<Boolean> callback);

    void exportGroupToExcel(List<Cell> cells, AsyncCallback<Void> callback);

    void getStatusOfGroup(Long requestId, AsyncCallback<ExtendedRequestGroupDTO> callback);

    void getAllGroupRequestsCount(AsyncCallback<Integer> callback);

    void getRequestsForUserDateCount(Date dateStart, Date dateEnd, AsyncCallback<Integer> callback);

    void getAllGroupRequests(int startRow, int maxRows, Map<String, Boolean> orderList,
        AsyncCallback<List<ExtendedRequestGroupDTO>> callback);

    void getRequestsForUserDate(Date dateStart, Date dateEnd, int startRow, int maxRows,
        Map<String, Boolean> orderList, AsyncCallback<List<ExtendedRequestDTO>> callback);

    void getRequestsByDishName(int startRow, int maxRows, String dishName, Map<String, Boolean> orderList,
        AsyncCallback<List<ExtendedRequestDTO>> callback);

    void getRequestsByDishNameCount(String dishName, AsyncCallback<Integer> callback);

    void makeRequestGroupByMenu(Long menuId, AsyncCallback<Boolean> callback);

    void getActiveRequestsByMenu(int startRow, int maxRows, Long menuId, Map<String, Boolean> orderList,
        AsyncCallback<List<RequestDTO>> callback);

    void getActiveRequestsByMenuCount(Long menuId, AsyncCallback<Integer> callback);

    void acceptGroupRequests(Long groupId, AsyncCallback<Void> callback);

    void tryToDeleteRequest(Long id, boolean force, String reason, AsyncCallback<RequestDTO> callback);

    void tryToDeclineRequest(Long id, boolean force, String reason, AsyncCallback<RequestDTO> callback);

    void deleteRequest(Long id, AsyncCallback<RequestDTO> callback);

    void editRequest(RequestDTO requestDTO, AsyncCallback<RequestDTO> callback);
}
