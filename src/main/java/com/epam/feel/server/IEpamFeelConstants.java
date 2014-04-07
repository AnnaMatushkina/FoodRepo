package com.epam.feel.server;

import org.apache.commons.lang.StringUtils;
import com.mattbertolini.hermes.Hermes;

/**
 * Interface for getting localized parameterized strings for application.
 * 
 * @author Michael_Silvanovich
 */
public abstract class IEpamFeelConstants {

    public static final EpamFeelConstants CONSTANTS;

    static {
        try {
            CONSTANTS = Hermes.get(EpamFeelConstants.class, StringUtils.EMPTY);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
