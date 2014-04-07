package com.epam.feel.server.dao;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import junit.framework.Assert;
import org.apache.commons.lang.time.DateUtils;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import com.epam.feel.server.dao.impl.MenuDaoImpl;
import com.epam.feel.server.model.Client;
import com.epam.feel.server.model.DishType;
import com.epam.feel.server.model.Image;
import com.epam.feel.server.model.Menu;
import com.epam.feel.server.model.MenuDetails;
import com.epam.feel.server.model.Request;
import com.epam.feel.server.model.RequestDetails;
import com.epam.feel.server.util.ConfigUtils;
import com.epam.feel.shared.enums.MenuStatus;
import com.epam.feel.shared.enums.RequestStatus;

/**
 * Test for check menu DAO functions {@link MenuDaoImpl}.
 * 
 * @author Evgeny_Neustroev
 */
@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {"/applicationContext.xml"})
@Transactional
@TransactionConfiguration (defaultRollback = true)
public class MenuDaoTest {

    private final static int IMAGE_COUNT = 10;

    @Autowired
    private MenuDao dao;

    @Autowired
    private RequestDao requestDao;

    @Autowired
    private ClientDao clientDao;

    /**
     * Check getting all dish types
     */
    @Test
    public void getAllDishTypesTest() {
        List<DishType> result = dao.getAllDishTypes();
        Assert.assertNotNull(result.get(0));
    }

    /**
     * Check saving of Menu entity
     */
    @Test
    public void saveMenuTest() {
        Menu menu = EntityHelper.createMenu(EntityHelper.DEFAULT_MENU_STATUS);

        Menu result = dao.saveMenu(menu);
        Assert.assertNotNull(result);
        Assert.assertEquals(menu, result);

        List<MenuDetails> details = result.getMenuDetails();
        Assert.assertNotNull(details);
        Assert.assertEquals(EntityHelper.MAX_COUNT, details.size());
    }

    /**
     * Check updating of Menu entity
     */
    @Test
    public void updateMenuTest() {
        Menu menu = EntityHelper.createMenu(EntityHelper.DEFAULT_MENU_STATUS);

        Menu savedMenu = dao.saveMenu(menu);
        Assert.assertNotNull(savedMenu);
        Assert.assertEquals(menu, savedMenu);

        List<MenuDetails> details = savedMenu.getMenuDetails();
        Assert.assertNotNull(details);
        Assert.assertEquals(EntityHelper.MAX_COUNT, details.size());

        savedMenu.setStatus(MenuStatus.BLOCKED);

        details.add(EntityHelper.createMenuDetails(savedMenu));
        savedMenu.setMenuDetails(details);

        Menu result = dao.saveMenu(savedMenu);
        Assert.assertNotNull(result);
    }

    /**
     * Check getting Menu by id
     */
    @Test
    public void getMenuTest() {
        Menu menu = EntityHelper.createMenu(EntityHelper.DEFAULT_MENU_STATUS);

        Menu savedMenu = dao.saveMenu(menu);
        Assert.assertNotNull(savedMenu);
        Assert.assertEquals(menu, savedMenu);

        Menu result = dao.getMenu(savedMenu.getId());
        Assert.assertNotNull(result);
        Assert.assertEquals(savedMenu, result);

        List<MenuDetails> details = result.getMenuDetails();
        Assert.assertNotNull(details);
        Assert.assertEquals(EntityHelper.MAX_COUNT, details.size());
    }

    /**
     * Check getting all available menus
     */
    @Test
    public void getAvaliableMenusTest() {
        Menu menu = EntityHelper.createMenu(EntityHelper.DEFAULT_MENU_STATUS);

        Menu savedMenu = dao.saveMenu(menu);
        Assert.assertNotNull(savedMenu);
        Assert.assertEquals(menu, savedMenu);

        List<Menu> result = dao.getActualMenus();
        Assert.assertTrue(result.contains(savedMenu));
        menu = result.get(result.indexOf(savedMenu));
        Assert.assertEquals(EntityHelper.DEFAULT_MENU_STATUS, menu.getStatus());
        List<MenuDetails> details = menu.getMenuDetails();
        Assert.assertNotNull(details);
        Assert.assertEquals(EntityHelper.MAX_COUNT, details.size());
    }

    /**
     * Check getting all menus
     */
    @Test
    public void getAllMenusAndRemoveTest() {
        Menu menu = EntityHelper.createMenu(EntityHelper.DEFAULT_MENU_STATUS);

        Menu savedMenu = dao.saveMenu(menu);
        Assert.assertNotNull(savedMenu);
        Assert.assertEquals(menu, savedMenu);

        List<Menu> resultBefore = dao.getAllMenus();

        dao.removeMenu(savedMenu);

        List<Menu> resultAfter = dao.getAllMenus();

        Assert.assertEquals(resultBefore.size(), resultAfter.size() + 1);
    }

    /**
     * Check getting available menu on current date
     */
    @Test
    public void getMenuForCloneOnNextDayTest() {
        Menu menuAvailable = EntityHelper.createMenu(MenuStatus.AVAILABLE);
        Menu savedAvailableMenu = dao.saveMenu(menuAvailable);
        Assert.assertNotNull(savedAvailableMenu);

        Menu menuDraft = EntityHelper.createMenu(MenuStatus.DRAFT);
        Menu savedDraftMenu = dao.saveMenu(menuDraft);
        Assert.assertNotNull(savedDraftMenu);

        List<Menu> result = dao.getMenuForCloneOnNextDay();
        Assert.assertNotNull(result);
        for (Menu itemMenu : result) {
            Assert.assertEquals(MenuStatus.AVAILABLE, itemMenu.getStatus());
            Assert.assertEquals(new LocalDate().toDate(), itemMenu.getMenuOnDate());
        }
    }

    @Test
    public void saveAndGetImageTest() {
        Image image = new Image();
        image.setContent(new byte[] {});
        image = dao.saveImage(image);
        Assert.assertNotNull(image);
        image = dao.getImage(image.getId());
        Assert.assertNotNull(image);
        Assert.assertEquals(image.getContent().length, 0);
    }

    @Test
    public void removeUnusedImagesTest() {
        final Date now = new Date();
        dao.removeUnusedImages(now);

        for (int i = 0; i < IMAGE_COUNT; i++) {
            Image image = new Image();
            image.setContent(new byte[] {});
            image.setDate(DateUtils.addDays(now, -1));
            dao.saveImage(image);
        }

        Assert.assertEquals(dao.removeUnusedImages(now), IMAGE_COUNT);
        Assert.assertEquals(dao.removeUnusedImages(now), 0);
    }

    @Test
    public void hasRequestsTest() {
        Menu menu = EntityHelper.createMenu(EntityHelper.DEFAULT_MENU_STATUS);
        menu = dao.saveMenu(menu);
        Assert.assertNotNull(menu);
        Assert.assertFalse(dao.hasRequests(menu));

        Client client = clientDao.getClient(ConfigUtils.DEFAULT_USER_ID);
        Request request = new Request();
        request.setClient(client);
        request.setStatus(RequestStatus.IN_PROCESS);
        request.setCreateDate(new Date());
        request.setRequestDetails(new HashSet<RequestDetails>(Arrays.asList(new RequestDetails[] {new RequestDetails(1,
            request, menu.getMenuDetails().iterator().next())})));
        request = requestDao.saveRequest(request);

        Assert.assertNotNull(request);
        Assert.assertTrue(dao.hasRequests(menu));
    }

    @Test
    public void findMenuByPeriod() {
        final Date now = new Date();
        final Date leftDate = DateUtils.addDays(now, -1);
        final Date rightDate = DateUtils.addDays(now, 1);

        boolean found = false;
        Menu menu = createMenuByDate(now);
        menu.setStatus(MenuStatus.AVAILABLE);
        menu = dao.saveMenu(menu);
        Assert.assertNotNull(menu);

        List<Menu> menus = dao.findMenuByPeriod(leftDate, rightDate);
        for (Menu m : menus) {
            if (m.getId().equals(menu.getId())) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);

        found = false;
        menu = createMenuByDate(now);
        menu.setStatus(MenuStatus.DELETED);
        menu = dao.saveMenu(menu);
        Assert.assertNotNull(menu);

        menus = dao.findMenuByPeriod(leftDate, rightDate);
        for (Menu m : menus) {
            if (m.getId().equals(menu.getId())) {
                found = true;
                break;
            }
        }
        Assert.assertFalse(found);
    }

    private Menu createMenuByDate(Date date) {
        Menu menu = EntityHelper.createMenu(EntityHelper.DEFAULT_MENU_STATUS);
        menu.setCreateDate(date);
        menu.setDeliveryFrom(date);
        menu.setDeliveryTo(date);
        menu.setReceptionFrom(date);
        menu.setReceptionTo(date);
        return menu;
    }
}
