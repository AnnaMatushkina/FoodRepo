package com.epam.feel.client;

import com.google.gwt.core.client.GWT;

/**
 * Interface for getting localized parameterized strings for application.
 * 
 * @author Evgeny_Neustroev
 */
public interface IEpamFeelMessages extends EpamFeelMessages {

    public static final IEpamFeelMessages MESSAGES = GWT.create(IEpamFeelMessages.class);

}
