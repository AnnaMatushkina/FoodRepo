package com.epam.feel.server.service;

import com.epam.feel.server.dao.RequestDao;

/**
 * Class to provide hacky access in tests to RequestDao field of RequestInfoServiceImpl
 * 
 * @author Michael_Silvanovich
 */
@Deprecated
interface HasRequestDaoSetter {

    /**
     * Sets RequestDao
     * 
     * @param dao
     *            new RequestDao to be set
     */
    @Deprecated
    void setRequestDao(RequestDao dao);

}
