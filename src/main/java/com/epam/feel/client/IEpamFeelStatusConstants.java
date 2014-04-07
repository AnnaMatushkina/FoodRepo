package com.epam.feel.client;

import com.google.gwt.core.client.GWT;

/**
 * Interface for getting localized constant strings of enums for application.
 * 
 * @author Evgeny_Neustroev
 */
public interface IEpamFeelStatusConstants extends EpamFeelStatusConstants {

    public static final IEpamFeelStatusConstants STATUSES = GWT.create(IEpamFeelStatusConstants.class);

}
