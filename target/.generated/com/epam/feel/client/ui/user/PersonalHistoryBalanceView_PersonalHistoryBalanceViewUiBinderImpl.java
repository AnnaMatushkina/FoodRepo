package com.epam.feel.client.ui.user;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class PersonalHistoryBalanceView_PersonalHistoryBalanceViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.epam.feel.client.ui.user.PersonalHistoryBalanceView>, com.epam.feel.client.ui.user.PersonalHistoryBalanceView.PersonalHistoryBalanceViewUiBinder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.epam.feel.client.ui.user.PersonalHistoryBalanceView owner) {

    com.epam.feel.client.ui.user.PersonalHistoryBalanceView_PersonalHistoryBalanceViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.epam.feel.client.ui.user.PersonalHistoryBalanceView_PersonalHistoryBalanceViewUiBinderImpl_GenBundle) GWT.create(com.epam.feel.client.ui.user.PersonalHistoryBalanceView_PersonalHistoryBalanceViewUiBinderImpl_GenBundle.class);
    com.epam.feel.client.EpamFeelConstants constants = (com.epam.feel.client.EpamFeelConstants) GWT.create(com.epam.feel.client.EpamFeelConstants.class);
    com.epam.feel.client.ui.user.MainHeader header = (com.epam.feel.client.ui.user.MainHeader) GWT.create(com.epam.feel.client.ui.user.MainHeader.class);
    com.epam.feel.client.ui.user.Footer footer = (com.epam.feel.client.ui.user.Footer) GWT.create(com.epam.feel.client.ui.user.Footer.class);
    com.google.gwt.user.client.ui.Anchor goToMain = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    com.google.gwt.user.client.ui.Anchor goToArchiveRequests = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    com.google.gwt.user.client.ui.Label label = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.epam.feel.client.ui.util.pagination.FixedPager balancePager = new com.epam.feel.client.ui.util.pagination.FixedPager();
    com.epam.feel.client.ui.admin.HistoryBalanceView historyBalance = (com.epam.feel.client.ui.admin.HistoryBalanceView) GWT.create(com.epam.feel.client.ui.admin.HistoryBalanceView.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel4 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel3 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.ScrollPanel f_ScrollPanel2 = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
    com.google.gwt.user.client.ui.DockLayoutPanel f_DockLayoutPanel1 = new com.google.gwt.user.client.ui.DockLayoutPanel(com.google.gwt.dom.client.Style.Unit.PX);

    f_DockLayoutPanel1.addNorth(header, 175);
    f_DockLayoutPanel1.addSouth(footer, 30);
    goToMain.setText("" + constants.goToMain() + "");
    f_VerticalPanel3.add(goToMain);
    goToArchiveRequests.setText("" + constants.requestsLabel() + "");
    f_VerticalPanel3.add(goToArchiveRequests);
    label.setText("" + constants.historyBalanceLabel() + "");
    f_VerticalPanel3.add(label);
    f_VerticalPanel4.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    balancePager.setRangeLimited(true);
    balancePager.setHeight("30");
    f_VerticalPanel4.add(balancePager);
    historyBalance.setForAdmin(false);
    f_VerticalPanel4.add(historyBalance);
    f_VerticalPanel4.setWidth("100%");
    f_VerticalPanel3.add(f_VerticalPanel4);
    f_VerticalPanel3.setSpacing(5);
    f_VerticalPanel3.setWidth("100%");
    f_ScrollPanel2.add(f_VerticalPanel3);
    f_ScrollPanel2.setAlwaysShowScrollBars(false);
    f_DockLayoutPanel1.add(f_ScrollPanel2);
    f_DockLayoutPanel1.setWidth("100%");
    f_DockLayoutPanel1.setHeight("100%");



    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onGoToMain(event);
      }
    };
    goToMain.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onGoToArchiveRequests(event);
      }
    };
    goToArchiveRequests.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

    owner.balancePager = balancePager;
    owner.footer = footer;
    owner.header = header;
    owner.historyBalance = historyBalance;
    owner.label = label;

    return f_DockLayoutPanel1;
  }
}
