package com.epam.feel.server.dao;

import com.epam.feel.server.dao.impl.*;
import com.epam.feel.server.model.*;
import com.epam.feel.server.model.Request;
import com.epam.feel.server.util.*;
import com.epam.feel.shared.enums.*;
import java.util.*;
import static junit.framework.Assert.*;
import org.junit.Test;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.context.transaction.*;
import org.springframework.transaction.annotation.*;

/**
 * Test for check request DAO functions {@link RequestDaoImpl}.
 * 
 * @author Evgeny_Neustroev
 */
@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {"/applicationContext.xml"})
@Transactional
@TransactionConfiguration (defaultRollback = true)
public class RequestDaoTest {

    private static final Map<String, Boolean> TEST_REQUEST_ORDERLIST = Collections.singletonMap(Request.DATE_COLUMN,
        true);
    private static final int TEST_REQUESTS_COUNT = 10;
    private static final int TEST_REQUEST_MENU_DETAILS_COUNT = 3;

    @Autowired
    private RequestDao requestDao;
    @Autowired
    private ClientDao clientDao;
    @Autowired
    private MenuDao menuDao;

    /**
     * Check saving Request entity
     */
    @Test
    public void saveRequestTest() {
        Client client = clientDao.getClient(ConfigUtils.DEFAULT_USER_ID);
        Menu menu = EntityHelper.createMenu(MenuStatus.AVAILABLE);
        menuDao.saveMenu(menu);
        Request request = EntityHelper.createRequest(EntityHelper.DEFAULT_REQUEST_STATUS, client, menu);

        Request result = requestDao.saveRequest(request);
        assertNotNull(result);
        assertEquals(request, result);

        Set<RequestDetails> details = result.getRequestDetails();
        assertNotNull(details);
        assertEquals(EntityHelper.MAX_COUNT, details.size());
    }

    /**
     * Check getting request by id
     */
    @Test
    public void getRequestTest() {
        Client client = clientDao.getClient(ConfigUtils.DEFAULT_USER_ID);
        Menu menu = EntityHelper.createMenu(MenuStatus.AVAILABLE);
        menuDao.saveMenu(menu);
        Request request = EntityHelper.createRequest(EntityHelper.DEFAULT_REQUEST_STATUS, client, menu);

        Request savedRequest = requestDao.saveRequest(request);
        assertNotNull(savedRequest);
        assertEquals(request, savedRequest);

        Request result = requestDao.getRequest(savedRequest.getId());
        assertNotNull(result);
        assertEquals(savedRequest, result);

        assertEquals(result.getStatus(), savedRequest.getStatus());
        assertEquals(result.getClient(), savedRequest.getClient());
    }

    /**
     * Check getting all active requests by client
     */
    @Test
    public void getRequestsByStatusesTest() {
        Client client = clientDao.getClient(ConfigUtils.DEFAULT_USER_ID);
        Menu menu = EntityHelper.createMenu(MenuStatus.AVAILABLE);
        menuDao.saveMenu(menu);
        Request request = EntityHelper.createRequest(EntityHelper.DEFAULT_REQUEST_STATUS, client, menu);

        Request savedRequest = requestDao.saveRequest(request);
        assertNotNull(savedRequest);
        assertEquals(request.getClient(), savedRequest.getClient());

        assertEquals(request.getStatus(), savedRequest.getStatus());
        assertEquals(request.getClient(), savedRequest.getClient());

        Request deletedRequest = EntityHelper.createRequest(RequestStatus.DELETED, client, menu);
        IRequest savedDeletedRequest = requestDao.saveRequest(deletedRequest);
        assertNotNull(savedDeletedRequest);

        List<RequestStatus> statuses = new ArrayList<RequestStatus>();
        statuses.add(RequestStatus.DECLINED);
        statuses.add(RequestStatus.IN_PROCESS);
        statuses.add(RequestStatus.ACCEPTED);
        statuses.add(RequestStatus.DECLINED);
        statuses.add(RequestStatus.PAID);

        List<Request> result = requestDao.getRequests(client, statuses);

        assertNotNull(result);

        for (Request r : result) {
            assertNotSame(r.getStatus(), RequestStatus.DELETED);
        }
    }

    /**
     * Check saving RequestGroup entity
     */
    @Test
    public void saveRequestGroupTest() {
        Client client = clientDao.getClient(ConfigUtils.DEFAULT_USER_ID);
        Menu menu = EntityHelper.createMenu(MenuStatus.AVAILABLE);
        menuDao.saveMenu(menu);

        List<Request> requests = new ArrayList<Request>();

        for (int i = 0; i < EntityHelper.MAX_COUNT; ++i) {
            Request request = EntityHelper.createRequest(EntityHelper.DEFAULT_REQUEST_STATUS, client, menu);
            requestDao.saveRequest(request);
            requests.add(request);
        }
        RequestGroup group = EntityHelper.createRequestGroup(EntityHelper.DEFAULT_GROUP_STATUS, requests);

        RequestGroup result = requestDao.saveRequestGroup(group);
        assertNotNull(result);
        assertEquals(group, result);
    }

    /**
     * Check getting request group by its ID
     */
    @Test
    public void getRequestGroupTest() {
        Client client = clientDao.getClient(ConfigUtils.DEFAULT_USER_ID);
        Menu menu = EntityHelper.createMenu(MenuStatus.AVAILABLE);
        menuDao.saveMenu(menu);

        List<Request> requests = new ArrayList<Request>();

        for (int i = 0; i < EntityHelper.MAX_COUNT; ++i) {
            Request request = EntityHelper.createRequest(EntityHelper.DEFAULT_REQUEST_STATUS, client, menu);
            requestDao.saveRequest(request);
            requests.add(request);
        }
        RequestGroup group = EntityHelper.createRequestGroup(EntityHelper.DEFAULT_GROUP_STATUS, requests);

        RequestGroup savedGroup = requestDao.saveRequestGroup(group);
        assertNotNull(savedGroup);
        assertEquals(group, savedGroup);

        RequestGroup result = requestDao.getRequestGroup(savedGroup.getId());
        assertNotNull(result);
        assertEquals(savedGroup, result);
    }

    /**
     * Check getting all request groups and remove them by ID
     */
    @Test
    public void getAllRequestGroupsAndRemoveTest() {
        Client client = clientDao.getClient(ConfigUtils.DEFAULT_USER_ID);
        Menu menu = EntityHelper.createMenu(MenuStatus.AVAILABLE);
        menu = menuDao.saveMenu(menu);

        List<Request> requests = new ArrayList<Request>();

        for (int i = 0; i < EntityHelper.MAX_COUNT; ++i) {
            Request request = EntityHelper.createRequest(EntityHelper.DEFAULT_REQUEST_STATUS, client, menu);
            requests.add(requestDao.saveRequest(request));
        }

        RequestGroup group = EntityHelper.createRequestGroup(EntityHelper.DEFAULT_GROUP_STATUS, requests);
        RequestGroup savedGroup = requestDao.saveRequestGroup(group);
        assertNotNull(savedGroup);
        assertEquals(group, savedGroup);

        int countBefore = requestDao.getAllRequestGroupsCount();
        requestDao.removeRequestGroup(savedGroup);

        int countAfter = requestDao.getAllRequestGroupsCount();

        assertEquals(countBefore, countAfter + 1);
    }
    @Test
    public void getActiveRequestsByMenuDetailsTest() {
        Menu menu = EntityHelper.createMenu(EntityHelper.DEFAULT_MENU_STATUS);
        menu = menuDao.saveMenu(menu);

        final List<MenuDetails> testMenuDetails = Arrays.asList(new MenuDetails[] {menu.getMenuDetails().iterator()
            .next()});

        assertNotNull(menu);
        assertFalse(menuDao.hasRequests(menu));

        Client client = clientDao.getClient(ConfigUtils.DEFAULT_USER_ID);
        Request request = new Request();
        request.setClient(client);
        request.setStatus(RequestStatus.IN_PROCESS);
        request.setCreateDate(new Date());
        request.setRequestDetails(new HashSet<RequestDetails>(Arrays.asList(new RequestDetails[] {new RequestDetails(1,
            request, menu.getMenuDetails().iterator().next())})));
        request = requestDao.saveRequest(request);

        assertEquals(1, requestDao.getActiveRequestsByMenuDetailsCount(testMenuDetails).intValue());
        List<Request> requests = requestDao.getActiveRequestsByMenuDetails(testMenuDetails);
        boolean found = false;
        for (Request r : requests) {
            if (r.getId().equals(request.getId())) {
                found = true;
                break;
            }
        }
        assertTrue(found);

        requests = requestDao.getActiveRequestsByMenuDetails(0, 1, testMenuDetails, TEST_REQUEST_ORDERLIST);
        found = false;
        for (Request r : requests) {
            if (r.getId().equals(request.getId())) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    @Test
    public void getRequestedMenuDetailsTest() {
        Menu menu = EntityHelper.createMenu(EntityHelper.DEFAULT_MENU_STATUS);
        menu = menuDao.saveMenu(menu);

        final MenuDetails testMenuDetails = menu.getMenuDetails().iterator().next();

        assertNotNull(menu);
        assertFalse(menuDao.hasRequests(menu));

        Client client = clientDao.getClient(ConfigUtils.DEFAULT_USER_ID);

        for (int i = 0; i < TEST_REQUESTS_COUNT; i++) {
            requestDao.saveRequest(makeRequest(client, menu));
        }

        Request request = makeRequest(client, menu);
        assertEquals(requestDao.getRequestedMenuDetails(testMenuDetails, request).intValue(),
            TEST_REQUESTS_COUNT * TEST_REQUEST_MENU_DETAILS_COUNT);

        request = requestDao.saveRequest(request);
        assertEquals(requestDao.getRequestedMenuDetails(testMenuDetails, request).intValue(),
            TEST_REQUESTS_COUNT * TEST_REQUEST_MENU_DETAILS_COUNT);

    }

    private Request makeRequest(Client client, Menu menu) {
        Request request = new Request();
        request.setClient(client);
        request.setStatus(RequestStatus.IN_PROCESS);
        request.setCreateDate(new Date());
        request.setRequestDetails(new HashSet<RequestDetails>(Arrays.asList(new RequestDetails[] {new RequestDetails(
            TEST_REQUEST_MENU_DETAILS_COUNT, request, menu.getMenuDetails().iterator().next())})));
        request = requestDao.saveRequest(request);
        return request;
    }


    @Test
    public void getRequestsTest(){
        Client client = EntityHelper.createClient(Role.CLIENT);
        client = clientDao.saveClient(client);
        Menu menu = EntityHelper.createMenu(MenuStatus.AVAILABLE);
        menu = menuDao.saveMenu(menu);

        Boolean result = requestDao.getRequests(menu, client);
        assertFalse(result);

        for (int i = 0; i < EntityHelper.MAX_COUNT; ++i) {
            Request request = EntityHelper.createRequest(EntityHelper.DEFAULT_REQUEST_STATUS, client, menu);
            request = requestDao.saveRequest(request);
        }

        result = requestDao.getRequests(menu, client);
        assertTrue(result);
    }

    @Test
    public void getAllRequestsTest(){
        List<Request> requestList = requestDao.getAllRequests();
        assertNotNull(requestList);
        int size = requestList.size();

        Client client = EntityHelper.createClient(Role.CLIENT);
        client = clientDao.saveClient(client);
        Menu menu = EntityHelper.createMenu(MenuStatus.AVAILABLE);
        menu = menuDao.saveMenu(menu);

        for (int i = 0; i < EntityHelper.MAX_COUNT; ++i) {
            Request request = EntityHelper.createRequest(EntityHelper.DEFAULT_REQUEST_STATUS, client, menu);
            request = requestDao.saveRequest(request);
        }

        requestList = requestDao.getAllRequests();
        assertNotNull(requestList);

        assertEquals(size+EntityHelper.MAX_COUNT, requestList.size());
    }

    @Test
    public void removeRequestTest(){
        Client client = EntityHelper.createClient(Role.CLIENT);
        client = clientDao.saveClient(client);
        Menu menu = EntityHelper.createMenu(MenuStatus.AVAILABLE);
        menu = menuDao.saveMenu(menu);

        Request request = EntityHelper.createRequest(EntityHelper.DEFAULT_REQUEST_STATUS, client, menu);
        request = requestDao.saveRequest(request);

        Request result = requestDao.getRequest(request.getId());
        assertNotNull(result);
        requestDao.removeRequest(request);
        result = null;
        result = requestDao.getRequest(request.getId());
        assertNull(result);
    }

    @Test
    public void getAllRequestsCountTest(){
        assertEquals((int)requestDao.getAllRequestsCount(), requestDao.getAllRequests().size());

        Client client = EntityHelper.createClient(Role.CLIENT);
        client = clientDao.saveClient(client);
        Menu menu = EntityHelper.createMenu(MenuStatus.AVAILABLE);
        menu = menuDao.saveMenu(menu);

        for (int i = 0; i < EntityHelper.MAX_COUNT; ++i) {
            Request request = EntityHelper.createRequest(EntityHelper.DEFAULT_REQUEST_STATUS, client, menu);
            request = requestDao.saveRequest(request);
        }

        assertEquals((int)requestDao.getAllRequestsCount(), requestDao.getAllRequests().size());
    }

}
