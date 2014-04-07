package com.epam.feel.client.ui.util;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class TimeView_TimeViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.epam.feel.client.ui.util.TimeView>, com.epam.feel.client.ui.util.TimeView.TimeViewUiBinder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.epam.feel.client.ui.util.TimeView owner) {

    com.epam.feel.client.ui.util.TimeView_TimeViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.epam.feel.client.ui.util.TimeView_TimeViewUiBinderImpl_GenBundle) GWT.create(com.epam.feel.client.ui.util.TimeView_TimeViewUiBinderImpl_GenBundle.class);
    com.epam.feel.client.EpamFeelResources st = (com.epam.feel.client.EpamFeelResources) GWT.create(com.epam.feel.client.EpamFeelResources.class);
    com.epam.feel.client.ui.util.box.ExtendedIntegerBox hourBox = (com.epam.feel.client.ui.util.box.ExtendedIntegerBox) GWT.create(com.epam.feel.client.ui.util.box.ExtendedIntegerBox.class);
    com.epam.feel.client.ui.util.SpinnerView hourSpinner = (com.epam.feel.client.ui.util.SpinnerView) GWT.create(com.epam.feel.client.ui.util.SpinnerView.class);
    com.epam.feel.client.ui.util.box.ExtendedIntegerBox minuteBox = (com.epam.feel.client.ui.util.box.ExtendedIntegerBox) GWT.create(com.epam.feel.client.ui.util.box.ExtendedIntegerBox.class);
    com.epam.feel.client.ui.util.SpinnerView minuteSpinner = (com.epam.feel.client.ui.util.SpinnerView) GWT.create(com.epam.feel.client.ui.util.SpinnerView.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel1 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);

    f_HorizontalPanel1.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    hourBox.setStyleName("" + st.global().timeViewInput() + "");
    f_HorizontalPanel1.add(hourBox);
    f_HorizontalPanel1.add(hourSpinner);
    minuteBox.setStyleName("" + st.global().timeViewInput() + "");
    f_HorizontalPanel1.add(minuteBox);
    f_HorizontalPanel1.add(minuteSpinner);



    owner.hourBox = hourBox;
    owner.hourSpinner = hourSpinner;
    owner.minuteBox = minuteBox;
    owner.minuteSpinner = minuteSpinner;

    return f_HorizontalPanel1;
  }
}
