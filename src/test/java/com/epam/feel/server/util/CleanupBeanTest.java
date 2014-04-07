package com.epam.feel.server.util;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import junit.framework.Assert;
import org.apache.commons.lang.time.DateUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import com.epam.feel.server.dao.ClientDao;
import com.epam.feel.server.dao.EntityHelper;
import com.epam.feel.server.dao.HistoryDao;
import com.epam.feel.server.dao.MenuDao;
import com.epam.feel.server.dao.RequestDao;
import com.epam.feel.server.model.Account;
import com.epam.feel.server.model.Client;
import com.epam.feel.server.model.ExtendedRequestGroup;
import com.epam.feel.server.model.Menu;
import com.epam.feel.server.model.Notification;
import com.epam.feel.server.model.Operation;
import com.epam.feel.server.model.Request;
import com.epam.feel.server.model.RequestGroup;
import com.epam.feel.server.model.Transaction;
import com.epam.feel.server.service.CleanupBean;
import com.epam.feel.shared.enums.GroupStatus;
import com.epam.feel.shared.enums.MenuStatus;
import com.epam.feel.shared.enums.RequestStatus;

@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {"/applicationContext.xml"})
@Transactional
@TransactionConfiguration (defaultRollback = true)
public class CleanupBeanTest {

    private static final String STORAGE_PERIOD_FIELD_NAME = "STORAGE_PERIOD";
    private static final String CLEANUP_ENABLED_FIELD_NAME = "CLEANUP_ENABLED";
    private static final int OLD_STORAGE_PERIOD = ConfigUtils.STORAGE_PERIOD;
    private static final boolean OLD_CLEANUP_ENABLED = ConfigUtils.isCleanupEnabled();

    @Autowired
    private CleanupBean cleanupBean;

    @Autowired
    private RequestDao requestDao;

    @Autowired
    private HistoryDao historyDao;

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private MenuDao menuDao;

    private final Calendar calendar = Calendar.getInstance();
    private static final int TEST_CLEANUP_PERIOD = 10;

    @Before
    public void setUp() throws IllegalAccessException, SecurityException, NoSuchFieldException {
        HelperUtil.setClassProperty(ConfigUtils.class, CLEANUP_ENABLED_FIELD_NAME, true);
    }

    @Test
    public void testClearRequestsNotMenu() throws SecurityException, IllegalAccessException, NoSuchFieldException {

        Date now = calendar.getTime();

        setStoragePeriodValue(TEST_CLEANUP_PERIOD);

        Client client = clientDao.getClient(ConfigUtils.DEFAULT_USER_ID);

        Menu menu = EntityHelper.createMenu(MenuStatus.AVAILABLE);
        menu.setMenuOnDate(DateUtils.addDays(now, -TEST_CLEANUP_PERIOD / 2));
        menu = menuDao.saveMenu(menu);

        Request request = EntityHelper.createRequest(EntityHelper.DEFAULT_REQUEST_STATUS, client, menu);
        request.setStatus(RequestStatus.PERFORMED);
        request.setCreateDate(DateUtils.addDays(now, -(TEST_CLEANUP_PERIOD + 2)));
        request.setDeliveryDate(DateUtils.addDays(now, -(TEST_CLEANUP_PERIOD + 1)));
        request = requestDao.saveRequest(request);

        cleanupBean.cleanUp();

        final List<Menu> menus = menuDao.getAllMenus();
        Assert.assertTrue(menus.contains(menu));

        final List<Request> requests = requestDao.getAllRequests();
        Assert.assertFalse(requests.contains(request));

        restoreOldStoragePeriodValue();

    }

    @Test
    public void testClearRequestNotGroup() throws SecurityException, IllegalAccessException, NoSuchFieldException {

        Date now = calendar.getTime();

        setStoragePeriodValue(TEST_CLEANUP_PERIOD);

        Client client = clientDao.getClient(ConfigUtils.DEFAULT_USER_ID);

        Menu menu = EntityHelper.createMenu(MenuStatus.AVAILABLE);
        menu.setMenuOnDate(DateUtils.addDays(now, -(TEST_CLEANUP_PERIOD / 2)));
        menu = menuDao.saveMenu(menu);

        Request performedRequest = EntityHelper.createRequest(EntityHelper.DEFAULT_REQUEST_STATUS, client, menu);
        performedRequest.setStatus(RequestStatus.PERFORMED);
        performedRequest.setCreateDate(DateUtils.addDays(now, -(TEST_CLEANUP_PERIOD + 2)));
        performedRequest.setDeliveryDate(DateUtils.addDays(now, -(TEST_CLEANUP_PERIOD + 1)));
        performedRequest = requestDao.saveRequest(performedRequest);

        RequestGroup group = EntityHelper.createRequestGroup(GroupStatus.ACCEPTED,
            Arrays.asList(new Request[] {performedRequest}));
        group = requestDao.saveRequestGroup(group);

        cleanupBean.cleanUp();

        final List<Menu> menus = menuDao.getAllMenus();
        Assert.assertTrue(menus.contains(menu));

        final List<ExtendedRequestGroup> groups = requestDao.getAllRequestGroups();
        Assert.assertTrue(groups.contains(new ExtendedRequestGroup(group)));

        restoreOldStoragePeriodValue();

    }

    @Test
    public void testClearHistory() throws SecurityException, IllegalAccessException, NoSuchFieldException {

        Date now = calendar.getTime();

        setStoragePeriodValue(TEST_CLEANUP_PERIOD);

        Account account = new Account(clientDao.getClient(ConfigUtils.DEFAULT_USER_ID));

        Date estimatedDate = DateUtils.addDays(now, -(TEST_CLEANUP_PERIOD + 1));

        Operation operation = EntityHelper.createOperation();
        operation.setCreateDate(estimatedDate);
        operation = historyDao.saveOperation(operation);

        Notification notification = EntityHelper.createNotification();
        notification.setCreateDate(estimatedDate);
        notification = historyDao.saveNotification(notification);

        Transaction transaction = EntityHelper.createTransaction(account);
        transaction.setCreateDate(estimatedDate);
        transaction = historyDao.saveTransaction(transaction);

        Assert.assertTrue(historyDao.getAllOperations().contains(operation));
        Assert.assertTrue(historyDao.getAllNotifications().contains(notification));
        Assert.assertTrue(historyDao.getAllTransactions().contains(transaction));

        cleanupBean.cleanUp();

        Assert.assertFalse(historyDao.getAllOperations().contains(operation));
        Assert.assertFalse(historyDao.getAllNotifications().contains(notification));
        Assert.assertTrue(historyDao.getAllTransactions().contains(transaction));

        restoreOldStoragePeriodValue();

    }

    @After
    public void tearDown() throws SecurityException, IllegalAccessException, NoSuchFieldException {
        HelperUtil.setClassProperty(ConfigUtils.class, CLEANUP_ENABLED_FIELD_NAME, OLD_CLEANUP_ENABLED);
    }

    private static void setStoragePeriodValue(int newValue) throws SecurityException, IllegalAccessException,
        NoSuchFieldException {
        HelperUtil.setClassProperty(ConfigUtils.class, STORAGE_PERIOD_FIELD_NAME, newValue);
    }

    private static void restoreOldStoragePeriodValue() throws SecurityException, IllegalAccessException,
        NoSuchFieldException {
        HelperUtil.setClassProperty(ConfigUtils.class, STORAGE_PERIOD_FIELD_NAME, OLD_STORAGE_PERIOD);
    }

}
