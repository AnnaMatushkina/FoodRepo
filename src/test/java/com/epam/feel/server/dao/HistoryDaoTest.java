package com.epam.feel.server.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import com.epam.feel.client.ui.util.pagination.CollectionUtils;
import com.epam.feel.server.dao.impl.HistoryDaoImpl;
import com.epam.feel.server.model.Account;
import com.epam.feel.server.model.Client;
import com.epam.feel.server.model.Notification;
import com.epam.feel.server.model.Operation;
import com.epam.feel.server.model.Transaction;
import com.epam.feel.server.util.ConfigUtils;
import com.epam.feel.shared.enums.OperationType;
import com.epam.feel.shared.enums.TransactionType;

/**
 * Test for check history DAO functions {@link HistoryDaoImpl}.
 * 
 * @author Evgeny_Neustroev
 */
@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {"/applicationContext.xml"})
@Transactional
@TransactionConfiguration (defaultRollback = true)
public class HistoryDaoTest {

    private final static int TEST_OPERATIONS_COUNT = 10;
    private final static int TEST_TRANSACTIONS_COUNT = 10;
    private final static int TEST_NOTIFICATIONS_COUNT = 10;

    private final static OperationType TEST_OPERATION_TYPE = OperationType.MENU_CHANGED;
    private final static TransactionType TEST_TRANSACTION_TYPE = TransactionType.ADVANCE_PAYMENT;

    private final static Map<String, Boolean> TEST_OPERATIONS_ORDER_LIST = CollectionUtils.getOrderList(
        Operation.DATE_COLUMN, true);
    private final static Map<String, Boolean> TEST_TRANSACTIONS_ORDER_LIST = CollectionUtils.getOrderList(
        Transaction.DATE_COLUMN, true);

    @Autowired
    private HistoryDao dao;

    @Autowired
    private ClientDao clientDao;

    /**
     * Check saving of Transaction entity
     */
    @Test
    public void saveTransactionTest() {
        Client client = clientDao.getClient(ConfigUtils.DEFAULT_USER_ID);

        Transaction transaction = EntityHelper.createTransaction(new Account(client));

        Transaction result = dao.saveTransaction(transaction);
        Assert.assertNotNull(result);
        Assert.assertEquals(transaction, result);

    }

    /**
     * Check getting all transactions from DB
     */
    @Test
    public void getAllTransactionsTest() {
        Client client = clientDao.getClient(ConfigUtils.DEFAULT_USER_ID);

        Transaction transaction = EntityHelper.createTransaction(new Account(client));

        Transaction savedTransaction = dao.saveTransaction(transaction);
        Assert.assertNotNull(savedTransaction);
        Assert.assertEquals(transaction, savedTransaction);

        List<Transaction> result = dao.getAllTransactions();
        Assert.assertNotNull(result);

        for (Transaction t : result) {
            Assert.assertNotNull(t);
        }
    }

    /**
     * Check saving of Notification entity
     */
    @Test
    public void saveNotificationTest() {
        Notification notification = EntityHelper.createNotification();

        Notification result = dao.saveNotification(notification);
        Assert.assertNotNull(result);
        Assert.assertEquals(notification, result);

    }

    /**
     * Check getting all notifications from DB
     */
    @Test
    public void getAllNotificationsTest() {
        Notification notification = EntityHelper.createNotification();

        Notification savedNotification = dao.saveNotification(notification);
        Assert.assertNotNull(savedNotification);
        Assert.assertEquals(notification, savedNotification);

        List<Notification> result = dao.getAllNotifications();
        Assert.assertNotNull(result);

        for (Notification n : result) {
            Assert.assertNotNull(n);
        }
    }

    /**
     * Check saving of Operation entity
     */
    @Test
    public void saveOpearionTest() {
        Operation operation = EntityHelper.createOperation();

        Operation result = dao.saveOperation(operation);
        Assert.assertNotNull(result);
        Assert.assertEquals(operation, result);
    }

    /**
     * Check getting all operations from DB
     */
    @Test
    public void getAllOperationsTest() {
        Operation operation = EntityHelper.createOperation();

        Operation savedOperation = dao.saveOperation(operation);
        Assert.assertNotNull(savedOperation);
        Assert.assertEquals(operation, savedOperation);

        List<Operation> result = dao.getAllOperations();
        Assert.assertNotNull(result);

        for (Operation o : result) {
            Assert.assertNotNull(o);
        }
    }

    @Test
    public void getOperationsByTypeTest() {

        final int oldOperationsCount = dao.getOperationsByTypeCount(TEST_OPERATION_TYPE);
        for (int i = 0; i < TEST_OPERATIONS_COUNT; i++) {
            Operation operation = makeOperation();
            Assert.assertNotNull(dao.saveOperation(operation));
        }
        final int newOperationsCount = dao.getOperationsByTypeCount(TEST_OPERATION_TYPE);
        Assert.assertEquals(TEST_OPERATIONS_COUNT, newOperationsCount - oldOperationsCount);

        List<Operation> operations = dao.getOperationsByType(TEST_OPERATION_TYPE, 0, newOperationsCount,
            TEST_OPERATIONS_ORDER_LIST);
        for (Operation operation : operations) {
            Assert.assertEquals(TEST_OPERATION_TYPE, operation.getType());
        }

    }

    @Test
    public void getTransactionsByAccountTest() {
        final Client client = clientDao.getClient(ConfigUtils.DEFAULT_USER_ID);
        final int oldTransactionCount = dao.getTransactionsByAccountCount(new Account(client));
        for (int i = 0; i < TEST_TRANSACTIONS_COUNT; i++) {
            dao.saveTransaction(makeTransaction(client));
        }
        final int newTransactionCount = dao.getTransactionsByAccountCount(new Account(client));
        Assert.assertEquals(newTransactionCount - oldTransactionCount, TEST_TRANSACTIONS_COUNT);

        List<Transaction> transactions = dao.getTransactionsByAccount(new Account(client), 0, newTransactionCount,
            TEST_TRANSACTIONS_ORDER_LIST);
        for (Transaction transaction : transactions) {
            Assert.assertEquals(transaction.getAccount().getId(), client.getId());
        }
    }

    @Test
    public void removeHistoryBeforeDateTest() {
        final Date now = new Date();
        final Date dateBefore = DateUtils.addDays(now, -1);
        final Client client = clientDao.getClient(ConfigUtils.DEFAULT_USER_ID);

        dao.removeHistoryBeforeDate(now);

        final int sum = TEST_NOTIFICATIONS_COUNT + TEST_OPERATIONS_COUNT;

        for (int i = 0; i < TEST_NOTIFICATIONS_COUNT; i++) {
            Notification notification = makeNotification();
            notification.setCreateDate(dateBefore);
            dao.saveNotification(notification);
        }

        for (int i = 0; i < TEST_OPERATIONS_COUNT; i++) {
            Operation operation = makeOperation();
            operation.setCreateDate(dateBefore);
            dao.saveOperation(operation);
        }

        for (int i = 0; i < TEST_TRANSACTIONS_COUNT; i++) {
            Transaction transaction = makeTransaction(client);
            transaction.setCreateDate(dateBefore);
            dao.saveTransaction(transaction);
        }

        Assert.assertEquals(dao.removeHistoryBeforeDate(now), sum);

    }

    private Transaction makeTransaction(Client client) {
        Transaction transaction = new Transaction();
        transaction.setCreateDate(new Date());
        transaction.setAccount(new Account(client));
        transaction.setAmount(0.0);
        transaction.setBalance(0.0);
        transaction.setOperatorName(client.getName());
        transaction.setType(TEST_TRANSACTION_TYPE);
        return transaction;
    }

    private Operation makeOperation() {
        Operation operation = EntityHelper.createOperation();
        operation.setType(TEST_OPERATION_TYPE);
        return operation;
    }

    private Notification makeNotification() {
        Notification notification = EntityHelper.createNotification();
        return notification;
    }
}
