package com.epam.feel.shared.dto;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import org.junit.Test;
import com.epam.feel.server.dao.EntityHelper;
import com.epam.feel.server.model.Menu;
import com.epam.feel.server.model.MenuDetails;
import com.epam.feel.server.util.EntityToDTO;

/**
 * Test for check menu DTO.
 * 
 * @author Anna_Gavrilina
 */
public class MenuDTOTest {

    /**
     * Check clone {@link MenuDTO}
     */
    @Test
    public void cloneMenuTest() {
        Menu menu = EntityHelper.createMenu(EntityHelper.DEFAULT_MENU_STATUS);
        menu.setId(0l);
        for (MenuDetails md : menu.getMenuDetails()) {
            md.setId((long) menu.getMenuDetails().indexOf(md));
        }

        MenuDTO menuDTO = EntityToDTO.convertMenu(menu);
        MenuDTO cloneMenu = menuDTO.clone();

        assertNull(cloneMenu.getId());
        assertEquals(menuDTO.getMenuName(), cloneMenu.getMenuName());
        assertEquals(menuDTO.getCreateDate(), cloneMenu.getCreateDate());
        assertEquals(menuDTO.getDeliveryEndDate(), cloneMenu.getDeliveryEndDate());
        assertEquals(menuDTO.getDeliveryStartDate(), cloneMenu.getDeliveryStartDate());
        assertEquals(menuDTO.getMenuOnDate(), cloneMenu.getMenuOnDate());
        assertEquals(menuDTO.getReceiptEndDate(), cloneMenu.getReceiptEndDate());
        assertEquals(menuDTO.getReceiptStartDate(), cloneMenu.getReceiptStartDate());
        assertEquals(menuDTO.getStatus(), cloneMenu.getStatus());
        for (MenuDetailsDTO md : cloneMenu.getMenuDetails()) {
            assertNull(md.getId());
        }
    }
}
