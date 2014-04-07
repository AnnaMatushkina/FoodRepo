package com.epam.feel.server.service;

import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.epam.feel.server.dao.EntityHelper;
import com.epam.feel.server.dao.HistoryDao;
import com.epam.feel.server.dao.RequestDao;
import com.epam.feel.server.model.Client;
import com.epam.feel.server.model.Menu;
import com.epam.feel.server.model.MenuDetails;
import com.epam.feel.server.model.Operation;
import com.epam.feel.server.model.Request;
import com.epam.feel.server.model.RequestDetails;
import com.epam.feel.server.model.RequestGroup;
import com.epam.feel.server.util.DTOToEntity;
import com.epam.feel.server.util.EntityToDTO;
import com.epam.feel.server.util.HelperUtil;
import com.epam.feel.shared.dto.ClientDTO;
import com.epam.feel.shared.dto.ExtendedRequestGroupDTO;
import com.epam.feel.shared.dto.GroupRequestDTO;
import com.epam.feel.shared.dto.MenuDTO;
import com.epam.feel.shared.dto.RequestDTO;
import com.epam.feel.shared.exception.EstimatedRequestDetailsException;
import com.epam.feel.shared.exception.RequestHasGroupException;
import com.epam.feel.shared.service.ClientInfoService;
import com.epam.feel.shared.service.HistoryInfoService;
import com.epam.feel.shared.service.RequestInfoService;

/**
 * Test for final realization service of Request {@link RequestInfoServiceImpl}.
 * 
 * @author Artem_Tumasov
 */

@RunWith (SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration (locations = {"/applicationContext.xml"})
public class RequestInfoServiceImplTest {

    private static final String DAO_FIELD = "dao";

    @Mock
    private RequestDao dao;

    @Mock
    private HistoryDao historyDao;

    @Autowired
    private RequestInfoService service;

    @Autowired
    private ClientInfoService clientService;

    @Mock
    private HistoryInfoService historyService;

    private Client client = null;
    private ClientDTO clientDTO = null;
    private Menu menu = EntityHelper.createMenu(EntityHelper.DEFAULT_MENU_STATUS);

    @Before
    public void setUp() throws IllegalAccessException {
        MockitoAnnotations.initMocks(this);
        mockServiceRequestDao(service, dao);
        HelperUtil.setObjectProperty(historyService, DAO_FIELD, historyDao);
        clientDTO = clientService.getCurrentClient();
        client = DTOToEntity.convertClient(clientDTO);
        when(historyDao.saveOperation(Matchers.<Operation> anyObject())).thenAnswer(new Answer<Operation>() {
            public Operation answer(InvocationOnMock invocation) {
                return (Operation) invocation.getArguments()[0];
            }
        });
    }

    @SuppressWarnings ("deprecation")
    private void mockServiceRequestDao(RequestInfoService service, RequestDao dao) {
        ((HasRequestDaoSetter) service).setRequestDao(dao);
    }

    @Test
    public void editRequestTest() throws EstimatedRequestDetailsException {
        Request request = EntityHelper.createRequest(EntityHelper.DEFAULT_REQUEST_STATUS, client, menu);
        request.setId(EntityHelper.DEFAULT_ID);
        when(dao.saveRequest(request)).thenReturn(request);

        for (RequestDetails details : request.getRequestDetails()) {
            when(dao.getRequestedMenuDetails(details.getMenuDetails(), request)).thenReturn(0);
        }

        RequestDTO resultDto = EntityToDTO.convertRequest(request, clientDTO);
        Assert.assertNotNull(resultDto);
        RequestDTO serviceResult = service.editRequest(resultDto, null);
        Assert.assertNotNull(serviceResult);

        Assert.assertEquals(serviceResult, resultDto);

    }

    @Test
    public void deleteRequestTest() throws RequestHasGroupException {
        Request request = EntityHelper.createRequest(EntityHelper.DEFAULT_REQUEST_STATUS, client, menu);
        request.setId(EntityHelper.DEFAULT_ID);
        RequestDTO resultDto = EntityToDTO.convertRequest(request, clientDTO);
        when(dao.saveRequest(request)).thenReturn(request);
        when(dao.getRequest(request.getId())).thenReturn(request);
        RequestDTO serviceResult = service.tryToDeleteRequest(resultDto.getId(), true, StringUtils.EMPTY);
        Assert.assertNotNull(serviceResult);

        Assert.assertEquals(serviceResult, resultDto);
    }

    @Test
    public void acceptRequestTest() {
        Request request = EntityHelper.createRequest(EntityHelper.DEFAULT_REQUEST_STATUS, client, menu);
        request.setId(EntityHelper.DEFAULT_ID);
        RequestDTO resultDto = EntityToDTO.convertRequest(request, clientDTO);

        when(dao.getRequest(request.getId())).thenReturn(request);
        when(dao.saveRequest(request)).thenReturn(request);
        RequestDTO serviceResult = service.acceptRequest(resultDto.getId());
        Assert.assertNotNull(serviceResult);

        Assert.assertEquals(serviceResult, resultDto);
    }

    @Test
    public void declineRequestTest() throws RequestHasGroupException {
        Request request = EntityHelper.createRequest(EntityHelper.DEFAULT_REQUEST_STATUS, client, menu);
        request.setId(EntityHelper.DEFAULT_ID);
        RequestDTO resultDto = EntityToDTO.convertRequest(request, clientDTO);

        when(dao.getRequest(request.getId())).thenReturn(request);
        when(dao.saveRequest(request)).thenReturn(request);
        RequestDTO serviceResult = service.tryToDeclineRequest(resultDto.getId(), true, StringUtils.EMPTY);
        Assert.assertNotNull(serviceResult);

        Assert.assertEquals(serviceResult, resultDto);
    }

    @Test
    public void completeRequestTest() {
        Request request = EntityHelper.createRequest(EntityHelper.DEFAULT_REQUEST_STATUS, client, menu);
        request.setId(EntityHelper.DEFAULT_ID);
        RequestDTO resultDto = EntityToDTO.convertRequest(request, clientDTO);

        when(dao.getRequest(request.getId())).thenReturn(request);
        when(dao.saveRequest(request)).thenReturn(request);
        RequestDTO serviceResult = service.completeRequest(resultDto.getId());
        Assert.assertNotNull(serviceResult);

        Assert.assertEquals(serviceResult, resultDto);
    }

    @Test
    public void makeRequestTest() throws EstimatedRequestDetailsException {
        MenuDetails menuDetails = EntityHelper.createMenuDetails(menu);
        Request request = EntityHelper.createRequest(EntityHelper.DEFAULT_REQUEST_STATUS, client, menu);
        request.setId((long) 1);
        List<RequestDetails> requestDetails = new ArrayList<RequestDetails>();

        for (int i = 0; i < EntityHelper.MAX_COUNT; ++i) {
            RequestDetails line = EntityHelper.createRequestDetails(request, menuDetails);
            line.setId((long) i);
            requestDetails.add(line);
        }

        RequestDTO requestDTO = EntityToDTO.convertRequest(request, clientDTO);
        when(dao.saveRequest(request)).thenReturn(request);
        when(dao.getRequestedMenuDetails(menuDetails, request)).thenReturn(0);
        RequestDTO serviceResult = service.makeRequest(requestDTO);
        Assert.assertNotNull(serviceResult);

        Assert.assertEquals(serviceResult, requestDTO);
    }

    @SuppressWarnings ("unused")
    private List<Request> getRequestsForUser() {
        List<Request> result = new ArrayList<Request>();

        for (int i = 0; i < EntityHelper.MAX_COUNT; ++i) {
            Request request = EntityHelper.createRequest(EntityHelper.DEFAULT_REQUEST_STATUS, client, menu);
            request.setId((long) i);
            result.add(request);
        }
        return result;
    }

    @Test
    public void getActiveRequestsTest() {
        List<RequestDTO> requestDTO = service.getActiveRequests(clientDTO.getId());
        Assert.assertNotNull(requestDTO);
    }

    @Test
    public void getRequestsForUserTest2() {
        MenuDTO menuDTO = EntityToDTO.convertMenu(menu);

        when(dao.getRequests(menu, client)).thenReturn(true);
        Boolean result = service.getRequestsForUser(menuDTO);

        Assert.assertEquals(result, true);
    }

    @Test
    public void payRequestTest() {
        Request request = EntityHelper.createRequest(EntityHelper.DEFAULT_REQUEST_STATUS, client, menu);
        request.setId(EntityHelper.DEFAULT_ID);
        Assert.assertNotNull(request);
        RequestDTO requestDTO = EntityToDTO.convertRequest(request, clientDTO);
        Assert.assertNotNull(requestDTO);
        when(dao.saveRequest(request)).thenReturn(request);
        when(dao.getRequest(request.getId())).thenReturn(request);
        RequestDTO result = service.payRequest(requestDTO.getId());
        Assert.assertNotNull(result);
        Assert.assertEquals(result, requestDTO);
    }

    @Test
    public void getStatusOfGroupTest() {
        List<Request> requests = new ArrayList<Request>();
        for (int i = 0; i < EntityHelper.MAX_COUNT; ++i) {
            Request line = EntityHelper.createRequest(EntityHelper.DEFAULT_REQUEST_STATUS, client, menu);
            line.setId((long) i);
            requests.add(line);
        }
        RequestGroup requestGroup = EntityHelper.createRequestGroup(EntityHelper.DEFAULT_GROUP_STATUS, requests);
        requestGroup.setId(EntityHelper.DEFAULT_ID);
        ExtendedRequestGroupDTO groupRequestDTO = new ExtendedRequestGroupDTO(
            EntityToDTO.convertRequestGroup(requestGroup));
        List<GroupRequestDTO> list = new ArrayList<GroupRequestDTO>();
        list.add(groupRequestDTO);
        List<RequestGroup> groupList = DTOToEntity.convertRequestGroupList(list);

        when(dao.getGroupForRequest(requestGroup.getRequests().iterator().next())).thenReturn(groupList);
        Request request = requestGroup.getRequests().iterator().next();
        RequestDTO requestDTO = EntityToDTO.convertRequest(request, clientDTO);
        when(dao.getRequest(requestDTO.getId())).thenReturn(request);
        GroupRequestDTO result = service.getStatusOfGroup(requestDTO.getId());
        Assert.assertNotNull(result);
        Assert.assertEquals(result, groupRequestDTO);
    }
}
