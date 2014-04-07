package com.epam.feel.client.ui.util.highlighting;

/**
 * Interface for components providing isChanged() method.
 * 
 * @author Michael_Silvanovich
 */
public interface Stateful {

    /**
     * Returns true if content is changed, false - in other case
     * 
     * @return true if content is changed, false - in other case
     */
    boolean isChanged();

}
