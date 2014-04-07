package com.epam.feel.server.util;

import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.util.StringUtils;

/**
 * Contains query manipulating utility methods.
 * 
 * @author Michael_Silvanovich
 */
public class QueryUtils {

    private QueryUtils() {}

    private static final String ORDER_BY_CLAUSE_START = " ORDER BY ";
    public static final String ASCENDING = " ASC";
    public static final String DESCENDING = " DESC";
    public static final String ANY_SYMBOL_SEQUENCE = "%";
    private static final String COUNT_PREFIX = "SELECT COUNT (*) ";
    private static final String FROM_STATEMENT = "FROM";
    private static final String REGEX_SPACES = "[\\s\\t]+";

    /**
     * Unwraps named query
     * 
     * @param em
     *            entity manager
     * @param queryName
     *            name of named query
     * @return unwrapped query string
     */
    public static String getNamedQueryString(EntityManager em, String queryName) {
        Query tmpQuery = em.createNamedQuery(queryName);
        org.hibernate.Query sqlQuery = tmpQuery.unwrap(org.hibernate.Query.class);
        String queryString = sqlQuery.getQueryString();
        return queryString;
    }

    /**
     * Inserts "order by"-clause into named query and returns resulting query
     * 
     * @param em
     *            entity manager
     * @param queryName
     *            name of named query
     * @param orderList
     *            list of orders: keys are column names, values are booleans: true - ascending, false - descending
     * @return query with "order by"-clause specified by given order list
     */
    public static Query getNamedQueryOrderedBy(EntityManager em, String queryName, Map<String, Boolean> orderList) {

        int limit = orderList.size();

        if (limit == 0)
            return em.createNamedQuery(queryName);

        StringBuffer sb = new StringBuffer(ORDER_BY_CLAUSE_START);
        int i = 1;
        for (Map.Entry<String, Boolean> item : orderList.entrySet()) {
            String columnName = item.getKey();
            sb.append(columnName);
            sb.append((item.getValue()) ? ASCENDING : DESCENDING);
            if (i < limit) {
                sb.append(", ");
                i++;
            }
        }

        return em.createQuery(getNamedQueryString(em, queryName) + sb.toString());

    }

    /**
     * Returns counting query for given named query
     * 
     * @param em
     *            entity manager
     * @param queryName
     *            name of named query
     * @return counting query for given named query
     */
    public static Query getCountQuery(EntityManager em, String queryName) {
        return em.createQuery(createCountQueryString(getNamedQueryString(em, queryName)));
    }

    /**
     * Create a count query string from a query string
     * 
     * @param queryString
     *            string to parse
     * @return the count query string
     */
    public static String createCountQueryString(String queryString) {
        assert queryString != null;
        return COUNT_PREFIX + queryString.substring(queryString.toUpperCase().indexOf(FROM_STATEMENT));
    }

    /**
     * Converts pattern into SQL 'like' string
     * 
     * @param pattern
     *            - pattern
     * @return SQL 'like' string
     */
    public static String getLikeExpression(String pattern) {
        String[] words = pattern.split(REGEX_SPACES);
        StringBuffer buffer = new StringBuffer();
        for (String word : words) {
            if (StringUtils.hasText(word)) {
                buffer.append(ANY_SYMBOL_SEQUENCE).append(word);
            }
        }
        buffer.append(ANY_SYMBOL_SEQUENCE);
        return buffer.toString();
    }

}
