package com.epam.feel.server.util;

import org.junit.Assert;
import org.junit.Test;
import com.epam.feel.server.dao.EntityHelper;
import com.epam.feel.server.model.Client;
import com.epam.feel.server.model.Menu;
import com.epam.feel.shared.enums.MenuStatus;
import com.epam.feel.shared.enums.Role;

/**
 * Test convertor's functions entity and DTO objects.
 * 
 * @author Evgeny_Kincharov
 */
public class ConvertersTest {

    /**
     * Check method for {@link com.epam.feel.server.util.EntityToDTO#convertClient(com.epam.feel.server.model.Client)}
     * and {@link com.epam.feel.server.util.DTOToEntity#convertClient(com.epam.feel.shared.dto.ClientDTO)} . .
     */
    @Test
    public void convertClientTest() {
        Client client = EntityHelper.createClient(Role.ADMIN, EntityHelper.createMenu(MenuStatus.AVAILABLE));
        Client newClient = DTOToEntity.convertClient(EntityToDTO.convertClient(client));
        Assert.assertNotNull(newClient);
        Assert.assertEquals(client, newClient);
        Assert.assertEquals(client.getBalance(), newClient.getBalance());
        Assert.assertEquals(client.getAdvance(), newClient.getAdvance());
    }

    /**
     * Check menu converters
     */
    @Test
    public void convertMenuTest() {
        Menu menu = EntityHelper.createMenu(EntityHelper.DEFAULT_MENU_STATUS);
        Menu newMenu = DTOToEntity.convertMenu(EntityToDTO.convertMenu(menu));
        Assert.assertNotNull(newMenu);
        Assert.assertEquals(menu, newMenu);
    }

}
