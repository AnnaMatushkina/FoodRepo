package com.epam.feel.shared.dto;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import org.junit.Test;
import com.epam.feel.server.dao.EntityHelper;
import com.epam.feel.server.model.Menu;
import com.epam.feel.server.model.MenuDetails;
import com.epam.feel.server.util.EntityToDTO;

/**
 * Test for check menu details DTO.
 * 
 * @author Anna_Gavrilina
 */
public class MenuDetailsDTOTest {

    /**
     * Check clone {@link MenuDetailsDTO}
     */
    @Test
    public void cloneMenuDetailsTest() {
        Menu menu = EntityHelper.createMenu(EntityHelper.DEFAULT_MENU_STATUS);
        menu.setId(0l);
        for (MenuDetails md : menu.getMenuDetails()) {
            md.setId((long) menu.getMenuDetails().indexOf(md));
        }

        MenuDTO menuDTO = EntityToDTO.convertMenu(menu);

        MenuDetailsDTO detailsDTO = menuDTO.getMenuDetails().get(0);
        MenuDetailsDTO cloneMenuDetails = detailsDTO.clone(menuDTO);

        assertNull(cloneMenuDetails.getId());
        assertEquals(menuDTO.getId(), cloneMenuDetails.getMenu().getId());
        assertEquals(detailsDTO.getDishName(), cloneMenuDetails.getDishName());
        assertEquals(detailsDTO.getImageId(), cloneMenuDetails.getImageId());
        assertEquals(detailsDTO.getStructure(), cloneMenuDetails.getStructure());
        assertEquals(detailsDTO.getUrl(), cloneMenuDetails.getUrl());
        assertEquals(detailsDTO.getDishType(), cloneMenuDetails.getDishType());
        assertEquals(detailsDTO.getIsChiefChoice(), cloneMenuDetails.getIsChiefChoice());
        assertEquals(detailsDTO.getMaxCount(), cloneMenuDetails.getMaxCount());
        assertEquals(detailsDTO.getPrice(), cloneMenuDetails.getPrice());
        assertEquals(detailsDTO.getWeight(), cloneMenuDetails.getWeight());
    }
}
