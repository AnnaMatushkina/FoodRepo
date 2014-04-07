package com.epam.feel.server.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.epam.feel.server.dao.CommonDao;
import com.epam.feel.server.dao.RequestDao;
import com.epam.feel.server.model.Client;
import com.epam.feel.server.model.ExtendedRequest;
import com.epam.feel.server.model.ExtendedRequestGroup;
import com.epam.feel.server.model.Menu;
import com.epam.feel.server.model.MenuDetails;
import com.epam.feel.server.model.Request;
import com.epam.feel.server.model.RequestDetails;
import com.epam.feel.server.model.RequestGroup;
import com.epam.feel.server.util.QueryUtils;
import com.epam.feel.shared.enums.GroupStatus;
import com.epam.feel.shared.enums.RequestStatus;

/**
 * DAO class for working with Request and RequestGroup entity classes.
 * 
 * @author Evgeny_Neustroev, Michael_Silvanovich
 */
@Repository
@Transactional (readOnly = true)
public class RequestDaoImpl implements RequestDao {

    private final static Logger LOG = LoggerFactory.getLogger(RequestDaoImpl.class);

    @Autowired
    private CommonDao commonDao;

    @Autowired
    protected JpaTemplate jpaTemplate;

    @Transactional (readOnly = false)
    @Override
    public Request saveRequest(Request request) {
        if (request.getStatus() != RequestStatus.DELETED && request.getStatus() != RequestStatus.PERFORMED) {
            request.calculateCost();
            request.calculateDeliveryDate();
        }
        return commonDao.update(request);
    }

    @Override
    public Request getRequest(Long id) {
        return commonDao.find(Request.class, id);
    }

    @Override
    public List<ExtendedRequest> getRequestsClientDate(Client client, Date dateStart, Date dateEnd, int startRow,
        int maxRows, Map<String, Boolean> orderList) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("client", client);
        params.put("dateStart", DateUtils.truncate(dateStart, Calendar.DAY_OF_MONTH));
        params.put("dateEnd", DateUtils.addDays(DateUtils.truncate(dateEnd, Calendar.DAY_OF_MONTH), 1));
        return commonDao.find(ExtendedRequest.QUERY_FIND_BY_CLIENT_AND_DATE, params, startRow, maxRows, orderList);
    }

    @Override
    public Integer getRequestsClientDateCount(Client client, Date dateStart, Date dateEnd) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("client", client);
        params.put("dateStart", DateUtils.truncate(dateStart, Calendar.DAY_OF_MONTH));
        params.put("dateEnd", DateUtils.addDays(DateUtils.truncate(dateEnd, Calendar.DAY_OF_MONTH), 1));
        return commonDao.executeCountQuery(ExtendedRequest.QUERY_FIND_BY_CLIENT_AND_DATE, params);
    }

    @Override
    public Boolean getRequests(Menu menu, Client client) {
        Map<String, Object> params = new HashMap<String, Object>();
        List<RequestStatus> statusList = new ArrayList<RequestStatus>();
        statusList.add(RequestStatus.IN_PROCESS);
        statusList.add(RequestStatus.PAID);
        statusList.add(RequestStatus.ACCEPTED);
        statusList.add(RequestStatus.DECLINED);
        params.put("client", client);
        params.put("menu", menu);
        params.put("statuses", statusList);
        List<Request> object = commonDao.find(Request.class, Request.QUERY_FIND_BY_MENU_CLIENT_AND_STATUSES,
            params);
        return !object.isEmpty();
    }

    @Override
    public List<Request> getRequests(Client client, List<RequestStatus> statuses) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("client", client);
        params.put("statuses", statuses);
        return commonDao.find(Request.class, Request.QUERY_FIND_BY_CLIENT_AND_STATUS, params);
    }

    @Override
    public List<Request> getClosedRequestsBeforeDate(Date date) {
        List<RequestStatus> statuses = Arrays.asList(new RequestStatus[] {RequestStatus.PERFORMED,
                RequestStatus.DECLINED, RequestStatus.DELETED});
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("date", date);
        params.put("statuses", statuses);
        return commonDao.find(Request.class, Request.QUERY_FIND_BEFORE_DATE_WITH_STATUSES, params);
    }

    @Override
    public List<Request> getAllRequests() {
        return commonDao.find(Request.class, Request.QUERY_FIND_ALL);
    }

    @Override
    public List<ExtendedRequest> getAllRequests(int startRow, int maxRows, Map<String, Boolean> orderList) {
        return commonDao.find(ExtendedRequest.QUERY_FIND_ALL, startRow, maxRows, orderList);
    }

    @Override
    public Integer getAllRequestsCount() {
        return commonDao.executeCountQuery(Request.QUERY_FIND_ALL);
    }

    @Override
    public List<ExtendedRequest> getRequestsByDishName(int startRow, int maxRows, String dishName,
        Map<String, Boolean> orderList) {
        Map<String, Object> params = getRequestByDishParams(dishName);
        return commonDao.find(ExtendedRequest.QUERY_FIND_BY_DISH_NAME, params, startRow, maxRows, orderList);
    }

    @Override
    public Integer getRequestsByDishNameCount(String dishName) {
        LOG.debug("dish name is " + dishName);
        Map<String, Object> params = getRequestByDishParams(dishName);
        return commonDao.executeCountQuery(ExtendedRequest.QUERY_FIND_BY_DISH_NAME, params);
    }

    private Map<String, Object> getRequestByDishParams(String dishName) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("dishname",
            dishName != null ? QueryUtils.getLikeExpression(dishName).toLowerCase() : QueryUtils.ANY_SYMBOL_SEQUENCE);
        return params;
    }

    @Transactional (readOnly = false)
    @Override
    public void removeRequest(final Request request) {

        Request attachedRequest = commonDao.update(request);
        commonDao.remove(attachedRequest);

    }

    @Transactional (readOnly = false)
    @Override
    public RequestGroup saveRequestGroup(RequestGroup requestGroup) {
        return commonDao.update(requestGroup);
    }

    @Override
    public RequestGroup getRequestGroup(Long id) {
        return commonDao.find(RequestGroup.class, id);
    }

    @Override
    public List<ExtendedRequestGroup> getAllRequestGroups() {
        return commonDao.find(ExtendedRequestGroup.class, ExtendedRequestGroup.QUERY_FIND_ALL);
    }

    @Override
    public List<ExtendedRequestGroup> getAllRequestGroups(int startRow, int maxRows, Map<String, Boolean> orderList) {
        return commonDao.find(ExtendedRequestGroup.QUERY_FIND_ALL, startRow, maxRows, orderList);
    }

    @Override
    public Integer getAllRequestGroupsCount() {
        return commonDao.executeCountQuery(RequestGroup.QUERY_FIND_ALL);
    }

    @Transactional (readOnly = false)
    @Override
    public void removeRequestGroup(RequestGroup requestGroup) {
        for (final Request request : requestGroup.getRequests()) {

            jpaTemplate.execute(new JpaCallback<Object>() {
                public Object doInJpa(EntityManager em) throws PersistenceException {
                    Query q = em.createNativeQuery("UPDATE request SET group_id = null where id = ?");
                    q.setParameter(1, request.getId());
                    q.executeUpdate();
                    return null;
                }
            });
        }

        RequestGroup rg = commonDao.update(requestGroup);
        commonDao.remove(rg);
    }

    @Override
    public List<RequestGroup> getGroupForRequest(Request request) {
        return commonDao.find(RequestGroup.class, RequestGroup.QUERY_FIND_GROUP_FOR_REQUEST,
            Collections.singletonMap("request", request.getId()));
    }

    @Override
    public ExtendedRequestGroup getActiveGroupRequestsByMenu(Menu menu) {
        Map<String, Object> params = new HashMap<String, Object>();
        List<GroupStatus> statuses = new ArrayList<GroupStatus>();
        statuses.add(GroupStatus.DRAFT);
        statuses.add(GroupStatus.ACCEPTED);
        params.put("statuses", statuses);
        params.put("menu", menu);
        List<ExtendedRequestGroup> requestGroupList = commonDao.find(ExtendedRequestGroup.class,
            ExtendedRequestGroup.QUERY_FIND_ACTIVE_GROUP_BY_MENU, params);
        return (requestGroupList.isEmpty()) ? null : requestGroupList.get(0);
    }

    @Override
    public List<RequestGroup> getClosedGroupsBeforeDate(Date date) {
        List<GroupStatus> statuses = Arrays.asList(new GroupStatus[] {GroupStatus.DELETED, GroupStatus.PERFORMED});
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("statuses", statuses);
        params.put("date", date);
        return commonDao.find(RequestGroup.class, RequestGroup.QUERY_FIND_CLOSED_GROUPS_BEFORE_DATE, params);
    }

    @Override
    public Integer getRequestedMenuDetails(final MenuDetails menuDetails, final Request request) {
        return jpaTemplate.execute(new JpaCallback<Integer>() {
            public Integer doInJpa(EntityManager em) throws PersistenceException {

                final boolean newRequest = request == null || request.getId() == null;
                final String query = (newRequest ? RequestDetails.QUERY_REQUESTED_MENU_DETAILS_COUNT : RequestDetails.QUERY_REQUESTED_MENU_DETAILS_EXCLUDING_CURRENT_COUNT);
                Query q = em.createNamedQuery(query);
                q.setParameter("menuDetails", menuDetails);
                final List<RequestStatus> excludedStatuses = Arrays.asList(new RequestStatus[] {RequestStatus.DECLINED,
                        RequestStatus.DELETED});
                q.setParameter("excluded_statuses", excludedStatuses);
                if (!newRequest) {
                    q.setParameter("request", request);
                }
                final Number result = (Number) q.getSingleResult();
                LOG.debug("QUERY: found avaiable count of" + menuDetails.getDishName() + " is " + result);
                if (result != null) {
                    return result.intValue();
                } else {
                    return 0;
                }

            }
        });
    }

    @Override
    public List<Request> getActiveRequestsByMenuDetails(int startRow, int maxRow, List<MenuDetails> menuDetails,
        Map<String, Boolean> orderList) {
        List<RequestStatus> statusList = new ArrayList<RequestStatus>();
        statusList.add(RequestStatus.IN_PROCESS);
        statusList.add(RequestStatus.PAID);
        statusList.add(RequestStatus.ACCEPTED);
        return getActiveRequestsByMenuDetails(startRow, maxRow, menuDetails, statusList, orderList);
    }

    @Override
    public Integer getActiveRequestsByMenuDetailsCount(List<MenuDetails> menuDetails) {
        List<RequestStatus> statusList = new ArrayList<RequestStatus>();
        statusList.add(RequestStatus.IN_PROCESS);
        statusList.add(RequestStatus.PAID);
        statusList.add(RequestStatus.ACCEPTED);
        return getActiveRequestsByMenuDetailsCount(menuDetails, statusList);
    }

    private List<Request> getActiveRequestsByMenuDetails(int startRow, int maxRow, List<MenuDetails> menuDetails,
        List<RequestStatus> statusList, Map<String, Boolean> orderList) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("statuses", statusList);
        params.put("details", menuDetails);
        return commonDao.find(Request.QUERY_FIND_BY_MENU_DETAILS_AND_STATUSES, params, startRow, maxRow, orderList);
    }

    private Integer getActiveRequestsByMenuDetailsCount(List<MenuDetails> menuDetails, List<RequestStatus> statusList) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("statuses", statusList);
        params.put("details", menuDetails);
        return commonDao.executeCountQuery(Request.QUERY_FIND_BY_MENU_DETAILS_AND_STATUSES, params);
    }

    @Override
    public List<Request> getActiveRequestsByMenuDetails(List<MenuDetails> menuDetails) {
        List<RequestStatus> statusList = new ArrayList<RequestStatus>();
        statusList.add(RequestStatus.IN_PROCESS);
        statusList.add(RequestStatus.PAID);
        statusList.add(RequestStatus.ACCEPTED);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("statuses", statusList);
        params.put("details", menuDetails);
        return commonDao.find(Request.class, Request.QUERY_FIND_BY_MENU_DETAILS_AND_STATUSES, params);
    }

}
