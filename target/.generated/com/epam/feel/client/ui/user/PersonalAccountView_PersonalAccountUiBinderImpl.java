package com.epam.feel.client.ui.user;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class PersonalAccountView_PersonalAccountUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.epam.feel.client.ui.user.PersonalAccountView>, com.epam.feel.client.ui.user.PersonalAccountView.PersonalAccountUiBinder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.epam.feel.client.ui.user.PersonalAccountView owner) {

    com.epam.feel.client.ui.user.PersonalAccountView_PersonalAccountUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.epam.feel.client.ui.user.PersonalAccountView_PersonalAccountUiBinderImpl_GenBundle) GWT.create(com.epam.feel.client.ui.user.PersonalAccountView_PersonalAccountUiBinderImpl_GenBundle.class);
    com.epam.feel.client.EpamFeelConstants constants = (com.epam.feel.client.EpamFeelConstants) GWT.create(com.epam.feel.client.EpamFeelConstants.class);
    com.epam.feel.client.ui.user.MainHeader header = (com.epam.feel.client.ui.user.MainHeader) GWT.create(com.epam.feel.client.ui.user.MainHeader.class);
    com.epam.feel.client.ui.user.Footer footer = (com.epam.feel.client.ui.user.Footer) GWT.create(com.epam.feel.client.ui.user.Footer.class);
    com.google.gwt.user.client.ui.Anchor goToMain = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    com.google.gwt.user.client.ui.Anchor historyPersonalBalance = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label f_Label6 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.CalendarView dateStartBox = (com.epam.feel.client.ui.util.CalendarView) GWT.create(com.epam.feel.client.ui.util.CalendarView.class);
    com.google.gwt.user.client.ui.Label f_Label7 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.CalendarView dateEndBox = (com.epam.feel.client.ui.util.CalendarView) GWT.create(com.epam.feel.client.ui.util.CalendarView.class);
    com.google.gwt.user.client.ui.Button submitFilter = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel5 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Button editButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.Button delButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HorizontalPanel widgetPanel = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label ordersLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.pagination.FixedPager ordersPager = new com.epam.feel.client.ui.util.pagination.FixedPager();
    com.epam.feel.client.ui.util.pagination.SortableProvideredDataGrid orders = (com.epam.feel.client.ui.util.pagination.SortableProvideredDataGrid) GWT.create(com.epam.feel.client.ui.util.pagination.SortableProvideredDataGrid.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel8 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.epam.feel.client.ui.util.table.MenuTable viewOrderPanel = (com.epam.feel.client.ui.util.table.MenuTable) GWT.create(com.epam.feel.client.ui.util.table.MenuTable.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel3 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.ScrollPanel f_ScrollPanel2 = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
    com.google.gwt.user.client.ui.DockLayoutPanel f_DockLayoutPanel1 = new com.google.gwt.user.client.ui.DockLayoutPanel(com.google.gwt.dom.client.Style.Unit.PX);

    f_DockLayoutPanel1.addNorth(header, 175);
    f_DockLayoutPanel1.addSouth(footer, 30);
    goToMain.setText("" + constants.goToMain() + "");
    f_VerticalPanel3.add(goToMain);
    historyPersonalBalance.setText("" + constants.historyBalanceLabel() + "");
    f_VerticalPanel3.add(historyPersonalBalance);
    f_Label4.setText("" + constants.requestsLabel() + "");
    f_VerticalPanel3.add(f_Label4);
    f_HorizontalPanel5.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_Label6.setText("" + constants.searchByDateLabel() + "");
    f_HorizontalPanel5.add(f_Label6);
    f_HorizontalPanel5.add(dateStartBox);
    f_Label7.setText("-");
    f_HorizontalPanel5.add(f_Label7);
    f_HorizontalPanel5.add(dateEndBox);
    submitFilter.setText("" + constants.filterIt() + "");
    f_HorizontalPanel5.add(submitFilter);
    f_HorizontalPanel5.setSpacing(5);
    f_VerticalPanel3.add(f_HorizontalPanel5);
    editButton.setText("" + constants.changeRequestField() + "");
    widgetPanel.add(editButton);
    delButton.setText("" + constants.delete() + "");
    widgetPanel.add(delButton);
    f_VerticalPanel3.add(widgetPanel);
    ordersLabel.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    ordersLabel.setText("" + constants.noDataForView() + "");
    f_VerticalPanel3.add(ordersLabel);
    f_VerticalPanel8.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    ordersPager.setRangeLimited(true);
    ordersPager.setHeight("30");
    f_VerticalPanel8.add(ordersPager);
    orders.setHeight("200");
    f_VerticalPanel8.add(orders);
    f_VerticalPanel8.setWidth("100%");
    f_VerticalPanel3.add(f_VerticalPanel8);
    viewOrderPanel.setBorderWidth(1);
    viewOrderPanel.setWidth("100%");
    f_VerticalPanel3.add(viewOrderPanel);
    f_VerticalPanel3.setSpacing(5);
    f_VerticalPanel3.setWidth("100%");
    f_ScrollPanel2.add(f_VerticalPanel3);
    f_ScrollPanel2.setAlwaysShowScrollBars(false);
    f_DockLayoutPanel1.add(f_ScrollPanel2);
    f_DockLayoutPanel1.setWidth("100%");
    f_DockLayoutPanel1.setHeight("100%");



    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onHistoryPersonalBalanceClicked(event);
      }
    };
    historyPersonalBalance.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onGoToMain(event);
      }
    };
    goToMain.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onEditButtonClicked(event);
      }
    };
    editButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onDelButtonClicked(event);
      }
    };
    delButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickFilter(event);
      }
    };
    submitFilter.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5);

    owner.dateEndBox = dateEndBox;
    owner.dateStartBox = dateStartBox;
    owner.delButton = delButton;
    owner.editButton = editButton;
    owner.footer = footer;
    owner.header = header;
    owner.orders = orders;
    owner.ordersLabel = ordersLabel;
    owner.ordersPager = ordersPager;
    owner.viewOrderPanel = viewOrderPanel;
    owner.widgetPanel = widgetPanel;

    return f_DockLayoutPanel1;
  }
}
