package com.epam.feel.client.ui.util;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class CalendarView_CalendarViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.epam.feel.client.ui.util.CalendarView>, com.epam.feel.client.ui.util.CalendarView.CalendarViewUiBinder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.epam.feel.client.ui.util.CalendarView owner) {

    com.epam.feel.client.ui.util.CalendarView_CalendarViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.epam.feel.client.ui.util.CalendarView_CalendarViewUiBinderImpl_GenBundle) GWT.create(com.epam.feel.client.ui.util.CalendarView_CalendarViewUiBinderImpl_GenBundle.class);
    com.epam.feel.client.EpamFeelConstants constants = (com.epam.feel.client.EpamFeelConstants) GWT.create(com.epam.feel.client.EpamFeelConstants.class);
    com.epam.feel.client.EpamFeelResources st = (com.epam.feel.client.EpamFeelResources) GWT.create(com.epam.feel.client.EpamFeelResources.class);
    com.google.gwt.user.datepicker.client.DateBox dateBox = (com.google.gwt.user.datepicker.client.DateBox) GWT.create(com.google.gwt.user.datepicker.client.DateBox.class);
    com.google.gwt.user.client.ui.Image image = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel2 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.Label hint = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel3 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);

    f_HorizontalPanel2.add(dateBox);
    image.setStyleName("" + st.global().calendarImage() + "");
    image.setUrl("epam_feel/calendar.png");
    f_HorizontalPanel2.add(image);
    f_VerticalPanel1.add(f_HorizontalPanel2);
    hint.setStyleName("" + st.global().hint() + "");
    f_VerticalPanel3.add(hint);
    f_VerticalPanel1.add(f_VerticalPanel3);



    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onImageClick(event);
      }
    };
    image.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    owner.dateBox = dateBox;
    owner.hint = hint;
    owner.image = image;

    return f_VerticalPanel1;
  }
}
