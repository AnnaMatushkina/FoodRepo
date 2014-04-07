package com.epam.feel.server.dao.impl;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.epam.feel.server.dao.CommonDao;
import com.epam.feel.server.dao.EntityUtils;
import com.epam.feel.server.model.BaseEntity;
import com.epam.feel.server.util.QueryUtils;

/**
 * DAO class for making basic operation for DB with all entity classes.
 * 
 * @author Maxim Tulupov (maxim_tulupov@epam.com)
 */
@Repository (CommonDao.NAME)
@Transactional (readOnly = true)
public class CommonDaoImpl implements CommonDao {

    private final static Logger LOG = LoggerFactory.getLogger(CommonDaoImpl.class);

    @Autowired
    protected JpaTemplate jpaTemplate;

    @Override
    public <T extends BaseEntity> List<T> find(Class<T> clazz, String queryName, Map<String, ?> queryParams) {
        LOG.debug("QueryEntity: class: {}; queryName: {}; queryParams: {}",
            new Object[] {clazz, queryName, queryParams});
        if (queryName == null) {
            return null;
        }

        @SuppressWarnings ("unchecked")
        final List<T> result = jpaTemplate.findByNamedQueryAndNamedParams(queryName, queryParams);
        return result;
    }

    @Override
    @SuppressWarnings ("unchecked")
    public <T extends BaseEntity> List<T> find(Class<T> clazz, String queryName) {
        LOG.debug("QueryEntity: class: {}; queryName: {}", new Object[] {clazz, queryName});
        return jpaTemplate.findByNamedQuery(queryName);
    }

    @Override
    public <T extends BaseEntity> T find(Class<T> clazz, Object id) {
        LOG.debug("QueryEntityById: class: {}; Id: {}", new Object[] {clazz, id});
        return jpaTemplate.find(clazz, id);
    }

    @Transactional (readOnly = false)
    @Override
    public <T extends BaseEntity> T update(T entity) {
        LOG.debug("UpdateEntity", entity);
        if (EntityUtils.isNew(entity)) {
            jpaTemplate.persist(entity);
            return entity;
        }
        T savedEntity = jpaTemplate.merge(entity);
        LOG.debug("AfterUpdateEntity", savedEntity);
        return savedEntity;
    }

    @Transactional (readOnly = false)
    @Override
    public <T extends BaseEntity> void remove(T entity) {
        LOG.debug("RemoveEntity", entity);
        jpaTemplate.remove(entity);
    }

    @Override
    @SuppressWarnings ("unchecked")
    public <T extends BaseEntity> List<T> find(final String queryName, final int startRow, final int maxRows,
        final Map<String, Boolean> orderList) {

        return jpaTemplate.execute(new JpaCallback<List<T>>() {

            @Override
            public List<T> doInJpa(EntityManager em) throws PersistenceException {
                Query q = QueryUtils.getNamedQueryOrderedBy(em, queryName, orderList);
                q.setFirstResult(startRow);
                q.setMaxResults(maxRows);
                return q.getResultList();
            }
        });
    }

    @Override
    @SuppressWarnings ("unchecked")
    public <T extends BaseEntity> List<T> find(final String queryName, final Map<String, ?> queryParams,
        final int startRow, final int maxRows, final Map<String, Boolean> orderList) {

        return jpaTemplate.execute(new JpaCallback<List<T>>() {

            @Override
            public List<T> doInJpa(EntityManager em) throws PersistenceException {
                Query q = QueryUtils.getNamedQueryOrderedBy(em, queryName, orderList);
                for (String paramName : queryParams.keySet()) {
                    q.setParameter(paramName, queryParams.get(paramName));
                }
                q.setFirstResult(startRow);
                q.setMaxResults(maxRows);
                return q.getResultList();
            }
        });
    }

    @Override
    public Integer executeCountQuery(final String queryName) {
        return jpaTemplate.execute(new JpaCallback<Integer>() {
            public Integer doInJpa(EntityManager em) throws PersistenceException {
                Query q = QueryUtils.getCountQuery(em, queryName);
                final Number result = (Number) q.getSingleResult();
                if (result != null) {
                    return result.intValue();
                } else {
                    return 0;
                }

            }
        });
    }

    @Override
    public Integer executeCountQuery(final String queryName, final Map<String, ?> queryParams) {
        return jpaTemplate.execute(new JpaCallback<Integer>() {
            public Integer doInJpa(EntityManager em) throws PersistenceException {
                Query q = QueryUtils.getCountQuery(em, queryName);
                for (String paramName : queryParams.keySet()) {
                    q.setParameter(paramName, queryParams.get(paramName));
                }
                final Number result = (Number) q.getSingleResult();
                if (result != null) {
                    return result.intValue();
                } else {
                    return 0;
                }

            }
        });
    }
}
