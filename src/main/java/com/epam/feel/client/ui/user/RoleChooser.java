package com.epam.feel.client.ui.user;

import com.epam.feel.client.ui.util.role.ChooseRoleListener;
import com.epam.feel.client.ui.util.role.IRoleChooser;
import com.epam.feel.shared.enums.Role;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * RoleChooser component, presents switcher between roles for administrator.
 * 
 * @author Michael_Silvanovich
 */
public class RoleChooser extends Composite implements IRoleChooser {

    private static RoleChooserUiBinder uiBinder = GWT.create(RoleChooserUiBinder.class);

    interface RoleChooserUiBinder extends UiBinder<Widget, RoleChooser> {}

    private ChooseRoleListener listener = ChooseRoleListener.NULL_LISTENER;

    @UiField
    Anchor asAdmin;

    @UiField
    Anchor asUser;

    public RoleChooser() {
        initWidget(uiBinder.createAndBindUi(this));
        toggleRole(Role.ADMIN);
    }

    public void setListener(ChooseRoleListener listener) {
        if (listener == null) {
            listener = ChooseRoleListener.NULL_LISTENER;
        }
        this.listener = listener;
    }

    @UiHandler ("asAdmin")
    void onAdminRoleSelected(ClickEvent event) {
        listener.onRoleChoosed(Role.ADMIN);
    }

    @UiHandler ("asUser")
    void onUserRoleSelected(ClickEvent event) {
        listener.onRoleChoosed(Role.CLIENT);
    }

    public void toggleRole(Role newRole) {
        final boolean isAdmin = newRole == Role.ADMIN;
        assert isAdmin || newRole == Role.CLIENT;
        asAdmin.setVisible(!isAdmin);
        asUser.setVisible(isAdmin);
    }
}
