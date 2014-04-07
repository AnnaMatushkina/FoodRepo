package com.epam.feel.client.ui.util.role;

import com.epam.feel.shared.enums.Role;

/**
 * Callback to indicate selecting role by client.
 * 
 * @author Michael_Silvanovich
 */
public interface ChooseRoleListener {

    /**
     * @param role
     *            choose role
     */
    void onRoleChoosed(Role role);

    /**
     * Default EMPTY listener, to avoid of NPE
     */
    public static final ChooseRoleListener NULL_LISTENER = new ChooseRoleListener() {
        @Override
        public void onRoleChoosed(Role role) {}
    };

}
