package com.epam.feel.client.ui.util.dialogs;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ReasonMessageBox_ReasonMessageBoxUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.epam.feel.client.ui.util.dialogs.ReasonMessageBox>, com.epam.feel.client.ui.util.dialogs.ReasonMessageBox.ReasonMessageBoxUiBinder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.epam.feel.client.ui.util.dialogs.ReasonMessageBox owner) {

    com.epam.feel.client.ui.util.dialogs.ReasonMessageBox_ReasonMessageBoxUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.epam.feel.client.ui.util.dialogs.ReasonMessageBox_ReasonMessageBoxUiBinderImpl_GenBundle) GWT.create(com.epam.feel.client.ui.util.dialogs.ReasonMessageBox_ReasonMessageBoxUiBinderImpl_GenBundle.class);
    com.epam.feel.client.EpamFeelConstants constants = (com.epam.feel.client.EpamFeelConstants) GWT.create(com.epam.feel.client.EpamFeelConstants.class);
    com.epam.feel.client.ui.util.box.FixedLengthTextArea message = (com.epam.feel.client.ui.util.box.FixedLengthTextArea) GWT.create(com.epam.feel.client.ui.util.box.FixedLengthTextArea.class);
    com.google.gwt.user.client.ui.Button ok = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.Button cancel = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel2 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);

    f_VerticalPanel1.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    message.setWidth("500px");
    message.setHeight("400px");
    f_VerticalPanel1.add(message);
    f_HorizontalPanel2.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    ok.setText("" + constants.ok() + "");
    f_HorizontalPanel2.add(ok);
    cancel.setText("" + constants.cancel() + "");
    f_HorizontalPanel2.add(cancel);
    f_VerticalPanel1.add(f_HorizontalPanel2);



    owner.cancel = cancel;
    owner.message = message;
    owner.ok = ok;

    return f_VerticalPanel1;
  }
}
