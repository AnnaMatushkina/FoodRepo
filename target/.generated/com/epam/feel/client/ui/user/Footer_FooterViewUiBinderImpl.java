package com.epam.feel.client.ui.user;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class Footer_FooterViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.epam.feel.client.ui.user.Footer>, com.epam.feel.client.ui.user.Footer.FooterViewUiBinder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.epam.feel.client.ui.user.Footer owner) {

    com.epam.feel.client.ui.user.Footer_FooterViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.epam.feel.client.ui.user.Footer_FooterViewUiBinderImpl_GenBundle) GWT.create(com.epam.feel.client.ui.user.Footer_FooterViewUiBinderImpl_GenBundle.class);
    com.epam.feel.client.EpamFeelConstants constants = (com.epam.feel.client.EpamFeelConstants) GWT.create(com.epam.feel.client.EpamFeelConstants.class);
    com.epam.feel.client.EpamFeelResources st = (com.epam.feel.client.EpamFeelResources) GWT.create(com.epam.feel.client.EpamFeelResources.class);
    com.google.gwt.user.client.ui.Label f_Label3 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel adminsPanel = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel2 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label copyright = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel1 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);

    f_Label3.setStyleName("" + st.global().footerLabel() + "");
    f_Label3.setText("" + constants.adminAddressLabel() + "");
    f_HorizontalPanel2.add(f_Label3);
    adminsPanel.setStyleName("" + st.global().footerAdminLinks() + "");
    f_HorizontalPanel2.add(adminsPanel);
    f_HorizontalPanel1.add(f_HorizontalPanel2);
    copyright.setStyleName("" + st.global().footerLabelCopy() + "");
    f_HorizontalPanel1.add(copyright);
    f_HorizontalPanel1.setStyleName("" + st.global().footer() + "");
    f_HorizontalPanel1.setWidth("100%");



    owner.adminsPanel = adminsPanel;
    owner.copyright = copyright;

    return f_HorizontalPanel1;
  }
}
