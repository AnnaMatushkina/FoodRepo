package com.epam.feel.server.dao;

import java.util.List;
import java.util.Map;
import com.epam.feel.server.model.BaseEntity;

/**
 * Provides common methods to work with persistent entities.
 * 
 * @author Maxim Tulupov (maxim_tulupov@epam.com)
 */
public interface CommonDao {

    String NAME = "com.epam.feel.server.dao.CommonDao";

    /**
     * Finds entity in DB
     * 
     * @param clazz
     *            - entity class
     * @param queryName
     *            - queryName. May be null
     * @param queryParams
     *            - parameters for query
     * @param <T>
     *            - entity type
     * @return entity from DB or null if it not found
     */
    <T extends BaseEntity> List<T> find(Class<T> clazz, String queryName, Map<String, ?> queryParams);

    /**
     * Finds entity in DB
     * 
     * @param clazz
     *            - entity class
     * @param id
     *            - entity id
     * @param <T>
     *            - entity type
     * @return entity from DB or null if it not found
     */
    <T extends BaseEntity> T find(Class<T> clazz, Object id);

    /**
     * Executes a find query
     * 
     * @param clazz
     *            - entity class
     * @param queryName
     *            - query name
     * @return result of execution a query
     */
    <T extends BaseEntity> List<T> find(Class<T> clazz, String queryName);

    /**
     * Saves or updates entity in DB
     * 
     * @param entity
     *            - entity for save or update
     * @return entity from DB or null it can not be saved
     */
    <T extends BaseEntity> T update(T entity);

    /**
     * Removes entity from DB
     * 
     * @param entity
     *            - entity for remove
     */
    <T extends BaseEntity> void remove(T entity);

    /**
     * Returns result of execution single integer-result-query
     * 
     * @param queryName
     *            - name of query
     * @return result of execution single integer-result-query
     */
    Integer executeCountQuery(String queryName);

    /**
     * Returns result of execution single integer-result-query specified by list of query parameters
     * 
     * @param queryParams
     *            - parameters for query
     * @param queryName
     *            - name of query
     * @return result of execution single integer-result-query
     */
    Integer executeCountQuery(String queryName, Map<String, ?> queryParams);

    /**
     * Finds entities in DB from startRow, with determined max results
     * 
     * @param orderList
     *            - order list
     * @param startRow
     *            - row we start from
     * @param maxRows
     *            - max results
     * @return results of execution a query
     */
    <T extends BaseEntity> List<T> find(String queryName, int startRow, int maxRows, Map<String, Boolean> orderList);

    /**
     * Finds entities in DB from startRow, with determined max results and specified by list of query parameters
     * 
     * @param orderList
     *            - order list
     * @param queryParams
     *            - parameters for query
     * @param startRow
     *            - row we start from
     * @param maxRows
     *            - max results
     * @return results of execution a query
     */
    <T extends BaseEntity> List<T> find(String queryName, Map<String, ?> queryParams, int startRow, int maxRows,
        Map<String, Boolean> orderList);

}
