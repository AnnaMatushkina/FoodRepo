package com.epam.feel.server.service;

import com.epam.feel.server.dao.MenuDao;

/**
 * Class to provide hacky access in tests to MenuDao field of MenuInfoServiceImpl
 * 
 * @author Michael_Silvanovich
 */
@Deprecated
interface HasMenuDaoSetter {

    /**
     * Sets MenuDao
     * 
     * @param dao
     *            new MenuDao to be set
     */
    @Deprecated
    void setMenuDao(MenuDao dao);

}
