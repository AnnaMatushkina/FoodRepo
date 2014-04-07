package com.epam.feel.server.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.epam.feel.shared.dto.DishTypeDTO;
import com.epam.feel.shared.dto.MenuDTO;
import com.epam.feel.shared.dto.MenuDetailsDTO;
import com.epam.feel.shared.enums.MenuStatus;
import com.epam.feel.shared.service.MenuInfoService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * Fake service for work with menu.
 * 
 * @author Evgeny_Neustroev
 */
public class FakeMenuInfoServiceImpl extends RemoteServiceServlet implements MenuInfoService {

    private static final long serialVersionUID = -3867540218090306434L;

    private final static Logger LOG = LoggerFactory.getLogger(FakeMenuInfoServiceImpl.class);

    private static int MAX_MENUS = 3;
    private static int MAX_PRICE = 100;
    private static int MAX_WEIGHT = 400;
    private static int MAX_COUNT = 30;
    private static String STRUCTURE = "Proteins, carbohydrates, fat";

    public FakeMenuInfoServiceImpl() {}

    /**
     * Generates menu on next day. <b>CAUTION: DO NOT DELETE IT (SEE ApplicationContext.xml)</b>
     */
    @Override
    public void generateMenuToNextDay() {
        getActualMenus();
    }

    /**
     * Generate one MenuDTO
     * 
     * @return
     */
    private MenuDTO generateMenu() {
        final int DETAILS_ID = 100500;
        final int MENU_ID = 100500;

        Calendar calendar = Calendar.getInstance();
        Random rnd = new Random();
        Date dateNow = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, (int) (-rnd.nextFloat() * 10));
        Date dateStart = calendar.getTime();
        calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, (int) (rnd.nextFloat() * 10 + 1));
        Date dateEnd = calendar.getTime();

        MenuDTO menu = new MenuDTO((long) MENU_ID, MenuStatus.DRAFT, dateNow, dateNow, "Menu_" + MENU_ID, dateStart,
            dateEnd, null, null);

        List<MenuDetailsDTO> dishes = new ArrayList<MenuDetailsDTO>();
        for (int i = 0; i < 3; i++) {
            DishTypeDTO dishType = new DishTypeDTO((long) DETAILS_ID + i, "Type_" + DETAILS_ID + i);
            MenuDetailsDTO menuDetailsDTO = new MenuDetailsDTO((long) DETAILS_ID + i, "Dish_" + DETAILS_ID + i,
                rnd.nextBoolean(), true, rnd.nextDouble() * MAX_PRICE, rnd.nextInt() * MAX_WEIGHT,
                (int) (rnd.nextFloat() * MAX_COUNT), STRUCTURE, "http://www.some-host/images/image" + DETAILS_ID + i
                    + ".html", null, menu, dishType);
            dishes.add(menuDetailsDTO);
        }
        menu.setMenuDetails(dishes);
        return menu;
    }

    /**
     * Gets last menus from DB
     */
    @Override
    public List<MenuDTO> getLastMenus(Date start, Date end) {
        LOG.debug("Run");
        List<MenuDTO> menuList = new ArrayList<MenuDTO>();

        for (int i = 0; i < MAX_MENUS; ++i) {
            Calendar calendar = Calendar.getInstance();
            Random rnd = new Random();
            Date dateNow = calendar.getTime();
            calendar.add(Calendar.DAY_OF_MONTH, (int) (-rnd.nextFloat() * 10));
            Date dateStart = calendar.getTime();
            calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, (int) (rnd.nextFloat() * 10));
            Date dateEnd = calendar.getTime();

            menuList.add(new MenuDTO((long) i, MenuStatus.values()[i % 2], dateNow, dateNow, "Menu_" + i, dateStart,
                dateEnd, null, null));
        }
        menuList.add(generateMenu());

        return menuList;
    }

    /**
     * Gets all actual (available) menus from DB
     */
    @Override
    public List<MenuDTO> getActualMenus() {
        LOG.debug("Run");
        // Test on actual menus or loading actual menus from database
        return getLastMenus(null, null);
    }

    /**
     * Gets all dish types from DB
     */
    @Override
    public List<DishTypeDTO> getAllDishTypes() {
        LOG.debug("Run");
        List<DishTypeDTO> dishTypes = new ArrayList<DishTypeDTO>();
        dishTypes.add(new DishTypeDTO(0l, "Первые блюда"));
        dishTypes.add(new DishTypeDTO(1l, "Вторые блюда"));
        dishTypes.add(new DishTypeDTO(3l, "Десерт"));
        return dishTypes;
    }

    /**
     * Saves menu in DB
     */
    @Override
    public MenuDTO saveMenu(MenuDTO menuDTO) {
        LOG.debug("Run: menuDTO: {}", menuDTO);
        return menuDTO;
    }

    /**
     * Removes menu from DB
     */
    @Override
    public Boolean removeMenu(Long menuId) {
        LOG.debug("Run: menuDTO: {}", menuId);
        return true;
    }

    /**
     * Sets status to menu
     */
    @Override
    public MenuDTO setStatusMenu(MenuDTO menuDTO, boolean isOpen) {
        LOG.debug("Run: menuDTO: {}; isOpen: {}", new Object[] {menuDTO, isOpen});
        menuDTO.setStatus(isOpen ? MenuStatus.DRAFT : MenuStatus.AVAILABLE);
        return menuDTO;
    }

    @Override
    public Boolean checkRequestTime() {
        return true;
    }

    @Override
    public Integer getRequestedDishesCount(Long menuDetailsId) {
        return 0;
    }

    @Override
    public List<MenuDTO> getLastMenusOrHavingRequests() {
        return getLastMenus(null, null);
    }

    @Override
    public Long saveImage(String fieldName) {
        return null;
    }

}
