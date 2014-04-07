package com.epam.feel.client.ui.admin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ChooseRoleDialog_ChooseRoleDialogUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.epam.feel.client.ui.admin.ChooseRoleDialog>, com.epam.feel.client.ui.admin.ChooseRoleDialog.ChooseRoleDialogUiBinder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.epam.feel.client.ui.admin.ChooseRoleDialog owner) {

    com.epam.feel.client.ui.admin.ChooseRoleDialog_ChooseRoleDialogUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.epam.feel.client.ui.admin.ChooseRoleDialog_ChooseRoleDialogUiBinderImpl_GenBundle) GWT.create(com.epam.feel.client.ui.admin.ChooseRoleDialog_ChooseRoleDialogUiBinderImpl_GenBundle.class);
    com.epam.feel.client.EpamFeelConstants constants = (com.epam.feel.client.EpamFeelConstants) GWT.create(com.epam.feel.client.EpamFeelConstants.class);
    com.google.gwt.user.client.ui.Anchor asAdminLink = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    com.google.gwt.user.client.ui.Anchor asClientLink = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);

    f_VerticalPanel1.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    asAdminLink.setText("" + constants.enterAsAdmin() + "");
    f_VerticalPanel1.add(asAdminLink);
    asClientLink.setText("" + constants.enterAsClient() + "");
    f_VerticalPanel1.add(asClientLink);
    f_VerticalPanel1.setWidth("100%");



    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onAdminRoleSelected(event);
      }
    };
    asAdminLink.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClientRoleSelected(event);
      }
    };
    asClientLink.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

    owner.asAdminLink = asAdminLink;
    owner.asClientLink = asClientLink;

    return f_VerticalPanel1;
  }
}
