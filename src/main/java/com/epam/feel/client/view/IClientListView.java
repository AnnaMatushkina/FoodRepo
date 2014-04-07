package com.epam.feel.client.view;

import com.epam.feel.client.activity.ApplicationActivity;
import com.epam.feel.client.ui.util.pagination.PagingDataProvider;
import com.epam.feel.shared.dto.ClientDTO;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Interface for ClientListView
 * 
 * @author Michael_Silvanovich
 */
public interface IClientListView extends IsWidget {

    /**
     * ClientListView presenter interface
     * 
     * @author Michael_Silvanovich
     */
    public interface IClientListViewPresenter extends ISuperPresenter {

        /**
         * Returns provider for clients table
         * 
         * @return provider for clients table
         */
        public PagingDataProvider<ClientDTO> getClientsProvider();

        /**
         * Sets name pattern to filter clients by
         * 
         * @param likeString
         *            - name pattern
         */
        public void setNameFilterString(String likeString);

    }

    /**
     * Sets presenter holder
     * 
     * @param activity
     */
    public void setPresenter(ApplicationActivity activity);

    /**
     * Returns presenter set to ClientListView instance
     * 
     * @return presenter set to ClientListView instance
     */
    public IClientListViewPresenter getPresenter();

}
