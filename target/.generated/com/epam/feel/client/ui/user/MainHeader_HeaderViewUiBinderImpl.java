package com.epam.feel.client.ui.user;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class MainHeader_HeaderViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.epam.feel.client.ui.user.MainHeader>, com.epam.feel.client.ui.user.MainHeader.HeaderViewUiBinder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.epam.feel.client.ui.user.MainHeader owner) {

    com.epam.feel.client.ui.user.MainHeader_HeaderViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.epam.feel.client.ui.user.MainHeader_HeaderViewUiBinderImpl_GenBundle) GWT.create(com.epam.feel.client.ui.user.MainHeader_HeaderViewUiBinderImpl_GenBundle.class);
    com.epam.feel.client.EpamFeelConstants constants = (com.epam.feel.client.EpamFeelConstants) GWT.create(com.epam.feel.client.EpamFeelConstants.class);
    com.epam.feel.client.EpamFeelResources st = (com.epam.feel.client.EpamFeelResources) GWT.create(com.epam.feel.client.EpamFeelResources.class);
    com.google.gwt.user.client.ui.Anchor headerTitle = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    com.google.gwt.user.client.ui.Label personalAccountLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Anchor exit = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel4 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label5 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label f_Label6 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label numAccount = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel paPanel = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Anchor balanceLink = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    com.google.gwt.user.client.ui.Label f_Label7 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label labelPrepayment = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label f_Label8 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label f_Label9 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel paymentPanel = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Anchor requestsAnchor = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    com.google.gwt.user.client.ui.Label f_Label10 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label requestsValue = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel requestsPanel = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Anchor archiveRequestLink = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    com.google.gwt.user.client.ui.SimplePanel f_SimplePanel11 = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
    com.epam.feel.client.ui.user.RoleChooser roleChooser = (com.epam.feel.client.ui.user.RoleChooser) GWT.create(com.epam.feel.client.ui.user.RoleChooser.class);
    com.google.gwt.user.client.ui.Image adviceImg = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
    com.google.gwt.user.client.ui.Anchor adviceAnchor = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    com.google.gwt.user.client.ui.HorizontalPanel advicePanel = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Image notAdviceImg = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
    com.google.gwt.user.client.ui.Anchor notAdviceAnchor = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    com.google.gwt.user.client.ui.HorizontalPanel notAdvicePanel = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel3 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.DecoratorPanel f_DecoratorPanel2 = (com.google.gwt.user.client.ui.DecoratorPanel) GWT.create(com.google.gwt.user.client.ui.DecoratorPanel.class);
    com.epam.feel.client.ui.util.table.SortableDataGrid requestsMenu = (com.epam.feel.client.ui.util.table.SortableDataGrid) GWT.create(com.epam.feel.client.ui.util.table.SortableDataGrid.class);
    com.google.gwt.user.client.ui.Button closeOrdersButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel12 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.DialogBox requestsTablePanel = new com.google.gwt.user.client.ui.DialogBox(false, true);
    com.google.gwt.user.client.ui.DockLayoutPanel f_DockLayoutPanel1 = new com.google.gwt.user.client.ui.DockLayoutPanel(com.google.gwt.dom.client.Style.Unit.PX);

    headerTitle.setStyleName("" + st.global().header() + "");
    headerTitle.setText("" + constants.systemLogoLabel() + "");
    f_HorizontalPanel4.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    personalAccountLabel.setStyleName("" + st.global().headerPersonalAccountLabel() + "");
    personalAccountLabel.setText("" + constants.personalAccountField() + "");
    f_HorizontalPanel4.add(personalAccountLabel);
    exit.setStyleName("" + st.global().logout() + "");
    exit.setTitle("" + constants.exitLabel() + "");
    f_HorizontalPanel4.add(exit);
    f_HorizontalPanel4.setWidth("100%");
    f_VerticalPanel3.add(f_HorizontalPanel4);
    f_Label5.setText("" + constants.personalAccountNumLabel() + "");
    paPanel.add(f_Label5);
    f_Label6.setText(": ");
    paPanel.add(f_Label6);
    numAccount.setStyleName("" + st.global().boldDateLabel() + "");
    numAccount.setText("" + constants.personalAccountNumField() + "");
    paPanel.add(numAccount);
    paPanel.setStyleName("" + st.global().headerPersonalAccountNum() + "");
    f_VerticalPanel3.add(paPanel);
    balanceLink.setText("" + constants.advanceLabel() + "");
    paymentPanel.add(balanceLink);
    f_Label7.setText(": ");
    paymentPanel.add(f_Label7);
    labelPrepayment.setStyleName("" + st.global().boldDateLabel() + "");
    labelPrepayment.setText("" + constants.paymentLabel() + "");
    paymentPanel.add(labelPrepayment);
    f_Label8.setText(" ");
    paymentPanel.add(f_Label8);
    f_Label9.setText("" + constants.monetaryUnit() + "");
    paymentPanel.add(f_Label9);
    paymentPanel.setStyleName("" + st.global().headerPayment() + "");
    f_VerticalPanel3.add(paymentPanel);
    requestsAnchor.setText("" + constants.activeOrders() + "");
    requestsPanel.add(requestsAnchor);
    f_Label10.setText(": ");
    requestsPanel.add(f_Label10);
    requestsValue.setStyleName("" + st.global().boldDateLabel() + "");
    requestsPanel.add(requestsValue);
    requestsPanel.setVisible(false);
    f_VerticalPanel3.add(requestsPanel);
    archiveRequestLink.setText("" + constants.archiveRequest() + "");
    f_VerticalPanel3.add(archiveRequestLink);
    f_SimplePanel11.setStyleName("" + st.global().delimeterLineHeader() + "");
    f_SimplePanel11.setWidth("100%");
    f_SimplePanel11.setHeight("0px");
    f_VerticalPanel3.add(f_SimplePanel11);
    roleChooser.setVisible(false);
    f_VerticalPanel3.add(roleChooser);
    adviceImg.setStyleName("" + st.global().imgAdvice() + "");
    adviceImg.setWidth("23px");
    adviceImg.setUrl("epam_feel/email.png");
    adviceImg.setHeight("19px");
    advicePanel.add(adviceImg);
    adviceAnchor.setText("" + constants.notificationAdvice() + "");
    advicePanel.add(adviceAnchor);
    advicePanel.setVisible(false);
    f_VerticalPanel3.add(advicePanel);
    notAdviceImg.setStyleName("" + st.global().imgAdvice() + "");
    notAdviceImg.setWidth("23px");
    notAdviceImg.setUrl("epam_feel/email_close.png");
    notAdviceImg.setHeight("19px");
    notAdvicePanel.add(notAdviceImg);
    notAdviceAnchor.setText("" + constants.notificationNotAdvice() + "");
    notAdvicePanel.add(notAdviceAnchor);
    notAdvicePanel.setVisible(false);
    f_VerticalPanel3.add(notAdvicePanel);
    f_VerticalPanel3.setWidth("100%");
    f_DecoratorPanel2.add(f_VerticalPanel3);
    f_DecoratorPanel2.setStyleName("gwt-DecoratorPanel " + st.global().headerDecoratorPanel() + "");
    f_DockLayoutPanel1.addEast(f_DecoratorPanel2, 450);
    f_VerticalPanel12.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    requestsMenu.setWidth("500");
    requestsMenu.setHeight("200");
    f_VerticalPanel12.add(requestsMenu);
    closeOrdersButton.setText("" + constants.closeDialog() + "");
    f_VerticalPanel12.add(closeOrdersButton);
    requestsTablePanel.setWidget(f_VerticalPanel12);
    requestsTablePanel.setGlassEnabled(true);
    requestsTablePanel.setAutoHideOnHistoryEventsEnabled(true);
    requestsTablePanel.setVisible(false);
    requestsTablePanel.setText("" + constants.activeOrders() + "");
    requestsTablePanel.setAnimationEnabled(true);
    f_DockLayoutPanel1.addSouth(requestsTablePanel, 0);
    f_DockLayoutPanel1.add(headerTitle);
    f_DockLayoutPanel1.setStyleName("" + st.global().headerMainTable() + "");
    f_DockLayoutPanel1.setWidth("100%");



    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.goToMainPage(event);
      }
    };
    headerTitle.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onExit(event);
      }
    };
    exit.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onRequestsAnchorClicked(event);
      }
    };
    requestsAnchor.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onCloseDialogClicked(event);
      }
    };
    closeOrdersButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onBalanceLinkClicked(event);
      }
    };
    balanceLink.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onPersonalAccount(event);
      }
    };
    archiveRequestLink.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onAdviceBox(event);
      }
    };
    adviceAnchor.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7);
    adviceImg.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onNotAdviceBox(event);
      }
    };
    notAdviceAnchor.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8);
    notAdviceImg.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8);

    owner.advicePanel = advicePanel;
    owner.archiveRequestLink = archiveRequestLink;
    owner.balanceLink = balanceLink;
    owner.labelPrepayment = labelPrepayment;
    owner.notAdvicePanel = notAdvicePanel;
    owner.numAccount = numAccount;
    owner.paPanel = paPanel;
    owner.paymentPanel = paymentPanel;
    owner.personalAccountLabel = personalAccountLabel;
    owner.requestsMenu = requestsMenu;
    owner.requestsPanel = requestsPanel;
    owner.requestsTablePanel = requestsTablePanel;
    owner.requestsValue = requestsValue;
    owner.roleChooser = roleChooser;

    return f_DockLayoutPanel1;
  }
}
