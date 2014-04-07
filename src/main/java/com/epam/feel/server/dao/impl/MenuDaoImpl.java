package com.epam.feel.server.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.epam.feel.server.dao.CommonDao;
import com.epam.feel.server.dao.MenuDao;
import com.epam.feel.server.model.DishType;
import com.epam.feel.server.model.Image;
import com.epam.feel.server.model.Menu;
import com.epam.feel.server.model.MenuDetails;
import com.epam.feel.server.model.RequestDetails;
import com.epam.feel.shared.enums.MenuStatus;
import com.epam.feel.shared.enums.RequestStatus;

/**
 * DAO class for working with Menu entity class.
 * 
 * @author Evgeny_Neustroev
 */
@Repository
@Transactional (readOnly = true)
public class MenuDaoImpl implements MenuDao {

    @Autowired
    private CommonDao commonDao;

    @Autowired
    private JpaTemplate jpaTemplate;

    @Override
    public List<DishType> getAllDishTypes() {
        return commonDao.find(DishType.class, DishType.QUERY_FIND_ALL);
    }

    @Override
    @Transactional (readOnly = false)
    public Menu saveMenu(Menu menu) {
        return commonDao.update(menu);
    }

    @Override
    public Menu getMenu(Long id) {
        return commonDao.find(Menu.class, id);
    }

    @Override
    public Image getImage(Long id) {
        return commonDao.find(Image.class, id);
    }

    @Override
    public int removeUnusedImages(final Date date) {
        Integer count = jpaTemplate.execute(new JpaCallback<Integer>() {

            @Override
            public Integer doInJpa(EntityManager em) throws PersistenceException {
                Query query = em.createNamedQuery(Image.QUERY_DELETE_UNUSED);
                query.setParameter("date", date);
                return query.executeUpdate();
            }
        });
        return count;
    }

    @Override
    @Transactional (readOnly = false)
    public Image saveImage(Image image) {
        return commonDao.update(image);
    }

    @Override
    public List<Menu> getActualMenus() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("statuses", Collections.singletonList(MenuStatus.AVAILABLE));
        params.put("date", new Date());
        return commonDao.find(Menu.class, Menu.QUERY_FIND_BY_STATUS_AND_DATE, params);
    }

    @Override
    public List<Menu> getMenusActualOrHavingRequests() {
        Map<String, Object> params = Collections.<String, Object> singletonMap("request_statuses",
            Arrays.asList(new RequestStatus[] {RequestStatus.IN_PROCESS, RequestStatus.PAID, RequestStatus.ACCEPTED}));
        return commonDao.find(Menu.class, Menu.QUERY_FIND_BY_STATUS_AND_DATE_OR_HAS_OPENED_REQUESTS, params);
    }

    @Override
    public List<Menu> getAllMenus() {
        return commonDao.find(Menu.class, Menu.QUERY_FIND_ALL);
    }

    @Override
    @Transactional (readOnly = false)
    public void removeMenu(Menu menu) {
        Menu m = commonDao.update(menu);
        commonDao.remove(m);
    }

    @Override
    public Boolean checkRequestTime() {
        List<Menu> menuList = commonDao.find(Menu.class, Menu.QUERY_CHECK_REQUEST_TIME,
            Collections.singletonMap("date", new Date()));
        return menuList.isEmpty();
    }

    @Override
    public List<Menu> getLastMenus(Date dateStart) {
        return commonDao.find(Menu.class, Menu.QUERY_FIND_LAST_MENU_EXCLUDING_STATUS, getLasMenusParams(dateStart));
    }

    private Map<String, Object> getLasMenusParams(Date dateStart) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("date", getDateWithoutTime(dateStart));
        params.put("statuses", getExcludeStatusesForMenu());
        return params;
    }

    private Date getDateWithoutTime(Date sourceDate) {
        DateTime date = new DateTime(sourceDate);
        Date dateWithoutTime = date.toLocalDate().toDate();
        return dateWithoutTime;
    }

    @Override
    public List<Menu> findEstimatedMenusByDate(Date date) {
        return commonDao.find(Menu.class, Menu.QUERY_FIND_ESTIMATED_MENUS_BY_DATE,
            Collections.singletonMap("date", date));
    }

    @Override
    public Boolean hasRequests(Menu menu) {
        Map<String, Object> params = getRequestsParams(menu);
        return commonDao.executeCountQuery(RequestDetails.QUERY_REQUESTED_MENU_DETAILS_BY_MENU_COUNT, params) > 0;
    }

    private Map<String, Object> getRequestsParams(Menu menu) {
        Map<String, Object> params = new HashMap<String, Object>();
        List<RequestStatus> statusList = new ArrayList<RequestStatus>();
        statusList.add(RequestStatus.IN_PROCESS);
        statusList.add(RequestStatus.PAID);
        statusList.add(RequestStatus.ACCEPTED);
        statusList.add(RequestStatus.DECLINED);
        params.put("menu", menu);
        params.put("statuses", statusList);
        return params;
    }

    @Override
    public List<Menu> findMenuByPeriod(Date dateStart, Date dateEnd) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("dateStart", getDateWithoutTime(dateStart));
        DateTime finishDate = new DateTime(getDateWithoutTime(dateEnd));
        finishDate.plusDays(1);
        params.put("dateEnd", finishDate.toDate());
        params.put("statuses", getExcludeStatusesForMenu());
        List<Menu> result = commonDao.find(Menu.class, Menu.QUERY_FIND_MENU_BY_PERIOD, params);
        return result;
    }

    private List<MenuStatus> getExcludeStatusesForMenu() {
        return Arrays.asList(new MenuStatus[] {MenuStatus.DELETED});
    }

    @Override
    public List<Menu> getMenuForCloneOnNextDay() {
        LocalDate localDate = new LocalDate();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("status", MenuStatus.AVAILABLE);
        params.put("currentDate", localDate.toDate());
        return commonDao.find(Menu.class, Menu.QUERY_FIND_MENU_FOR_CLONE_ON_NEXT_DAY, params);
    }

    @Override
    public MenuDetails getMenuDetails(Long id) {
        return commonDao.find(MenuDetails.class, id);
    }
}
