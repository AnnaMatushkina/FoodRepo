package com.epam.feel.client.ui.admin;

import static com.epam.feel.client.IEpamFeelConstants.CONSTANTS;
import com.epam.feel.client.ui.util.role.ChooseRoleListener;
import com.epam.feel.shared.enums.Role;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * Dialog with two anchors, used to provide UI for choosing role by administrator.
 * 
 * @author Michael_Silvanovich
 */
public class ChooseRoleDialog extends DialogBox {

    private static ChooseRoleDialogUiBinder uiBinder = GWT.create(ChooseRoleDialogUiBinder.class);

    interface ChooseRoleDialogUiBinder extends UiBinder<Widget, ChooseRoleDialog> {}

    @UiField
    Anchor asAdminLink;

    @UiField
    Anchor asClientLink;

    private ChooseRoleListener listener = ChooseRoleListener.NULL_LISTENER;

    public ChooseRoleDialog() {
        super();
        initUi();
    }

    protected void initUi() {
        setGlassEnabled(true);
        setAnimationEnabled(true);
        setModal(true);
        setText(CONSTANTS.chooseRoleDialogTitle());
        setWidget(uiBinder.createAndBindUi(this));
        center();
    }

    /**
     * Sets callback to choose role component
     * 
     * @param listener
     *            new callback to choose role component
     */
    public void setListener(ChooseRoleListener listener) {
        if (listener == null) {
            listener = ChooseRoleListener.NULL_LISTENER;
        }
        this.listener = listener;
    }

    @UiHandler ("asAdminLink")
    void onAdminRoleSelected(ClickEvent event) {
        listener.onRoleChoosed(Role.ADMIN);
        hide();
    }

    @UiHandler ("asClientLink")
    void onClientRoleSelected(ClickEvent event) {
        listener.onRoleChoosed(Role.CLIENT);
        hide();
    }

}
