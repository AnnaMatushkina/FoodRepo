package com.epam.feel.server.service;

import com.epam.feel.server.util.ConfigUtils;



/**
 * Clean up service for periodically removing of useless data from DB.
 * 
 * @author Michael_Silvanovich
 */
public interface CleanupBean {

    /**
     * Cleans up useless data (with storage period specified in ConfigUtils) from database
     * 
     * @see ConfigUtils
     */
    public void cleanUp();

}
