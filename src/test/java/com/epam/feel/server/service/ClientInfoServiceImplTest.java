package com.epam.feel.server.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
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
import com.epam.feel.server.dao.ClientDao;
import com.epam.feel.server.dao.EntityHelper;
import com.epam.feel.server.dao.HistoryDao;
import com.epam.feel.server.model.Client;
import com.epam.feel.server.model.Transaction;
import com.epam.feel.server.util.ConfigUtils;
import com.epam.feel.server.util.DTOToEntity;
import com.epam.feel.server.util.EntityToDTO;
import com.epam.feel.server.util.HelperUtil;
import com.epam.feel.shared.WebAppConstants;
import com.epam.feel.shared.dto.ClientDTO;
import com.epam.feel.shared.enums.Role;
import com.epam.feel.shared.service.ClientInfoService;
import com.epam.feel.shared.service.HistoryInfoService;

/**
 * Test for final realization service of Client.
 * 
 * @author Evgeny_Kincharov
 */
@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {"/applicationContext.xml"})
public class ClientInfoServiceImplTest {

    private static final String HISTORY_DAO_FIELD = "dao";
    private static final double DEFAULT_SUMM = 123.11;
    private static final double DEFAULT_DELTA = 1e-5;

    @Mock
    private ClientDao dao;

    @Autowired
    private HttpServletRequest request;

    @Mock
    private HistoryDao historyDao;

    @Autowired
    private ClientInfoService service;

    @Autowired
    private HistoryInfoService historyService;

    @Before
    public void setUp() throws IllegalAccessException {
        MockitoAnnotations.initMocks(this);
        mockServiceClientDao(service, dao);
        HelperUtil.setObjectProperty(historyService, HISTORY_DAO_FIELD, historyDao);
        when(historyDao.saveTransaction(Matchers.<Transaction> anyObject())).thenAnswer(new Answer<Transaction>() {
            public Transaction answer(InvocationOnMock invocation) {
                return (Transaction) invocation.getArguments()[0];
            }
        });

        Client client = EntityHelper.createClient(Role.CLIENT);
        ClientDTO clientDTO = EntityToDTO.convertClient(client);

        request.getSession().setAttribute(WebAppConstants.CLIENT_SESSION_KEY, clientDTO);
        when(dao.getClient(client.getId())).thenReturn(client);
        when(dao.saveClient(Matchers.<Client> anyObject())).thenAnswer(new Answer<Client>() {
            @Override
            public Client answer(InvocationOnMock invocation) throws Throwable {
                return (Client) invocation.getArguments()[0];
            }
        });
    }

    @SuppressWarnings ("deprecation")
    private void mockServiceClientDao(ClientInfoService service, ClientDao dao) {
        ((HasClientDaoSetter) service).setClientDao(dao);
    }

    @Test
    public void adviceClientTest() {
        ClientDTO clientDTO = service.getCurrentClient();
        Client client = DTOToEntity.convertClient(clientDTO);
        when(dao.getClient(clientDTO.getId())).thenReturn(client);
        when(dao.saveClient(Matchers.<Client> anyObject())).thenAnswer(new Answer<Client>() {
            public Client answer(InvocationOnMock invocation) {
                return (Client) invocation.getArguments()[0];
            }
        });
        Boolean advised = true;
        clientDTO = service.adviseClient(clientDTO.getId(), advised);
        assertEquals(clientDTO.isAdvised(), advised);
        advised = false;
        clientDTO = service.adviseClient(clientDTO.getId(), advised);
        assertEquals(clientDTO.isAdvised(), advised);
    }

    /**
     * Test method for {@link com.epam.feel.server.service.ClientInfoServiceImpl#getAdministrators()},
     * {@link com.epam.feel.server.service.ClientInfoServiceImpl#getCurrentClient()}.
     */
    @Test
    public void getClientsTest() {
        when(dao.getAdministrators()).thenReturn(Arrays.asList(EntityHelper.createClient(Role.ADMIN)));
        when(dao.getClient(ConfigUtils.DEFAULT_USER_ID)).thenReturn(EntityHelper.createClient(Role.CLIENT));
        assertEquals(service.getAdministrators().size(), 1);
        assertEquals(service.getCurrentClient().getRole(), Role.CLIENT);
        verify(dao, times(1)).getAdministrators();
    }

    /**
     * Test method for
     * {@link com.epam.feel.server.service.ClientInfoServiceImpl#makeAdvancePayment (com.epam.feel.shared.dto.ClientDTO, double)}
     * .
     */
    @Test
    public void makeAdvancePayment() {
        ClientDTO currentClient = EntityToDTO.convertClient(EntityHelper.createClient(Role.ADMIN));
        Client client = DTOToEntity.convertClient(currentClient);
        when(dao.getClient(client.getId())).thenReturn(client);
        when(dao.saveClient(Matchers.<Client> anyObject())).thenAnswer(new Answer<Client>() {
            public Client answer(InvocationOnMock invocation) {
                return (Client) invocation.getArguments()[0];
            }
        });
        double startSumm = currentClient.getBalance();
        currentClient = service.makeAdvancePayment(currentClient.getId(), DEFAULT_SUMM);
        assertEquals(startSumm, currentClient.getBalance() - DEFAULT_SUMM, DEFAULT_DELTA);
        verify(dao, times(1)).saveClient(Matchers.<Client> anyObject());
    }
}
