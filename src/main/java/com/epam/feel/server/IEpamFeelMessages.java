package com.epam.feel.server;

import org.apache.commons.lang.StringUtils;
import com.mattbertolini.hermes.Hermes;

/**
 * Interface for getting localized parameterized strings for application.
 * 
 * @author Michael_Silvanovich
 */
public abstract class IEpamFeelMessages {

    public static final EpamFeelMessages MESSAGES;

    static {
        try {
            MESSAGES = Hermes.get(EpamFeelMessages.class, StringUtils.EMPTY);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
