/**
 *
 */
package com.epam.feel.server.dao;

import com.epam.feel.server.dao.impl.*;
import com.epam.feel.server.model.*;
import com.epam.feel.shared.enums.*;
import java.util.*;
import org.apache.commons.lang.*;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.context.transaction.*;
import org.springframework.transaction.annotation.*;

/**
 * Test for check client DAO functions {@link ClientDaoImpl}.
 *
 * @author Evgeny_Kincharov
 */
@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {"/applicationContext.xml" })
@Transactional
@TransactionConfiguration (defaultRollback = true)
public class ClientDaoTest {

    @Autowired
    private ClientDao dao;

    /**
     * Test for saving of Client entity
     */
    @Test
    public void saveClientTest() {
        Client client = EntityHelper.createClient(Role.CLIENT);
        Client result = dao.saveClient(client);
        assertNotNull(result);
        assertEquals(client, result);
        assertEquals(result.getRole(), Role.CLIENT);
    }

    /**
     * Test for get client by ID
     */
    @Test
    public void getClientTest() {
        Client client = EntityHelper.createClient(Role.CLIENT);

        Client savedClient = dao.saveClient(client);
        assertNotNull(savedClient);
        assertEquals(client, savedClient);

        Client result = dao.getClient(savedClient.getId());
        assertNotNull(result);
        assertEquals(savedClient, result);
    }

    /**
     * Test for get all administrators
     */
    @Test
    public void getAdministratorsTest() {
        Client admin = EntityHelper.createClient(Role.ADMIN);
        admin = dao.saveClient(admin);
        dao.saveClient(EntityHelper.createClient(Role.CLIENT));
        List<Client> admins = dao.getAdministrators();
        for (Client client : admins) {
            assertEquals(client.getRole(), Role.ADMIN);
        }
        assertTrue(admins.size() >= 1);
        assertTrue(admins.contains(admin));
    }

    /**
     * Test for saving account
     */
    @Test
    public void saveAccountTest() {
        Account account = EntityHelper.createAccount();
        assertNotNull(account);
        Account result = dao.saveAccount(account);
        assertNotNull(result);
        assertEquals(account, result);
    }

    /**
     * Test for saving error account
     */
    @Test (expected = UnsupportedOperationException.class)
    public void saveErrorAccountTest() {
        Account account = new Account();
        assertNotNull(account);
        dao.saveAccount(account);
    }

    /**
     * Test for getting count of all clients
     */
    @Test
    public void getAllClientsCountTest() {
        Integer integer = dao.getAllClientsCount();
        assertNotNull(integer);
    }

    /**
     * Test for getting count of all clients by name
     */
    @Test
    public void getClientsByNameCountTest() {
        String name = StringUtils.EMPTY;
        Integer integer = dao.getClientsByNameCount(name);
        assertNotNull(integer);
        assertEquals(integer, dao.getAllClientsCount());
        Client client = EntityHelper.createClient(Role.CLIENT);
        client.setName("Privet");
        Client result = dao.saveClient(client);
        assertNotNull(result);
        integer = dao.getClientsByNameCount(client.getName());
        assertNotNull(integer);
        integer = dao.getClientsByNameCount(client.getName().substring(0, 2));
        assertNotNull(integer);
        integer = dao.getClientsByNameCount(client.getName().substring(2));
        assertNotNull(integer);
    }

    /**
     * Test for getting all clients
     */
    @Test
    public void getAllClientsTest() {
        Integer clientsInDB = dao.getAllClientsCount();
        Client client;
        int minCount = 10;
        int count = clientsInDB + minCount;
        for (int i = clientsInDB; i < count; i++) {
            client = EntityHelper.createClient(Role.CLIENT);
            client.setId(Long.valueOf(i));
            dao.saveClient(client);
        }
        Map<String, Boolean> EMPTY_MAP = Collections.emptyMap();
        Map<String, Boolean> currentOrderList = EMPTY_MAP;

        List<Client> clientList = dao.getAllClients(0, minCount, currentOrderList);
        assertEquals(clientList.size(), minCount);
        clientList = dao.getAllClients(0, count, currentOrderList);
        assertEquals(clientList.size(), count);

    }

    /**
     * Test for getting all clients by name
     */
    @Test
    public void getClientsByNameTest(){
        Map<String, Boolean> EMPTY_MAP = Collections.emptyMap();
        Map<String, Boolean> currentOrderList = EMPTY_MAP;

        Client client = EntityHelper.createClient(Role.CLIENT);
        client.setName("Privet");
        dao.saveClient(client);

        List<Client> clientList = dao.getClientsByName(0,1,client.getName(),currentOrderList);
        assertNotNull(clientList);

        clientList = dao.getClientsByName(0,1,client.getName().substring(1,2),currentOrderList);
        assertNotNull(clientList);
        assertEquals(clientList.get(0), client);

        clientList = dao.getClientsByName(0,1,client.getName().substring(2,4),currentOrderList);
        assertNotNull(clientList);
        assertEquals(clientList.get(0), client);
    }

}
