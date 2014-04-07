package com.epam.feel.server.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.epam.feel.server.dao.HistoryDao;
import com.epam.feel.server.dao.MenuDao;
import com.epam.feel.server.dao.RequestDao;
import com.epam.feel.server.model.Menu;
import com.epam.feel.server.model.Request;
import com.epam.feel.server.model.RequestGroup;
import com.epam.feel.server.util.ConfigUtils;

/**
 * Cleaning up bean.
 * 
 * @author Michael_Silvanovich
 */
@Service
public class CleanupBeanImpl implements CleanupBean {

    private final static Logger LOG = LoggerFactory.getLogger(CleanupBeanImpl.class);

    @Autowired
    private HistoryDao historyDao;

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private RequestDao requestDao;

    public void cleanUp() {

        if (!ConfigUtils.isCleanupEnabled()) {
            return;
        }

        LOG.info("[CLEAN UP] cleanning up is started");

        final Date now = Calendar.getInstance().getTime();
        final Date interestingDate = DateUtils.addDays(now, -ConfigUtils.STORAGE_PERIOD);

        deleteClosedRequestsAndGroups(interestingDate);
        deleteEstimatedMenus(interestingDate);
        deleteOldHistory(interestingDate);
        deleteUnusedImages(interestingDate);

        LOG.info("[CLEAN UP] cleanning up is finished");

    }

    private void deleteUnusedImages(Date interestingDate) {
        menuDao.removeUnusedImages(interestingDate);
    }

    private void deleteOldHistory(Date interestingDate) {
        historyDao.removeHistoryBeforeDate(interestingDate);
    }

    private void deleteClosedRequestsAndGroups(Date interestingDate) {

        List<RequestGroup> groups = requestDao.getClosedGroupsBeforeDate(interestingDate);
        for (RequestGroup group : groups) {
            requestDao.removeRequestGroup(group);
        }

        List<Request> requests = requestDao.getClosedRequestsBeforeDate(interestingDate);
        for (Request request : requests) {
            LOG.info("CLEANUP: deleting request " + request.getId());
            requestDao.removeRequest(request);
        }
    }

    private void deleteEstimatedMenus(final Date interestingDate) {
        List<Menu> menus = menuDao.findEstimatedMenusByDate(interestingDate);
        for (Menu menu : menus) {
            if (!menuDao.hasRequests(menu)) {
                menuDao.removeMenu(menu);
            }
        }
    }
}
