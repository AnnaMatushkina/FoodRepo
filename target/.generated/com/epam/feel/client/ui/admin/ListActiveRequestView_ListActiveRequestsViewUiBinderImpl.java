package com.epam.feel.client.ui.admin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ListActiveRequestView_ListActiveRequestsViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.epam.feel.client.ui.admin.ListActiveRequestView>, com.epam.feel.client.ui.admin.ListActiveRequestView.ListActiveRequestsViewUiBinder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.epam.feel.client.ui.admin.ListActiveRequestView owner) {

    com.epam.feel.client.ui.admin.ListActiveRequestView_ListActiveRequestsViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.epam.feel.client.ui.admin.ListActiveRequestView_ListActiveRequestsViewUiBinderImpl_GenBundle) GWT.create(com.epam.feel.client.ui.admin.ListActiveRequestView_ListActiveRequestsViewUiBinderImpl_GenBundle.class);
    com.epam.feel.client.EpamFeelResources st = (com.epam.feel.client.EpamFeelResources) GWT.create(com.epam.feel.client.EpamFeelResources.class);
    com.epam.feel.client.EpamFeelConstants constants = (com.epam.feel.client.EpamFeelConstants) GWT.create(com.epam.feel.client.EpamFeelConstants.class);
    com.google.gwt.user.client.ui.Label f_Label3 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.ListBox nameMenu = (com.google.gwt.user.client.ui.ListBox) GWT.create(com.google.gwt.user.client.ui.ListBox.class);
    com.google.gwt.user.client.ui.HorizontalPanel filterPanel = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Anchor makeGroup = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    com.google.gwt.user.client.ui.Label noDataLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.pagination.FixedPager requestsPager = new com.epam.feel.client.ui.util.pagination.FixedPager();
    com.epam.feel.client.ui.util.pagination.SortableProvideredDataGrid requests = (com.epam.feel.client.ui.util.pagination.SortableProvideredDataGrid) GWT.create(com.epam.feel.client.ui.util.pagination.SortableProvideredDataGrid.class);
    com.google.gwt.user.client.ui.VerticalPanel dataPanel = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel2 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.Button changeRequest = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.Button acceptRequest = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.Button payForRequest = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.Button declineRequest = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.Button completeRequest = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.Button deleteRequest = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.Button prepaidRequest = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.Button outputBalance = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel4 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label6 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Label menuNameLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel5 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.epam.feel.client.ui.util.table.MenuTable viewRequestPanel = (com.epam.feel.client.ui.util.table.MenuTable) GWT.create(com.epam.feel.client.ui.util.table.MenuTable.class);
    com.google.gwt.user.client.ui.VerticalPanel viewVerticalPanel = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel1 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);

    filterPanel.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_Label3.setText("" + constants.choosedMenuLabel() + "");
    filterPanel.add(f_Label3);
    nameMenu.setWidth("500");
    filterPanel.add(nameMenu);
    filterPanel.setVisible(false);
    filterPanel.setSpacing(5);
    f_VerticalPanel2.add(filterPanel);
    makeGroup.setVisible(false);
    makeGroup.setText("" + constants.makeGroupRequestsField() + "");
    f_VerticalPanel2.add(makeGroup);
    noDataLabel.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    noDataLabel.setVisible(true);
    noDataLabel.setText("" + constants.noDataForView() + "");
    f_VerticalPanel2.add(noDataLabel);
    dataPanel.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    dataPanel.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_TOP);
    requestsPager.setRangeLimited(true);
    requestsPager.setHeight("30");
    dataPanel.add(requestsPager);
    requests.setWidth("900");
    requests.setHeight("300");
    dataPanel.add(requests);
    dataPanel.setWidth("900");
    f_VerticalPanel2.add(dataPanel);
    f_VerticalPanel2.setWidth("100%");
    f_HorizontalPanel1.add(f_VerticalPanel2);
    changeRequest.setText("" + constants.changeRequestField() + "");
    f_HorizontalPanel4.add(changeRequest);
    acceptRequest.setText("" + constants.acceptRequestField() + "");
    f_HorizontalPanel4.add(acceptRequest);
    payForRequest.setText("" + constants.payForRequestField() + "");
    f_HorizontalPanel4.add(payForRequest);
    declineRequest.setText("" + constants.declineRequestField() + "");
    f_HorizontalPanel4.add(declineRequest);
    completeRequest.setText("" + constants.completeRequestField() + "");
    f_HorizontalPanel4.add(completeRequest);
    deleteRequest.setText("" + constants.deleteRequestField() + "");
    f_HorizontalPanel4.add(deleteRequest);
    prepaidRequest.setText("" + constants.prepaidRequestField() + "");
    f_HorizontalPanel4.add(prepaidRequest);
    outputBalance.setText("" + constants.outputBalanceField() + "");
    f_HorizontalPanel4.add(outputBalance);
    viewVerticalPanel.add(f_HorizontalPanel4);
    f_Label6.setText("" + constants.preMenuNameLabel() + "");
    f_HorizontalPanel5.add(f_Label6);
    menuNameLabel.setStyleName("" + st.global().preMenuNameLabel() + "");
    f_HorizontalPanel5.add(menuNameLabel);
    viewVerticalPanel.add(f_HorizontalPanel5);
    viewRequestPanel.setBorderWidth(1);
    viewRequestPanel.setWidth("100%");
    viewVerticalPanel.add(viewRequestPanel);
    viewVerticalPanel.setVisible(false);
    viewVerticalPanel.setSpacing(10);
    f_HorizontalPanel1.add(viewVerticalPanel);
    f_HorizontalPanel1.setWidth("100%");
    f_HorizontalPanel1.setHeight("100%");



    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onMakeGroupClick(event);
      }
    };
    makeGroup.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    final com.google.gwt.event.dom.client.ChangeHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ChangeHandler() {
      public void onChange(com.google.gwt.event.dom.client.ChangeEvent event) {
        owner.onNameMenuChange(event);
      }
    };
    nameMenu.addChangeHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onChangeRequestClicked(event);
      }
    };
    changeRequest.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onAcceptRequestClicked(event);
      }
    };
    acceptRequest.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onPayForRequestClicked(event);
      }
    };
    payForRequest.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onCancelRequestClicked(event);
      }
    };
    declineRequest.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onCloseRequestClicked(event);
      }
    };
    completeRequest.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onDeleteRequestClicked(event);
      }
    };
    deleteRequest.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames9 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onPrepaidRequestClicked(event);
      }
    };
    prepaidRequest.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames9);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames10 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onOutputBalanceClicked(event);
      }
    };
    outputBalance.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames10);

    owner.acceptRequest = acceptRequest;
    owner.changeRequest = changeRequest;
    owner.completeRequest = completeRequest;
    owner.dataPanel = dataPanel;
    owner.declineRequest = declineRequest;
    owner.deleteRequest = deleteRequest;
    owner.filterPanel = filterPanel;
    owner.makeGroup = makeGroup;
    owner.menuNameLabel = menuNameLabel;
    owner.nameMenu = nameMenu;
    owner.noDataLabel = noDataLabel;
    owner.outputBalance = outputBalance;
    owner.payForRequest = payForRequest;
    owner.prepaidRequest = prepaidRequest;
    owner.requests = requests;
    owner.requestsPager = requestsPager;
    owner.viewRequestPanel = viewRequestPanel;
    owner.viewVerticalPanel = viewVerticalPanel;

    return f_HorizontalPanel1;
  }
}
