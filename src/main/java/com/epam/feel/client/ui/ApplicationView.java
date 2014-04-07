package com.epam.feel.client.ui;

import com.epam.feel.client.EpamFeelResources;
import com.epam.feel.client.activity.ApplicationActivity;
import com.epam.feel.client.ui.admin.ChooseRoleDialog;
import com.epam.feel.client.ui.admin.MainMenuAdminView;
import com.epam.feel.client.ui.user.MainMenuUserView;
import com.epam.feel.client.ui.util.dialogs.MessageDialog;
import com.epam.feel.client.ui.util.role.ChooseRoleListener;
import com.epam.feel.client.ui.util.role.IRoleChooser;
import com.epam.feel.client.ui.util.role.RoleChoseMainMenu;
import com.epam.feel.client.view.IApplicationView;
import com.epam.feel.shared.dto.ClientDTO;
import com.epam.feel.shared.enums.Role;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;

/**
 * Main application layout view implementation.
 * 
 * @author Anna_Gavrilina
 */
@Singleton
public class ApplicationView extends Composite implements IApplicationView {

    interface ApplicationViewUiBinder extends UiBinder<Widget, ApplicationView> {}

    private static ApplicationViewUiBinder uiBinder = GWT.create(ApplicationViewUiBinder.class);

    @UiField
    RootLayoutPanel content;

    private ApplicationActivity applicationActivity;

    private ChooseRoleDialog chooseRoleDialog;
    private MainMenuAdminView mainMenuAdminView;
    private MainMenuUserView mainMenuUserView;

    private ChooseRoleListener chooserCallback;
    private Role userRole;

    public ApplicationView() {
        EpamFeelResources.INSTANCE.global().ensureInjected();
        initWidget(uiBinder.createAndBindUi(this));
    }

    private AsyncCallback<ClientDTO> callback = new AsyncCallback<ClientDTO>() {
        @Override
        public void onFailure(Throwable throwable) {
            GWT.log("ApplicationView.callback (err)", throwable);
        }

        @Override
        public void onSuccess(ClientDTO result) {
            if (mainMenuUserView != null)
                mainMenuUserView.setPresenter(applicationActivity);
            Role oldRole = userRole;
            userRole = result.getRole();
            if (userRole == oldRole) {
                return;
            }
            content.clear();
            if (userRole == Role.ADMIN) {
                getChooseRoleDialog().show();
            } else if (userRole == Role.CLIENT) {
                content.add(getMainMenuClientView());
            } else {
                MessageDialog.alert("[Error] - ApplicationView");
                userRole = null;
            }
        }

    };

    protected ChooseRoleDialog getChooseRoleDialog() {
        if (chooseRoleDialog == null) {
            chooseRoleDialog = new ChooseRoleDialog();
            chooseRoleDialog.setListener(getChooserCallback());
        }
        return chooseRoleDialog;
    }

    protected ChooseRoleListener getChooserCallback() {
        if (chooserCallback == null) {
            chooserCallback = createChooserCallback();
        }
        return chooserCallback;
    }

    protected ChooseRoleListener createChooserCallback() {
        return new ChooseRoleListener() {

            @Override
            public void onRoleChoosed(Role role) {
                showRole(role);
            }
        };
    }

    private void showRole(Role role) {
        content.clear();
        boolean canRefresh = true;
        if (role == Role.ADMIN) {
            canRefresh = mainMenuAdminView != null;
            mainMenuAdminView = getMainMenuAdminView();
            resetRoleChooser(mainMenuAdminView, role);
            content.add(mainMenuAdminView);
            if (canRefresh) {
                mainMenuAdminView.refreshData();
            }
        } else {
            canRefresh = mainMenuUserView != null;
            mainMenuUserView = getMainMenuClientView();
            resetRoleChooser(mainMenuUserView, role);
            content.add(mainMenuUserView);
            if (canRefresh) {
                mainMenuUserView.refreshData();
            }
        }
    }

    private void resetRoleChooser(RoleChoseMainMenu activeView, Role newRole) {
        IRoleChooser chooser = activeView.getRoleChooser();
        boolean isAdmin = userRole == Role.ADMIN;
        if (isAdmin) {
            chooser.setListener(getChooserCallback());
            chooser.toggleRole(newRole);
        } else {
            chooser.setListener(null);
        }
        chooser.setVisible(isAdmin);
    }

    protected MainMenuAdminView getMainMenuAdminView() {
        if (mainMenuAdminView == null) {
            mainMenuAdminView = new MainMenuAdminView(applicationActivity);
        }
        return mainMenuAdminView;
    }

    protected MainMenuUserView getMainMenuClientView() {
        if (mainMenuUserView == null) {
            mainMenuUserView = new MainMenuUserView(applicationActivity);
        }
        return mainMenuUserView;
    }

    private void initClient() {
        applicationActivity.getHeader().getCurrentClient(callback);
    }

    @Override
    public void setPresenter(ApplicationActivity applicationActivity) {
        this.applicationActivity = applicationActivity;
        initClient();
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        hideProgress();
    }

    private static native void hideProgress()
    /*-{
		$doc.getElementById('progress').style.visibility = 'hidden';
    }-*/;

}