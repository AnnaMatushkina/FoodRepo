package com.epam.feel.shared.service;

import java.util.List;
import java.util.Map;
import com.epam.feel.shared.dto.NotificationDTO;
import com.epam.feel.shared.dto.OperationDTO;
import com.epam.feel.shared.dto.TransactionDTO;
import com.epam.feel.shared.enums.OperationType;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Interface for saving and getting history of actions.
 * 
 * @author Evgeny_Neustroev
 */
@RemoteServiceRelativePath ("springGwtServices/historyinfoservice")
public interface HistoryInfoService extends RemoteService {

    public TransactionDTO saveTransaction(TransactionDTO transaction);

    public NotificationDTO saveNotification(NotificationDTO notificaction);

    public OperationDTO saveOperation(OperationDTO operation);

    public Integer getAllTransactionsCount();

    public Integer getAllNotificationsCount();

    public Integer getOperationsByTypeCount(OperationType type);

    public Integer getTransactionsOfCurrentClientCount();

    public List<TransactionDTO> getAllTransactions(int startRow, int maxRows, Map<String, Boolean> orderList);

    public List<TransactionDTO> getTransactionsOfCurrentClient(int startRow, int maxRows, Map<String, Boolean> orderList);

    public List<NotificationDTO> getAllNotifications(int startRow, int maxRows, Map<String, Boolean> orderList);

    public List<OperationDTO> getOperationsByType(OperationType type, int startRow, int maxRows,
        Map<String, Boolean> orderList);

}
