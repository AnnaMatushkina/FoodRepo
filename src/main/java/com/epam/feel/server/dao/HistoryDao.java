package com.epam.feel.server.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.epam.feel.server.model.Account;
import com.epam.feel.server.model.Notification;
import com.epam.feel.server.model.Operation;
import com.epam.feel.server.model.Transaction;
import com.epam.feel.shared.enums.OperationType;

/**
 * DAO interface for working with Log entity class.
 * 
 * @author Evgeny_Neustroev
 */
public interface HistoryDao {

    /**
     * Saves Transaction entity in DB
     * 
     * @param transaction
     *            - entity to save
     * @return saved entity or null if it can not be saved
     */
    public Transaction saveTransaction(Transaction transaction);

    /**
     * Finds all transactions in DB
     * 
     * @return list of all transactions
     */
    public List<Transaction> getAllTransactions();

    /**
     * Saves Notification entity in DB
     * 
     * @param notificaction
     *            - entity to save
     * @return saved entity or null if it can not be saved
     */
    public Notification saveNotification(Notification notificaction);

    /**
     * Finds all notifications in DB
     * 
     * @return list of all notifications
     */
    public List<Notification> getAllNotifications();

    /**
     * Saves Operation entity in DB
     * 
     * @param operation
     *            - entity to save
     * @return saved entity or null if it can not be saved
     */
    public Operation saveOperation(Operation operation);

    /**
     * Finds all operations in DB
     * 
     * @return list of all operations
     */
    public List<Operation> getAllOperations();

    /**
     * Removes all operations, notifications, and transactions created before date
     * 
     * @param date
     *            - interesting date
     * @return count of removed items
     */
    public int removeHistoryBeforeDate(Date date);

    /**
     * Returns total count of transactions
     * 
     * @return total count of transactions
     */
    public Integer getAllTransactionsCount();

    /**
     * Returns all transactions from startRow to startRow + maxRows
     * 
     * @param startRow
     *            starting row
     * @param maxRows
     *            max result count
     * @return found transactions
     */
    public List<Transaction> getAllTransactions(int startRow, int maxRows, Map<String, Boolean> orderList);

    /**
     * Returns total count of notifications
     * 
     * @return total count of transactions
     */
    public Integer getAllNotificationsCount();

    /**
     * Returns total count of operations can be found by given operation type
     * 
     * @param type
     *            operation type
     * @return total count of operations
     */
    public Integer getOperationsByTypeCount(OperationType type);

    /**
     * Returns total count of transactions can be found by given account
     * 
     * @param account
     *            account
     * @return total count of transactions
     */
    public Integer getTransactionsByAccountCount(Account account);

    /**
     * Returns all transactions from startRow to startRow + maxRows by given account
     * 
     * @param account
     *            account
     * @param startRow
     *            starting row
     * @param maxRows
     *            max result count
     * @return found transactions
     */
    public List<Transaction> getTransactionsByAccount(Account account, int startRow, int maxRows,
        Map<String, Boolean> orderList);

    /**
     * Returns all notifications from startRow to startRow + maxRows
     * 
     * @param startRow
     *            starting row
     * @param maxRows
     *            max result count
     * @return found notifications
     */
    public List<Notification> getAllNotifications(int startRow, int maxRows, Map<String, Boolean> orderList);

    /**
     * Returns operations specified by given type
     * 
     * @param type
     *            type to filter by
     * @param startRow
     *            starting row
     * @param maxRows
     *            max result count
     * @param orderList
     *            list of order by clause
     * @return list of operations specified by given type
     */
    public List<Operation> getOperationsByType(OperationType type, int startRow, int maxRows,
        Map<String, Boolean> orderList);

}
