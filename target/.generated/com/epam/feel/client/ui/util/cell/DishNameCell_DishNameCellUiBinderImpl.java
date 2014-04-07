package com.epam.feel.client.ui.util.cell;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class DishNameCell_DishNameCellUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.epam.feel.client.ui.util.cell.DishNameCell>, com.epam.feel.client.ui.util.cell.DishNameCell.DishNameCellUiBinder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.epam.feel.client.ui.util.cell.DishNameCell owner) {

    com.epam.feel.client.ui.util.cell.DishNameCell_DishNameCellUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.epam.feel.client.ui.util.cell.DishNameCell_DishNameCellUiBinderImpl_GenBundle) GWT.create(com.epam.feel.client.ui.util.cell.DishNameCell_DishNameCellUiBinderImpl_GenBundle.class);
    com.epam.feel.client.EpamFeelConstants constants = (com.epam.feel.client.EpamFeelConstants) GWT.create(com.epam.feel.client.EpamFeelConstants.class);
    com.epam.feel.client.EpamFeelResources st = (com.epam.feel.client.EpamFeelResources) GWT.create(com.epam.feel.client.EpamFeelResources.class);
    com.google.gwt.user.client.ui.Image cookie = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
    com.google.gwt.user.client.ui.SimplePanel nameContainer = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel2 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Image image = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
    com.google.gwt.user.client.ui.Label dishConsistency = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.FlowPanel f_FlowPanel3 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);

    cookie.setAltText("" + constants.isChiefDishField() + "");
    cookie.setWidth("20px");
    cookie.setTitle("" + constants.isChiefDishField() + "");
    cookie.setUrl("epam_feel/cookies.png");
    cookie.setHeight("20px");
    f_HorizontalPanel2.add(cookie);
    f_HorizontalPanel2.add(nameContainer);
    f_VerticalPanel1.add(f_HorizontalPanel2);
    image.setStyleName("" + st.global().leftFloatImage() + "");
    image.setWidth("75px");
    image.setHeight("75px");
    f_FlowPanel3.add(image);
    dishConsistency.setStyleName("" + st.global().smallText() + "");
    f_FlowPanel3.add(dishConsistency);
    f_VerticalPanel1.add(f_FlowPanel3);



    owner.cookie = cookie;
    owner.dishConsistency = dishConsistency;
    owner.image = image;
    owner.nameContainer = nameContainer;

    return f_VerticalPanel1;
  }
}
