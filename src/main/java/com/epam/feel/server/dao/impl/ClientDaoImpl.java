/**
 * 
 */
package com.epam.feel.server.dao.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import com.epam.feel.server.dao.ClientDao;
import com.epam.feel.server.dao.CommonDao;
import com.epam.feel.server.model.Account;
import com.epam.feel.server.model.Client;
import com.epam.feel.server.util.QueryUtils;
import com.epam.feel.shared.enums.Role;

/**
 * DAO class for working with Client entity class.
 * 
 * @author Evgeny_Kincharov
 */

@Repository
@Transactional (readOnly = true)
public class ClientDaoImpl implements ClientDao {

    @Autowired
    private CommonDao commonDao;

    @Override
    public List<Client> getAllClients(int startRow, int maxRows, Map<String, Boolean> orderList) {
        return commonDao.find(Client.QUERY_FIND_ALL, startRow, maxRows, orderList);
    }

    @Override
    public Integer getAllClientsCount() {
        return commonDao.executeCountQuery(Client.QUERY_FIND_ALL);
    }

    @Override
    public List<Client> getClientsByName(int startRow, int maxRows, String name, Map<String, Boolean> orderList) {
        return commonDao.find(Client.QUERY_FIND_BY_NAME, getClientByNameParams(name), startRow, maxRows, orderList);
    }

    @Override
    public Integer getClientsByNameCount(String name) {
        return commonDao.executeCountQuery(Client.QUERY_FIND_BY_NAME, getClientByNameParams(name));
    }

    private Map<String, Object> getClientByNameParams(String name) {
        Map<String, Object> params = new HashMap<String, Object>();
        params
            .put(
                "name",
                StringUtils.hasText(name) ? QueryUtils.getLikeExpression(name).toLowerCase() : QueryUtils.ANY_SYMBOL_SEQUENCE);
        return params;
    }

    @Override
    public List<Client> getAdministrators() {
        return commonDao.find(Client.class, Client.QUERY_FIND_BY_ROLE, Collections.singletonMap("role", Role.ADMIN));
    }

    @Override
    public Client getClient(Long id) {
        return commonDao.find(Client.class, id);
    }

    @Override
    @Transactional (readOnly = false)
    public Client saveClient(Client client) {
        return commonDao.update(client);
    }

    @Override
    @Transactional (readOnly = false)
    public Account saveAccount(Account account) {
        if (account.getId() == null) {
            throw new UnsupportedOperationException("You can't create new account! You must create client before!");
        }
        return commonDao.update(account);
    }
}
