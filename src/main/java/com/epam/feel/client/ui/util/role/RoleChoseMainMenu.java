package com.epam.feel.client.ui.util.role;

/**
 * MainMenu with role chooser, used to provide administrator possibilities of role choosing.
 * 
 * @author Michael_Silvanovich
 */
public interface RoleChoseMainMenu {

    /**
     * Returns role chooser component specified for this main menu
     * 
     * @return role chooser component
     */
    IRoleChooser getRoleChooser();

    /**
     * Will be called after choosing
     */
    void refreshData();

}
