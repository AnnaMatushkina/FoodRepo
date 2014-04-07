package com.epam.feel.server.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.transaction.annotation.Transactional;
import com.epam.feel.server.dao.ClientDao;
import com.epam.feel.server.dao.EntityHelper;
import com.epam.feel.server.dao.HistoryDao;
import com.epam.feel.server.dao.MenuDao;
import com.epam.feel.server.model.Client;
import com.epam.feel.server.model.DishType;
import com.epam.feel.server.model.Menu;
import com.epam.feel.server.model.MenuDetails;
import com.epam.feel.server.model.Operation;
import com.epam.feel.server.util.EntityToDTO;
import com.epam.feel.shared.WebAppConstants;
import com.epam.feel.shared.dto.ClientDTO;
import com.epam.feel.shared.dto.DishTypeDTO;
import com.epam.feel.shared.dto.MenuDTO;
import com.epam.feel.shared.enums.MenuStatus;
import com.epam.feel.shared.enums.Role;
import com.epam.feel.shared.service.HistoryInfoService;
import com.epam.feel.shared.service.MenuInfoService;

/**
 * Test for final realization service of Menu {@link MenuInfoServiceImpl}.
 * 
 * @author Evgeny_Neustroev
 */
@RunWith (SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration (defaultRollback = true)
@ContextConfiguration (locations = {"/applicationContext.xml"})
public class MenuInfoServiceImplTest {

    private static final String HISTORY_DAO_FIELD = "dao";

    @Mock
    private MenuDao dao;

    @Autowired
    private HistoryInfoService historyService;

    @Mock
    private HistoryDao historyDao;

    @Mock
    private ClientDao clientDao;

    @Autowired
    private MenuInfoService service;

    @Autowired
    private HttpServletRequest request;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockServiceMenuDao(service, dao);
        ReflectionTestUtils.setField(historyService, HISTORY_DAO_FIELD, historyDao);
        when(historyDao.saveOperation(Matchers.<Operation> anyObject())).thenAnswer(new Answer<Operation>() {
            public Operation answer(InvocationOnMock invocation) {
                return (Operation) invocation.getArguments()[0];
            }
        });
        Client client = EntityHelper.createClient(Role.CLIENT);
        ClientDTO clientDTO = EntityToDTO.convertClient(client);
        request.getSession().setAttribute(WebAppConstants.CLIENT_SESSION_KEY, clientDTO);
        when(clientDao.getClient(client.getId())).thenReturn(client);
        when(historyDao.saveOperation(Matchers.<Operation> anyObject())).thenAnswer(new Answer<Operation>() {
            public Operation answer(InvocationOnMock invocation) {
                return (Operation) invocation.getArguments()[0];
            }
        });
        when(clientDao.saveClient(Matchers.<Client> anyObject())).thenAnswer(new Answer<Client>() {
            @Override
            public Client answer(InvocationOnMock invocation) throws Throwable {
                return (Client) invocation.getArguments()[0];
            }
        });
        when(dao.saveMenu(Matchers.<Menu> anyObject())).thenAnswer(new Answer<Menu>() {

            @Override
            public Menu answer(InvocationOnMock invocation) throws Throwable {
                return (Menu) invocation.getArguments()[0];
            }
        });
    }

    @SuppressWarnings ("deprecation")
    private void mockServiceMenuDao(MenuInfoService service, MenuDao dao) {
        ((HasMenuDaoSetter) service).setMenuDao(dao);
    }

    private List<Menu> getMenuList() {
        List<Menu> result = new ArrayList<Menu>(EntityHelper.MAX_COUNT);

        for (int i = 0; i < EntityHelper.MAX_COUNT; ++i) {
            Menu menu = EntityHelper.createMenu(EntityHelper.DEFAULT_MENU_STATUS);
            menu.setId(new Long(i));
            result.add(menu);
        }

        return result;
    }

    private List<DishType> getDishTypeList() {
        List<DishType> result = new ArrayList<DishType>(EntityHelper.MAX_COUNT);

        for (int i = 0; i < EntityHelper.MAX_COUNT; ++i) {
            result.add(EntityHelper.createDishType());
        }

        return result;
    }

    /**
     * Test for getting all menus
     */
    @Test
    public void getLastMenusTest() {
        when(dao.getLastMenus(new Date())).thenReturn(getMenuList());

        List<MenuDTO> daoResult = EntityToDTO.convertMenuList(getMenuList());
        Assert.assertNotNull(daoResult);

        List<MenuDTO> serviceResult = service.getLastMenus(null, null);
        Assert.assertNotNull(serviceResult);
    }

    /**
     * Test for getting actual (available) menus
     */
    @Test
    public void getActualMenusTest() {
        when(dao.getActualMenus()).thenReturn(getMenuList());
        List<MenuDTO> daoResult = EntityToDTO.convertMenuList(getMenuList());
        Assert.assertNotNull(daoResult);

        List<MenuDTO> serviceResult = service.getActualMenus();
        Assert.assertNotNull(serviceResult);

        Assert.assertEquals(daoResult.size(), serviceResult.size());

        final int size = daoResult.size();
        for (int i = 0; i < size; ++i) {
            Assert.assertEquals(daoResult.get(i), serviceResult.get(i));
        }
    }

    /**
     * Test for getting all dish types
     */
    @Test
    public void getDishTypesTest() {
        List<DishTypeDTO> daoResult = EntityToDTO.convertDishTypeList(getDishTypeList());
        Assert.assertNotNull(daoResult);

        when(dao.getAllDishTypes()).thenReturn(getDishTypeList());

        List<DishTypeDTO> serviceResult = service.getAllDishTypes();
        Assert.assertNotNull(serviceResult);

        Assert.assertEquals(daoResult.size(), serviceResult.size());

        final int size = daoResult.size();
        for (int i = 0; i < size; ++i) {
            Assert.assertEquals(daoResult.get(i), serviceResult.get(i));
        }
    }

    /**
     * Test for saving menu
     */
    @Test
    public void saveMenuTest() {
        Menu menu = EntityHelper.createMenu(EntityHelper.DEFAULT_MENU_STATUS);
        menu.setId(EntityHelper.DEFAULT_ID);
        MenuDTO resultDto = EntityToDTO.convertMenu(menu);
        MenuDTO serviceResult = service.saveMenu(resultDto);

        Assert.assertNotNull(serviceResult);
        Assert.assertEquals(resultDto, serviceResult);
    }

    /**
     * Test for update menu on next day
     * 
     * @throws IllegalAccessException
     */
    @Test
    public void generateMenuToNextDayTest() throws IllegalAccessException {
        final List<Menu> startMenu = new ArrayList<Menu>();
        Menu menu = EntityHelper.createMenu(MenuStatus.AVAILABLE);
        Random rnd = new Random();
        menu.setId(rnd.nextLong());
        for (MenuDetails dish : menu.getMenuDetails()) {
            dish.setId(rnd.nextLong());
        }
        startMenu.add(menu);
        when(dao.getMenuForCloneOnNextDay()).thenAnswer(new Answer<List<Menu>>() {

            @Override
            public List<Menu> answer(InvocationOnMock invocation) throws Throwable {
                return startMenu;
            }
        });
        when(dao.saveMenu(Matchers.<Menu> anyObject())).thenAnswer(new Answer<Menu>() {
            public Menu answer(InvocationOnMock invocation) {
                Menu result = (Menu) invocation.getArguments()[0];
                if (result.getStatus() == MenuStatus.BLOCKED) {
                    Assert.assertNotNull(result.getId());
                    for (MenuDetails dish : result.getMenuDetails()) {
                        Assert.assertNotNull(dish.getId());
                    }
                } else {
                    Assert.assertNull(result.getId());
                    for (MenuDetails dish : result.getMenuDetails()) {
                        Assert.assertNull(dish.getId());
                    }
                }

                return result;
            }
        });
        service.generateMenuToNextDay();
        verify(dao, times(1)).getMenuForCloneOnNextDay();
        verify(dao, times(2)).saveMenu(Matchers.<Menu> anyObject());
    }

}
