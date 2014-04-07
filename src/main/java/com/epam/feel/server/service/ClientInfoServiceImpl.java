package com.epam.feel.server.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import com.epam.auth.service.client.User;
import com.epam.feel.server.dao.ClientDao;
import com.epam.feel.server.filter.AuthorizationFilter;
import com.epam.feel.server.model.Client;
import com.epam.feel.server.util.ConfigUtils;
import com.epam.feel.server.util.DTOToEntity;
import com.epam.feel.server.util.EntityToDTO;
import com.epam.feel.server.util.HistoryUtils;
import com.epam.feel.shared.WebAppConstants;
import com.epam.feel.shared.dto.AccountDTO;
import com.epam.feel.shared.dto.ClientDTO;
import com.epam.feel.shared.dto.TransactionDTO;
import com.epam.feel.shared.enums.Role;
import com.epam.feel.shared.enums.TransactionType;
import com.epam.feel.shared.exception.LoadUserException;
import com.epam.feel.shared.service.ClientInfoService;
import com.epam.feel.shared.service.HistoryInfoService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * Service for work with clients.
 * 
 * @author Evgeny_Kincharov
 */
@SuppressWarnings ("deprecation")
public class ClientInfoServiceImpl extends RemoteServiceServlet implements ClientInfoService, HasClientDaoSetter {
    private static final long serialVersionUID = -7031764276618022701L;

    private final static Logger LOG = LoggerFactory.getLogger(ClientInfoServiceImpl.class);

    @Autowired
    private ClientDao dao;

    @Autowired
    private HistoryInfoService historyService;

    @Autowired
    private HttpServletRequest request;

    private TransactionDTO createTransaction(AccountDTO account, double value, TransactionType type) {
        return HistoryUtils.createTransaction(account, getCurrentClient().getName(), value, type);
    }

    @Override
    public List<ClientDTO> getAdministrators() {
        LOG.debug("Get all administrators from database");
        return EntityToDTO.convertClients(dao.getAdministrators());
    }

    private ClientDTO loadAuthorizedClientFromSession() {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(AuthorizationFilter.USER_PARAM_NAME);
        Client result;
        if (user != null) {
            LOG.debug("AD user {}", user);
            result = dao.getClient(user.getId());
        } else {
            LOG.debug("Session property currentUser is not defined if application is running in debug mode previous message is normal."
                + " Maybe external authorization module (epam-am) is not connected");
            // TODO Not for production, possibility if break something in authorizations module will
            // return default client
            result = dao.getClient(ConfigUtils.DEFAULT_USER_ID);
        }

        if (user != null && result == null) {
            Date currentDate = new Date();
            result = new Client();
            result.setId(user.getId());
            result.setBalance(0.0);
            result.setAdvance(0.0);
            result.setRole(Role.CLIENT);
            result.setCreateDate(currentDate);
            result.setName(user.getName());
            result.setEmail(user.getLogin());
            result.setAdvised(false);
            result.setCreateDate(new Date());
            result = dao.saveClient(result);
        } else if (isChangeClientInfo(result, user)) {
            result.setName(user.getName());
            result.setEmail(user.getLogin());
            result = dao.saveClient(result);
        }

        ClientDTO tempResult = EntityToDTO.convertClient(result);
        session.setAttribute(WebAppConstants.CLIENT_SESSION_KEY, tempResult);
        if (tempResult != null) {
            LOG.info("Loaded user " + tempResult);
        } else {
            throw new LoadUserException(
                "Session property currentUser is not defined. Maybe external authorization module (epam-am) is not connected");
        }
        return tempResult;
    }

    private boolean isChangeClientInfo(Client client, User user) {
        return (client != null) && (user != null)
            && (!client.getName().equals(user.getName()) || !client.getEmail().equals(user.getLogin()));
    }

    @Override
    public ClientDTO getCurrentClient() {
        ClientDTO result = (ClientDTO) request.getSession().getAttribute(WebAppConstants.CLIENT_SESSION_KEY);
        if (result == null) {
            LOG.debug("Session constant {} is not defined, try load from db", WebAppConstants.CLIENT_SESSION_KEY);
            result = loadAuthorizedClientFromSession();
        } else {
            LOG.debug("Successful get current client: {}", result);
        }
        return result;
    }

    @Transactional (readOnly = false)
    @Override
    public ClientDTO makeAdvancePayment(Long id, double value) {
        ClientDTO client = EntityToDTO.convertClient(dao.getClient(id));
        LOG.debug("Make payment: client: {}; value: {}", new Object[] {client, value});
        historyService
            .saveTransaction(createTransaction(new AccountDTO(client), value, TransactionType.ADVANCE_PAYMENT));
        Client clientEntity = DTOToEntity.convertClient(client);
        double balance = clientEntity.getBalance();
        clientEntity.setBalance(balance + value);
        Client savedClient = dao.saveClient(clientEntity);
        return EntityToDTO.convertClient(savedClient);
    }

    @Transactional (readOnly = false)
    @Override
    public Double outputBalance(Long id) {
        ClientDTO client = EntityToDTO.convertClient(dao.getClient(id));
        LOG.debug("Output balance of a client", client);
        AccountDTO account = new AccountDTO(client);
        final Double balance = account.getBalance();
        historyService.saveTransaction(createTransaction(account, balance, TransactionType.OUTPUT_BALANCE));
        Client clientEntity = DTOToEntity.convertClient(client);
        clientEntity.setBalance(new Double(0));
        dao.saveClient(clientEntity);
        return balance;
    }

    @Override
    public ClientDTO adviseClient(Long id, Boolean advised) {
        LOG.debug("Client make advise {}", advised);
        ClientDTO client = EntityToDTO.convertClient(dao.getClient(id));
        client.setAdvised(advised);
        Client savedClient = dao.saveClient(DTOToEntity.convertClient(client));
        ClientDTO clientDTO = EntityToDTO.convertClient(savedClient);
        request.getSession().setAttribute(WebAppConstants.CLIENT_SESSION_KEY, clientDTO);
        return clientDTO;
    }

    @Override
    public Map<String, String> logout() {
        LOG.info("Client logged out");
        Map<String, String> cookieKey = new HashMap<String, String>();
        cookieKey.put(WebAppConstants.AM_KEY_DOMAIN_COOKIE, ConfigUtils.AM_COOKIE_DOMAIN);
        cookieKey.put(WebAppConstants.AM_KEY_PATH_COOKIE, ConfigUtils.AM_COOKIE_PATH);
        cookieKey.put(WebAppConstants.AM_KEY_HOST, request.getServerName());
        LOG.debug("Hostname=" + request.getServerName());

        if (request.getSession() != null) {
            request.getSession().invalidate();
        }

        return cookieKey;
    }

    @Override
    public ClientDTO reloadCurrentClient() {
        LOG.debug("Client reloading from DB");
        ClientDTO client = getCurrentClient();
        ClientDTO newClient = EntityToDTO.convertClient(dao.getClient(client.getId()));
        request.getSession().setAttribute(WebAppConstants.CLIENT_SESSION_KEY, newClient);
        return newClient;
    }

    @Override
    public List<ClientDTO> getClientsByName(int startRow, int maxRows, String name, Map<String, Boolean> orderList) {
        LOG.debug("Gets clients by name {}; startRow {}; maxRows {}", new Object[] {name, startRow, maxRows});
        if (StringUtils.hasText(name)) {
            return EntityToDTO.convertClients(dao.getClientsByName(startRow, maxRows, name.trim(), orderList));
        } else {
            return EntityToDTO.convertClients(dao.getAllClients(startRow, maxRows, orderList));
        }
    }

    @Override
    public Integer getClientsByNameCount(String name) {
        LOG.debug("Gets clients by name {}", new Object[] {name});
        if (StringUtils.hasText(name)) {
            return dao.getClientsByNameCount(name);
        } else {
            return dao.getAllClientsCount();
        }
    }

    @Override
    @Deprecated
    public void setClientDao(ClientDao dao) {
        this.dao = dao;
    }
}
