package com.epam.feel.server.service;

import static com.epam.feel.server.IEpamFeelMessages.MESSAGES;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.epam.feel.server.dao.MenuDao;
import com.epam.feel.server.dao.RequestDao;
import com.epam.feel.server.model.Image;
import com.epam.feel.server.model.Menu;
import com.epam.feel.server.servlet.FileUpload;
import com.epam.feel.server.util.DTOToEntity;
import com.epam.feel.server.util.EntityToDTO;
import com.epam.feel.server.util.HistoryUtils;
import com.epam.feel.shared.WebAppConstants;
import com.epam.feel.shared.dto.DishTypeDTO;
import com.epam.feel.shared.dto.MenuDTO;
import com.epam.feel.shared.dto.MenuDetailsDTO;
import com.epam.feel.shared.enums.MenuStatus;
import com.epam.feel.shared.enums.OperationType;
import com.epam.feel.shared.service.ClientInfoService;
import com.epam.feel.shared.service.HistoryInfoService;
import com.epam.feel.shared.service.MenuInfoService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * Service for work with menu.
 * 
 * @author Evgeny_Neustroev
 */
@SuppressWarnings ("deprecation")
public class MenuInfoServiceImpl extends RemoteServiceServlet implements MenuInfoService, HasMenuDaoSetter {

    private static final long serialVersionUID = 1867535149082500183L;

    private static final int DAYS_INCREMENT_AUTOGENERATE_MENU = 1;

    private final static Logger LOG = LoggerFactory.getLogger(MenuInfoServiceImpl.class);

    @Autowired
    MenuDao dao;

    @Autowired
    RequestDao requestDao;

    @Autowired
    ClientInfoService clientService;

    @Autowired
    HistoryInfoService historyService;

    public MenuInfoServiceImpl() {}

    private MenuDTO doSaveMenu(MenuDTO menuDTO) {
        LOG.debug("Saves menu in DB: menuDTO: {}", menuDTO);
        Menu menu = DTOToEntity.convertMenu(menuDTO);
        Date deliveryFrom = getDeliveryDate(menu.getMenuOnDate(), menu.getDeliveryFrom());
        Date deliveryTo = getDeliveryDate(menu.getMenuOnDate(), menu.getDeliveryTo());
        menu.setDeliveryFrom(deliveryFrom);
        menu.setDeliveryTo(deliveryTo);
        menuDTO = EntityToDTO.convertMenu(dao.saveMenu(menu));
        return menuDTO;
    }

    private Date getDeliveryDate(Date onMenu, Date delivery) {
        if (onMenu == null || delivery == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(onMenu);
        Calendar d = Calendar.getInstance();
        d.setTime(delivery);
        c.set(Calendar.HOUR_OF_DAY, d.get(Calendar.HOUR_OF_DAY));
        c.set(Calendar.MINUTE, d.get(Calendar.MINUTE));
        c.set(Calendar.SECOND, d.get(Calendar.SECOND));
        return c.getTime();
    }

    /**
     * Get last menus from DB
     */
    @Override
    public List<MenuDTO> getLastMenus(Date start, Date end) {
        LOG.debug("Get last menus from DB period start {}; end {}", new Date[] {start, end});
        if (start == null && end == null) {
            return EntityToDTO.convertMenuList(dao.getLastMenus(new Date()));
        }
        if (start == null) {
            start = new Date(0l);
        }
        if (end == null) {
            return EntityToDTO.convertMenuList(dao.getLastMenus(start));
        } else {
            return EntityToDTO.convertMenuList(dao.findMenuByPeriod(start, end));
        }
    }

    /**
     * Get last menus from DB
     */
    @Override
    public List<MenuDTO> getLastMenusOrHavingRequests() {
        return EntityToDTO.convertMenuList(dao.getMenusActualOrHavingRequests());
    }

    /**
     * Get all available (actual) menus from DB
     */
    @Override
    public List<MenuDTO> getActualMenus() {
        LOG.debug("Get all available (actual) menus from DB");
        return EntityToDTO.convertMenuList(dao.getActualMenus());
    }

    /**
     * Get all dish types from DB
     */
    @Override
    public List<DishTypeDTO> getAllDishTypes() {
        LOG.debug("Get all dish types from DB");
        return EntityToDTO.convertDishTypeList(dao.getAllDishTypes());
    }

    /**
     * Saves menu in DB
     */
    @Transactional (readOnly = false)
    @Override
    public MenuDTO saveMenu(MenuDTO menuDTO) {
        String clientName = clientService.getCurrentClient().getName();
        menuDTO = doSaveMenu(menuDTO);
        historyService.saveOperation(HistoryUtils.createMenuOperation(OperationType.MENU_CHANGED,
            MESSAGES.savedMenu(String.valueOf(menuDTO.getId()), menuDTO.getMenuName()), clientName));
        return menuDTO;
    }

    @Transactional (readOnly = false)
    @Override
    public Boolean removeMenu(Long menuId) {
        LOG.debug("Removes menu from DB: menuDTO: {}", menuId);
        if (menuId == null) {
            return true;
        }
        Menu menu = dao.getMenu(menuId);
        if (dao.hasRequests(menu)) {
            return false;
        } else {
            MenuDTO menuDTO = EntityToDTO.convertMenu(menu);
            for (MenuDetailsDTO dto : menuDTO.getMenuDetails()) {
                dto.setAlive(false);
            }
            menuDTO.setStatus(MenuStatus.DELETED);
            menuDTO = saveMenu(menuDTO);
            historyService.saveOperation(HistoryUtils.createMenuOperation(OperationType.MENU_CHANGED, MESSAGES
                .removedMenu(String.valueOf(menuDTO.getId()), menuDTO.getMenuName()), clientService.getCurrentClient()
                .getName()));
            return menuDTO != null;
        }
    }

    /**
     * Set status for menu (True - Open, False - closed).
     * 
     * @see com.epam.feel.shared.service.MenuInfoService#setStatusMenu(com.epam.feel.shared.dto.MenuDTO, boolean)
     */
    @Transactional (readOnly = false)
    @Override
    public MenuDTO setStatusMenu(MenuDTO menuDTO, boolean isOpen) {
        LOG.debug("Set status for menu: menuDTO: {}; isOpen: {}", new Object[] {menuDTO, isOpen});
        menuDTO.setStatus(isOpen ? MenuStatus.DRAFT : MenuStatus.AVAILABLE);
        menuDTO = doSaveMenu(menuDTO);

        final String idString = String.valueOf(menuDTO.getId());
        final String menuName = menuDTO.getMenuName();
        final String message = isOpen ? MESSAGES.menuOpened(idString, menuName) : MESSAGES.menuClosed(idString,
            menuName);

        historyService.saveOperation(HistoryUtils.createMenuOperation(OperationType.MENU_CHANGED, message,
            clientService.getCurrentClient().getName()));
        return menuDTO;
    }

    @Override
    public Integer getRequestedDishesCount(Long menuDetailsId) {
        return requestDao.getRequestedMenuDetails(dao.getMenuDetails(menuDetailsId), null);
    }

    @Override
    public Boolean checkRequestTime() {
        LOG.debug("Check request time. Return true if reception time is over.");
        return dao.checkRequestTime();
    }

    @Override
    public Long saveImage(String fieldName) {
        Image image = new Image();
        image.setContent(FileUpload.getImageBytes(fieldName));
        return dao.saveImage(image).getId();
    }

    /**
     * Create menu on next day.
     * 
     * @see com.epam.feel.shared.service.MenuInfoService#generateMenuToNextDay()
     */
    @Transactional (readOnly = false)
    @Override
    public void generateMenuToNextDay() {
        LOG.debug("Create menu on next day. Executing on {}", new Date());
        List<MenuDTO> availableMenus = EntityToDTO.convertMenuList(dao.getMenuForCloneOnNextDay());
        for (MenuDTO menu : availableMenus) {
            MenuDTO newMenu = menu.clone();
            newMenu.setCreateDate(new Date());
            newMenu.setMenuOnDate(DateUtils.addDays(newMenu.getMenuOnDate(), DAYS_INCREMENT_AUTOGENERATE_MENU));
            newMenu.setReceiptStartDate(DateUtils.addDays(newMenu.getReceiptStartDate(),
                DAYS_INCREMENT_AUTOGENERATE_MENU));
            newMenu.setReceiptEndDate(DateUtils.addDays(newMenu.getReceiptEndDate(), DAYS_INCREMENT_AUTOGENERATE_MENU));
            newMenu
                .setDeliveryEndDate(DateUtils.addDays(newMenu.getDeliveryEndDate(), DAYS_INCREMENT_AUTOGENERATE_MENU));
            newMenu.setDeliveryStartDate(DateUtils.addDays(newMenu.getDeliveryStartDate(),
                DAYS_INCREMENT_AUTOGENERATE_MENU));
            newMenu = doSaveMenu(newMenu);
            menu.setStatus(MenuStatus.BLOCKED);
            doSaveMenu(menu);

            historyService.saveOperation(HistoryUtils.createMenuOperation(OperationType.MENU_CHANGED,
                MESSAGES.menuNextDay(String.valueOf(newMenu.getId()), newMenu.getMenuName()),
                WebAppConstants.GENERATE_MENU_LOG_USER));
        }
    }

    @Deprecated
    @Override
    public void setMenuDao(MenuDao menuDao) {
        this.dao = menuDao;
    }

}
