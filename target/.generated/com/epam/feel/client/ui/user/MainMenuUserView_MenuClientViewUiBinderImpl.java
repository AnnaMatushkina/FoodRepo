package com.epam.feel.client.ui.user;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class MainMenuUserView_MenuClientViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.epam.feel.client.ui.user.MainMenuUserView>, com.epam.feel.client.ui.user.MainMenuUserView.MenuClientViewUiBinder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.epam.feel.client.ui.user.MainMenuUserView owner) {

    com.epam.feel.client.ui.user.MainMenuUserView_MenuClientViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.epam.feel.client.ui.user.MainMenuUserView_MenuClientViewUiBinderImpl_GenBundle) GWT.create(com.epam.feel.client.ui.user.MainMenuUserView_MenuClientViewUiBinderImpl_GenBundle.class);
    com.epam.feel.client.EpamFeelConstants constants = (com.epam.feel.client.EpamFeelConstants) GWT.create(com.epam.feel.client.EpamFeelConstants.class);
    com.epam.feel.client.EpamFeelResources st = (com.epam.feel.client.EpamFeelResources) GWT.create(com.epam.feel.client.EpamFeelResources.class);
    com.epam.feel.client.ui.user.MainHeader header = (com.epam.feel.client.ui.user.MainHeader) GWT.create(com.epam.feel.client.ui.user.MainHeader.class);
    com.epam.feel.client.ui.user.Footer footer = (com.epam.feel.client.ui.user.Footer) GWT.create(com.epam.feel.client.ui.user.Footer.class);
    com.google.gwt.user.client.ui.Label f_Label5 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.ListBox nameMenu = (com.google.gwt.user.client.ui.ListBox) GWT.create(com.google.gwt.user.client.ui.ListBox.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel4 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label7 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label dateMenu = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel6 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label9 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label dateTakeRequest = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label f_Label10 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label timeFrom = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label f_Label11 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label timeTo = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel8 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label12 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label dateBecameRequest = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label f_Label13 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label deliveryTimeFrom = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label f_Label14 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label deliveryTimeTo = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel deliveryTimes = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Hyperlink orderLinkTop = (com.google.gwt.user.client.ui.Hyperlink) GWT.create(com.google.gwt.user.client.ui.Hyperlink.class);
    com.google.gwt.user.client.ui.Label f_Label16 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Hyperlink clearLinkTop = (com.google.gwt.user.client.ui.Hyperlink) GWT.create(com.google.gwt.user.client.ui.Hyperlink.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel15 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.epam.feel.client.ui.util.table.MenuTable menu = (com.epam.feel.client.ui.util.table.MenuTable) GWT.create(com.epam.feel.client.ui.util.table.MenuTable.class);
    com.google.gwt.user.client.ui.Hyperlink orderLinkBottom = (com.google.gwt.user.client.ui.Hyperlink) GWT.create(com.google.gwt.user.client.ui.Hyperlink.class);
    com.google.gwt.user.client.ui.Label statusPostOrder = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Hyperlink clearLinkBottom = (com.google.gwt.user.client.ui.Hyperlink) GWT.create(com.google.gwt.user.client.ui.Hyperlink.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel17 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel menuPanel = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel mainPanel = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label18 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.VerticalPanel noFindActiveMenusPanel = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel3 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.ScrollPanel f_ScrollPanel2 = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
    com.google.gwt.user.client.ui.DockLayoutPanel f_DockLayoutPanel1 = new com.google.gwt.user.client.ui.DockLayoutPanel(com.google.gwt.dom.client.Style.Unit.PX);

    f_DockLayoutPanel1.addNorth(header, 175);
    f_DockLayoutPanel1.addSouth(footer, 30);
    f_Label5.setText("" + constants.choosedMenuLabel() + "");
    f_HorizontalPanel4.add(f_Label5);
    nameMenu.setWidth("500");
    f_HorizontalPanel4.add(nameMenu);
    f_HorizontalPanel4.setSpacing(5);
    mainPanel.add(f_HorizontalPanel4);
    f_Label7.setText("" + constants.menuForLabel() + "");
    f_HorizontalPanel6.add(f_Label7);
    dateMenu.setStyleName("" + st.global().boldDateLabel() + "");
    f_HorizontalPanel6.add(dateMenu);
    f_HorizontalPanel6.setSpacing(5);
    mainPanel.add(f_HorizontalPanel6);
    f_Label9.setText("" + constants.dateTakeRequestField() + "");
    f_HorizontalPanel8.add(f_Label9);
    dateTakeRequest.setStyleName("" + st.global().boldDateLabel() + "");
    f_HorizontalPanel8.add(dateTakeRequest);
    f_Label10.setText("" + constants.timeFromField() + "");
    f_HorizontalPanel8.add(f_Label10);
    timeFrom.setStyleName("" + st.global().boldDateLabel() + "");
    f_HorizontalPanel8.add(timeFrom);
    f_Label11.setText("" + constants.timeToField() + "");
    f_HorizontalPanel8.add(f_Label11);
    timeTo.setStyleName("" + st.global().boldDateLabel() + "");
    f_HorizontalPanel8.add(timeTo);
    f_HorizontalPanel8.setSpacing(5);
    mainPanel.add(f_HorizontalPanel8);
    f_Label12.setText("" + constants.dateBecameRequestField() + "");
    deliveryTimes.add(f_Label12);
    dateBecameRequest.setStyleName("" + st.global().boldDateLabel() + "");
    deliveryTimes.add(dateBecameRequest);
    f_Label13.setText("" + constants.deliveryTimeFromField() + "");
    deliveryTimes.add(f_Label13);
    deliveryTimeFrom.setStyleName("" + st.global().boldDateLabel() + "");
    deliveryTimes.add(deliveryTimeFrom);
    f_Label14.setText("" + constants.timeToField() + "");
    deliveryTimes.add(f_Label14);
    deliveryTimeTo.setStyleName("" + st.global().boldDateLabel() + "");
    deliveryTimes.add(deliveryTimeTo);
    deliveryTimes.setSpacing(5);
    mainPanel.add(deliveryTimes);
    orderLinkTop.setText("" + constants.orderLinkField() + "");
    f_HorizontalPanel15.add(orderLinkTop);
    f_Label16.setText("" + constants.wishes() + "");
    f_HorizontalPanel15.add(f_Label16);
    f_HorizontalPanel15.setCellHorizontalAlignment(f_Label16, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    clearLinkTop.setText("" + constants.clearLinkField() + "");
    f_HorizontalPanel15.add(clearLinkTop);
    f_HorizontalPanel15.setCellHorizontalAlignment(clearLinkTop, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_HorizontalPanel15.setWidth("100%");
    mainPanel.add(f_HorizontalPanel15);
    menu.setBorderWidth(1);
    menu.setWidth("100%");
    menuPanel.add(menu);
    orderLinkBottom.setText("" + constants.orderLinkField() + "");
    f_HorizontalPanel17.add(orderLinkBottom);
    statusPostOrder.setText("");
    f_HorizontalPanel17.add(statusPostOrder);
    f_HorizontalPanel17.setCellHorizontalAlignment(statusPostOrder, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    clearLinkBottom.setText("" + constants.clearLinkField() + "");
    f_HorizontalPanel17.add(clearLinkBottom);
    f_HorizontalPanel17.setCellHorizontalAlignment(clearLinkBottom, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_HorizontalPanel17.setWidth("100%");
    menuPanel.add(f_HorizontalPanel17);
    menuPanel.setWidth("100%");
    mainPanel.add(menuPanel);
    mainPanel.setSpacing(5);
    mainPanel.setWidth("100%");
    f_HorizontalPanel3.add(mainPanel);
    f_Label18.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    f_Label18.setText("" + constants.noFindActiveMenusNotification() + "");
    noFindActiveMenusPanel.add(f_Label18);
    noFindActiveMenusPanel.setVisible(false);
    noFindActiveMenusPanel.setWidth("100%");
    f_HorizontalPanel3.add(noFindActiveMenusPanel);
    f_HorizontalPanel3.setSpacing(5);
    f_HorizontalPanel3.setWidth("100%");
    f_ScrollPanel2.add(f_HorizontalPanel3);
    f_ScrollPanel2.setAlwaysShowScrollBars(false);
    f_DockLayoutPanel1.add(f_ScrollPanel2);
    f_DockLayoutPanel1.setWidth("100%");
    f_DockLayoutPanel1.setHeight("100%");



    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onOrderLinkClicked(event);
      }
    };
    orderLinkTop.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);
    orderLinkBottom.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    final com.google.gwt.event.dom.client.ChangeHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ChangeHandler() {
      public void onChange(com.google.gwt.event.dom.client.ChangeEvent event) {
        owner.onNameMenuChange(event);
      }
    };
    nameMenu.addChangeHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClearLinkClicked(event);
      }
    };
    clearLinkTop.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);
    clearLinkBottom.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);

    owner.dateBecameRequest = dateBecameRequest;
    owner.dateMenu = dateMenu;
    owner.dateTakeRequest = dateTakeRequest;
    owner.deliveryTimeFrom = deliveryTimeFrom;
    owner.deliveryTimeTo = deliveryTimeTo;
    owner.deliveryTimes = deliveryTimes;
    owner.footer = footer;
    owner.header = header;
    owner.mainPanel = mainPanel;
    owner.menu = menu;
    owner.menuPanel = menuPanel;
    owner.nameMenu = nameMenu;
    owner.noFindActiveMenusPanel = noFindActiveMenusPanel;
    owner.statusPostOrder = statusPostOrder;
    owner.timeFrom = timeFrom;
    owner.timeTo = timeTo;

    return f_DockLayoutPanel1;
  }
}
