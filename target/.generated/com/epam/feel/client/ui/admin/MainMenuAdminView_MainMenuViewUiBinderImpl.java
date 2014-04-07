package com.epam.feel.client.ui.admin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class MainMenuAdminView_MainMenuViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.epam.feel.client.ui.admin.MainMenuAdminView>, com.epam.feel.client.ui.admin.MainMenuAdminView.MainMenuViewUiBinder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.epam.feel.client.ui.admin.MainMenuAdminView owner) {

    com.epam.feel.client.ui.admin.MainMenuAdminView_MainMenuViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.epam.feel.client.ui.admin.MainMenuAdminView_MainMenuViewUiBinderImpl_GenBundle) GWT.create(com.epam.feel.client.ui.admin.MainMenuAdminView_MainMenuViewUiBinderImpl_GenBundle.class);
    com.epam.feel.client.EpamFeelConstants constants = (com.epam.feel.client.EpamFeelConstants) GWT.create(com.epam.feel.client.EpamFeelConstants.class);
    com.epam.feel.client.ui.user.MainHeader header = (com.epam.feel.client.ui.user.MainHeader) GWT.create(com.epam.feel.client.ui.user.MainHeader.class);
    com.epam.feel.client.ui.user.Footer footer = (com.epam.feel.client.ui.user.Footer) GWT.create(com.epam.feel.client.ui.user.Footer.class);
    com.epam.feel.client.ui.admin.CreateMenuView createMenuView = (com.epam.feel.client.ui.admin.CreateMenuView) GWT.create(com.epam.feel.client.ui.admin.CreateMenuView.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel3 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.ScrollPanel f_ScrollPanel2 = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
    com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.admin.ListActiveRequestView listActiveRequest = (com.epam.feel.client.ui.admin.ListActiveRequestView) GWT.create(com.epam.feel.client.ui.admin.ListActiveRequestView.class);
    com.google.gwt.user.client.ui.ScrollPanel f_ScrollPanel6 = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
    com.google.gwt.user.client.ui.Label f_Label7 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.admin.ListRequestView listRequest = (com.epam.feel.client.ui.admin.ListRequestView) GWT.create(com.epam.feel.client.ui.admin.ListRequestView.class);
    com.google.gwt.user.client.ui.ScrollPanel f_ScrollPanel8 = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
    com.google.gwt.user.client.ui.Label f_Label9 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.admin.ListGroupRequestView listGroupRequest = (com.epam.feel.client.ui.admin.ListGroupRequestView) GWT.create(com.epam.feel.client.ui.admin.ListGroupRequestView.class);
    com.google.gwt.user.client.ui.ScrollPanel f_ScrollPanel10 = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
    com.google.gwt.user.client.ui.Label f_Label11 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.StackLayoutPanel requestsView = new com.google.gwt.user.client.ui.StackLayoutPanel(com.google.gwt.dom.client.Style.Unit.PX);
    com.google.gwt.user.client.ui.SimplePanel f_SimplePanel5 = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
    com.google.gwt.user.client.ui.Label f_Label12 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.admin.ClientListView clientListView = (com.epam.feel.client.ui.admin.ClientListView) GWT.create(com.epam.feel.client.ui.admin.ClientListView.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel14 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.ScrollPanel f_ScrollPanel13 = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
    com.google.gwt.user.client.ui.Label f_Label15 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.pagination.FixedPager menuPager = new com.epam.feel.client.ui.util.pagination.FixedPager();
    com.epam.feel.client.ui.admin.HistoryMenuView historyMenu = (com.epam.feel.client.ui.admin.HistoryMenuView) GWT.create(com.epam.feel.client.ui.admin.HistoryMenuView.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel18 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.ScrollPanel f_ScrollPanel17 = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
    com.google.gwt.user.client.ui.Label f_Label19 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.pagination.FixedPager requestPager = new com.epam.feel.client.ui.util.pagination.FixedPager();
    com.epam.feel.client.ui.admin.HistoryRequestView historyRequest = (com.epam.feel.client.ui.admin.HistoryRequestView) GWT.create(com.epam.feel.client.ui.admin.HistoryRequestView.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel21 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.ScrollPanel f_ScrollPanel20 = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
    com.google.gwt.user.client.ui.Label f_Label22 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.pagination.FixedPager requestGroupPager = new com.epam.feel.client.ui.util.pagination.FixedPager();
    com.epam.feel.client.ui.admin.HistoryRequestGroupView historyRequestGroup = (com.epam.feel.client.ui.admin.HistoryRequestGroupView) GWT.create(com.epam.feel.client.ui.admin.HistoryRequestGroupView.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel24 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.ScrollPanel f_ScrollPanel23 = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
    com.google.gwt.user.client.ui.Label f_Label25 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.pagination.FixedPager notificationPager = new com.epam.feel.client.ui.util.pagination.FixedPager();
    com.epam.feel.client.ui.admin.HistoryNotificationView historyNotification = (com.epam.feel.client.ui.admin.HistoryNotificationView) GWT.create(com.epam.feel.client.ui.admin.HistoryNotificationView.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel27 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.ScrollPanel f_ScrollPanel26 = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
    com.google.gwt.user.client.ui.Label f_Label28 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.pagination.FixedPager balancePager = new com.epam.feel.client.ui.util.pagination.FixedPager();
    com.epam.feel.client.ui.admin.HistoryBalanceView historyBalance = (com.epam.feel.client.ui.admin.HistoryBalanceView) GWT.create(com.epam.feel.client.ui.admin.HistoryBalanceView.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel30 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.ScrollPanel f_ScrollPanel29 = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
    com.google.gwt.user.client.ui.Label f_Label31 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.StackLayoutPanel historyView = new com.google.gwt.user.client.ui.StackLayoutPanel(com.google.gwt.dom.client.Style.Unit.PX);
    com.google.gwt.user.client.ui.SimplePanel f_SimplePanel16 = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
    com.google.gwt.user.client.ui.Label f_Label32 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.TabLayoutPanel mainMenu = new com.google.gwt.user.client.ui.TabLayoutPanel(40, com.google.gwt.dom.client.Style.Unit.PX);
    com.google.gwt.user.client.ui.DockLayoutPanel f_DockLayoutPanel1 = new com.google.gwt.user.client.ui.DockLayoutPanel(com.google.gwt.dom.client.Style.Unit.PX);

    header.setIsAdminHeader(true);
    f_DockLayoutPanel1.addNorth(header, 80);
    f_DockLayoutPanel1.addSouth(footer, 30);
    f_VerticalPanel3.add(createMenuView);
    f_VerticalPanel3.setWidth("100%");
    f_VerticalPanel3.setHeight("100%");
    f_ScrollPanel2.add(f_VerticalPanel3);
    f_ScrollPanel2.setAlwaysShowScrollBars(false);
    f_Label4.setText("" + constants.menuTab() + "");
    mainMenu.add(f_ScrollPanel2, f_Label4);
    f_ScrollPanel6.add(listActiveRequest);
    f_ScrollPanel6.setAlwaysShowScrollBars(false);
    f_Label7.setText("" + constants.actualRequests() + "");
    requestsView.add(f_ScrollPanel6, f_Label7, 30);
    f_ScrollPanel8.add(listRequest);
    f_ScrollPanel8.setAlwaysShowScrollBars(false);
    f_Label9.setText("" + constants.requestArchive() + "");
    requestsView.add(f_ScrollPanel8, f_Label9, 30);
    f_ScrollPanel10.add(listGroupRequest);
    f_ScrollPanel10.setAlwaysShowScrollBars(false);
    f_Label11.setText("" + constants.requestGroupPanel() + "");
    requestsView.add(f_ScrollPanel10, f_Label11, 30);
    requestsView.setWidth("100%");
    requestsView.setHeight("100%");
    f_SimplePanel5.add(requestsView);
    f_Label12.setText("" + constants.requestListTab() + "");
    mainMenu.add(f_SimplePanel5, f_Label12);
    f_VerticalPanel14.add(clientListView);
    f_VerticalPanel14.setWidth("100%");
    f_VerticalPanel14.setHeight("100%");
    f_ScrollPanel13.add(f_VerticalPanel14);
    f_ScrollPanel13.setAlwaysShowScrollBars(false);
    f_Label15.setText("" + constants.clientTab() + "");
    mainMenu.add(f_ScrollPanel13, f_Label15);
    f_VerticalPanel18.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    f_VerticalPanel18.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_TOP);
    menuPager.setRangeLimited(true);
    menuPager.setHeight("30");
    f_VerticalPanel18.add(menuPager);
    historyMenu.setWidth("100%");
    historyMenu.setHeight("500");
    f_VerticalPanel18.add(historyMenu);
    f_VerticalPanel18.setWidth("100%");
    f_VerticalPanel18.setHeight("550");
    f_ScrollPanel17.add(f_VerticalPanel18);
    f_ScrollPanel17.setAlwaysShowScrollBars(false);
    f_Label19.setText("" + constants.menuHistoryPanel() + "");
    historyView.add(f_ScrollPanel17, f_Label19, 30);
    f_VerticalPanel21.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    f_VerticalPanel21.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_TOP);
    requestPager.setRangeLimited(true);
    requestPager.setHeight("30");
    f_VerticalPanel21.add(requestPager);
    historyRequest.setWidth("100%");
    historyRequest.setHeight("500");
    f_VerticalPanel21.add(historyRequest);
    f_VerticalPanel21.setWidth("100%");
    f_VerticalPanel21.setHeight("550");
    f_ScrollPanel20.add(f_VerticalPanel21);
    f_ScrollPanel20.setAlwaysShowScrollBars(false);
    f_Label22.setText("" + constants.requestHistoryPanel() + "");
    historyView.add(f_ScrollPanel20, f_Label22, 30);
    f_VerticalPanel24.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    f_VerticalPanel24.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_TOP);
    requestGroupPager.setRangeLimited(true);
    requestGroupPager.setHeight("30");
    f_VerticalPanel24.add(requestGroupPager);
    historyRequestGroup.setWidth("100%");
    historyRequestGroup.setHeight("500");
    f_VerticalPanel24.add(historyRequestGroup);
    f_VerticalPanel24.setWidth("100%");
    f_VerticalPanel24.setHeight("550");
    f_ScrollPanel23.add(f_VerticalPanel24);
    f_ScrollPanel23.setAlwaysShowScrollBars(false);
    f_Label25.setText("" + constants.requestGroupHistoryPanel() + "");
    historyView.add(f_ScrollPanel23, f_Label25, 30);
    f_VerticalPanel27.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    notificationPager.setRangeLimited(true);
    notificationPager.setHeight("30");
    f_VerticalPanel27.add(notificationPager);
    historyNotification.setWidth("100%");
    historyNotification.setHeight("500");
    f_VerticalPanel27.add(historyNotification);
    f_VerticalPanel27.setWidth("100%");
    f_VerticalPanel27.setHeight("550");
    f_ScrollPanel26.add(f_VerticalPanel27);
    f_ScrollPanel26.setAlwaysShowScrollBars(false);
    f_Label28.setText("" + constants.notificationHistoryPanel() + "");
    historyView.add(f_ScrollPanel26, f_Label28, 30);
    f_VerticalPanel30.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    balancePager.setRangeLimited(true);
    balancePager.setHeight("30");
    f_VerticalPanel30.add(balancePager);
    historyBalance.setForAdmin(true);
    historyBalance.setWidth("100%");
    historyBalance.setHeight("500");
    f_VerticalPanel30.add(historyBalance);
    f_VerticalPanel30.setWidth("100%");
    f_VerticalPanel30.setHeight("550");
    f_ScrollPanel29.add(f_VerticalPanel30);
    f_ScrollPanel29.setAlwaysShowScrollBars(false);
    f_Label31.setText("" + constants.balanceHistoryPanel() + "");
    historyView.add(f_ScrollPanel29, f_Label31, 30);
    historyView.setWidth("100%");
    historyView.setHeight("100%");
    f_SimplePanel16.add(historyView);
    f_Label32.setText("" + constants.historyTab() + "");
    mainMenu.add(f_SimplePanel16, f_Label32);
    mainMenu.setHeight("100%");
    f_DockLayoutPanel1.add(mainMenu);
    f_DockLayoutPanel1.setWidth("100%");
    f_DockLayoutPanel1.setHeight("100%");



    final com.google.gwt.event.logical.shared.SelectionHandler<java.lang.Integer> handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.logical.shared.SelectionHandler<java.lang.Integer>() {
      public void onSelection(com.google.gwt.event.logical.shared.SelectionEvent<java.lang.Integer> event) {
        owner.onHistoryViewSelection(event);
      }
    };
    historyView.addSelectionHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    final com.google.gwt.event.logical.shared.SelectionHandler<java.lang.Integer> handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.logical.shared.SelectionHandler<java.lang.Integer>() {
      public void onSelection(com.google.gwt.event.logical.shared.SelectionEvent<java.lang.Integer> event) {
        owner.onRequestsViewSelection(event);
      }
    };
    requestsView.addSelectionHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

    final com.google.gwt.event.logical.shared.BeforeSelectionHandler<java.lang.Integer> handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.logical.shared.BeforeSelectionHandler<java.lang.Integer>() {
      public void onBeforeSelection(com.google.gwt.event.logical.shared.BeforeSelectionEvent<java.lang.Integer> event) {
        owner.onPreMainMenuSelection(event);
      }
    };
    mainMenu.addBeforeSelectionHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);

    final com.google.gwt.event.logical.shared.SelectionHandler<java.lang.Integer> handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.logical.shared.SelectionHandler<java.lang.Integer>() {
      public void onSelection(com.google.gwt.event.logical.shared.SelectionEvent<java.lang.Integer> event) {
        owner.onMainMenuSelection(event);
      }
    };
    mainMenu.addSelectionHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);

    owner.balancePager = balancePager;
    owner.clientListView = clientListView;
    owner.createMenuView = createMenuView;
    owner.footer = footer;
    owner.header = header;
    owner.historyBalance = historyBalance;
    owner.historyMenu = historyMenu;
    owner.historyNotification = historyNotification;
    owner.historyRequest = historyRequest;
    owner.historyRequestGroup = historyRequestGroup;
    owner.historyView = historyView;
    owner.listActiveRequest = listActiveRequest;
    owner.listGroupRequest = listGroupRequest;
    owner.listRequest = listRequest;
    owner.mainMenu = mainMenu;
    owner.menuPager = menuPager;
    owner.notificationPager = notificationPager;
    owner.requestGroupPager = requestGroupPager;
    owner.requestPager = requestPager;
    owner.requestsView = requestsView;

    return f_DockLayoutPanel1;
  }
}
