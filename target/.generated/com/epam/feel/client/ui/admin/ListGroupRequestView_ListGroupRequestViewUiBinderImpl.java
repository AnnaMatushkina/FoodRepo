package com.epam.feel.client.ui.admin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ListGroupRequestView_ListGroupRequestViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.epam.feel.client.ui.admin.ListGroupRequestView>, com.epam.feel.client.ui.admin.ListGroupRequestView.ListGroupRequestViewUiBinder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.epam.feel.client.ui.admin.ListGroupRequestView owner) {

    com.epam.feel.client.ui.admin.ListGroupRequestView_ListGroupRequestViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.epam.feel.client.ui.admin.ListGroupRequestView_ListGroupRequestViewUiBinderImpl_GenBundle) GWT.create(com.epam.feel.client.ui.admin.ListGroupRequestView_ListGroupRequestViewUiBinderImpl_GenBundle.class);
    com.epam.feel.client.EpamFeelConstants constants = (com.epam.feel.client.EpamFeelConstants) GWT.create(com.epam.feel.client.EpamFeelConstants.class);
    com.epam.feel.client.EpamFeelResources st = (com.epam.feel.client.EpamFeelResources) GWT.create(com.epam.feel.client.EpamFeelResources.class);
    com.google.gwt.user.client.ui.Label noDataLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.pagination.FixedPager groupsPager = new com.epam.feel.client.ui.util.pagination.FixedPager();
    com.epam.feel.client.ui.util.pagination.SortableProvideredDataGrid groups = (com.epam.feel.client.ui.util.pagination.SortableProvideredDataGrid) GWT.create(com.epam.feel.client.ui.util.pagination.SortableProvideredDataGrid.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel3 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel2 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.Label titleGroup = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.Button registerGroup = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.FormPanel formForExcel = (com.google.gwt.user.client.ui.FormPanel) GWT.create(com.google.gwt.user.client.ui.FormPanel.class);
    com.google.gwt.user.client.ui.Button saveExcel = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.Button deleteGroup = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.Button completeGroup = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel4 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.FlexTable groupInfo = (com.google.gwt.user.client.ui.FlexTable) GWT.create(com.google.gwt.user.client.ui.FlexTable.class);
    com.google.gwt.user.client.ui.VerticalPanel viewVerticalPanel = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel1 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);

    noDataLabel.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    noDataLabel.setVisible(false);
    noDataLabel.setText("" + constants.noDataForView() + "");
    f_VerticalPanel2.add(noDataLabel);
    f_VerticalPanel3.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    f_VerticalPanel3.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_TOP);
    groupsPager.setRangeLimited(true);
    groupsPager.setHeight("30");
    f_VerticalPanel3.add(groupsPager);
    groups.setVisible(true);
    groups.setWidth("750");
    groups.setHeight("300");
    f_VerticalPanel3.add(groups);
    f_VerticalPanel3.setWidth("750");
    f_VerticalPanel2.add(f_VerticalPanel3);
    f_VerticalPanel2.setWidth("100%");
    f_HorizontalPanel1.add(f_VerticalPanel2);
    viewVerticalPanel.add(titleGroup);
    registerGroup.setText("" + constants.registerGroupField() + "");
    f_HorizontalPanel4.add(registerGroup);
    formForExcel.setMethod("POST");
    f_HorizontalPanel4.add(formForExcel);
    saveExcel.setText("" + constants.saveExcelField() + "");
    f_HorizontalPanel4.add(saveExcel);
    deleteGroup.setText("" + constants.delete() + "");
    f_HorizontalPanel4.add(deleteGroup);
    completeGroup.setText("" + constants.completeGroupField() + "");
    f_HorizontalPanel4.add(completeGroup);
    viewVerticalPanel.add(f_HorizontalPanel4);
    groupInfo.setStyleName("" + st.global().tableMenu() + "");
    groupInfo.setBorderWidth(1);
    viewVerticalPanel.add(groupInfo);
    viewVerticalPanel.setVisible(false);
    viewVerticalPanel.setSpacing(10);
    viewVerticalPanel.setWidth("100%");
    f_HorizontalPanel1.add(viewVerticalPanel);
    f_HorizontalPanel1.setWidth("100%");
    f_HorizontalPanel1.setHeight("100%");



    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onRegGroupClicked(event);
      }
    };
    registerGroup.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onCompleteGroupClicked(event);
      }
    };
    completeGroup.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onSaveExcelClicked(event);
      }
    };
    saveExcel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onDelGroupClicked(event);
      }
    };
    deleteGroup.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);

    owner.completeGroup = completeGroup;
    owner.deleteGroup = deleteGroup;
    owner.formForExcel = formForExcel;
    owner.groupInfo = groupInfo;
    owner.groups = groups;
    owner.groupsPager = groupsPager;
    owner.noDataLabel = noDataLabel;
    owner.registerGroup = registerGroup;
    owner.saveExcel = saveExcel;
    owner.titleGroup = titleGroup;
    owner.viewVerticalPanel = viewVerticalPanel;

    return f_HorizontalPanel1;
  }
}
