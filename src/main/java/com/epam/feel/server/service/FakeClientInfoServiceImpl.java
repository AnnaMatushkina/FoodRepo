package com.epam.feel.server.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.epam.feel.server.util.ConfigUtils;
import com.epam.feel.shared.dto.ClientDTO;
import com.epam.feel.shared.enums.Role;

/**
 * Fake service for work with clients.
 * 
 * @author Evgeny_Neustroev
 */
public class FakeClientInfoServiceImpl extends ClientInfoServiceImpl {

    private final static Logger LOG = LoggerFactory.getLogger(FakeClientInfoServiceImpl.class);

    private static final long serialVersionUID = -2376067717447433670L;

    private static final int MAX_ADMINS = 3;
    private static final int MAX_BALLANCE = 3000;

    /**
     * Gets all administrators from DB
     */
    @Override
    public List<ClientDTO> getAdministrators() {
        LOG.debug("Run");
        List<ClientDTO> adminsList = new ArrayList<ClientDTO>();

        Random rnd = new Random();
        for (int i = 0; i < MAX_ADMINS; ++i) {
            Date date = new Date();
            adminsList.add(new ClientDTO((long) i, rnd.nextDouble() * MAX_BALLANCE, 0.0, Role.ADMIN, "Admin_" + i,
                "Admin_" + i + "@epam.com", rnd.nextBoolean(), date));
        }
        return adminsList;
    }

    /**
     * Gets current client
     */
    @Override
    public ClientDTO getCurrentClient() {
        LOG.debug("Run");
        final int CURRENT_ID = 100500;
        Date date = new Date();
        Random rnd = new Random();

        ClientDTO client = new ClientDTO((long) CURRENT_ID, rnd.nextDouble() * MAX_BALLANCE, 0.0,
            ConfigUtils.FAKE_CLIENT_ROLE, "Client_Unk", "Client_Unk@epam.com", rnd.nextBoolean(), date);

        return client;
    }

    /**
     * Makes advance payment
     */
    @Override
    public ClientDTO makeAdvancePayment(Long id, double value) {
        return getCurrentClient();
    }

    /**
     * Outputs balance
     */
    @Override
    public Double outputBalance(Long id) {
        LOG.debug("Run: client: {}", id);
        return 0.0;
    }

    @Override
    public ClientDTO reloadCurrentClient() {
        return getCurrentClient();
    }

    @Override
    public ClientDTO adviseClient(Long id, Boolean advised) {
        ClientDTO client = getCurrentClient();
        client.setAdvised(advised);
        return client;
    }
}
