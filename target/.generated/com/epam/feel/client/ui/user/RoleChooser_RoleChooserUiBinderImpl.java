package com.epam.feel.client.ui.user;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class RoleChooser_RoleChooserUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.epam.feel.client.ui.user.RoleChooser>, com.epam.feel.client.ui.user.RoleChooser.RoleChooserUiBinder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.epam.feel.client.ui.user.RoleChooser owner) {

    com.epam.feel.client.ui.user.RoleChooser_RoleChooserUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.epam.feel.client.ui.user.RoleChooser_RoleChooserUiBinderImpl_GenBundle) GWT.create(com.epam.feel.client.ui.user.RoleChooser_RoleChooserUiBinderImpl_GenBundle.class);
    com.epam.feel.client.EpamFeelConstants constants = (com.epam.feel.client.EpamFeelConstants) GWT.create(com.epam.feel.client.EpamFeelConstants.class);
    com.epam.feel.client.EpamFeelResources st = (com.epam.feel.client.EpamFeelResources) GWT.create(com.epam.feel.client.EpamFeelResources.class);
    com.google.gwt.user.client.ui.Anchor asAdmin = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    com.google.gwt.user.client.ui.Anchor asUser = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    com.google.gwt.user.client.ui.HorizontalPanel roleChooser = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);

    asAdmin.setText("" + constants.enterAsAdmin() + "");
    roleChooser.add(asAdmin);
    asUser.setText("" + constants.enterAsClient() + "");
    roleChooser.add(asUser);



    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onAdminRoleSelected(event);
      }
    };
    asAdmin.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onUserRoleSelected(event);
      }
    };
    asUser.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

    owner.asAdmin = asAdmin;
    owner.asUser = asUser;

    return roleChooser;
  }
}
