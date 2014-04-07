package com.epam.feel.client.ui.admin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ClientListView_ClientListViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.epam.feel.client.ui.admin.ClientListView>, com.epam.feel.client.ui.admin.ClientListView.ClientListViewUiBinder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.epam.feel.client.ui.admin.ClientListView owner) {

    com.epam.feel.client.ui.admin.ClientListView_ClientListViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.epam.feel.client.ui.admin.ClientListView_ClientListViewUiBinderImpl_GenBundle) GWT.create(com.epam.feel.client.ui.admin.ClientListView_ClientListViewUiBinderImpl_GenBundle.class);
    com.epam.feel.client.EpamFeelResources st = (com.epam.feel.client.EpamFeelResources) GWT.create(com.epam.feel.client.EpamFeelResources.class);
    com.epam.feel.client.EpamFeelConstants constants = (com.epam.feel.client.EpamFeelConstants) GWT.create(com.epam.feel.client.EpamFeelConstants.class);
    com.google.gwt.user.client.ui.Label f_Label2 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.TextBox filterBox = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    com.google.gwt.user.client.ui.Button submitFilter = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HorizontalPanel filterPanel = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label noDataLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Button advance = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.Button outputBalance = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HorizontalPanel operationPanel = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.epam.feel.client.ui.util.pagination.FixedPager clientsPager = new com.epam.feel.client.ui.util.pagination.FixedPager();
    com.epam.feel.client.ui.util.pagination.SortableProvideredDataGrid clients = (com.epam.feel.client.ui.util.pagination.SortableProvideredDataGrid) GWT.create(com.epam.feel.client.ui.util.pagination.SortableProvideredDataGrid.class);
    com.google.gwt.user.client.ui.VerticalPanel dataPanel = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);

    filterPanel.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_Label2.setText("" + constants.enterClientName() + "");
    filterPanel.add(f_Label2);
    filterBox.setWidth("400");
    filterPanel.add(filterBox);
    submitFilter.setText("" + constants.filterIt() + "");
    filterPanel.add(submitFilter);
    filterPanel.setSpacing(5);
    f_VerticalPanel1.add(filterPanel);
    noDataLabel.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    noDataLabel.setVisible(true);
    noDataLabel.setText("" + constants.noDataForView() + "");
    f_VerticalPanel1.add(noDataLabel);
    advance.setText("" + constants.advancePayment() + "");
    operationPanel.add(advance);
    outputBalance.setText("" + constants.outputBalance() + "");
    outputBalance.setEnabled(false);
    operationPanel.add(outputBalance);
    f_VerticalPanel1.add(operationPanel);
    dataPanel.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    dataPanel.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_TOP);
    clientsPager.setRangeLimited(true);
    clientsPager.setHeight("30");
    dataPanel.add(clientsPager);
    clients.setWidth("900");
    clients.setHeight("300");
    dataPanel.add(clients);
    dataPanel.setWidth("900");
    f_VerticalPanel1.add(dataPanel);
    f_VerticalPanel1.setWidth("100%");



    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onPrepaidRequestClicked(event);
      }
    };
    advance.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onOutputBalanceClicked(event);
      }
    };
    outputBalance.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onFilterSubmitted(event);
      }
    };
    submitFilter.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);

    final com.google.gwt.event.dom.client.KeyUpHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.KeyUpHandler() {
      public void onKeyUp(com.google.gwt.event.dom.client.KeyUpEvent event) {
        owner.onFilterSubmitted(event);
      }
    };
    filterBox.addKeyUpHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);

    owner.advance = advance;
    owner.clients = clients;
    owner.clientsPager = clientsPager;
    owner.dataPanel = dataPanel;
    owner.filterBox = filterBox;
    owner.filterPanel = filterPanel;
    owner.noDataLabel = noDataLabel;
    owner.operationPanel = operationPanel;
    owner.outputBalance = outputBalance;
    owner.submitFilter = submitFilter;

    return f_VerticalPanel1;
  }
}
