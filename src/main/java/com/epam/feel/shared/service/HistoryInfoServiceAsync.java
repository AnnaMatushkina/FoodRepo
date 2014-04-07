package com.epam.feel.shared.service;

import java.util.List;
import java.util.Map;
import com.epam.feel.shared.dto.NotificationDTO;
import com.epam.feel.shared.dto.OperationDTO;
import com.epam.feel.shared.dto.TransactionDTO;
import com.epam.feel.shared.enums.OperationType;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * GWT-RPC service asynchronous (client-side) interface.
 * 
 * @see com.epam.feel.shared.service.HistoryInfoService
 */
public interface HistoryInfoServiceAsync {

    void saveTransaction(TransactionDTO transaction, AsyncCallback<TransactionDTO> callback);

    void saveNotification(NotificationDTO notificaction, AsyncCallback<NotificationDTO> callback);

    void saveOperation(OperationDTO operation, AsyncCallback<OperationDTO> callback);

    void getAllTransactionsCount(AsyncCallback<Integer> callback);

    void getAllNotificationsCount(AsyncCallback<Integer> callback);

    void getOperationsByTypeCount(OperationType type, AsyncCallback<Integer> callback);

    void getTransactionsOfCurrentClientCount(AsyncCallback<Integer> callback);

    void getAllTransactions(int startRow, int maxRows, Map<String, Boolean> orderList,
        AsyncCallback<List<TransactionDTO>> callback);

    void getTransactionsOfCurrentClient(int startRow, int maxRows, Map<String, Boolean> orderList,
        AsyncCallback<List<TransactionDTO>> callback);

    void getAllNotifications(int startRow, int maxRows, Map<String, Boolean> orderList,
        AsyncCallback<List<NotificationDTO>> callback);

    void getOperationsByType(OperationType type, int startRow, int maxRows, Map<String, Boolean> orderList,
        AsyncCallback<List<OperationDTO>> callback);

}
