package com.epam.feel.client.ui.util;

import java.util.ArrayList;
import java.util.List;
import com.epam.feel.shared.dto.MenuDTO;
import com.epam.feel.shared.dto.MenuDetailsDTO;

/**
 * Helper class to use only with {@link MenuDTO}: decorated menu details list to present only alive menu details.
 * 
 * @author Michael_Silvanovich
 */
public final class AliveMenuDetails extends ArrayList<MenuDetailsDTO> {

    private static final long serialVersionUID = 8905319567084286226L;

    private List<MenuDetailsDTO> list;

    public AliveMenuDetails() {}

    public AliveMenuDetails(List<MenuDetailsDTO> list) {
        this.list = list;
        update();
    }

    /**
     * Refreshes elements in list. Uses to refresh it after outside changes of decorated list
     */
    public void update() {
        clear();
        for (MenuDetailsDTO dto : list) {
            if (dto.getAlive()) {
                add(dto);
            }
        }
    }

    @Override
    public boolean remove(Object o) {
        super.remove(o);
        return list.remove(o);
    }

}
