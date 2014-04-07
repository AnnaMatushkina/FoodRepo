package com.epam.feel.server.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.epam.feel.shared.dto.AccountDTO;
import com.epam.feel.shared.dto.NotificationDTO;
import com.epam.feel.shared.dto.OperationDTO;
import com.epam.feel.shared.dto.TransactionDTO;
import com.epam.feel.shared.enums.OperationType;
import com.epam.feel.shared.enums.TransactionType;
import com.epam.feel.shared.service.HistoryInfoService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * Fake service for work with history.
 * 
 * @author Evgeny_Neustroev
 */
public class FakeHistoryInfoServiceImpl extends RemoteServiceServlet implements HistoryInfoService {

    private static final long serialVersionUID = 3962947905528081885L;

    private final static Logger LOG = LoggerFactory.getLogger(FakeHistoryInfoServiceImpl.class);

    private static final int MAX_COUNT = 3;
    private static final Date DEFAULT_DATE = new Date();
    private static final String DEFAULT_EMAIL = "user@epam.com";
    private static final String DEFAULT_OPERATOR = "John Smith";
    private static final Double DEFAULT_DOUBLE = Math.random();
    private static final String DEFAULT_TEXT = "Default description";
    private static final TransactionType DEFAULT_TRANSACTION_TYPE = TransactionType.ADVANCE_PAYMENT;

    public FakeHistoryInfoServiceImpl() {
        super();
    }

    private AccountDTO createAccount() {
        return new AccountDTO(100500l, DEFAULT_OPERATOR, DEFAULT_DOUBLE, DEFAULT_DATE, DEFAULT_DOUBLE);
    }

    /**
     * Saves transaction in DB
     */
    @Override
    public TransactionDTO saveTransaction(TransactionDTO transaction) {
        LOG.debug("Run: transaction: {}", transaction);
        return transaction;
    }

    /**
     * Saves notification in DB
     */
    @Override
    public NotificationDTO saveNotification(NotificationDTO notificaction) {
        LOG.debug("Run: notificaction: {}", notificaction);
        return notificaction;
    }

    /**
     * Saves operation in DB
     */
    @Override
    public OperationDTO saveOperation(OperationDTO operation) {
        LOG.debug("Run: operation: {}", operation);
        return operation;
    }

    @Override
    public Integer getAllTransactionsCount() {
        return MAX_COUNT;
    }

    @Override
    public Integer getAllNotificationsCount() {
        return MAX_COUNT;
    }

    @Override
    public Integer getOperationsByTypeCount(OperationType type) {
        return MAX_COUNT;
    }

    @Override
    public Integer getTransactionsOfCurrentClientCount() {
        return MAX_COUNT;
    }

    @Override
    public List<TransactionDTO> getAllTransactions(int startRow, int maxRows, Map<String, Boolean> orderList) {
        List<TransactionDTO> list = getAllTransactions();
        int end = Math.min(startRow + maxRows, list.size());
        return new ArrayList<TransactionDTO>(list.subList(startRow, end));
    }

    @Override
    public List<TransactionDTO> getTransactionsOfCurrentClient(int startRow, int maxRows, Map<String, Boolean> orderList) {
        return getAllTransactions(startRow, maxRows, orderList);
    }

    @Override
    public List<NotificationDTO> getAllNotifications(int startRow, int maxRows, Map<String, Boolean> orderList) {
        List<NotificationDTO> list = getAllNotifications();
        int end = Math.min(startRow + maxRows, list.size());
        return new ArrayList<NotificationDTO>(list.subList(startRow, end));
    }

    @Override
    public List<OperationDTO> getOperationsByType(OperationType type, int startRow, int maxRows,
        Map<String, Boolean> orderList) {
        List<OperationDTO> list = getOperationsByType(type);
        int end = Math.min(startRow + maxRows, list.size());
        return new ArrayList<OperationDTO>(list.subList(startRow, end));
    }

    /**
     * Gets all transactions from DB
     */
    private List<TransactionDTO> getAllTransactions() {
        LOG.debug("Run");
        List<TransactionDTO> result = new ArrayList<TransactionDTO>(MAX_COUNT);

        AccountDTO account = createAccount();

        for (int i = 0; i < MAX_COUNT; ++i) {
            result.add(new TransactionDTO((long) (i + 100500), account, DEFAULT_DATE, DEFAULT_OPERATOR, DEFAULT_DOUBLE,
                (DEFAULT_DOUBLE / 3), DEFAULT_TRANSACTION_TYPE));
        }

        return result;
    }

    /**
     * Gets all notifications from DB
     */
    private List<NotificationDTO> getAllNotifications() {
        LOG.debug("Run");
        List<NotificationDTO> result = new ArrayList<NotificationDTO>(MAX_COUNT);

        for (int i = 0; i < MAX_COUNT; ++i) {
            result.add(new NotificationDTO((long) (i + 100500), DEFAULT_DATE, DEFAULT_OPERATOR, DEFAULT_EMAIL,
                DEFAULT_TEXT));
        }

        return result;
    }

    /**
     * Gets all operations from DB by operation type
     */
    private List<OperationDTO> getOperationsByType(OperationType type) {
        LOG.debug("Run: transaction: {}", type);
        List<OperationDTO> result = new ArrayList<OperationDTO>(MAX_COUNT);

        for (int i = 0; i < MAX_COUNT; ++i) {
            result.add(new OperationDTO((long) (i + 100500), DEFAULT_DATE, DEFAULT_OPERATOR, type, DEFAULT_TEXT + " "
                + type.toString()));
        }

        return result;
    }
}
