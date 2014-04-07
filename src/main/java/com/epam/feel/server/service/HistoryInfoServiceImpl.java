package com.epam.feel.server.service;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.epam.feel.server.dao.HistoryDao;
import com.epam.feel.server.model.Account;
import com.epam.feel.server.model.Notification;
import com.epam.feel.server.model.Operation;
import com.epam.feel.server.model.Transaction;
import com.epam.feel.server.util.DTOToEntity;
import com.epam.feel.server.util.EntityToDTO;
import com.epam.feel.shared.dto.AccountDTO;
import com.epam.feel.shared.dto.ClientDTO;
import com.epam.feel.shared.dto.NotificationDTO;
import com.epam.feel.shared.dto.OperationDTO;
import com.epam.feel.shared.dto.TransactionDTO;
import com.epam.feel.shared.enums.OperationType;
import com.epam.feel.shared.service.ClientInfoService;
import com.epam.feel.shared.service.HistoryInfoService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * Service for work with history.
 * 
 * @author Evgeny_Neustroev
 */
public class HistoryInfoServiceImpl extends RemoteServiceServlet implements HistoryInfoService {

    private static final long serialVersionUID = -7275399717481166984L;

    private final static Logger LOG = LoggerFactory.getLogger(HistoryInfoServiceImpl.class);

    @Autowired
    private HistoryDao dao;

    @Autowired
    ClientInfoService clientService;

    /**
     * Saves transaction in DB
     */
    @Override
    public TransactionDTO saveTransaction(TransactionDTO transaction) {
        LOG.debug("Saves transaction in DB: transaction: {}", transaction);
        Transaction transactionEntity = DTOToEntity.convertTransaction(transaction);
        transactionEntity = dao.saveTransaction(transactionEntity);
        return transactionEntity != null ? EntityToDTO.convertTransaction(transactionEntity) : null;
    }

    /**
     * Gets total count of transactions from DB
     */
    @Override
    public Integer getAllTransactionsCount() {
        LOG.debug("Gets total count of transactions from DB");
        return dao.getAllTransactionsCount();
    }

    /**
     * Gets total count of notifications from DB
     */
    @Override
    public Integer getAllNotificationsCount() {
        LOG.debug("Gets total count of transactions from DB");
        return dao.getAllNotificationsCount();
    }

    @Override
    public List<TransactionDTO> getAllTransactions(int startRow, int maxRows, Map<String, Boolean> orderList) {
        LOG.debug("Gets list of transactions from DB, startRow {}; maxRow {}", new Integer[] {startRow, maxRows});
        return EntityToDTO.convertTrasactionList(dao.getAllTransactions(startRow, maxRows, orderList));
    }

    /**
     * Gets all notifications from DB specified by starting row and max count of results
     */
    @Override
    public List<NotificationDTO> getAllNotifications(int startRow, int maxRows, Map<String, Boolean> orderList) {
        LOG.debug("Gets list of notifications from DB, startRow {}; maxRow {}", new Integer[] {startRow, maxRows});
        return EntityToDTO.convertNotificationList(dao.getAllNotifications(startRow, maxRows, orderList));
    }

    /**
     * Gets transactions of current client from DB specified by starting row and max count of results
     */
    @Override
    public List<TransactionDTO> getTransactionsOfCurrentClient(int startRow, int maxRows, Map<String, Boolean> orderList) {
        LOG.debug("Gets transactions from DB for current client, startRow {}; maxRow {}", new Integer[] {startRow,
                maxRows});
        ClientDTO client = clientService.getCurrentClient();
        Account accountEntity = DTOToEntity.convertAccount(new AccountDTO(client));
        return EntityToDTO.convertTrasactionList(dao.getTransactionsByAccount(accountEntity, startRow, maxRows,
            orderList));
    }

    /**
     * Gets total count of transactions of current client from DB
     */
    @Override
    public Integer getTransactionsOfCurrentClientCount() {
        LOG.debug("Gets count transactions for current client from DB");
        ClientDTO client = clientService.getCurrentClient();
        Account accountEntity = DTOToEntity.convertAccount(new AccountDTO(client));
        return dao.getTransactionsByAccountCount(accountEntity);
    }

    /**
     * Saves notification in DB
     */
    @Override
    public NotificationDTO saveNotification(NotificationDTO notification) {
        LOG.debug("Saves notification in DB: notification: {}", notification);
        Notification notificationEntity = DTOToEntity.convertNotification(notification);
        return EntityToDTO.convertNotification(dao.saveNotification(notificationEntity));
    }

    /**
     * Saves operation in DB
     */
    @Override
    public OperationDTO saveOperation(OperationDTO operation) {
        LOG.debug("Saves operation in DB: operation: {}", operation);
        Operation operationEntity = DTOToEntity.convertOperation(operation);
        return EntityToDTO.convertOperation(dao.saveOperation(operationEntity));
    }

    /**
     * Gets operations from DB specified by given type, starting row and max count of results
     */
    @Override
    public List<OperationDTO> getOperationsByType(OperationType type, int startRow, int maxRows,
        Map<String, Boolean> orderList) {
        LOG.debug("Gets operations from DB by operation type: type: {}", type);
        return EntityToDTO.convertOperationList(dao.getOperationsByType(type, startRow, maxRows, orderList));
    }

    /**
     * Gets total count of operations from DB specified by given type
     */
    @Override
    public Integer getOperationsByTypeCount(OperationType type) {
        LOG.debug("Gets count of operation by type: type: {}", type);
        return dao.getOperationsByTypeCount(type);
    }

}
