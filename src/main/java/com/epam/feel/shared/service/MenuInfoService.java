package com.epam.feel.shared.service;

import java.util.Date;
import java.util.List;
import com.epam.feel.shared.dto.DishTypeDTO;
import com.epam.feel.shared.dto.MenuDTO;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Interface for getting menu information.
 * 
 * @author Evgeny_Neustroev
 */
@RemoteServiceRelativePath ("springGwtServices/menuinfoservice")
public interface MenuInfoService extends RemoteService {
    public List<MenuDTO> getLastMenus(Date start, Date end);

    public List<MenuDTO> getActualMenus();

    public List<DishTypeDTO> getAllDishTypes();

    public MenuDTO saveMenu(MenuDTO menuDTO);

    public Boolean removeMenu(Long menuId);

    public MenuDTO setStatusMenu(MenuDTO menuDTO, boolean isOpen);

    public Boolean checkRequestTime();

    public Integer getRequestedDishesCount(Long menuDetailsId);

    public void generateMenuToNextDay();

    public List<MenuDTO> getLastMenusOrHavingRequests();

    public Long saveImage(String fieldName);

}
