package com.epam.feel.server.util;

import java.io.IOException;
import java.util.Properties;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.epam.feel.shared.WebAppConstants;
import com.epam.feel.shared.enums.Role;

/**
 * Contains (or loads from properties) some configuration constants.
 * 
 * @author Michael_Silvanovich
 */
public class ConfigUtils {

    private final static Logger LOG = LoggerFactory.getLogger(ConfigUtils.class);

    private static final String DEFAULT_PROPERTIES_FILE = "/DefaultConfig.properties";
    private static final String AM_PROPERTIES_FILE = "/config.properties";

    private static final String PROP_FAKE_ROLE = "config.fake_client_role";
    private static final String PROP_DEFAULT_CLIENT_ID = "config.default_client_id";
    private static final String PROP_EMAILING_ENABLED = "config.emaling_enabled";
    private static final String PROP_STORAGE_PERIOD = "config.storage_period";
    private static final String PROP_CLEANUP_ENABLED = "config.cleanup_enabled";

    private static final Integer DEFAULT_STORAGE_PERIOD = 90;

    private static final boolean EMAILING_ENABLED_STATE;
    private static final boolean CLEANUP_ENABLED;

    public static final Role FAKE_CLIENT_ROLE;
    public static final Long DEFAULT_USER_ID;
    public static final Integer STORAGE_PERIOD;

    public static final String AM_COOKIE_DOMAIN;
    public static final String AM_COOKIE_PATH;

    static {

        final Properties properties = new Properties();
        final Properties propertiesAm = new Properties();
        try {

            properties.load(ConfigUtils.class.getResourceAsStream(DEFAULT_PROPERTIES_FILE));
            propertiesAm.load(ConfigUtils.class.getResourceAsStream(AM_PROPERTIES_FILE));

            AM_COOKIE_DOMAIN = propertiesAm.getProperty(WebAppConstants.AM_KEY_DOMAIN_COOKIE);
            AM_COOKIE_PATH = propertiesAm.getProperty(WebAppConstants.AM_KEY_PATH_COOKIE);

            DEFAULT_USER_ID = getDefaultClientId(properties);
            FAKE_CLIENT_ROLE = getFakeClientRole(properties);
            EMAILING_ENABLED_STATE = getEmailingEnabledState(properties);
            STORAGE_PERIOD = getStoragePeriod(properties);
            CLEANUP_ENABLED = getCleanupEnabled(properties);

        } catch (IllegalArgumentException e) {
            LOG.error(e.getMessage(), e);
            throw new RuntimeException("Role with given name is not found");
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            throw new RuntimeException("Default properties is not found");
        }

    }

    private static Long getDefaultClientId(final Properties properties) {
        return Long.parseLong(properties.getProperty(PROP_DEFAULT_CLIENT_ID));
    }

    private static Boolean getCleanupEnabled(Properties properties) {
        final String cleanupEnabledState = properties.getProperty(PROP_CLEANUP_ENABLED);
        return StringUtils.isBlank(cleanupEnabledState) ? true : Boolean.parseBoolean(cleanupEnabledState.trim());
    }

    private static Integer getStoragePeriod(Properties properties) {
        final String storagePeriod = properties.getProperty(PROP_STORAGE_PERIOD);
        return StringUtils.isBlank(storagePeriod) ? DEFAULT_STORAGE_PERIOD : Integer.parseInt(storagePeriod.trim());
    }

    private static boolean getEmailingEnabledState(Properties properties) {
        final String emailingState = properties.getProperty(PROP_EMAILING_ENABLED);
        return StringUtils.isNotBlank(emailingState) ? Boolean.parseBoolean(emailingState.trim()) : true;
    }

    private static Role getFakeClientRole(final Properties properties) {
        try {
            return getRole(properties, PROP_FAKE_ROLE);
        } catch (IllegalArgumentException e) {
            LOG.error(e.getMessage(), e);
            throw new RuntimeException("Role with given name is not found");
        } catch (NullPointerException e) {
            LOG.error(e.getMessage(), e);
            throw new RuntimeException("Fake client role is not set");
        }
    }

    private static Role getRole(final Properties properties, final String propertyName) {
        try {
            return Role.valueOf(properties.getProperty(propertyName));
        } catch (IllegalArgumentException e) {
            LOG.error(e.getMessage(), e);
            throw new RuntimeException("Role with given name is not found");
        }
    }

    /**
     * Returns email enabled state
     * 
     * @return true - if email is enabled, false - in other case
     */
    public static boolean isEmailingEnabled() {
        return EMAILING_ENABLED_STATE;
    }

    public static boolean isCleanupEnabled() {
        return CLEANUP_ENABLED && STORAGE_PERIOD > 0;
    }

}
