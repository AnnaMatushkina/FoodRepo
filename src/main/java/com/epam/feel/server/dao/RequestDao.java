package com.epam.feel.server.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.epam.feel.server.model.Client;
import com.epam.feel.server.model.ExtendedRequest;
import com.epam.feel.server.model.ExtendedRequestGroup;
import com.epam.feel.server.model.Menu;
import com.epam.feel.server.model.MenuDetails;
import com.epam.feel.server.model.Request;
import com.epam.feel.server.model.RequestGroup;
import com.epam.feel.shared.enums.RequestStatus;

/**
 * DAO interface for working with Request entity class.
 * 
 * @author Evgeny_Neustroev
 */
public interface RequestDao {

    /**
     * Saves Request entity in DB
     * 
     * @param request
     *            - entity to save
     * @return saved entity or null if it can not be saved
     */
    public Request saveRequest(Request request);

    /**
     * Finds request entity in DB by its ID
     * 
     * @param id
     *            - ID of requested entity
     * @return entity from DB or null if it can not be found
     */
    public Request getRequest(Long id);

    /**
     * Finds list of requests in DB by menu for current user and current date
     * 
     * @param menu
     *            - client making the requests
     * @return true if there is at least one request, otherwise false
     */
    public Boolean getRequests(Menu menu, Client client);

    /**
     * Finds list of requests in DB by client and statuses
     * 
     * @param client
     *            - client making the requests
     * @return list of entities from DB
     */
    public List<Request> getRequests(Client client, List<RequestStatus> statuses);

    /**
     * Finds all request in DB
     * 
     * @return list of entities from DB
     */
    public List<Request> getAllRequests();

    /**
     * Removes request from DB
     * 
     * @param request
     *            - request for remove
     */
    public void removeRequest(Request request);

    /**
     * Saves RequestGroup entity in DB
     * 
     * @param requestGroup
     *            - entity to save
     * @return saved entity from DB or null if it can not be saved
     */
    public RequestGroup saveRequestGroup(RequestGroup requestGroup);

    /**
     * Finds RequestGroup entity in DB by its ID
     * 
     * @param id
     *            - ID of requested entity
     * @return entity from DB or null if it can not be found
     */
    public RequestGroup getRequestGroup(Long id);

    /**
     * Finds all request groups in DB
     * 
     * @return list of entities from DB
     */
    public List<ExtendedRequestGroup> getAllRequestGroups();

    /**
     * Removes request group from DB
     * 
     * @param requestGroup
     *            - request group for remove
     */
    public void removeRequestGroup(RequestGroup requestGroup);

    /**
     * Return group status
     * 
     * @return Group status
     */
    public List<RequestGroup> getGroupForRequest(Request request);

    /**
     * Returns closed groups created before date
     * 
     * @param date
     * @return list of closed groups created before date
     */
    public List<RequestGroup> getClosedGroupsBeforeDate(Date date);

    /**
     * Returns requests closed before date
     * 
     * @param date
     * @return list of requests closed before date
     */
    public List<Request> getClosedRequestsBeforeDate(Date date);

    /**
     * Returns count of requested menu details
     * 
     * @param request
     *            - request to exclude
     * @param menuDetails
     *            - menu details object
     * @return count of requested menu details
     */
    public Integer getRequestedMenuDetails(MenuDetails menuDetails, Request request);

    /**
     * Returns total count for request {@link #getAllRequests(int, int, Map)}
     * 
     * @return total count of rows for noted query
     */
    public Integer getAllRequestsCount();

    /**
     * Returns total count for request {@link #getAllRequestGroups(int, int, Map)}
     * 
     * @return total count of rows for noted query
     */
    public Integer getAllRequestGroupsCount();

    /**
     * Returns total count for request {@link #getRequestsClientDate(Client, Date, Date, int, int, Map)}
     * 
     * @param client
     * @param dateStart
     * @param dateEnd
     * @return total count of rows for noted query
     */
    public Integer getRequestsClientDateCount(Client client, Date dateStart, Date dateEnd);

    /**
     * Finds all request groups in DB with specified starting row and max results count
     * 
     * @param startRow
     *            - start row index
     * @param maxRows
     *            - max results count
     * @return list of entities from DB
     */
    public List<ExtendedRequestGroup> getAllRequestGroups(int startRow, int maxRows, Map<String, Boolean> orderList);

    /**
     * Finds all request in DB with specified starting row and max results count
     * 
     * @param startRow
     *            - start row index
     * @param maxRows
     *            - max results count
     * @return list of entities from DB
     */
    public List<ExtendedRequest> getAllRequests(int startRow, int maxRows, Map<String, Boolean> orderList);

    /**
     * Finds list of requests in DB by client and date with specified starting row and max results count
     * 
     * @param startRow
     *            - start row index
     * @param maxRows
     *            - max results count
     * @param client
     *            - client making the requests
     * @param dateStart
     *            - start date of filter (if null, requests are receive from beginning of time)
     * @param dateEnd
     *            - last date of filter (if null, requests are receive at current moment)
     * @return list of entities from DB
     */
    public List<ExtendedRequest> getRequestsClientDate(Client client, Date dateStart, Date dateEnd, int startRow,
        int maxRows, Map<String, Boolean> orderList);

    /**
     * Returns list of requests with dishes with name like given dish name
     * 
     * @param startRow
     *            start row index
     * @param maxRows
     *            max results count
     * @param dishName
     *            possible name
     * @param orderList
     *            list of "order by"
     * @return found list of requests
     */
    public List<ExtendedRequest> getRequestsByDishName(int startRow, int maxRows, String dishName,
        Map<String, Boolean> orderList);

    /**
     * Returns total count for request {@link #getRequestsByDishName(int, int, String, Map)}
     * 
     * @return total count of rows for noted query
     */
    public Integer getRequestsByDishNameCount(String dishName);

    /**
     * Find active group by given menu
     * 
     * @param menu
     *            - menu to filter by
     * @return active group
     */
    public ExtendedRequestGroup getActiveGroupRequestsByMenu(Menu menu);

    /**
     * Returns count of active requests containing request details with given menuDetails
     * 
     * @param menuDetails
     *            - menu details list
     * @return count of active requests containing request details with given menuDetails
     */
    public Integer getActiveRequestsByMenuDetailsCount(List<MenuDetails> menuDetails);

    /**
     * Returns active requests with one or more request details according to given menu details
     * 
     * @param startRow
     *            - start row index
     * @param maxRow
     *            - max results count
     * @param menuDetails
     *            - menu details list
     * @param orderList
     *            orderList list of "order by"
     * @return active requests with one or more request details according to given menu details
     */
    public List<Request> getActiveRequestsByMenuDetails(int startRow, int maxRow, List<MenuDetails> menuDetails,
        Map<String, Boolean> orderList);

    /**
     * Returns active requests with one or more request details according to given menu details
     * 
     * @param menuDetails
     *            - menu details list
     * @return active requests with one or more request details according to given menu details
     */
    public List<Request> getActiveRequestsByMenuDetails(List<MenuDetails> menuDetails);

}
