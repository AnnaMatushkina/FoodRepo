package com.epam.feel.server.service;

import com.epam.feel.server.dao.ClientDao;

/**
 * Class to provide hacky access in tests to ClientDao field of ClientInfoServiceImpl
 * 
 * @author Michael_Silvanovich
 */
@Deprecated
interface HasClientDaoSetter {

    /**
     * Sets ClientDao
     * 
     * @param dao
     *            new ClientDao to be set
     */
    @Deprecated
    void setClientDao(ClientDao dao);

}
