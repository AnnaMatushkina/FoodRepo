package com.epam.feel.client.ui.util.role;

import com.epam.feel.shared.enums.Role;
import com.google.gwt.user.client.ui.Widget;

public interface IRoleChooser {

    /**
     * Sets callback to choose role component
     * 
     * @param listener
     *            new callback to choose role component
     */
    void setListener(ChooseRoleListener listener);

    /**
     * Sets role chooser view to represent a given role
     * 
     * @param newRole
     *            role to represent
     */
    void toggleRole(Role newRole);

    /**
     * @see Widget#setVisible(boolean)
     */
    void setVisible(boolean visible);

}