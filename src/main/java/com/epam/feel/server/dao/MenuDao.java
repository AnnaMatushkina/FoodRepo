package com.epam.feel.server.dao;

import java.util.Date;
import java.util.List;
import com.epam.feel.server.model.DishType;
import com.epam.feel.server.model.Image;
import com.epam.feel.server.model.Menu;
import com.epam.feel.server.model.MenuDetails;

/**
 * DAO interface for working with Menu entity class.
 * 
 * @author Evgeny_Neustroev
 */
public interface MenuDao {

    /**
     * Finds all dish types from DB
     * 
     * @return - list entity of all dish types in DB
     */
    public List<DishType> getAllDishTypes();

    /**
     * Saves menu entity in DB
     * 
     * @param menu
     *            - entity to save
     * @return - saved entity or null if it can not be saved
     */
    public Menu saveMenu(Menu menu);

    /**
     * Finds Menu entity in DB by its ID
     * 
     * @param id
     *            - ID of requested entity
     * @return entity from DB or null if it can not be found
     */
    public Menu getMenu(Long id);

    /**
     * Finds list of available menus in DB
     * 
     * @return list of entities from DB
     */
    public List<Menu> getActualMenus();

    /**
     * Finds list of all menus in DB
     * 
     * @return list of entities from DB
     */
    public List<Menu> getAllMenus();

    /**
     * Removes menu from DB
     * 
     * @param menu
     *            - entity for remove
     */
    public void removeMenu(Menu menu);

    /**
     * Check exists menu with receipt date less current date
     * 
     * @return true - if menu not exists or false - if menu exists
     */
    public Boolean checkRequestTime();

    /**
     * Finds list of last menus in DB start on current date
     * 
     * @return list of entities from DB
     */
    public List<Menu> getLastMenus(Date dateStart);

    /**
     * Finds all menus estimated before date
     * 
     * @param date
     *            - estimation date
     * @return list of all menus estimated before date
     */
    public List<Menu> findEstimatedMenusByDate(Date date);

    /**
     * Returns true if menu has requests, false - in other case
     * 
     * @param menu
     *            - menu to count by
     * @return true if menu has requests, false - in other case
     */
    public Boolean hasRequests(Menu menu);

    /**
     * Found menu by period
     * 
     * @param dateStart
     *            start of period
     * @param dateEnd
     *            finish of period
     * @return list of entities from DB
     */
    public List<Menu> findMenuByPeriod(Date dateStart, Date dateEnd);

    /**
     * Found list available menu on current date.
     * 
     * @return list of entities from DB
     */
    public List<Menu> getMenuForCloneOnNextDay();

    /**
     * Finds MenuDetails entity in DB by its ID
     * 
     * @param id
     *            - ID of requested entity
     * @return entity from DB or null if it can not be found
     */
    public MenuDetails getMenuDetails(Long id);

    /**
     * Returns result similar to {@link #getLastMenus(Date)} for current date + menu that has opened requests
     * 
     * @return result similar to {@link #getLastMenus(Date)} for current date + menu that has opened requests
     */
    public List<Menu> getMenusActualOrHavingRequests();

    /**
     * Returns image corresponding to given id
     * 
     * @param id
     *            - id of image to be obtained
     * @return image entity object
     */
    public Image getImage(Long id);

    /**
     * Saves image into db
     * 
     * @param image
     *            - image to be saved
     * @return persisted image
     */
    public Image saveImage(Image image);

    /**
     * Finds and removes unused images by date
     * 
     * @return count of removed images
     */
    public int removeUnusedImages(Date date);

}
