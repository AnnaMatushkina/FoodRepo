package com.epam.feel.server.dao.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.epam.feel.server.dao.CommonDao;
import com.epam.feel.server.dao.HistoryDao;
import com.epam.feel.server.model.Account;
import com.epam.feel.server.model.Notification;
import com.epam.feel.server.model.Operation;
import com.epam.feel.server.model.Transaction;
import com.epam.feel.shared.enums.OperationType;

/**
 * DAO class for working with Log entity class.
 * 
 * @author Evgeny_Neustroev
 */
@Repository
@Transactional (readOnly = true)
public class HistoryDaoImpl implements HistoryDao {

    @Autowired
    private CommonDao commonDao;

    @Autowired
    protected JpaTemplate jpaTemplate;

    @Transactional (readOnly = false)
    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return commonDao.update(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return commonDao.find(Transaction.class, Transaction.QUERY_FIND_ALL);
    }

    @Transactional (readOnly = false)
    @Override
    public Notification saveNotification(Notification notificaction) {
        return commonDao.update(notificaction);
    }

    @Override
    public List<Notification> getAllNotifications() {
        return commonDao.find(Notification.class, Notification.QUERY_FIND_ALL);
    }

    @Override
    public Integer getAllNotificationsCount() {
        return commonDao.executeCountQuery(Notification.QUERY_FIND_ALL);
    }

    @Transactional (readOnly = false)
    @Override
    public Operation saveOperation(Operation operation) {
        return commonDao.update(operation);
    }

    @Override
    public List<Operation> getAllOperations() {
        return commonDao.find(Operation.class, Operation.QUERY_FIND_ALL);
    }

    @Override
    @Transactional
    public int removeHistoryBeforeDate(final Date date) {
        return jpaTemplate.execute(new JpaCallback<Integer>() {

            @Override
            public Integer doInJpa(EntityManager em) throws PersistenceException {
                int count = removeOperations(em);
                count += removeNotifications(em);
                // count += removeTransactions(em);
                return count;
            }

            private int removeOperations(EntityManager em) {
                Query query = em.createNamedQuery(Operation.QUERY_DELETE_BEFORE_DATE);
                query.setParameter("date", date);
                return query.executeUpdate();
            }

            private int removeNotifications(EntityManager em) {
                Query query = em.createNamedQuery(Notification.QUERY_DELETE_BEFORE_DATE);
                query.setParameter("date", date);
                return query.executeUpdate();
            }

            // private int removeTransactions(EntityManager em) {
            // Query query = em.createNamedQuery(Transaction.QUERY_DELETE_BEFORE_DATE);
            // query.setParameter("date", date);
            // return query.executeUpdate();
            // }

        });
    }

    @Override
    public Integer getAllTransactionsCount() {
        return commonDao.executeCountQuery(Transaction.QUERY_FIND_ALL);
    }

    @Override
    public List<Transaction> getAllTransactions(final int startRow, final int maxRows, Map<String, Boolean> orderList) {
        return commonDao.find(Transaction.QUERY_FIND_ALL, startRow, maxRows, orderList);
    }

    @Override
    public List<Operation> getOperationsByType(OperationType type, int startRow, int maxRows,
        Map<String, Boolean> orderList) {
        return commonDao.find(Operation.QUERY_FIND_BY_TYPE, Collections.singletonMap("type", type), startRow, maxRows,
            orderList);
    }

    @Override
    public Integer getOperationsByTypeCount(OperationType type) {
        return commonDao.executeCountQuery(Operation.QUERY_FIND_BY_TYPE, Collections.singletonMap("type", type));
    }

    @Override
    public List<Transaction> getTransactionsByAccount(Account account, int startRow, int maxRows,
        Map<String, Boolean> orderList) {
        return commonDao.find(Transaction.QUERY_FIND_BY_ACCOUNT, Collections.singletonMap("account", account),
            startRow, maxRows, orderList);
    }

    @Override
    public Integer getTransactionsByAccountCount(Account account) {
        return commonDao.executeCountQuery(Transaction.QUERY_FIND_BY_ACCOUNT,
            Collections.singletonMap("account", account));
    }

    @Override
    public List<Notification> getAllNotifications(int startRow, int maxRows, Map<String, Boolean> orderList) {
        return commonDao.find(Notification.QUERY_FIND_ALL, startRow, maxRows, orderList);
    }
}
