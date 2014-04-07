/**
 * 
 */
package com.epam.feel.server.dao;

import java.util.List;
import java.util.Map;
import com.epam.feel.server.model.Account;
import com.epam.feel.server.model.Client;

/**
 * DAO interface for working with Client entity class.
 * 
 * @author Evgeny_Kincharov
 */
public interface ClientDao {

    /**
     * Finds Client entity in DB by its ID
     * 
     * @param id
     *            - ID interesting client (from table Clients)
     * @return - client entity or null if client with this id not found
     */
    public Client getClient(Long id);

    /**
     * Finds list of administrators in DB
     * 
     * @return list entity of all administrators in DB
     */
    public List<Client> getAdministrators();

    /**
     * Save Client entity in DB
     * 
     * @param client
     *            - entity to save
     * @return - saved entity or null if it can not be save
     */
    public Client saveClient(Client client);

    /**
     * Save account entity of client to DB
     * 
     * @param account
     *            - entity to save
     */
    public Account saveAccount(Account account);

    /**
     * Returns client list specified for paging parameters
     * 
     * @param startRow
     *            - first row index
     * @param maxRows
     *            - max results count
     * @param orderList
     *            - order list
     * @return client list specified for paging parameters
     */
    public List<Client> getAllClients(int startRow, int maxRows, Map<String, Boolean> orderList);

    /**
     * Returns count of clients
     * 
     * @return count of clients
     */
    public Integer getAllClientsCount();

    /**
     * Returns clients with name similar to name pattern
     * 
     * @param startRow
     *            - first row index
     * @param maxRows
     *            - max results count
     * @param name
     *            - name pattern
     * @param orderList
     *            - order list
     * @return client list specified by given name pattern
     */
    public List<Client> getClientsByName(int startRow, int maxRows, String name, Map<String, Boolean> orderList);

    /**
     * Returns full count for {@link #getClientsByName(int, int, String, Map)} query
     * 
     * @param name
     *            - name pattern
     * @return full count of clients found by executing {@link #getClientsByName(int, int, String, Map)}
     */
    public Integer getClientsByNameCount(String name);

}
