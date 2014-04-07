package com.epam.feel.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ApplicationView_ApplicationViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.epam.feel.client.ui.ApplicationView>, com.epam.feel.client.ui.ApplicationView.ApplicationViewUiBinder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.epam.feel.client.ui.ApplicationView owner) {

    com.epam.feel.client.ui.ApplicationView_ApplicationViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.epam.feel.client.ui.ApplicationView_ApplicationViewUiBinderImpl_GenBundle) GWT.create(com.epam.feel.client.ui.ApplicationView_ApplicationViewUiBinderImpl_GenBundle.class);
    com.google.gwt.user.client.ui.RootLayoutPanel content = (com.google.gwt.user.client.ui.RootLayoutPanel) GWT.create(com.google.gwt.user.client.ui.RootLayoutPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);

    f_VerticalPanel1.add(content);
    f_VerticalPanel1.setWidth("100%");



    owner.content = content;

    return f_VerticalPanel1;
  }
}
