package com.epam.feel.client.ui.admin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class CreateMenuView_CreateMenuViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.epam.feel.client.ui.admin.CreateMenuView>, com.epam.feel.client.ui.admin.CreateMenuView.CreateMenuViewUiBinder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.epam.feel.client.ui.admin.CreateMenuView owner) {

    com.epam.feel.client.ui.admin.CreateMenuView_CreateMenuViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.epam.feel.client.ui.admin.CreateMenuView_CreateMenuViewUiBinderImpl_GenBundle) GWT.create(com.epam.feel.client.ui.admin.CreateMenuView_CreateMenuViewUiBinderImpl_GenBundle.class);
    com.epam.feel.client.EpamFeelConstants constants = (com.epam.feel.client.EpamFeelConstants) GWT.create(com.epam.feel.client.EpamFeelConstants.class);
    com.epam.feel.client.EpamFeelResources st = (com.epam.feel.client.EpamFeelResources) GWT.create(com.epam.feel.client.EpamFeelResources.class);
    com.google.gwt.user.client.ui.Label f_Label3 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.CalendarView dateStartBox = (com.epam.feel.client.ui.util.CalendarView) GWT.create(com.epam.feel.client.ui.util.CalendarView.class);
    com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.CalendarView dateEndBox = (com.epam.feel.client.ui.util.CalendarView) GWT.create(com.epam.feel.client.ui.util.CalendarView.class);
    com.google.gwt.user.client.ui.Button submitFilter = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel2 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label emptyMenuListLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.table.SortableDataGrid menuTable = (com.epam.feel.client.ui.util.table.SortableDataGrid) GWT.create(com.epam.feel.client.ui.util.table.SortableDataGrid.class);
    com.google.gwt.user.client.ui.DecoratorPanel f_DecoratorPanel5 = (com.google.gwt.user.client.ui.DecoratorPanel) GWT.create(com.google.gwt.user.client.ui.DecoratorPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel menuTablePanel = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel menuPanel = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.Button createMenu = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.Button copyMenu = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.Button saveMenu = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.Button unBlockMenu = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.Button blockMenu = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.Button deleteMenu = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel7 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel6 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label12 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.CalendarView newMenuDate = (com.epam.feel.client.ui.util.CalendarView) GWT.create(com.epam.feel.client.ui.util.CalendarView.class);
    com.google.gwt.user.client.ui.Label f_Label13 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.highlighting.HighlightableTextBox newMenuTitle = (com.epam.feel.client.ui.util.highlighting.HighlightableTextBox) GWT.create(com.epam.feel.client.ui.util.highlighting.HighlightableTextBox.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel11 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label16 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.CalendarView newOrderStartDate = (com.epam.feel.client.ui.util.CalendarView) GWT.create(com.epam.feel.client.ui.util.CalendarView.class);
    com.epam.feel.client.ui.util.TimeView newOrderStartTime = (com.epam.feel.client.ui.util.TimeView) GWT.create(com.epam.feel.client.ui.util.TimeView.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel17 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label18 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.CalendarView newOrderEndDate = (com.epam.feel.client.ui.util.CalendarView) GWT.create(com.epam.feel.client.ui.util.CalendarView.class);
    com.epam.feel.client.ui.util.TimeView newOrderEndTime = (com.epam.feel.client.ui.util.TimeView) GWT.create(com.epam.feel.client.ui.util.TimeView.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel19 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel15 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label21 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.TimeView newOrderDeliveryStartTime = (com.epam.feel.client.ui.util.TimeView) GWT.create(com.epam.feel.client.ui.util.TimeView.class);
    com.google.gwt.user.client.ui.Label f_Label22 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.TimeView newOrderDeliveryEndTime = (com.epam.feel.client.ui.util.TimeView) GWT.create(com.epam.feel.client.ui.util.TimeView.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel20 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel14 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel10 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.DecoratorPanel f_DecoratorPanel9 = (com.google.gwt.user.client.ui.DecoratorPanel) GWT.create(com.google.gwt.user.client.ui.DecoratorPanel.class);
    com.google.gwt.user.client.ui.Button addDish = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.Button editDish = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.Button delDish = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HorizontalPanel dishActions = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.epam.feel.client.ui.util.table.SortableDataGrid menuDetails = (com.epam.feel.client.ui.util.table.SortableDataGrid) GWT.create(com.epam.feel.client.ui.util.table.SortableDataGrid.class);
    com.google.gwt.user.client.ui.DecoratorPanel f_DecoratorPanel23 = (com.google.gwt.user.client.ui.DecoratorPanel) GWT.create(com.google.gwt.user.client.ui.DecoratorPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel menuDetailsPanel = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel dishsTable = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel8 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.DecoratorPanel menuEditPanel = (com.google.gwt.user.client.ui.DecoratorPanel) GWT.create(com.google.gwt.user.client.ui.DecoratorPanel.class);
    com.google.gwt.user.client.ui.Label f_Label28 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.highlighting.HighlightableTextBox newTitleBox = (com.epam.feel.client.ui.util.highlighting.HighlightableTextBox) GWT.create(com.epam.feel.client.ui.util.highlighting.HighlightableTextBox.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel27 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label30 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.ListBox newTypeDishes = (com.google.gwt.user.client.ui.ListBox) GWT.create(com.google.gwt.user.client.ui.ListBox.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel29 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel26 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label33 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.highlighting.HighlightableIntegerBox newWeightBox = (com.epam.feel.client.ui.util.highlighting.HighlightableIntegerBox) GWT.create(com.epam.feel.client.ui.util.highlighting.HighlightableIntegerBox.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel32 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label35 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.box.ExtendedDoubleBox newPriceBox = (com.epam.feel.client.ui.util.box.ExtendedDoubleBox) GWT.create(com.epam.feel.client.ui.util.box.ExtendedDoubleBox.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel34 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label37 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.highlighting.HighlightableIntegerBox newMaxCountBox = (com.epam.feel.client.ui.util.highlighting.HighlightableIntegerBox) GWT.create(com.epam.feel.client.ui.util.highlighting.HighlightableIntegerBox.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel36 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.CheckBox isChefDish = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel38 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel31 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label40 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.box.FixedLengthTextArea newConsistBox = (com.epam.feel.client.ui.util.box.FixedLengthTextArea) GWT.create(com.epam.feel.client.ui.util.box.FixedLengthTextArea.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel39 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label42 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.gwtupload.FixedSingleUploader newPhoto = new com.epam.feel.client.ui.util.gwtupload.FixedSingleUploader(gwtupload.client.IFileInput.FileInputType.BROWSER_INPUT);
    com.google.gwt.user.client.ui.Button imageDel = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HorizontalPanel imageDish = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel41 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label f_Label44 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.TextBox newURL = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel43 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Button dialogOk = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.Button dialogCancel = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel45 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel25 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.DialogBox dishEditorPanel = new com.google.gwt.user.client.ui.DialogBox(false, true);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel24 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);

    f_HorizontalPanel2.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_Label3.setText("" + constants.menuListLabel() + "");
    f_HorizontalPanel2.add(f_Label3);
    f_HorizontalPanel2.add(dateStartBox);
    f_Label4.setText("-");
    f_HorizontalPanel2.add(f_Label4);
    f_HorizontalPanel2.add(dateEndBox);
    submitFilter.setText("" + constants.filterIt() + "");
    f_HorizontalPanel2.add(submitFilter);
    f_HorizontalPanel2.setSpacing(5);
    menuPanel.add(f_HorizontalPanel2);
    emptyMenuListLabel.setText("" + constants.noDataForView() + "");
    menuPanel.add(emptyMenuListLabel);
    menuTable.setWidth("1500");
    menuTable.setHeight("150");
    f_DecoratorPanel5.add(menuTable);
    menuTablePanel.add(f_DecoratorPanel5);
    menuPanel.add(menuTablePanel);
    f_VerticalPanel1.add(menuPanel);
    createMenu.setText("" + constants.createMenuField() + "");
    f_HorizontalPanel7.add(createMenu);
    copyMenu.setVisible(false);
    copyMenu.setText("" + constants.copyMenuField() + "");
    f_HorizontalPanel7.add(copyMenu);
    saveMenu.setVisible(false);
    saveMenu.setText("" + constants.saveMenuField() + "");
    f_HorizontalPanel7.add(saveMenu);
    unBlockMenu.setVisible(false);
    unBlockMenu.setText("" + constants.unBlockMenuField() + "");
    f_HorizontalPanel7.add(unBlockMenu);
    blockMenu.setVisible(false);
    blockMenu.setText("" + constants.blockMenuField() + "");
    f_HorizontalPanel7.add(blockMenu);
    deleteMenu.setVisible(false);
    deleteMenu.setText("" + constants.deleteMenuField() + "");
    f_HorizontalPanel7.add(deleteMenu);
    f_VerticalPanel6.add(f_HorizontalPanel7);
    f_VerticalPanel6.setWidth("100%");
    f_VerticalPanel1.add(f_VerticalPanel6);
    f_Label12.setStyleName("" + st.global().labelWithField() + "");
    f_Label12.setText("" + constants.menuForLabel() + "");
    f_HorizontalPanel11.add(f_Label12);
    newMenuDate.setWidth("75");
    f_HorizontalPanel11.add(newMenuDate);
    f_Label13.setStyleName("" + st.global().labelWithField() + " " + st.global().leftLargeMargin() + "");
    f_Label13.setText("" + constants.titleColumn() + "");
    f_HorizontalPanel11.add(f_Label13);
    newMenuTitle.setWidth("550");
    newMenuTitle.setMaxLength(300);
    f_HorizontalPanel11.add(newMenuTitle);
    f_HorizontalPanel11.setSpacing(10);
    f_VerticalPanel10.add(f_HorizontalPanel11);
    f_Label16.setStyleName("" + st.global().labelWithField() + "");
    f_Label16.setText("" + constants.menuReceiptFromLabel() + "");
    f_HorizontalPanel15.add(f_Label16);
    newOrderStartDate.setStyleName("" + st.global().labelWithField() + "");
    newOrderStartDate.setWidth("75");
    f_HorizontalPanel17.add(newOrderStartDate);
    f_HorizontalPanel17.add(newOrderStartTime);
    f_HorizontalPanel15.add(f_HorizontalPanel17);
    f_Label18.setStyleName("" + st.global().labelBetweenFields() + "");
    f_Label18.setText("" + constants.menuReceiptToLabel() + "");
    f_HorizontalPanel15.add(f_Label18);
    newOrderEndDate.setStyleName("" + st.global().labelWithField() + "");
    newOrderEndDate.setWidth("75");
    f_HorizontalPanel19.add(newOrderEndDate);
    f_HorizontalPanel19.add(newOrderEndTime);
    f_HorizontalPanel15.add(f_HorizontalPanel19);
    f_HorizontalPanel14.add(f_HorizontalPanel15);
    f_Label21.setStyleName("" + st.global().labelWithField() + "");
    f_Label21.setText("" + constants.menuDeliveryFromLabel() + "");
    f_HorizontalPanel20.add(f_Label21);
    f_HorizontalPanel20.add(newOrderDeliveryStartTime);
    f_Label22.setStyleName("" + st.global().labelBetweenFields() + "");
    f_Label22.setText("" + constants.menuDeliveryToLabel() + "");
    f_HorizontalPanel20.add(f_Label22);
    f_HorizontalPanel20.add(newOrderDeliveryEndTime);
    f_HorizontalPanel20.setStyleName("" + st.global().leftMediumMargin() + "");
    f_HorizontalPanel14.add(f_HorizontalPanel20);
    f_HorizontalPanel14.setSpacing(10);
    f_VerticalPanel10.add(f_HorizontalPanel14);
    f_DecoratorPanel9.add(f_VerticalPanel10);
    f_VerticalPanel8.add(f_DecoratorPanel9);
    addDish.setText("" + constants.addDishField() + "");
    dishActions.add(addDish);
    editDish.setText("" + constants.editDishField() + "");
    dishActions.add(editDish);
    delDish.setText("" + constants.delDishField() + "");
    dishActions.add(delDish);
    f_VerticalPanel8.add(dishActions);
    menuDetails.setWidth("1500px");
    menuDetails.setHeight("380px");
    f_DecoratorPanel23.add(menuDetails);
    menuDetailsPanel.add(f_DecoratorPanel23);
    dishsTable.add(menuDetailsPanel);
    f_VerticalPanel8.add(dishsTable);
    menuEditPanel.add(f_VerticalPanel8);
    menuEditPanel.setVisible(false);
    f_VerticalPanel1.add(menuEditPanel);
    f_Label28.setStyleName("" + st.global().labelWithField() + "");
    f_Label28.setText("" + constants.titleColumn() + "");
    f_HorizontalPanel27.add(f_Label28);
    newTitleBox.setWidth("450px");
    newTitleBox.setMaxLength(50);
    f_HorizontalPanel27.add(newTitleBox);
    f_HorizontalPanel26.add(f_HorizontalPanel27);
    f_Label30.setStyleName("" + st.global().labelWithField() + "");
    f_Label30.setText("" + constants.dishTypeLabel() + "");
    f_HorizontalPanel29.add(f_Label30);
    newTypeDishes.setWidth("150px");
    f_HorizontalPanel29.add(newTypeDishes);
    f_HorizontalPanel29.setStyleName("" + st.global().leftSmallMargin() + "");
    f_HorizontalPanel26.add(f_HorizontalPanel29);
    f_HorizontalPanel26.setSpacing(10);
    f_VerticalPanel25.add(f_HorizontalPanel26);
    f_Label33.setStyleName("" + st.global().labelWithField() + "");
    f_Label33.setText("" + constants.weightColumn() + "");
    f_HorizontalPanel32.add(f_Label33);
    newWeightBox.setWidth("80px");
    newWeightBox.setMaxLength(4);
    f_HorizontalPanel32.add(newWeightBox);
    f_HorizontalPanel31.add(f_HorizontalPanel32);
    f_Label35.setStyleName("" + st.global().labelWithField() + "");
    f_Label35.setText("" + constants.priceColumn() + "");
    f_HorizontalPanel34.add(f_Label35);
    newPriceBox.setWidth("80px");
    newPriceBox.setMaxLength(11);
    f_HorizontalPanel34.add(newPriceBox);
    f_HorizontalPanel34.setStyleName("" + st.global().leftSmallMargin() + "");
    f_HorizontalPanel31.add(f_HorizontalPanel34);
    f_Label37.setStyleName("" + st.global().labelWithField() + "");
    f_Label37.setText("" + constants.dishMaxCountlabel() + "");
    f_HorizontalPanel36.add(f_Label37);
    newMaxCountBox.setWidth("80px");
    newMaxCountBox.setMaxLength(3);
    f_HorizontalPanel36.add(newMaxCountBox);
    f_HorizontalPanel36.setStyleName("" + st.global().leftSmallMargin() + "");
    f_HorizontalPanel31.add(f_HorizontalPanel36);
    isChefDish.setText("" + constants.isChiefDishField() + "");
    f_HorizontalPanel38.add(isChefDish);
    f_HorizontalPanel38.setStyleName("" + st.global().leftSmallMargin() + "");
    f_HorizontalPanel31.add(f_HorizontalPanel38);
    f_HorizontalPanel31.setSpacing(10);
    f_VerticalPanel25.add(f_HorizontalPanel31);
    f_Label40.setStyleName("" + st.global().labelWithField() + "");
    f_Label40.setText("" + constants.structureColumn() + ":");
    f_HorizontalPanel39.add(f_Label40);
    newConsistBox.setVisibleLines(5);
    newConsistBox.setWidth("700px");
    f_HorizontalPanel39.add(newConsistBox);
    f_HorizontalPanel39.setSpacing(10);
    f_VerticalPanel25.add(f_HorizontalPanel39);
    f_Label42.setStyleName("" + st.global().labelWithField() + "");
    f_Label42.setText("" + constants.uploadPhotoLabel() + "");
    f_HorizontalPanel41.add(f_Label42);
    newPhoto.setFileInputSize(30);
    f_HorizontalPanel41.add(newPhoto);
    imageDel.setVisible(false);
    imageDel.setText("" + constants.deletePhoto() + "");
    f_HorizontalPanel41.add(imageDel);
    f_HorizontalPanel41.add(imageDish);
    f_HorizontalPanel41.setSpacing(10);
    f_VerticalPanel25.add(f_HorizontalPanel41);
    f_Label44.setStyleName("" + st.global().labelWithField() + "");
    f_Label44.setText("URL");
    f_HorizontalPanel43.add(f_Label44);
    newURL.setWidth("700px");
    newURL.setMaxLength(200);
    f_HorizontalPanel43.add(newURL);
    f_HorizontalPanel43.setSpacing(10);
    f_VerticalPanel25.add(f_HorizontalPanel43);
    dialogOk.setText("" + constants.dialogConfirm() + "");
    f_HorizontalPanel45.add(dialogOk);
    dialogCancel.setText("" + constants.cancel() + "");
    f_HorizontalPanel45.add(dialogCancel);
    f_HorizontalPanel45.setStyleName("" + st.global().floatRight() + "");
    f_HorizontalPanel45.setSpacing(10);
    f_VerticalPanel25.add(f_HorizontalPanel45);
    dishEditorPanel.setWidget(f_VerticalPanel25);
    dishEditorPanel.setGlassEnabled(true);
    dishEditorPanel.setAutoHideOnHistoryEventsEnabled(true);
    dishEditorPanel.setVisible(false);
    dishEditorPanel.setAnimationEnabled(true);
    f_VerticalPanel24.add(dishEditorPanel);
    f_VerticalPanel24.setVisible(false);
    f_VerticalPanel1.add(f_VerticalPanel24);



    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickFilter(event);
      }
    };
    submitFilter.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickImageDel(event);
      }
    };
    imageDel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onCreateNewMenuLinkClicked(event);
      }
    };
    createMenu.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onCopyMenuClicked(event);
      }
    };
    copyMenu.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onSaveMenuClicked(event);
      }
    };
    saveMenu.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onBlockMenuClicked(event);
      }
    };
    blockMenu.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onUnBlockMenuClicked(event);
      }
    };
    unBlockMenu.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onDialogOk(event);
      }
    };
    dialogOk.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames9 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onDialogCancel(event);
      }
    };
    dialogCancel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames9);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames10 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onAddDishButtonClicked(event);
      }
    };
    addDish.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames10);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames11 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onEditDishButtonClicked(event);
      }
    };
    editDish.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames11);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames12 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onDelDishButtonClicked(event);
      }
    };
    delDish.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames12);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames13 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onDeleteMenuButtonClicked(event);
      }
    };
    deleteMenu.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames13);

    owner.addDish = addDish;
    owner.blockMenu = blockMenu;
    owner.copyMenu = copyMenu;
    owner.createMenu = createMenu;
    owner.dateEndBox = dateEndBox;
    owner.dateStartBox = dateStartBox;
    owner.delDish = delDish;
    owner.deleteMenu = deleteMenu;
    owner.dialogCancel = dialogCancel;
    owner.dialogOk = dialogOk;
    owner.dishActions = dishActions;
    owner.dishEditorPanel = dishEditorPanel;
    owner.dishsTable = dishsTable;
    owner.editDish = editDish;
    owner.emptyMenuListLabel = emptyMenuListLabel;
    owner.imageDel = imageDel;
    owner.imageDish = imageDish;
    owner.isChefDish = isChefDish;
    owner.menuDetails = menuDetails;
    owner.menuDetailsPanel = menuDetailsPanel;
    owner.menuEditPanel = menuEditPanel;
    owner.menuPanel = menuPanel;
    owner.menuTable = menuTable;
    owner.menuTablePanel = menuTablePanel;
    owner.newConsistBox = newConsistBox;
    owner.newMaxCountBox = newMaxCountBox;
    owner.newMenuDate = newMenuDate;
    owner.newMenuTitle = newMenuTitle;
    owner.newOrderDeliveryEndTime = newOrderDeliveryEndTime;
    owner.newOrderDeliveryStartTime = newOrderDeliveryStartTime;
    owner.newOrderEndDate = newOrderEndDate;
    owner.newOrderEndTime = newOrderEndTime;
    owner.newOrderStartDate = newOrderStartDate;
    owner.newOrderStartTime = newOrderStartTime;
    owner.newPhoto = newPhoto;
    owner.newPriceBox = newPriceBox;
    owner.newTitleBox = newTitleBox;
    owner.newTypeDishes = newTypeDishes;
    owner.newURL = newURL;
    owner.newWeightBox = newWeightBox;
    owner.saveMenu = saveMenu;
    owner.unBlockMenu = unBlockMenu;

    return f_VerticalPanel1;
  }
}
