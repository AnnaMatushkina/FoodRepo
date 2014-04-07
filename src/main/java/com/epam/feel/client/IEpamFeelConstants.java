package com.epam.feel.client;

import com.google.gwt.core.client.GWT;

/**
 * Interface for getting localized constant strings for application.
 * 
 * @author Evgeny_Neustroev
 */
public interface IEpamFeelConstants extends EpamFeelConstants {

    public static final IEpamFeelConstants CONSTANTS = GWT.create(IEpamFeelConstants.class);

}
