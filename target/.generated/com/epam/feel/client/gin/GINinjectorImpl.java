package com.epam.feel.client.gin;

import com.google.gwt.core.client.GWT;

public class GINinjectorImpl implements com.epam.feel.client.gin.GINinjector {
  public com.google.gwt.activity.shared.ActivityManager getActivityManager() {
    return get_Key$type$com$google$gwt$activity$shared$ActivityManager$_annotation$$none$$();
  }
  
  public com.epam.feel.client.ui.ApplicationView getApplicationView() {
    return get_Key$type$com$epam$feel$client$ui$ApplicationView$_annotation$$none$$();
  }
  
  public com.epam.feel.client.mvp.ClientFactory getClientFactory() {
    return get_Key$type$com$epam$feel$client$mvp$ClientFactory$_annotation$$none$$();
  }
  
  public com.epam.feel.shared.service.ClientInfoServiceAsync getClientInfoServiceAsync() {
    return get_Key$type$com$epam$feel$shared$service$ClientInfoServiceAsync$_annotation$$none$$();
  }
  
  public com.epam.feel.shared.service.HistoryInfoServiceAsync getHistoryInfoServiceAsync() {
    return get_Key$type$com$epam$feel$shared$service$HistoryInfoServiceAsync$_annotation$$none$$();
  }
  
  public com.epam.feel.shared.service.MenuInfoServiceAsync getMenuInfoServiceAsync() {
    return get_Key$type$com$epam$feel$shared$service$MenuInfoServiceAsync$_annotation$$none$$();
  }
  
  public com.epam.feel.shared.service.RequestInfoServiceAsync getOrderInfoServiceAsync() {
    return get_Key$type$com$epam$feel$shared$service$RequestInfoServiceAsync$_annotation$$none$$();
  }
  
  public com.google.gwt.place.shared.PlaceHistoryHandler getPlaceHistoryHandler() {
    return get_Key$type$com$google$gwt$place$shared$PlaceHistoryHandler$_annotation$$none$$();
  }
  
  public com.epam.feel.client.mvp.ViewFactory getViewFactory() {
    return get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$();
  }
  
  
  /**
   * Binding for com.epam.feel.client.ui.admin.ListRequestView declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.admin.ListRequestView, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$client$ui$admin$ListRequestView$_annotation$$none$$(com.epam.feel.client.ui.admin.ListRequestView injectee) {
    
  }
  
  private com.epam.feel.client.ui.admin.ListRequestView create_Key$type$com$epam$feel$client$ui$admin$ListRequestView$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.client.ui.admin.ListRequestView.class);
    assert created instanceof com.epam.feel.client.ui.admin.ListRequestView;
    com.epam.feel.client.ui.admin.ListRequestView result = (com.epam.feel.client.ui.admin.ListRequestView) created;
    
    memberInject_Key$type$com$epam$feel$client$ui$admin$ListRequestView$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.ui.admin.ListRequestView declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.admin.ListRequestView, annotation=[none]]
   */
  private com.epam.feel.client.ui.admin.ListRequestView get_Key$type$com$epam$feel$client$ui$admin$ListRequestView$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$ui$admin$ListRequestView$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.activity.HistoryMenuActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.HistoryMenuActivity, annotation=[none]]
   */
  private native void com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.MenuInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::menuInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$PageTemplateActivity_mainHeaderPresenter_fieldInjection(com.epam.feel.client.activity.PageTemplateActivity injectee, com.epam.feel.client.view.IMainHeaderView.IMainHeaderPresenter value) /*-{
    injectee.@com.epam.feel.client.activity.PageTemplateActivity::mainHeaderPresenter = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$PageTemplateActivity_footerPresenter_fieldInjection(com.epam.feel.client.activity.PageTemplateActivity injectee, com.epam.feel.client.view.IFooterView.IFooterPresenter value) /*-{
    injectee.@com.epam.feel.client.activity.PageTemplateActivity::footerPresenter = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.ViewFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::viewFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.AppPlaceFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::placeFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.HistoryInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::historyInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.RequestInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::requestInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.ClientInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::clientInfoServiceAsync = value;
  }-*/;
  
  private void memberInject_Key$type$com$epam$feel$client$activity$HistoryMenuActivity$_annotation$$none$$(com.epam.feel.client.activity.HistoryMenuActivity injectee) {
    com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection(injectee, get_Key$type$com$epam$feel$shared$service$MenuInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$PageTemplateActivity_mainHeaderPresenter_fieldInjection(injectee, get_Key$type$com$epam$feel$client$view$IMainHeaderView$IMainHeaderPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$PageTemplateActivity_footerPresenter_fieldInjection(injectee, get_Key$type$com$epam$feel$client$view$IFooterView$IFooterPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection(injectee, get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection(injectee, get_Key$type$com$epam$feel$client$mvp$AppPlaceFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection(injectee, get_Key$type$com$epam$feel$shared$service$HistoryInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection(injectee, get_Key$type$com$epam$feel$shared$service$RequestInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection(injectee, get_Key$type$com$epam$feel$shared$service$ClientInfoServiceAsync$_annotation$$none$$());
    
  }
  
  private com.epam.feel.client.activity.HistoryMenuActivity com$epam$feel$client$activity$HistoryMenuActivity_HistoryMenuActivity_methodInjection(com.epam.feel.client.mvp.ClientFactory _0, com.epam.feel.client.mvp.ViewFactory _1) {
    return new com.epam.feel.client.activity.HistoryMenuActivity(_0, _1);
  }
  
  private com.epam.feel.client.activity.HistoryMenuActivity create_Key$type$com$epam$feel$client$activity$HistoryMenuActivity$_annotation$$none$$() {
    com.epam.feel.client.activity.HistoryMenuActivity result = com$epam$feel$client$activity$HistoryMenuActivity_HistoryMenuActivity_methodInjection(get_Key$type$com$epam$feel$client$mvp$ClientFactory$_annotation$$none$$(), get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    memberInject_Key$type$com$epam$feel$client$activity$HistoryMenuActivity$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.activity.HistoryMenuActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.HistoryMenuActivity, annotation=[none]]
   */
  private com.epam.feel.client.activity.HistoryMenuActivity get_Key$type$com$epam$feel$client$activity$HistoryMenuActivity$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$activity$HistoryMenuActivity$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.activity.HistoryRequestActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.HistoryRequestActivity, annotation=[none]]
   */
  private native void com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection_(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.MenuInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::menuInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$PageTemplateActivity_mainHeaderPresenter_fieldInjection_(com.epam.feel.client.activity.PageTemplateActivity injectee, com.epam.feel.client.view.IMainHeaderView.IMainHeaderPresenter value) /*-{
    injectee.@com.epam.feel.client.activity.PageTemplateActivity::mainHeaderPresenter = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$PageTemplateActivity_footerPresenter_fieldInjection_(com.epam.feel.client.activity.PageTemplateActivity injectee, com.epam.feel.client.view.IFooterView.IFooterPresenter value) /*-{
    injectee.@com.epam.feel.client.activity.PageTemplateActivity::footerPresenter = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection_(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.ViewFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::viewFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection_(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.AppPlaceFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::placeFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection_(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.HistoryInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::historyInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection_(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.RequestInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::requestInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection_(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.ClientInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::clientInfoServiceAsync = value;
  }-*/;
  
  private void memberInject_Key$type$com$epam$feel$client$activity$HistoryRequestActivity$_annotation$$none$$(com.epam.feel.client.activity.HistoryRequestActivity injectee) {
    com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection_(injectee, get_Key$type$com$epam$feel$shared$service$MenuInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$PageTemplateActivity_mainHeaderPresenter_fieldInjection_(injectee, get_Key$type$com$epam$feel$client$view$IMainHeaderView$IMainHeaderPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$PageTemplateActivity_footerPresenter_fieldInjection_(injectee, get_Key$type$com$epam$feel$client$view$IFooterView$IFooterPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection_(injectee, get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection_(injectee, get_Key$type$com$epam$feel$client$mvp$AppPlaceFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection_(injectee, get_Key$type$com$epam$feel$shared$service$HistoryInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection_(injectee, get_Key$type$com$epam$feel$shared$service$RequestInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection_(injectee, get_Key$type$com$epam$feel$shared$service$ClientInfoServiceAsync$_annotation$$none$$());
    
  }
  
  private com.epam.feel.client.activity.HistoryRequestActivity com$epam$feel$client$activity$HistoryRequestActivity_HistoryRequestActivity_methodInjection(com.epam.feel.client.mvp.ClientFactory _0, com.epam.feel.client.mvp.ViewFactory _1) {
    return new com.epam.feel.client.activity.HistoryRequestActivity(_0, _1);
  }
  
  private com.epam.feel.client.activity.HistoryRequestActivity create_Key$type$com$epam$feel$client$activity$HistoryRequestActivity$_annotation$$none$$() {
    com.epam.feel.client.activity.HistoryRequestActivity result = com$epam$feel$client$activity$HistoryRequestActivity_HistoryRequestActivity_methodInjection(get_Key$type$com$epam$feel$client$mvp$ClientFactory$_annotation$$none$$(), get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    memberInject_Key$type$com$epam$feel$client$activity$HistoryRequestActivity$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.activity.HistoryRequestActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.HistoryRequestActivity, annotation=[none]]
   */
  private com.epam.feel.client.activity.HistoryRequestActivity get_Key$type$com$epam$feel$client$activity$HistoryRequestActivity$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$activity$HistoryRequestActivity$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.activity.HistoryNotificationActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.HistoryNotificationActivity, annotation=[none]]
   */
  private native void com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection__(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.MenuInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::menuInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$PageTemplateActivity_mainHeaderPresenter_fieldInjection__(com.epam.feel.client.activity.PageTemplateActivity injectee, com.epam.feel.client.view.IMainHeaderView.IMainHeaderPresenter value) /*-{
    injectee.@com.epam.feel.client.activity.PageTemplateActivity::mainHeaderPresenter = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$PageTemplateActivity_footerPresenter_fieldInjection__(com.epam.feel.client.activity.PageTemplateActivity injectee, com.epam.feel.client.view.IFooterView.IFooterPresenter value) /*-{
    injectee.@com.epam.feel.client.activity.PageTemplateActivity::footerPresenter = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection__(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.ViewFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::viewFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection__(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.AppPlaceFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::placeFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection__(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.HistoryInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::historyInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection__(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.RequestInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::requestInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection__(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.ClientInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::clientInfoServiceAsync = value;
  }-*/;
  
  private void memberInject_Key$type$com$epam$feel$client$activity$HistoryNotificationActivity$_annotation$$none$$(com.epam.feel.client.activity.HistoryNotificationActivity injectee) {
    com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection__(injectee, get_Key$type$com$epam$feel$shared$service$MenuInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$PageTemplateActivity_mainHeaderPresenter_fieldInjection__(injectee, get_Key$type$com$epam$feel$client$view$IMainHeaderView$IMainHeaderPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$PageTemplateActivity_footerPresenter_fieldInjection__(injectee, get_Key$type$com$epam$feel$client$view$IFooterView$IFooterPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection__(injectee, get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection__(injectee, get_Key$type$com$epam$feel$client$mvp$AppPlaceFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection__(injectee, get_Key$type$com$epam$feel$shared$service$HistoryInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection__(injectee, get_Key$type$com$epam$feel$shared$service$RequestInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection__(injectee, get_Key$type$com$epam$feel$shared$service$ClientInfoServiceAsync$_annotation$$none$$());
    
  }
  
  private com.epam.feel.client.activity.HistoryNotificationActivity com$epam$feel$client$activity$HistoryNotificationActivity_HistoryNotificationActivity_methodInjection(com.epam.feel.client.mvp.ClientFactory _0, com.epam.feel.client.mvp.ViewFactory _1) {
    return new com.epam.feel.client.activity.HistoryNotificationActivity(_0, _1);
  }
  
  private com.epam.feel.client.activity.HistoryNotificationActivity create_Key$type$com$epam$feel$client$activity$HistoryNotificationActivity$_annotation$$none$$() {
    com.epam.feel.client.activity.HistoryNotificationActivity result = com$epam$feel$client$activity$HistoryNotificationActivity_HistoryNotificationActivity_methodInjection(get_Key$type$com$epam$feel$client$mvp$ClientFactory$_annotation$$none$$(), get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    memberInject_Key$type$com$epam$feel$client$activity$HistoryNotificationActivity$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.activity.HistoryNotificationActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.HistoryNotificationActivity, annotation=[none]]
   */
  private com.epam.feel.client.activity.HistoryNotificationActivity get_Key$type$com$epam$feel$client$activity$HistoryNotificationActivity$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$activity$HistoryNotificationActivity$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.view.IMainHeaderView declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:80)
   */
  private com.epam.feel.client.view.IMainHeaderView create_Key$type$com$epam$feel$client$view$IMainHeaderView$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$ui$user$MainHeader$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.IMainHeaderView singleton_Key$type$com$epam$feel$client$view$IMainHeaderView$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:80)
   */
  private com.epam.feel.client.view.IMainHeaderView get_Key$type$com$epam$feel$client$view$IMainHeaderView$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$IMainHeaderView$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$IMainHeaderView$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$IMainHeaderView$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$IMainHeaderView$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.view.IHistoryMenuView$IHistoryMenuPresenter declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:95)
   */
  private com.epam.feel.client.view.IHistoryMenuView.IHistoryMenuPresenter create_Key$type$com$epam$feel$client$view$IHistoryMenuView$IHistoryMenuPresenter$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$activity$HistoryMenuActivity$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.IHistoryMenuView.IHistoryMenuPresenter singleton_Key$type$com$epam$feel$client$view$IHistoryMenuView$IHistoryMenuPresenter$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:95)
   */
  private com.epam.feel.client.view.IHistoryMenuView.IHistoryMenuPresenter get_Key$type$com$epam$feel$client$view$IHistoryMenuView$IHistoryMenuPresenter$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$IHistoryMenuView$IHistoryMenuPresenter$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$IHistoryMenuView$IHistoryMenuPresenter$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$IHistoryMenuView$IHistoryMenuPresenter$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$IHistoryMenuView$IHistoryMenuPresenter$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.place.ArchiveOrderViewPlace declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.place.ArchiveOrderViewPlace, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$client$place$ArchiveOrderViewPlace$_annotation$$none$$(com.epam.feel.client.place.ArchiveOrderViewPlace injectee) {
    
  }
  
  private com.epam.feel.client.place.ArchiveOrderViewPlace create_Key$type$com$epam$feel$client$place$ArchiveOrderViewPlace$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.client.place.ArchiveOrderViewPlace.class);
    assert created instanceof com.epam.feel.client.place.ArchiveOrderViewPlace;
    com.epam.feel.client.place.ArchiveOrderViewPlace result = (com.epam.feel.client.place.ArchiveOrderViewPlace) created;
    
    memberInject_Key$type$com$epam$feel$client$place$ArchiveOrderViewPlace$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.place.ArchiveOrderViewPlace declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.place.ArchiveOrderViewPlace, annotation=[none]]
   */
  private com.epam.feel.client.place.ArchiveOrderViewPlace get_Key$type$com$epam$feel$client$place$ArchiveOrderViewPlace$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$place$ArchiveOrderViewPlace$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.google.gwt.activity.shared.ActivityMapper declared at:
   *   public com.google.gwt.activity.shared.ActivityMapper com.epam.feel.client.gin.GINClientModule.getActivityMapper(com.epam.feel.client.mvp.ClientFactory,com.google.inject.Provider,com.google.inject.Provider,com.google.inject.Provider)
   */
  private com.google.gwt.activity.shared.ActivityMapper com$epam$feel$client$gin$GINClientModule_getActivityMapper_methodInjection(com.epam.feel.client.gin.GINClientModule injectee, com.epam.feel.client.mvp.ClientFactory _0, com.google.inject.Provider _1, com.google.inject.Provider _2, com.google.inject.Provider _3) {
    return injectee.getActivityMapper(_0, _1, _2, _3);
  }
  
  private com.google.gwt.activity.shared.ActivityMapper create_Key$type$com$google$gwt$activity$shared$ActivityMapper$_annotation$$none$$() {
    return com$epam$feel$client$gin$GINClientModule_getActivityMapper_methodInjection(new com.epam.feel.client.gin.GINClientModule(), get_Key$type$com$epam$feel$client$mvp$ClientFactory$_annotation$$none$$(), get_Key$type$com$google$inject$Provider$com$epam$feel$client$activity$ApplicationActivity$$_annotation$$none$$(), get_Key$type$com$google$inject$Provider$com$epam$feel$client$activity$PersonalAccountActivity$$_annotation$$none$$(), get_Key$type$com$google$inject$Provider$com$epam$feel$client$activity$HistoryBalanceActivity$$_annotation$$none$$());
  }
  
  private com.google.gwt.activity.shared.ActivityMapper singleton_Key$type$com$google$gwt$activity$shared$ActivityMapper$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   public com.google.gwt.activity.shared.ActivityMapper com.epam.feel.client.gin.GINClientModule.getActivityMapper(com.epam.feel.client.mvp.ClientFactory,com.google.inject.Provider,com.google.inject.Provider,com.google.inject.Provider)
   */
  private com.google.gwt.activity.shared.ActivityMapper get_Key$type$com$google$gwt$activity$shared$ActivityMapper$_annotation$$none$$() {
    if (singleton_Key$type$com$google$gwt$activity$shared$ActivityMapper$_annotation$$none$$ == null) {
      singleton_Key$type$com$google$gwt$activity$shared$ActivityMapper$_annotation$$none$$ = create_Key$type$com$google$gwt$activity$shared$ActivityMapper$_annotation$$none$$();
    }
    return singleton_Key$type$com$google$gwt$activity$shared$ActivityMapper$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.activity.HistoryBalanceActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.HistoryBalanceActivity, annotation=[none]]
   */
  private native void com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection___(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.MenuInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::menuInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$PageTemplateActivity_mainHeaderPresenter_fieldInjection___(com.epam.feel.client.activity.PageTemplateActivity injectee, com.epam.feel.client.view.IMainHeaderView.IMainHeaderPresenter value) /*-{
    injectee.@com.epam.feel.client.activity.PageTemplateActivity::mainHeaderPresenter = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$PageTemplateActivity_footerPresenter_fieldInjection___(com.epam.feel.client.activity.PageTemplateActivity injectee, com.epam.feel.client.view.IFooterView.IFooterPresenter value) /*-{
    injectee.@com.epam.feel.client.activity.PageTemplateActivity::footerPresenter = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection___(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.ViewFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::viewFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection___(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.AppPlaceFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::placeFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection___(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.HistoryInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::historyInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection___(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.RequestInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::requestInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection___(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.ClientInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::clientInfoServiceAsync = value;
  }-*/;
  
  private void memberInject_Key$type$com$epam$feel$client$activity$HistoryBalanceActivity$_annotation$$none$$(com.epam.feel.client.activity.HistoryBalanceActivity injectee) {
    com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection___(injectee, get_Key$type$com$epam$feel$shared$service$MenuInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$PageTemplateActivity_mainHeaderPresenter_fieldInjection___(injectee, get_Key$type$com$epam$feel$client$view$IMainHeaderView$IMainHeaderPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$PageTemplateActivity_footerPresenter_fieldInjection___(injectee, get_Key$type$com$epam$feel$client$view$IFooterView$IFooterPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection___(injectee, get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection___(injectee, get_Key$type$com$epam$feel$client$mvp$AppPlaceFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection___(injectee, get_Key$type$com$epam$feel$shared$service$HistoryInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection___(injectee, get_Key$type$com$epam$feel$shared$service$RequestInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection___(injectee, get_Key$type$com$epam$feel$shared$service$ClientInfoServiceAsync$_annotation$$none$$());
    
  }
  
  private com.epam.feel.client.activity.HistoryBalanceActivity com$epam$feel$client$activity$HistoryBalanceActivity_HistoryBalanceActivity_methodInjection(com.epam.feel.client.mvp.ClientFactory _0, com.epam.feel.client.mvp.ViewFactory _1) {
    return new com.epam.feel.client.activity.HistoryBalanceActivity(_0, _1);
  }
  
  private com.epam.feel.client.activity.HistoryBalanceActivity create_Key$type$com$epam$feel$client$activity$HistoryBalanceActivity$_annotation$$none$$() {
    com.epam.feel.client.activity.HistoryBalanceActivity result = com$epam$feel$client$activity$HistoryBalanceActivity_HistoryBalanceActivity_methodInjection(get_Key$type$com$epam$feel$client$mvp$ClientFactory$_annotation$$none$$(), get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    memberInject_Key$type$com$epam$feel$client$activity$HistoryBalanceActivity$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.activity.HistoryBalanceActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.HistoryBalanceActivity, annotation=[none]]
   */
  private com.epam.feel.client.activity.HistoryBalanceActivity get_Key$type$com$epam$feel$client$activity$HistoryBalanceActivity$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$activity$HistoryBalanceActivity$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.activity.HistoryRequestGroupActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.HistoryRequestGroupActivity, annotation=[none]]
   */
  private native void com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection____(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.MenuInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::menuInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$PageTemplateActivity_mainHeaderPresenter_fieldInjection____(com.epam.feel.client.activity.PageTemplateActivity injectee, com.epam.feel.client.view.IMainHeaderView.IMainHeaderPresenter value) /*-{
    injectee.@com.epam.feel.client.activity.PageTemplateActivity::mainHeaderPresenter = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$PageTemplateActivity_footerPresenter_fieldInjection____(com.epam.feel.client.activity.PageTemplateActivity injectee, com.epam.feel.client.view.IFooterView.IFooterPresenter value) /*-{
    injectee.@com.epam.feel.client.activity.PageTemplateActivity::footerPresenter = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection____(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.ViewFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::viewFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection____(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.AppPlaceFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::placeFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection____(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.HistoryInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::historyInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection____(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.RequestInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::requestInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection____(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.ClientInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::clientInfoServiceAsync = value;
  }-*/;
  
  private void memberInject_Key$type$com$epam$feel$client$activity$HistoryRequestGroupActivity$_annotation$$none$$(com.epam.feel.client.activity.HistoryRequestGroupActivity injectee) {
    com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection____(injectee, get_Key$type$com$epam$feel$shared$service$MenuInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$PageTemplateActivity_mainHeaderPresenter_fieldInjection____(injectee, get_Key$type$com$epam$feel$client$view$IMainHeaderView$IMainHeaderPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$PageTemplateActivity_footerPresenter_fieldInjection____(injectee, get_Key$type$com$epam$feel$client$view$IFooterView$IFooterPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection____(injectee, get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection____(injectee, get_Key$type$com$epam$feel$client$mvp$AppPlaceFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection____(injectee, get_Key$type$com$epam$feel$shared$service$HistoryInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection____(injectee, get_Key$type$com$epam$feel$shared$service$RequestInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection____(injectee, get_Key$type$com$epam$feel$shared$service$ClientInfoServiceAsync$_annotation$$none$$());
    
  }
  
  private com.epam.feel.client.activity.HistoryRequestGroupActivity com$epam$feel$client$activity$HistoryRequestGroupActivity_HistoryRequestGroupActivity_methodInjection(com.epam.feel.client.mvp.ClientFactory _0, com.epam.feel.client.mvp.ViewFactory _1) {
    return new com.epam.feel.client.activity.HistoryRequestGroupActivity(_0, _1);
  }
  
  private com.epam.feel.client.activity.HistoryRequestGroupActivity create_Key$type$com$epam$feel$client$activity$HistoryRequestGroupActivity$_annotation$$none$$() {
    com.epam.feel.client.activity.HistoryRequestGroupActivity result = com$epam$feel$client$activity$HistoryRequestGroupActivity_HistoryRequestGroupActivity_methodInjection(get_Key$type$com$epam$feel$client$mvp$ClientFactory$_annotation$$none$$(), get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    memberInject_Key$type$com$epam$feel$client$activity$HistoryRequestGroupActivity$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.activity.HistoryRequestGroupActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.HistoryRequestGroupActivity, annotation=[none]]
   */
  private com.epam.feel.client.activity.HistoryRequestGroupActivity get_Key$type$com$epam$feel$client$activity$HistoryRequestGroupActivity$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$activity$HistoryRequestGroupActivity$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.shared.service.MenuInfoServiceAsync declared at:
   *   Implicit binding for Key[type=com.epam.feel.shared.service.MenuInfoServiceAsync, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$shared$service$MenuInfoServiceAsync$_annotation$$none$$(com.epam.feel.shared.service.MenuInfoServiceAsync injectee) {
    
  }
  
  private com.epam.feel.shared.service.MenuInfoServiceAsync create_Key$type$com$epam$feel$shared$service$MenuInfoServiceAsync$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.shared.service.MenuInfoService.class);
    assert created instanceof com.epam.feel.shared.service.MenuInfoServiceAsync;
    com.epam.feel.shared.service.MenuInfoServiceAsync result = (com.epam.feel.shared.service.MenuInfoServiceAsync) created;
    
    memberInject_Key$type$com$epam$feel$shared$service$MenuInfoServiceAsync$_annotation$$none$$(result);
    return result;
  }
  
  private com.epam.feel.shared.service.MenuInfoServiceAsync singleton_Key$type$com$epam$feel$shared$service$MenuInfoServiceAsync$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   Implicit binding for Key[type=com.epam.feel.shared.service.MenuInfoServiceAsync, annotation=[none]]
   */
  private com.epam.feel.shared.service.MenuInfoServiceAsync get_Key$type$com$epam$feel$shared$service$MenuInfoServiceAsync$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$shared$service$MenuInfoServiceAsync$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$shared$service$MenuInfoServiceAsync$_annotation$$none$$ = create_Key$type$com$epam$feel$shared$service$MenuInfoServiceAsync$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$shared$service$MenuInfoServiceAsync$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.ui.admin.HistoryRequestGroupView declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.admin.HistoryRequestGroupView, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$client$ui$admin$HistoryRequestGroupView$_annotation$$none$$(com.epam.feel.client.ui.admin.HistoryRequestGroupView injectee) {
    
  }
  
  private com.epam.feel.client.ui.admin.HistoryRequestGroupView create_Key$type$com$epam$feel$client$ui$admin$HistoryRequestGroupView$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.client.ui.admin.HistoryRequestGroupView.class);
    assert created instanceof com.epam.feel.client.ui.admin.HistoryRequestGroupView;
    com.epam.feel.client.ui.admin.HistoryRequestGroupView result = (com.epam.feel.client.ui.admin.HistoryRequestGroupView) created;
    
    memberInject_Key$type$com$epam$feel$client$ui$admin$HistoryRequestGroupView$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.ui.admin.HistoryRequestGroupView declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.admin.HistoryRequestGroupView, annotation=[none]]
   */
  private com.epam.feel.client.ui.admin.HistoryRequestGroupView get_Key$type$com$epam$feel$client$ui$admin$HistoryRequestGroupView$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$ui$admin$HistoryRequestGroupView$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.google.inject.Provider<com.epam.feel.client.place.HistoryBalancePlace> declared at:
   *   Implicit binding for Key[type=com.google.inject.Provider<com.epam.feel.client.place.HistoryBalancePlace>, annotation=[none]]
   */
  private com.google.inject.Provider<com.epam.feel.client.place.HistoryBalancePlace> create_Key$type$com$google$inject$Provider$com$epam$feel$client$place$HistoryBalancePlace$$_annotation$$none$$() {
    return new com.google.inject.Provider<com.epam.feel.client.place.HistoryBalancePlace>() { 
      public com.epam.feel.client.place.HistoryBalancePlace get() { 
        return get_Key$type$com$epam$feel$client$place$HistoryBalancePlace$_annotation$$none$$();
      }
    };
  }
  
  
  /**
   * Binding for com.google.inject.Provider<com.epam.feel.client.place.HistoryBalancePlace> declared at:
   *   Implicit binding for Key[type=com.google.inject.Provider<com.epam.feel.client.place.HistoryBalancePlace>, annotation=[none]]
   */
  private com.google.inject.Provider<com.epam.feel.client.place.HistoryBalancePlace> get_Key$type$com$google$inject$Provider$com$epam$feel$client$place$HistoryBalancePlace$$_annotation$$none$$() {
    return create_Key$type$com$google$inject$Provider$com$epam$feel$client$place$HistoryBalancePlace$$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.view.IPersonalAccountView declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:79)
   */
  private com.epam.feel.client.view.IPersonalAccountView create_Key$type$com$epam$feel$client$view$IPersonalAccountView$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$ui$user$PersonalAccountView$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.IPersonalAccountView singleton_Key$type$com$epam$feel$client$view$IPersonalAccountView$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:79)
   */
  private com.epam.feel.client.view.IPersonalAccountView get_Key$type$com$epam$feel$client$view$IPersonalAccountView$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$IPersonalAccountView$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$IPersonalAccountView$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$IPersonalAccountView$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$IPersonalAccountView$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.activity.CashManagementActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.CashManagementActivity, annotation=[none]]
   */
  private native void com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection_____(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.MenuInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::menuInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$PageTemplateActivity_mainHeaderPresenter_fieldInjection_____(com.epam.feel.client.activity.PageTemplateActivity injectee, com.epam.feel.client.view.IMainHeaderView.IMainHeaderPresenter value) /*-{
    injectee.@com.epam.feel.client.activity.PageTemplateActivity::mainHeaderPresenter = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$PageTemplateActivity_footerPresenter_fieldInjection_____(com.epam.feel.client.activity.PageTemplateActivity injectee, com.epam.feel.client.view.IFooterView.IFooterPresenter value) /*-{
    injectee.@com.epam.feel.client.activity.PageTemplateActivity::footerPresenter = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection_____(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.ViewFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::viewFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection_____(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.AppPlaceFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::placeFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection_____(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.HistoryInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::historyInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection_____(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.RequestInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::requestInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection_____(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.ClientInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::clientInfoServiceAsync = value;
  }-*/;
  
  private void memberInject_Key$type$com$epam$feel$client$activity$CashManagementActivity$_annotation$$none$$(com.epam.feel.client.activity.CashManagementActivity injectee) {
    com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection_____(injectee, get_Key$type$com$epam$feel$shared$service$MenuInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$PageTemplateActivity_mainHeaderPresenter_fieldInjection_____(injectee, get_Key$type$com$epam$feel$client$view$IMainHeaderView$IMainHeaderPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$PageTemplateActivity_footerPresenter_fieldInjection_____(injectee, get_Key$type$com$epam$feel$client$view$IFooterView$IFooterPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection_____(injectee, get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection_____(injectee, get_Key$type$com$epam$feel$client$mvp$AppPlaceFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection_____(injectee, get_Key$type$com$epam$feel$shared$service$HistoryInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection_____(injectee, get_Key$type$com$epam$feel$shared$service$RequestInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection_____(injectee, get_Key$type$com$epam$feel$shared$service$ClientInfoServiceAsync$_annotation$$none$$());
    
  }
  
  private com.epam.feel.client.activity.CashManagementActivity com$epam$feel$client$activity$CashManagementActivity_CashManagementActivity_methodInjection(com.epam.feel.client.mvp.ClientFactory _0, com.epam.feel.client.mvp.ViewFactory _1) {
    return new com.epam.feel.client.activity.CashManagementActivity(_0, _1);
  }
  
  private com.epam.feel.client.activity.CashManagementActivity create_Key$type$com$epam$feel$client$activity$CashManagementActivity$_annotation$$none$$() {
    com.epam.feel.client.activity.CashManagementActivity result = com$epam$feel$client$activity$CashManagementActivity_CashManagementActivity_methodInjection(get_Key$type$com$epam$feel$client$mvp$ClientFactory$_annotation$$none$$(), get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    memberInject_Key$type$com$epam$feel$client$activity$CashManagementActivity$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.activity.CashManagementActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.CashManagementActivity, annotation=[none]]
   */
  private com.epam.feel.client.activity.CashManagementActivity get_Key$type$com$epam$feel$client$activity$CashManagementActivity$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$activity$CashManagementActivity$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.view.ICashManagementView$ICashManagementPresenter declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:90)
   */
  private com.epam.feel.client.view.ICashManagementView.ICashManagementPresenter create_Key$type$com$epam$feel$client$view$ICashManagementView$ICashManagementPresenter$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$activity$CashManagementActivity$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.ICashManagementView.ICashManagementPresenter singleton_Key$type$com$epam$feel$client$view$ICashManagementView$ICashManagementPresenter$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:90)
   */
  private com.epam.feel.client.view.ICashManagementView.ICashManagementPresenter get_Key$type$com$epam$feel$client$view$ICashManagementView$ICashManagementPresenter$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$ICashManagementView$ICashManagementPresenter$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$ICashManagementView$ICashManagementPresenter$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$ICashManagementView$ICashManagementPresenter$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$ICashManagementView$ICashManagementPresenter$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.google.web.bindery.event.shared.EventBus declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:109)
   */
  private com.google.web.bindery.event.shared.EventBus create_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$() {
    return get_Key$type$com$google$web$bindery$event$shared$SimpleEventBus$_annotation$$none$$();
  }
  
  private com.google.web.bindery.event.shared.EventBus singleton_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:109)
   */
  private com.google.web.bindery.event.shared.EventBus get_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$() {
    if (singleton_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$ == null) {
      singleton_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$ = create_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$();
    }
    return singleton_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.google.inject.Provider<com.epam.feel.client.activity.HistoryBalanceActivity> declared at:
   *   Implicit binding for Key[type=com.google.inject.Provider<com.epam.feel.client.activity.HistoryBalanceActivity>, annotation=[none]]
   */
  private com.google.inject.Provider<com.epam.feel.client.activity.HistoryBalanceActivity> create_Key$type$com$google$inject$Provider$com$epam$feel$client$activity$HistoryBalanceActivity$$_annotation$$none$$() {
    return new com.google.inject.Provider<com.epam.feel.client.activity.HistoryBalanceActivity>() { 
      public com.epam.feel.client.activity.HistoryBalanceActivity get() { 
        return get_Key$type$com$epam$feel$client$activity$HistoryBalanceActivity$_annotation$$none$$();
      }
    };
  }
  
  
  /**
   * Binding for com.google.inject.Provider<com.epam.feel.client.activity.HistoryBalanceActivity> declared at:
   *   Implicit binding for Key[type=com.google.inject.Provider<com.epam.feel.client.activity.HistoryBalanceActivity>, annotation=[none]]
   */
  private com.google.inject.Provider<com.epam.feel.client.activity.HistoryBalanceActivity> get_Key$type$com$google$inject$Provider$com$epam$feel$client$activity$HistoryBalanceActivity$$_annotation$$none$$() {
    return create_Key$type$com$google$inject$Provider$com$epam$feel$client$activity$HistoryBalanceActivity$$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.place.ApplicationPlace declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.place.ApplicationPlace, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$client$place$ApplicationPlace$_annotation$$none$$(com.epam.feel.client.place.ApplicationPlace injectee) {
    
  }
  
  private com.epam.feel.client.place.ApplicationPlace create_Key$type$com$epam$feel$client$place$ApplicationPlace$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.client.place.ApplicationPlace.class);
    assert created instanceof com.epam.feel.client.place.ApplicationPlace;
    com.epam.feel.client.place.ApplicationPlace result = (com.epam.feel.client.place.ApplicationPlace) created;
    
    memberInject_Key$type$com$epam$feel$client$place$ApplicationPlace$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.place.ApplicationPlace declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.place.ApplicationPlace, annotation=[none]]
   */
  private com.epam.feel.client.place.ApplicationPlace get_Key$type$com$epam$feel$client$place$ApplicationPlace$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$place$ApplicationPlace$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.mvp.AppPlaceFactory declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:110)
   */
  private native void com$epam$feel$client$mvp$AppPlaceFactory_applicationPlaceTokenizer_fieldInjection(com.epam.feel.client.mvp.AppPlaceFactory injectee, com.epam.feel.client.place.ApplicationPlace.Tokenizer value) /*-{
    injectee.@com.epam.feel.client.mvp.AppPlaceFactory::applicationPlaceTokenizer = value;
  }-*/;
  
  private native void com$epam$feel$client$mvp$AppPlaceFactory_personalAccountPlaceTokenizer_fieldInjection(com.epam.feel.client.mvp.AppPlaceFactory injectee, com.epam.feel.client.place.PersonalAccountPlace.Tokenizer value) /*-{
    injectee.@com.epam.feel.client.mvp.AppPlaceFactory::personalAccountPlaceTokenizer = value;
  }-*/;
  
  private native void com$epam$feel$client$mvp$AppPlaceFactory_applicationProviderPlace_fieldInjection(com.epam.feel.client.mvp.AppPlaceFactory injectee, com.google.inject.Provider value) /*-{
    injectee.@com.epam.feel.client.mvp.AppPlaceFactory::applicationProviderPlace = value;
  }-*/;
  
  private native void com$epam$feel$client$mvp$AppPlaceFactory_balanceHistoryProviderPlace_fieldInjection(com.epam.feel.client.mvp.AppPlaceFactory injectee, com.google.inject.Provider value) /*-{
    injectee.@com.epam.feel.client.mvp.AppPlaceFactory::balanceHistoryProviderPlace = value;
  }-*/;
  
  private native void com$epam$feel$client$mvp$AppPlaceFactory_archiveOrderViewPlaceTokenizer_fieldInjection(com.epam.feel.client.mvp.AppPlaceFactory injectee, com.epam.feel.client.place.ArchiveOrderViewPlace.Tokenizer value) /*-{
    injectee.@com.epam.feel.client.mvp.AppPlaceFactory::archiveOrderViewPlaceTokenizer = value;
  }-*/;
  
  private native void com$epam$feel$client$mvp$AppPlaceFactory_archiveOrderViewProviderPlace_fieldInjection(com.epam.feel.client.mvp.AppPlaceFactory injectee, com.google.inject.Provider value) /*-{
    injectee.@com.epam.feel.client.mvp.AppPlaceFactory::archiveOrderViewProviderPlace = value;
  }-*/;
  
  private native void com$epam$feel$client$mvp$AppPlaceFactory_personalAccountProviderPlace_fieldInjection(com.epam.feel.client.mvp.AppPlaceFactory injectee, com.google.inject.Provider value) /*-{
    injectee.@com.epam.feel.client.mvp.AppPlaceFactory::personalAccountProviderPlace = value;
  }-*/;
  
  private native void com$epam$feel$client$mvp$AppPlaceFactory_balanceHistoryPlaceTokenizer_fieldInjection(com.epam.feel.client.mvp.AppPlaceFactory injectee, com.epam.feel.client.place.HistoryBalancePlace.Tokenizer value) /*-{
    injectee.@com.epam.feel.client.mvp.AppPlaceFactory::balanceHistoryPlaceTokenizer = value;
  }-*/;
  
  private void memberInject_Key$type$com$epam$feel$client$mvp$AppPlaceFactory$_annotation$$none$$(com.epam.feel.client.mvp.AppPlaceFactory injectee) {
    com$epam$feel$client$mvp$AppPlaceFactory_applicationPlaceTokenizer_fieldInjection(injectee, get_Key$type$com$epam$feel$client$place$ApplicationPlace$Tokenizer$_annotation$$none$$());
    com$epam$feel$client$mvp$AppPlaceFactory_personalAccountPlaceTokenizer_fieldInjection(injectee, get_Key$type$com$epam$feel$client$place$PersonalAccountPlace$Tokenizer$_annotation$$none$$());
    com$epam$feel$client$mvp$AppPlaceFactory_applicationProviderPlace_fieldInjection(injectee, get_Key$type$com$google$inject$Provider$com$epam$feel$client$place$ApplicationPlace$$_annotation$$none$$());
    com$epam$feel$client$mvp$AppPlaceFactory_balanceHistoryProviderPlace_fieldInjection(injectee, get_Key$type$com$google$inject$Provider$com$epam$feel$client$place$HistoryBalancePlace$$_annotation$$none$$());
    com$epam$feel$client$mvp$AppPlaceFactory_archiveOrderViewPlaceTokenizer_fieldInjection(injectee, get_Key$type$com$epam$feel$client$place$ArchiveOrderViewPlace$Tokenizer$_annotation$$none$$());
    com$epam$feel$client$mvp$AppPlaceFactory_archiveOrderViewProviderPlace_fieldInjection(injectee, get_Key$type$com$google$inject$Provider$com$epam$feel$client$place$ArchiveOrderViewPlace$$_annotation$$none$$());
    com$epam$feel$client$mvp$AppPlaceFactory_personalAccountProviderPlace_fieldInjection(injectee, get_Key$type$com$google$inject$Provider$com$epam$feel$client$place$PersonalAccountPlace$$_annotation$$none$$());
    com$epam$feel$client$mvp$AppPlaceFactory_balanceHistoryPlaceTokenizer_fieldInjection(injectee, get_Key$type$com$epam$feel$client$place$HistoryBalancePlace$Tokenizer$_annotation$$none$$());
    
  }
  
  private com.epam.feel.client.mvp.AppPlaceFactory create_Key$type$com$epam$feel$client$mvp$AppPlaceFactory$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.client.mvp.AppPlaceFactory.class);
    assert created instanceof com.epam.feel.client.mvp.AppPlaceFactory;
    com.epam.feel.client.mvp.AppPlaceFactory result = (com.epam.feel.client.mvp.AppPlaceFactory) created;
    
    memberInject_Key$type$com$epam$feel$client$mvp$AppPlaceFactory$_annotation$$none$$(result);
    return result;
  }
  
  private com.epam.feel.client.mvp.AppPlaceFactory singleton_Key$type$com$epam$feel$client$mvp$AppPlaceFactory$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:110)
   */
  private com.epam.feel.client.mvp.AppPlaceFactory get_Key$type$com$epam$feel$client$mvp$AppPlaceFactory$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$mvp$AppPlaceFactory$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$mvp$AppPlaceFactory$_annotation$$none$$ = create_Key$type$com$epam$feel$client$mvp$AppPlaceFactory$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$mvp$AppPlaceFactory$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.mvp.ViewFactory declared at:
   *   public com.epam.feel.client.mvp.ViewFactory com.epam.feel.client.gin.GINClientModule.getViewFactory(com.epam.feel.client.view.IApplicationView,com.epam.feel.client.view.IPersonalAccountView,com.epam.feel.client.view.IPersonalHistoryBalanceView)
   */
  private com.epam.feel.client.mvp.ViewFactory com$epam$feel$client$gin$GINClientModule_getViewFactory_methodInjection(com.epam.feel.client.gin.GINClientModule injectee, com.epam.feel.client.view.IApplicationView _0, com.epam.feel.client.view.IPersonalAccountView _1, com.epam.feel.client.view.IPersonalHistoryBalanceView _2) {
    return injectee.getViewFactory(_0, _1, _2);
  }
  
  private com.epam.feel.client.mvp.ViewFactory create_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$() {
    return com$epam$feel$client$gin$GINClientModule_getViewFactory_methodInjection(new com.epam.feel.client.gin.GINClientModule(), get_Key$type$com$epam$feel$client$view$IApplicationView$_annotation$$none$$(), get_Key$type$com$epam$feel$client$view$IPersonalAccountView$_annotation$$none$$(), get_Key$type$com$epam$feel$client$view$IPersonalHistoryBalanceView$_annotation$$none$$());
  }
  
  private com.epam.feel.client.mvp.ViewFactory singleton_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   public com.epam.feel.client.mvp.ViewFactory com.epam.feel.client.gin.GINClientModule.getViewFactory(com.epam.feel.client.view.IApplicationView,com.epam.feel.client.view.IPersonalAccountView,com.epam.feel.client.view.IPersonalHistoryBalanceView)
   */
  private com.epam.feel.client.mvp.ViewFactory get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$ = create_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.shared.service.HistoryInfoServiceAsync declared at:
   *   Implicit binding for Key[type=com.epam.feel.shared.service.HistoryInfoServiceAsync, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$shared$service$HistoryInfoServiceAsync$_annotation$$none$$(com.epam.feel.shared.service.HistoryInfoServiceAsync injectee) {
    
  }
  
  private com.epam.feel.shared.service.HistoryInfoServiceAsync create_Key$type$com$epam$feel$shared$service$HistoryInfoServiceAsync$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.shared.service.HistoryInfoService.class);
    assert created instanceof com.epam.feel.shared.service.HistoryInfoServiceAsync;
    com.epam.feel.shared.service.HistoryInfoServiceAsync result = (com.epam.feel.shared.service.HistoryInfoServiceAsync) created;
    
    memberInject_Key$type$com$epam$feel$shared$service$HistoryInfoServiceAsync$_annotation$$none$$(result);
    return result;
  }
  
  private com.epam.feel.shared.service.HistoryInfoServiceAsync singleton_Key$type$com$epam$feel$shared$service$HistoryInfoServiceAsync$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   Implicit binding for Key[type=com.epam.feel.shared.service.HistoryInfoServiceAsync, annotation=[none]]
   */
  private com.epam.feel.shared.service.HistoryInfoServiceAsync get_Key$type$com$epam$feel$shared$service$HistoryInfoServiceAsync$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$shared$service$HistoryInfoServiceAsync$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$shared$service$HistoryInfoServiceAsync$_annotation$$none$$ = create_Key$type$com$epam$feel$shared$service$HistoryInfoServiceAsync$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$shared$service$HistoryInfoServiceAsync$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.view.IHistoryBalanceView$IHistoryBalancePresenter declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:92)
   */
  private com.epam.feel.client.view.IHistoryBalanceView.IHistoryBalancePresenter create_Key$type$com$epam$feel$client$view$IHistoryBalanceView$IHistoryBalancePresenter$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$activity$HistoryBalanceActivity$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.IHistoryBalanceView.IHistoryBalancePresenter singleton_Key$type$com$epam$feel$client$view$IHistoryBalanceView$IHistoryBalancePresenter$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:92)
   */
  private com.epam.feel.client.view.IHistoryBalanceView.IHistoryBalancePresenter get_Key$type$com$epam$feel$client$view$IHistoryBalanceView$IHistoryBalancePresenter$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$IHistoryBalanceView$IHistoryBalancePresenter$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$IHistoryBalanceView$IHistoryBalancePresenter$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$IHistoryBalanceView$IHistoryBalancePresenter$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$IHistoryBalanceView$IHistoryBalancePresenter$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.view.IPersonalHistoryBalanceView declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:93)
   */
  private com.epam.feel.client.view.IPersonalHistoryBalanceView create_Key$type$com$epam$feel$client$view$IPersonalHistoryBalanceView$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$ui$user$PersonalHistoryBalanceView$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.IPersonalHistoryBalanceView singleton_Key$type$com$epam$feel$client$view$IPersonalHistoryBalanceView$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:93)
   */
  private com.epam.feel.client.view.IPersonalHistoryBalanceView get_Key$type$com$epam$feel$client$view$IPersonalHistoryBalanceView$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$IPersonalHistoryBalanceView$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$IPersonalHistoryBalanceView$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$IPersonalHistoryBalanceView$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$IPersonalHistoryBalanceView$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.view.IHistoryRequestGroupView declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:98)
   */
  private com.epam.feel.client.view.IHistoryRequestGroupView create_Key$type$com$epam$feel$client$view$IHistoryRequestGroupView$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$ui$admin$HistoryRequestGroupView$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.IHistoryRequestGroupView singleton_Key$type$com$epam$feel$client$view$IHistoryRequestGroupView$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:98)
   */
  private com.epam.feel.client.view.IHistoryRequestGroupView get_Key$type$com$epam$feel$client$view$IHistoryRequestGroupView$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$IHistoryRequestGroupView$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$IHistoryRequestGroupView$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$IHistoryRequestGroupView$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$IHistoryRequestGroupView$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.place.ArchiveOrderViewPlace$Tokenizer declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.place.ArchiveOrderViewPlace$Tokenizer, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$client$place$ArchiveOrderViewPlace$Tokenizer$_annotation$$none$$(com.epam.feel.client.place.ArchiveOrderViewPlace.Tokenizer injectee) {
    
  }
  
  private com.epam.feel.client.place.ArchiveOrderViewPlace.Tokenizer com$epam$feel$client$place$ArchiveOrderViewPlace$Tokenizer_Tokenizer_methodInjection(com.google.inject.Provider _0) {
    return new com.epam.feel.client.place.ArchiveOrderViewPlace.Tokenizer(_0);
  }
  
  private com.epam.feel.client.place.ArchiveOrderViewPlace.Tokenizer create_Key$type$com$epam$feel$client$place$ArchiveOrderViewPlace$Tokenizer$_annotation$$none$$() {
    com.epam.feel.client.place.ArchiveOrderViewPlace.Tokenizer result = com$epam$feel$client$place$ArchiveOrderViewPlace$Tokenizer_Tokenizer_methodInjection(get_Key$type$com$google$inject$Provider$com$epam$feel$client$place$ArchiveOrderViewPlace$$_annotation$$none$$());
    memberInject_Key$type$com$epam$feel$client$place$ArchiveOrderViewPlace$Tokenizer$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.place.ArchiveOrderViewPlace$Tokenizer declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.place.ArchiveOrderViewPlace$Tokenizer, annotation=[none]]
   */
  private com.epam.feel.client.place.ArchiveOrderViewPlace.Tokenizer get_Key$type$com$epam$feel$client$place$ArchiveOrderViewPlace$Tokenizer$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$place$ArchiveOrderViewPlace$Tokenizer$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.google.gwt.place.shared.PlaceHistoryHandler declared at:
   *   public com.google.gwt.place.shared.PlaceHistoryHandler com.epam.feel.client.gin.GINClientModule.getHistoryHandler(com.google.gwt.place.shared.PlaceController,com.epam.feel.client.mvp.AppPlaceHistoryMapper,com.google.web.bindery.event.shared.EventBus,com.epam.feel.client.mvp.AppPlaceFactory)
   */
  private com.google.gwt.place.shared.PlaceHistoryHandler com$epam$feel$client$gin$GINClientModule_getHistoryHandler_methodInjection(com.epam.feel.client.gin.GINClientModule injectee, com.google.gwt.place.shared.PlaceController _0, com.epam.feel.client.mvp.AppPlaceHistoryMapper _1, com.google.web.bindery.event.shared.EventBus _2, com.epam.feel.client.mvp.AppPlaceFactory _3) {
    return injectee.getHistoryHandler(_0, _1, _2, _3);
  }
  
  private com.google.gwt.place.shared.PlaceHistoryHandler create_Key$type$com$google$gwt$place$shared$PlaceHistoryHandler$_annotation$$none$$() {
    return com$epam$feel$client$gin$GINClientModule_getHistoryHandler_methodInjection(new com.epam.feel.client.gin.GINClientModule(), get_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$(), get_Key$type$com$epam$feel$client$mvp$AppPlaceHistoryMapper$_annotation$$none$$(), get_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$(), get_Key$type$com$epam$feel$client$mvp$AppPlaceFactory$_annotation$$none$$());
  }
  
  private com.google.gwt.place.shared.PlaceHistoryHandler singleton_Key$type$com$google$gwt$place$shared$PlaceHistoryHandler$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   public com.google.gwt.place.shared.PlaceHistoryHandler com.epam.feel.client.gin.GINClientModule.getHistoryHandler(com.google.gwt.place.shared.PlaceController,com.epam.feel.client.mvp.AppPlaceHistoryMapper,com.google.web.bindery.event.shared.EventBus,com.epam.feel.client.mvp.AppPlaceFactory)
   */
  private com.google.gwt.place.shared.PlaceHistoryHandler get_Key$type$com$google$gwt$place$shared$PlaceHistoryHandler$_annotation$$none$$() {
    if (singleton_Key$type$com$google$gwt$place$shared$PlaceHistoryHandler$_annotation$$none$$ == null) {
      singleton_Key$type$com$google$gwt$place$shared$PlaceHistoryHandler$_annotation$$none$$ = create_Key$type$com$google$gwt$place$shared$PlaceHistoryHandler$_annotation$$none$$();
    }
    return singleton_Key$type$com$google$gwt$place$shared$PlaceHistoryHandler$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.IEpamFeelMessages declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:115)
   */
  private void memberInject_Key$type$com$epam$feel$client$IEpamFeelMessages$_annotation$$none$$(com.epam.feel.client.IEpamFeelMessages injectee) {
    
  }
  
  private com.epam.feel.client.IEpamFeelMessages create_Key$type$com$epam$feel$client$IEpamFeelMessages$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.client.IEpamFeelMessages.class);
    assert created instanceof com.epam.feel.client.IEpamFeelMessages;
    com.epam.feel.client.IEpamFeelMessages result = (com.epam.feel.client.IEpamFeelMessages) created;
    
    memberInject_Key$type$com$epam$feel$client$IEpamFeelMessages$_annotation$$none$$(result);
    return result;
  }
  
  private com.epam.feel.client.IEpamFeelMessages singleton_Key$type$com$epam$feel$client$IEpamFeelMessages$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:115)
   */
  private com.epam.feel.client.IEpamFeelMessages get_Key$type$com$epam$feel$client$IEpamFeelMessages$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$IEpamFeelMessages$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$IEpamFeelMessages$_annotation$$none$$ = create_Key$type$com$epam$feel$client$IEpamFeelMessages$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$IEpamFeelMessages$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.activity.ListGroupRequestActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.ListGroupRequestActivity, annotation=[none]]
   */
  private native void com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection______(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.MenuInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::menuInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$PageTemplateActivity_mainHeaderPresenter_fieldInjection______(com.epam.feel.client.activity.PageTemplateActivity injectee, com.epam.feel.client.view.IMainHeaderView.IMainHeaderPresenter value) /*-{
    injectee.@com.epam.feel.client.activity.PageTemplateActivity::mainHeaderPresenter = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$PageTemplateActivity_footerPresenter_fieldInjection______(com.epam.feel.client.activity.PageTemplateActivity injectee, com.epam.feel.client.view.IFooterView.IFooterPresenter value) /*-{
    injectee.@com.epam.feel.client.activity.PageTemplateActivity::footerPresenter = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection______(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.ViewFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::viewFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection______(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.AppPlaceFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::placeFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection______(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.HistoryInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::historyInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection______(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.RequestInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::requestInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection______(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.ClientInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::clientInfoServiceAsync = value;
  }-*/;
  
  private void memberInject_Key$type$com$epam$feel$client$activity$ListGroupRequestActivity$_annotation$$none$$(com.epam.feel.client.activity.ListGroupRequestActivity injectee) {
    com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection______(injectee, get_Key$type$com$epam$feel$shared$service$MenuInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$PageTemplateActivity_mainHeaderPresenter_fieldInjection______(injectee, get_Key$type$com$epam$feel$client$view$IMainHeaderView$IMainHeaderPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$PageTemplateActivity_footerPresenter_fieldInjection______(injectee, get_Key$type$com$epam$feel$client$view$IFooterView$IFooterPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection______(injectee, get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection______(injectee, get_Key$type$com$epam$feel$client$mvp$AppPlaceFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection______(injectee, get_Key$type$com$epam$feel$shared$service$HistoryInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection______(injectee, get_Key$type$com$epam$feel$shared$service$RequestInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection______(injectee, get_Key$type$com$epam$feel$shared$service$ClientInfoServiceAsync$_annotation$$none$$());
    
  }
  
  private com.epam.feel.client.activity.ListGroupRequestActivity com$epam$feel$client$activity$ListGroupRequestActivity_ListGroupRequestActivity_methodInjection(com.epam.feel.client.mvp.ClientFactory _0, com.epam.feel.client.mvp.ViewFactory _1) {
    return new com.epam.feel.client.activity.ListGroupRequestActivity(_0, _1);
  }
  
  private com.epam.feel.client.activity.ListGroupRequestActivity create_Key$type$com$epam$feel$client$activity$ListGroupRequestActivity$_annotation$$none$$() {
    com.epam.feel.client.activity.ListGroupRequestActivity result = com$epam$feel$client$activity$ListGroupRequestActivity_ListGroupRequestActivity_methodInjection(get_Key$type$com$epam$feel$client$mvp$ClientFactory$_annotation$$none$$(), get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    memberInject_Key$type$com$epam$feel$client$activity$ListGroupRequestActivity$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.activity.ListGroupRequestActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.ListGroupRequestActivity, annotation=[none]]
   */
  private com.epam.feel.client.activity.ListGroupRequestActivity get_Key$type$com$epam$feel$client$activity$ListGroupRequestActivity$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$activity$ListGroupRequestActivity$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.google.inject.Provider<com.epam.feel.client.place.ApplicationPlace> declared at:
   *   Implicit binding for Key[type=com.google.inject.Provider<com.epam.feel.client.place.ApplicationPlace>, annotation=[none]]
   */
  private com.google.inject.Provider<com.epam.feel.client.place.ApplicationPlace> create_Key$type$com$google$inject$Provider$com$epam$feel$client$place$ApplicationPlace$$_annotation$$none$$() {
    return new com.google.inject.Provider<com.epam.feel.client.place.ApplicationPlace>() { 
      public com.epam.feel.client.place.ApplicationPlace get() { 
        return get_Key$type$com$epam$feel$client$place$ApplicationPlace$_annotation$$none$$();
      }
    };
  }
  
  
  /**
   * Binding for com.google.inject.Provider<com.epam.feel.client.place.ApplicationPlace> declared at:
   *   Implicit binding for Key[type=com.google.inject.Provider<com.epam.feel.client.place.ApplicationPlace>, annotation=[none]]
   */
  private com.google.inject.Provider<com.epam.feel.client.place.ApplicationPlace> get_Key$type$com$google$inject$Provider$com$epam$feel$client$place$ApplicationPlace$$_annotation$$none$$() {
    return create_Key$type$com$google$inject$Provider$com$epam$feel$client$place$ApplicationPlace$$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.view.IListGroupRequestView$IListGroupRequestPresenter declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:105)
   */
  private com.epam.feel.client.view.IListGroupRequestView.IListGroupRequestPresenter create_Key$type$com$epam$feel$client$view$IListGroupRequestView$IListGroupRequestPresenter$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$activity$ListGroupRequestActivity$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.IListGroupRequestView.IListGroupRequestPresenter singleton_Key$type$com$epam$feel$client$view$IListGroupRequestView$IListGroupRequestPresenter$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:105)
   */
  private com.epam.feel.client.view.IListGroupRequestView.IListGroupRequestPresenter get_Key$type$com$epam$feel$client$view$IListGroupRequestView$IListGroupRequestPresenter$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$IListGroupRequestView$IListGroupRequestPresenter$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$IListGroupRequestView$IListGroupRequestPresenter$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$IListGroupRequestView$IListGroupRequestPresenter$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$IListGroupRequestView$IListGroupRequestPresenter$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.activity.ListOrderActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.ListOrderActivity, annotation=[none]]
   */
  private native void com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection_______(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.MenuInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::menuInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$PageTemplateActivity_mainHeaderPresenter_fieldInjection_______(com.epam.feel.client.activity.PageTemplateActivity injectee, com.epam.feel.client.view.IMainHeaderView.IMainHeaderPresenter value) /*-{
    injectee.@com.epam.feel.client.activity.PageTemplateActivity::mainHeaderPresenter = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$PageTemplateActivity_footerPresenter_fieldInjection_______(com.epam.feel.client.activity.PageTemplateActivity injectee, com.epam.feel.client.view.IFooterView.IFooterPresenter value) /*-{
    injectee.@com.epam.feel.client.activity.PageTemplateActivity::footerPresenter = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection_______(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.ViewFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::viewFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection_______(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.AppPlaceFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::placeFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection_______(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.HistoryInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::historyInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection_______(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.RequestInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::requestInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection_______(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.ClientInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::clientInfoServiceAsync = value;
  }-*/;
  
  private void memberInject_Key$type$com$epam$feel$client$activity$ListOrderActivity$_annotation$$none$$(com.epam.feel.client.activity.ListOrderActivity injectee) {
    com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection_______(injectee, get_Key$type$com$epam$feel$shared$service$MenuInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$PageTemplateActivity_mainHeaderPresenter_fieldInjection_______(injectee, get_Key$type$com$epam$feel$client$view$IMainHeaderView$IMainHeaderPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$PageTemplateActivity_footerPresenter_fieldInjection_______(injectee, get_Key$type$com$epam$feel$client$view$IFooterView$IFooterPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection_______(injectee, get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection_______(injectee, get_Key$type$com$epam$feel$client$mvp$AppPlaceFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection_______(injectee, get_Key$type$com$epam$feel$shared$service$HistoryInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection_______(injectee, get_Key$type$com$epam$feel$shared$service$RequestInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection_______(injectee, get_Key$type$com$epam$feel$shared$service$ClientInfoServiceAsync$_annotation$$none$$());
    
  }
  
  private com.epam.feel.client.activity.ListOrderActivity com$epam$feel$client$activity$ListOrderActivity_ListOrderActivity_methodInjection(com.epam.feel.client.mvp.ClientFactory _0, com.epam.feel.client.mvp.ViewFactory _1) {
    return new com.epam.feel.client.activity.ListOrderActivity(_0, _1);
  }
  
  private com.epam.feel.client.activity.ListOrderActivity create_Key$type$com$epam$feel$client$activity$ListOrderActivity$_annotation$$none$$() {
    com.epam.feel.client.activity.ListOrderActivity result = com$epam$feel$client$activity$ListOrderActivity_ListOrderActivity_methodInjection(get_Key$type$com$epam$feel$client$mvp$ClientFactory$_annotation$$none$$(), get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    memberInject_Key$type$com$epam$feel$client$activity$ListOrderActivity$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.activity.ListOrderActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.ListOrderActivity, annotation=[none]]
   */
  private com.epam.feel.client.activity.ListOrderActivity get_Key$type$com$epam$feel$client$activity$ListOrderActivity$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$activity$ListOrderActivity$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.view.IHistoryMenuView declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:94)
   */
  private com.epam.feel.client.view.IHistoryMenuView create_Key$type$com$epam$feel$client$view$IHistoryMenuView$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$ui$admin$HistoryMenuView$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.IHistoryMenuView singleton_Key$type$com$epam$feel$client$view$IHistoryMenuView$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:94)
   */
  private com.epam.feel.client.view.IHistoryMenuView get_Key$type$com$epam$feel$client$view$IHistoryMenuView$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$IHistoryMenuView$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$IHistoryMenuView$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$IHistoryMenuView$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$IHistoryMenuView$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.ui.user.Footer declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.user.Footer, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$client$ui$user$Footer$_annotation$$none$$(com.epam.feel.client.ui.user.Footer injectee) {
    
  }
  
  private com.epam.feel.client.ui.user.Footer create_Key$type$com$epam$feel$client$ui$user$Footer$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.client.ui.user.Footer.class);
    assert created instanceof com.epam.feel.client.ui.user.Footer;
    com.epam.feel.client.ui.user.Footer result = (com.epam.feel.client.ui.user.Footer) created;
    
    memberInject_Key$type$com$epam$feel$client$ui$user$Footer$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.ui.user.Footer declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.user.Footer, annotation=[none]]
   */
  private com.epam.feel.client.ui.user.Footer get_Key$type$com$epam$feel$client$ui$user$Footer$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$ui$user$Footer$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.google.inject.Provider<com.epam.feel.client.place.ArchiveOrderViewPlace> declared at:
   *   Implicit binding for Key[type=com.google.inject.Provider<com.epam.feel.client.place.ArchiveOrderViewPlace>, annotation=[none]]
   */
  private com.google.inject.Provider<com.epam.feel.client.place.ArchiveOrderViewPlace> create_Key$type$com$google$inject$Provider$com$epam$feel$client$place$ArchiveOrderViewPlace$$_annotation$$none$$() {
    return new com.google.inject.Provider<com.epam.feel.client.place.ArchiveOrderViewPlace>() { 
      public com.epam.feel.client.place.ArchiveOrderViewPlace get() { 
        return get_Key$type$com$epam$feel$client$place$ArchiveOrderViewPlace$_annotation$$none$$();
      }
    };
  }
  
  
  /**
   * Binding for com.google.inject.Provider<com.epam.feel.client.place.ArchiveOrderViewPlace> declared at:
   *   Implicit binding for Key[type=com.google.inject.Provider<com.epam.feel.client.place.ArchiveOrderViewPlace>, annotation=[none]]
   */
  private com.google.inject.Provider<com.epam.feel.client.place.ArchiveOrderViewPlace> get_Key$type$com$google$inject$Provider$com$epam$feel$client$place$ArchiveOrderViewPlace$$_annotation$$none$$() {
    return create_Key$type$com$google$inject$Provider$com$epam$feel$client$place$ArchiveOrderViewPlace$$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.activity.CreateMenuActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.CreateMenuActivity, annotation=[none]]
   */
  private native void com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.MenuInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::menuInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$PageTemplateActivity_mainHeaderPresenter_fieldInjection________(com.epam.feel.client.activity.PageTemplateActivity injectee, com.epam.feel.client.view.IMainHeaderView.IMainHeaderPresenter value) /*-{
    injectee.@com.epam.feel.client.activity.PageTemplateActivity::mainHeaderPresenter = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$PageTemplateActivity_footerPresenter_fieldInjection________(com.epam.feel.client.activity.PageTemplateActivity injectee, com.epam.feel.client.view.IFooterView.IFooterPresenter value) /*-{
    injectee.@com.epam.feel.client.activity.PageTemplateActivity::footerPresenter = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.ViewFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::viewFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.AppPlaceFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::placeFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.HistoryInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::historyInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.RequestInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::requestInfoServiceAsync = value;
  }-*/;
  
  private void com$epam$feel$client$activity$CreateMenuActivity_mainHeaderPresenter_fieldInjection(com.epam.feel.client.activity.CreateMenuActivity injectee, com.epam.feel.client.view.IMainHeaderView.IMainHeaderPresenter value) {
    injectee.mainHeaderPresenter = value;
  }
  
  private native void com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.ClientInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::clientInfoServiceAsync = value;
  }-*/;
  
  private void com$epam$feel$client$activity$CreateMenuActivity_footerPresenter_fieldInjection(com.epam.feel.client.activity.CreateMenuActivity injectee, com.epam.feel.client.view.IFooterView.IFooterPresenter value) {
    injectee.footerPresenter = value;
  }
  
  private void memberInject_Key$type$com$epam$feel$client$activity$CreateMenuActivity$_annotation$$none$$(com.epam.feel.client.activity.CreateMenuActivity injectee) {
    com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection________(injectee, get_Key$type$com$epam$feel$shared$service$MenuInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$PageTemplateActivity_mainHeaderPresenter_fieldInjection________(injectee, get_Key$type$com$epam$feel$client$view$IMainHeaderView$IMainHeaderPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$PageTemplateActivity_footerPresenter_fieldInjection________(injectee, get_Key$type$com$epam$feel$client$view$IFooterView$IFooterPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection________(injectee, get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection________(injectee, get_Key$type$com$epam$feel$client$mvp$AppPlaceFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection________(injectee, get_Key$type$com$epam$feel$shared$service$HistoryInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection________(injectee, get_Key$type$com$epam$feel$shared$service$RequestInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$CreateMenuActivity_mainHeaderPresenter_fieldInjection(injectee, get_Key$type$com$epam$feel$client$view$IMainHeaderView$IMainHeaderPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection________(injectee, get_Key$type$com$epam$feel$shared$service$ClientInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$CreateMenuActivity_footerPresenter_fieldInjection(injectee, get_Key$type$com$epam$feel$client$view$IFooterView$IFooterPresenter$_annotation$$none$$());
    
  }
  
  private com.epam.feel.client.activity.CreateMenuActivity com$epam$feel$client$activity$CreateMenuActivity_CreateMenuActivity_methodInjection(com.epam.feel.client.mvp.ClientFactory _0, com.epam.feel.client.mvp.ViewFactory _1) {
    return new com.epam.feel.client.activity.CreateMenuActivity(_0, _1);
  }
  
  private com.epam.feel.client.activity.CreateMenuActivity create_Key$type$com$epam$feel$client$activity$CreateMenuActivity$_annotation$$none$$() {
    com.epam.feel.client.activity.CreateMenuActivity result = com$epam$feel$client$activity$CreateMenuActivity_CreateMenuActivity_methodInjection(get_Key$type$com$epam$feel$client$mvp$ClientFactory$_annotation$$none$$(), get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    memberInject_Key$type$com$epam$feel$client$activity$CreateMenuActivity$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.activity.CreateMenuActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.CreateMenuActivity, annotation=[none]]
   */
  private com.epam.feel.client.activity.CreateMenuActivity get_Key$type$com$epam$feel$client$activity$CreateMenuActivity$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$activity$CreateMenuActivity$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.view.IApplicationView declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:77)
   */
  private com.epam.feel.client.view.IApplicationView create_Key$type$com$epam$feel$client$view$IApplicationView$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$ui$ApplicationView$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.IApplicationView singleton_Key$type$com$epam$feel$client$view$IApplicationView$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:77)
   */
  private com.epam.feel.client.view.IApplicationView get_Key$type$com$epam$feel$client$view$IApplicationView$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$IApplicationView$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$IApplicationView$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$IApplicationView$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$IApplicationView$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.view.IPersonalAccountView$IPersonalAccountPresenter declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:82)
   */
  private com.epam.feel.client.view.IPersonalAccountView.IPersonalAccountPresenter create_Key$type$com$epam$feel$client$view$IPersonalAccountView$IPersonalAccountPresenter$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$activity$PersonalAccountActivity$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.IPersonalAccountView.IPersonalAccountPresenter singleton_Key$type$com$epam$feel$client$view$IPersonalAccountView$IPersonalAccountPresenter$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:82)
   */
  private com.epam.feel.client.view.IPersonalAccountView.IPersonalAccountPresenter get_Key$type$com$epam$feel$client$view$IPersonalAccountView$IPersonalAccountPresenter$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$IPersonalAccountView$IPersonalAccountPresenter$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$IPersonalAccountView$IPersonalAccountPresenter$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$IPersonalAccountView$IPersonalAccountPresenter$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$IPersonalAccountView$IPersonalAccountPresenter$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.ui.user.PersonalHistoryBalanceView declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.user.PersonalHistoryBalanceView, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$client$ui$user$PersonalHistoryBalanceView$_annotation$$none$$(com.epam.feel.client.ui.user.PersonalHistoryBalanceView injectee) {
    
  }
  
  private com.epam.feel.client.ui.user.PersonalHistoryBalanceView create_Key$type$com$epam$feel$client$ui$user$PersonalHistoryBalanceView$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.client.ui.user.PersonalHistoryBalanceView.class);
    assert created instanceof com.epam.feel.client.ui.user.PersonalHistoryBalanceView;
    com.epam.feel.client.ui.user.PersonalHistoryBalanceView result = (com.epam.feel.client.ui.user.PersonalHistoryBalanceView) created;
    
    memberInject_Key$type$com$epam$feel$client$ui$user$PersonalHistoryBalanceView$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.ui.user.PersonalHistoryBalanceView declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.user.PersonalHistoryBalanceView, annotation=[none]]
   */
  private com.epam.feel.client.ui.user.PersonalHistoryBalanceView get_Key$type$com$epam$feel$client$ui$user$PersonalHistoryBalanceView$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$ui$user$PersonalHistoryBalanceView$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.google.inject.Provider<com.epam.feel.client.activity.PersonalAccountActivity> declared at:
   *   Implicit binding for Key[type=com.google.inject.Provider<com.epam.feel.client.activity.PersonalAccountActivity>, annotation=[none]]
   */
  private com.google.inject.Provider<com.epam.feel.client.activity.PersonalAccountActivity> create_Key$type$com$google$inject$Provider$com$epam$feel$client$activity$PersonalAccountActivity$$_annotation$$none$$() {
    return new com.google.inject.Provider<com.epam.feel.client.activity.PersonalAccountActivity>() { 
      public com.epam.feel.client.activity.PersonalAccountActivity get() { 
        return get_Key$type$com$epam$feel$client$activity$PersonalAccountActivity$_annotation$$none$$();
      }
    };
  }
  
  
  /**
   * Binding for com.google.inject.Provider<com.epam.feel.client.activity.PersonalAccountActivity> declared at:
   *   Implicit binding for Key[type=com.google.inject.Provider<com.epam.feel.client.activity.PersonalAccountActivity>, annotation=[none]]
   */
  private com.google.inject.Provider<com.epam.feel.client.activity.PersonalAccountActivity> get_Key$type$com$google$inject$Provider$com$epam$feel$client$activity$PersonalAccountActivity$$_annotation$$none$$() {
    return create_Key$type$com$google$inject$Provider$com$epam$feel$client$activity$PersonalAccountActivity$$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.activity.ClientListViewActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.ClientListViewActivity, annotation=[none]]
   */
  private native void com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection_________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.MenuInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::menuInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$PageTemplateActivity_mainHeaderPresenter_fieldInjection_________(com.epam.feel.client.activity.PageTemplateActivity injectee, com.epam.feel.client.view.IMainHeaderView.IMainHeaderPresenter value) /*-{
    injectee.@com.epam.feel.client.activity.PageTemplateActivity::mainHeaderPresenter = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$PageTemplateActivity_footerPresenter_fieldInjection_________(com.epam.feel.client.activity.PageTemplateActivity injectee, com.epam.feel.client.view.IFooterView.IFooterPresenter value) /*-{
    injectee.@com.epam.feel.client.activity.PageTemplateActivity::footerPresenter = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection_________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.ViewFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::viewFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection_________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.AppPlaceFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::placeFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection_________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.HistoryInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::historyInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection_________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.RequestInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::requestInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection_________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.ClientInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::clientInfoServiceAsync = value;
  }-*/;
  
  private void memberInject_Key$type$com$epam$feel$client$activity$ClientListViewActivity$_annotation$$none$$(com.epam.feel.client.activity.ClientListViewActivity injectee) {
    com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection_________(injectee, get_Key$type$com$epam$feel$shared$service$MenuInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$PageTemplateActivity_mainHeaderPresenter_fieldInjection_________(injectee, get_Key$type$com$epam$feel$client$view$IMainHeaderView$IMainHeaderPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$PageTemplateActivity_footerPresenter_fieldInjection_________(injectee, get_Key$type$com$epam$feel$client$view$IFooterView$IFooterPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection_________(injectee, get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection_________(injectee, get_Key$type$com$epam$feel$client$mvp$AppPlaceFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection_________(injectee, get_Key$type$com$epam$feel$shared$service$HistoryInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection_________(injectee, get_Key$type$com$epam$feel$shared$service$RequestInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection_________(injectee, get_Key$type$com$epam$feel$shared$service$ClientInfoServiceAsync$_annotation$$none$$());
    
  }
  
  private com.epam.feel.client.activity.ClientListViewActivity com$epam$feel$client$activity$ClientListViewActivity_ClientListViewActivity_methodInjection(com.epam.feel.client.mvp.ClientFactory _0, com.epam.feel.client.mvp.ViewFactory _1) {
    return new com.epam.feel.client.activity.ClientListViewActivity(_0, _1);
  }
  
  private com.epam.feel.client.activity.ClientListViewActivity create_Key$type$com$epam$feel$client$activity$ClientListViewActivity$_annotation$$none$$() {
    com.epam.feel.client.activity.ClientListViewActivity result = com$epam$feel$client$activity$ClientListViewActivity_ClientListViewActivity_methodInjection(get_Key$type$com$epam$feel$client$mvp$ClientFactory$_annotation$$none$$(), get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    memberInject_Key$type$com$epam$feel$client$activity$ClientListViewActivity$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.activity.ClientListViewActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.ClientListViewActivity, annotation=[none]]
   */
  private com.epam.feel.client.activity.ClientListViewActivity get_Key$type$com$epam$feel$client$activity$ClientListViewActivity$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$activity$ClientListViewActivity$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.mvp.AppPlaceHistoryMapper declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.mvp.AppPlaceHistoryMapper, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$client$mvp$AppPlaceHistoryMapper$_annotation$$none$$(com.epam.feel.client.mvp.AppPlaceHistoryMapper injectee) {
    
  }
  
  private com.epam.feel.client.mvp.AppPlaceHistoryMapper create_Key$type$com$epam$feel$client$mvp$AppPlaceHistoryMapper$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.client.mvp.AppPlaceHistoryMapper.class);
    assert created instanceof com.epam.feel.client.mvp.AppPlaceHistoryMapper;
    com.epam.feel.client.mvp.AppPlaceHistoryMapper result = (com.epam.feel.client.mvp.AppPlaceHistoryMapper) created;
    
    memberInject_Key$type$com$epam$feel$client$mvp$AppPlaceHistoryMapper$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.mvp.AppPlaceHistoryMapper declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.mvp.AppPlaceHistoryMapper, annotation=[none]]
   */
  private com.epam.feel.client.mvp.AppPlaceHistoryMapper get_Key$type$com$epam$feel$client$mvp$AppPlaceHistoryMapper$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$mvp$AppPlaceHistoryMapper$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.view.IListRequestView$IListRequestPresenter declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:89)
   */
  private com.epam.feel.client.view.IListRequestView.IListRequestPresenter create_Key$type$com$epam$feel$client$view$IListRequestView$IListRequestPresenter$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$activity$ListOrderActivity$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.IListRequestView.IListRequestPresenter singleton_Key$type$com$epam$feel$client$view$IListRequestView$IListRequestPresenter$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:89)
   */
  private com.epam.feel.client.view.IListRequestView.IListRequestPresenter get_Key$type$com$epam$feel$client$view$IListRequestView$IListRequestPresenter$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$IListRequestView$IListRequestPresenter$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$IListRequestView$IListRequestPresenter$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$IListRequestView$IListRequestPresenter$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$IListRequestView$IListRequestPresenter$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.ui.admin.HistoryRequestView declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.admin.HistoryRequestView, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$client$ui$admin$HistoryRequestView$_annotation$$none$$(com.epam.feel.client.ui.admin.HistoryRequestView injectee) {
    
  }
  
  private com.epam.feel.client.ui.admin.HistoryRequestView create_Key$type$com$epam$feel$client$ui$admin$HistoryRequestView$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.client.ui.admin.HistoryRequestView.class);
    assert created instanceof com.epam.feel.client.ui.admin.HistoryRequestView;
    com.epam.feel.client.ui.admin.HistoryRequestView result = (com.epam.feel.client.ui.admin.HistoryRequestView) created;
    
    memberInject_Key$type$com$epam$feel$client$ui$admin$HistoryRequestView$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.ui.admin.HistoryRequestView declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.admin.HistoryRequestView, annotation=[none]]
   */
  private com.epam.feel.client.ui.admin.HistoryRequestView get_Key$type$com$epam$feel$client$ui$admin$HistoryRequestView$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$ui$admin$HistoryRequestView$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.ui.user.MainHeader declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.user.MainHeader, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$client$ui$user$MainHeader$_annotation$$none$$(com.epam.feel.client.ui.user.MainHeader injectee) {
    
  }
  
  private com.epam.feel.client.ui.user.MainHeader create_Key$type$com$epam$feel$client$ui$user$MainHeader$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.client.ui.user.MainHeader.class);
    assert created instanceof com.epam.feel.client.ui.user.MainHeader;
    com.epam.feel.client.ui.user.MainHeader result = (com.epam.feel.client.ui.user.MainHeader) created;
    
    memberInject_Key$type$com$epam$feel$client$ui$user$MainHeader$_annotation$$none$$(result);
    return result;
  }
  
  private com.epam.feel.client.ui.user.MainHeader singleton_Key$type$com$epam$feel$client$ui$user$MainHeader$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.user.MainHeader, annotation=[none]]
   */
  private com.epam.feel.client.ui.user.MainHeader get_Key$type$com$epam$feel$client$ui$user$MainHeader$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$ui$user$MainHeader$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$ui$user$MainHeader$_annotation$$none$$ = create_Key$type$com$epam$feel$client$ui$user$MainHeader$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$ui$user$MainHeader$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.view.IHistoryNotificationView declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:101)
   */
  private com.epam.feel.client.view.IHistoryNotificationView create_Key$type$com$epam$feel$client$view$IHistoryNotificationView$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$ui$admin$HistoryNotificationView$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.IHistoryNotificationView singleton_Key$type$com$epam$feel$client$view$IHistoryNotificationView$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:101)
   */
  private com.epam.feel.client.view.IHistoryNotificationView get_Key$type$com$epam$feel$client$view$IHistoryNotificationView$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$IHistoryNotificationView$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$IHistoryNotificationView$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$IHistoryNotificationView$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$IHistoryNotificationView$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.ui.admin.ListGroupRequestView declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.admin.ListGroupRequestView, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$client$ui$admin$ListGroupRequestView$_annotation$$none$$(com.epam.feel.client.ui.admin.ListGroupRequestView injectee) {
    
  }
  
  private com.epam.feel.client.ui.admin.ListGroupRequestView create_Key$type$com$epam$feel$client$ui$admin$ListGroupRequestView$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.client.ui.admin.ListGroupRequestView.class);
    assert created instanceof com.epam.feel.client.ui.admin.ListGroupRequestView;
    com.epam.feel.client.ui.admin.ListGroupRequestView result = (com.epam.feel.client.ui.admin.ListGroupRequestView) created;
    
    memberInject_Key$type$com$epam$feel$client$ui$admin$ListGroupRequestView$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.ui.admin.ListGroupRequestView declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.admin.ListGroupRequestView, annotation=[none]]
   */
  private com.epam.feel.client.ui.admin.ListGroupRequestView get_Key$type$com$epam$feel$client$ui$admin$ListGroupRequestView$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$ui$admin$ListGroupRequestView$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.view.IHistoryRequestView declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:96)
   */
  private com.epam.feel.client.view.IHistoryRequestView create_Key$type$com$epam$feel$client$view$IHistoryRequestView$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$ui$admin$HistoryRequestView$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.IHistoryRequestView singleton_Key$type$com$epam$feel$client$view$IHistoryRequestView$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:96)
   */
  private com.epam.feel.client.view.IHistoryRequestView get_Key$type$com$epam$feel$client$view$IHistoryRequestView$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$IHistoryRequestView$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$IHistoryRequestView$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$IHistoryRequestView$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$IHistoryRequestView$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.view.ICreateMenuView declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:86)
   */
  private com.epam.feel.client.view.ICreateMenuView create_Key$type$com$epam$feel$client$view$ICreateMenuView$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$ui$admin$CreateMenuView$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.ICreateMenuView singleton_Key$type$com$epam$feel$client$view$ICreateMenuView$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:86)
   */
  private com.epam.feel.client.view.ICreateMenuView get_Key$type$com$epam$feel$client$view$ICreateMenuView$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$ICreateMenuView$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$ICreateMenuView$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$ICreateMenuView$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$ICreateMenuView$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.activity.PersonalAccountActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.PersonalAccountActivity, annotation=[none]]
   */
  private native void com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection__________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.MenuInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::menuInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$PageTemplateActivity_mainHeaderPresenter_fieldInjection__________(com.epam.feel.client.activity.PageTemplateActivity injectee, com.epam.feel.client.view.IMainHeaderView.IMainHeaderPresenter value) /*-{
    injectee.@com.epam.feel.client.activity.PageTemplateActivity::mainHeaderPresenter = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$PageTemplateActivity_footerPresenter_fieldInjection__________(com.epam.feel.client.activity.PageTemplateActivity injectee, com.epam.feel.client.view.IFooterView.IFooterPresenter value) /*-{
    injectee.@com.epam.feel.client.activity.PageTemplateActivity::footerPresenter = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection__________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.ViewFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::viewFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection__________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.AppPlaceFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::placeFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection__________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.HistoryInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::historyInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection__________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.RequestInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::requestInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection__________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.ClientInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::clientInfoServiceAsync = value;
  }-*/;
  
  private void memberInject_Key$type$com$epam$feel$client$activity$PersonalAccountActivity$_annotation$$none$$(com.epam.feel.client.activity.PersonalAccountActivity injectee) {
    com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection__________(injectee, get_Key$type$com$epam$feel$shared$service$MenuInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$PageTemplateActivity_mainHeaderPresenter_fieldInjection__________(injectee, get_Key$type$com$epam$feel$client$view$IMainHeaderView$IMainHeaderPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$PageTemplateActivity_footerPresenter_fieldInjection__________(injectee, get_Key$type$com$epam$feel$client$view$IFooterView$IFooterPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection__________(injectee, get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection__________(injectee, get_Key$type$com$epam$feel$client$mvp$AppPlaceFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection__________(injectee, get_Key$type$com$epam$feel$shared$service$HistoryInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection__________(injectee, get_Key$type$com$epam$feel$shared$service$RequestInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection__________(injectee, get_Key$type$com$epam$feel$shared$service$ClientInfoServiceAsync$_annotation$$none$$());
    
  }
  
  private com.epam.feel.client.activity.PersonalAccountActivity com$epam$feel$client$activity$PersonalAccountActivity_PersonalAccountActivity_methodInjection(com.epam.feel.client.mvp.ClientFactory _0, com.epam.feel.client.mvp.ViewFactory _1) {
    return new com.epam.feel.client.activity.PersonalAccountActivity(_0, _1);
  }
  
  private com.epam.feel.client.activity.PersonalAccountActivity create_Key$type$com$epam$feel$client$activity$PersonalAccountActivity$_annotation$$none$$() {
    com.epam.feel.client.activity.PersonalAccountActivity result = com$epam$feel$client$activity$PersonalAccountActivity_PersonalAccountActivity_methodInjection(get_Key$type$com$epam$feel$client$mvp$ClientFactory$_annotation$$none$$(), get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    memberInject_Key$type$com$epam$feel$client$activity$PersonalAccountActivity$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.activity.PersonalAccountActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.PersonalAccountActivity, annotation=[none]]
   */
  private com.epam.feel.client.activity.PersonalAccountActivity get_Key$type$com$epam$feel$client$activity$PersonalAccountActivity$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$activity$PersonalAccountActivity$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.shared.service.RequestInfoServiceAsync declared at:
   *   Implicit binding for Key[type=com.epam.feel.shared.service.RequestInfoServiceAsync, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$shared$service$RequestInfoServiceAsync$_annotation$$none$$(com.epam.feel.shared.service.RequestInfoServiceAsync injectee) {
    
  }
  
  private com.epam.feel.shared.service.RequestInfoServiceAsync create_Key$type$com$epam$feel$shared$service$RequestInfoServiceAsync$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.shared.service.RequestInfoService.class);
    assert created instanceof com.epam.feel.shared.service.RequestInfoServiceAsync;
    com.epam.feel.shared.service.RequestInfoServiceAsync result = (com.epam.feel.shared.service.RequestInfoServiceAsync) created;
    
    memberInject_Key$type$com$epam$feel$shared$service$RequestInfoServiceAsync$_annotation$$none$$(result);
    return result;
  }
  
  private com.epam.feel.shared.service.RequestInfoServiceAsync singleton_Key$type$com$epam$feel$shared$service$RequestInfoServiceAsync$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   Implicit binding for Key[type=com.epam.feel.shared.service.RequestInfoServiceAsync, annotation=[none]]
   */
  private com.epam.feel.shared.service.RequestInfoServiceAsync get_Key$type$com$epam$feel$shared$service$RequestInfoServiceAsync$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$shared$service$RequestInfoServiceAsync$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$shared$service$RequestInfoServiceAsync$_annotation$$none$$ = create_Key$type$com$epam$feel$shared$service$RequestInfoServiceAsync$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$shared$service$RequestInfoServiceAsync$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.activity.ApplicationActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.ApplicationActivity, annotation=[none]]
   */
  private void com$epam$feel$client$activity$ApplicationActivity_clientListViewPresenter_fieldInjection(com.epam.feel.client.activity.ApplicationActivity injectee, com.epam.feel.client.view.IClientListView.IClientListViewPresenter value) {
    injectee.clientListViewPresenter = value;
  }
  
  private native void com$epam$feel$client$activity$PageTemplateActivity_mainHeaderPresenter_fieldInjection___________(com.epam.feel.client.activity.PageTemplateActivity injectee, com.epam.feel.client.view.IMainHeaderView.IMainHeaderPresenter value) /*-{
    injectee.@com.epam.feel.client.activity.PageTemplateActivity::mainHeaderPresenter = value;
  }-*/;
  
  private void com$epam$feel$client$activity$ApplicationActivity_listRequestPresenter_fieldInjection(com.epam.feel.client.activity.ApplicationActivity injectee, com.epam.feel.client.view.IListRequestView.IListRequestPresenter value) {
    injectee.listRequestPresenter = value;
  }
  
  private native void com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection___________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.ViewFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::viewFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection___________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.AppPlaceFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::placeFactory = value;
  }-*/;
  
  private void com$epam$feel$client$activity$ApplicationActivity_historyBalancePresenter_fieldInjection(com.epam.feel.client.activity.ApplicationActivity injectee, com.epam.feel.client.view.IHistoryBalanceView.IHistoryBalancePresenter value) {
    injectee.historyBalancePresenter = value;
  }
  
  private native void com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection___________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.HistoryInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::historyInfoServiceAsync = value;
  }-*/;
  
  private void com$epam$feel$client$activity$ApplicationActivity_historyNotificationPresenter_fieldInjection(com.epam.feel.client.activity.ApplicationActivity injectee, com.epam.feel.client.view.IHistoryNotificationView.IHistoryNotificationPresenter value) {
    injectee.historyNotificationPresenter = value;
  }
  
  private native void com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection___________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.RequestInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::requestInfoServiceAsync = value;
  }-*/;
  
  private void com$epam$feel$client$activity$ApplicationActivity_listGroupRequestPresenter_fieldInjection(com.epam.feel.client.activity.ApplicationActivity injectee, com.epam.feel.client.view.IListGroupRequestView.IListGroupRequestPresenter value) {
    injectee.listGroupRequestPresenter = value;
  }
  
  private native void com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection___________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.MenuInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::menuInfoServiceAsync = value;
  }-*/;
  
  private void com$epam$feel$client$activity$ApplicationActivity_historyRequestGroupPresenter_fieldInjection(com.epam.feel.client.activity.ApplicationActivity injectee, com.epam.feel.client.view.IHistoryRequestGroupView.IHistoryRequestGroupPresenter value) {
    injectee.historyRequestGroupPresenter = value;
  }
  
  private native void com$epam$feel$client$activity$PageTemplateActivity_footerPresenter_fieldInjection___________(com.epam.feel.client.activity.PageTemplateActivity injectee, com.epam.feel.client.view.IFooterView.IFooterPresenter value) /*-{
    injectee.@com.epam.feel.client.activity.PageTemplateActivity::footerPresenter = value;
  }-*/;
  
  private void com$epam$feel$client$activity$ApplicationActivity_createMenuPresenter_fieldInjection(com.epam.feel.client.activity.ApplicationActivity injectee, com.epam.feel.client.view.ICreateMenuView.ICreateMenuPresenter value) {
    injectee.createMenuPresenter = value;
  }
  
  private void com$epam$feel$client$activity$ApplicationActivity_historyMenuPresenter_fieldInjection(com.epam.feel.client.activity.ApplicationActivity injectee, com.epam.feel.client.view.IHistoryMenuView.IHistoryMenuPresenter value) {
    injectee.historyMenuPresenter = value;
  }
  
  private native void com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection___________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.ClientInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::clientInfoServiceAsync = value;
  }-*/;
  
  private void com$epam$feel$client$activity$ApplicationActivity_cashManagementrPresenter_fieldInjection(com.epam.feel.client.activity.ApplicationActivity injectee, com.epam.feel.client.view.ICashManagementView.ICashManagementPresenter value) {
    injectee.cashManagementrPresenter = value;
  }
  
  private void com$epam$feel$client$activity$ApplicationActivity_historyRequestPresenter_fieldInjection(com.epam.feel.client.activity.ApplicationActivity injectee, com.epam.feel.client.view.IHistoryRequestView.IHistoryRequestPresenter value) {
    injectee.historyRequestPresenter = value;
  }
  
  private void memberInject_Key$type$com$epam$feel$client$activity$ApplicationActivity$_annotation$$none$$(com.epam.feel.client.activity.ApplicationActivity injectee) {
    com$epam$feel$client$activity$ApplicationActivity_clientListViewPresenter_fieldInjection(injectee, get_Key$type$com$epam$feel$client$view$IClientListView$IClientListViewPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$PageTemplateActivity_mainHeaderPresenter_fieldInjection___________(injectee, get_Key$type$com$epam$feel$client$view$IMainHeaderView$IMainHeaderPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$ApplicationActivity_listRequestPresenter_fieldInjection(injectee, get_Key$type$com$epam$feel$client$view$IListRequestView$IListRequestPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection___________(injectee, get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection___________(injectee, get_Key$type$com$epam$feel$client$mvp$AppPlaceFactory$_annotation$$none$$());
    com$epam$feel$client$activity$ApplicationActivity_historyBalancePresenter_fieldInjection(injectee, get_Key$type$com$epam$feel$client$view$IHistoryBalanceView$IHistoryBalancePresenter$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection___________(injectee, get_Key$type$com$epam$feel$shared$service$HistoryInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$ApplicationActivity_historyNotificationPresenter_fieldInjection(injectee, get_Key$type$com$epam$feel$client$view$IHistoryNotificationView$IHistoryNotificationPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection___________(injectee, get_Key$type$com$epam$feel$shared$service$RequestInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$ApplicationActivity_listGroupRequestPresenter_fieldInjection(injectee, get_Key$type$com$epam$feel$client$view$IListGroupRequestView$IListGroupRequestPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection___________(injectee, get_Key$type$com$epam$feel$shared$service$MenuInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$ApplicationActivity_historyRequestGroupPresenter_fieldInjection(injectee, get_Key$type$com$epam$feel$client$view$IHistoryRequestGroupView$IHistoryRequestGroupPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$PageTemplateActivity_footerPresenter_fieldInjection___________(injectee, get_Key$type$com$epam$feel$client$view$IFooterView$IFooterPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$ApplicationActivity_createMenuPresenter_fieldInjection(injectee, get_Key$type$com$epam$feel$client$view$ICreateMenuView$ICreateMenuPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$ApplicationActivity_historyMenuPresenter_fieldInjection(injectee, get_Key$type$com$epam$feel$client$view$IHistoryMenuView$IHistoryMenuPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection___________(injectee, get_Key$type$com$epam$feel$shared$service$ClientInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$ApplicationActivity_cashManagementrPresenter_fieldInjection(injectee, get_Key$type$com$epam$feel$client$view$ICashManagementView$ICashManagementPresenter$_annotation$$none$$());
    com$epam$feel$client$activity$ApplicationActivity_historyRequestPresenter_fieldInjection(injectee, get_Key$type$com$epam$feel$client$view$IHistoryRequestView$IHistoryRequestPresenter$_annotation$$none$$());
    
  }
  
  private com.epam.feel.client.activity.ApplicationActivity com$epam$feel$client$activity$ApplicationActivity_ApplicationActivity_methodInjection(com.epam.feel.client.mvp.ClientFactory _0, com.epam.feel.client.mvp.ViewFactory _1) {
    return new com.epam.feel.client.activity.ApplicationActivity(_0, _1);
  }
  
  private com.epam.feel.client.activity.ApplicationActivity create_Key$type$com$epam$feel$client$activity$ApplicationActivity$_annotation$$none$$() {
    com.epam.feel.client.activity.ApplicationActivity result = com$epam$feel$client$activity$ApplicationActivity_ApplicationActivity_methodInjection(get_Key$type$com$epam$feel$client$mvp$ClientFactory$_annotation$$none$$(), get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    memberInject_Key$type$com$epam$feel$client$activity$ApplicationActivity$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.activity.ApplicationActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.ApplicationActivity, annotation=[none]]
   */
  private com.epam.feel.client.activity.ApplicationActivity get_Key$type$com$epam$feel$client$activity$ApplicationActivity$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$activity$ApplicationActivity$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.google.gwt.activity.shared.ActivityManager declared at:
   *   public com.google.gwt.activity.shared.ActivityManager com.epam.feel.client.gin.GINClientModule.getActivityManager(com.google.gwt.activity.shared.ActivityMapper,com.google.web.bindery.event.shared.EventBus)
   */
  private com.google.gwt.activity.shared.ActivityManager com$epam$feel$client$gin$GINClientModule_getActivityManager_methodInjection(com.epam.feel.client.gin.GINClientModule injectee, com.google.gwt.activity.shared.ActivityMapper _0, com.google.web.bindery.event.shared.EventBus _1) {
    return injectee.getActivityManager(_0, _1);
  }
  
  private com.google.gwt.activity.shared.ActivityManager create_Key$type$com$google$gwt$activity$shared$ActivityManager$_annotation$$none$$() {
    return com$epam$feel$client$gin$GINClientModule_getActivityManager_methodInjection(new com.epam.feel.client.gin.GINClientModule(), get_Key$type$com$google$gwt$activity$shared$ActivityMapper$_annotation$$none$$(), get_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$());
  }
  
  private com.google.gwt.activity.shared.ActivityManager singleton_Key$type$com$google$gwt$activity$shared$ActivityManager$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   public com.google.gwt.activity.shared.ActivityManager com.epam.feel.client.gin.GINClientModule.getActivityManager(com.google.gwt.activity.shared.ActivityMapper,com.google.web.bindery.event.shared.EventBus)
   */
  private com.google.gwt.activity.shared.ActivityManager get_Key$type$com$google$gwt$activity$shared$ActivityManager$_annotation$$none$$() {
    if (singleton_Key$type$com$google$gwt$activity$shared$ActivityManager$_annotation$$none$$ == null) {
      singleton_Key$type$com$google$gwt$activity$shared$ActivityManager$_annotation$$none$$ = create_Key$type$com$google$gwt$activity$shared$ActivityManager$_annotation$$none$$();
    }
    return singleton_Key$type$com$google$gwt$activity$shared$ActivityManager$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.ui.admin.HistoryNotificationView declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.admin.HistoryNotificationView, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$client$ui$admin$HistoryNotificationView$_annotation$$none$$(com.epam.feel.client.ui.admin.HistoryNotificationView injectee) {
    
  }
  
  private com.epam.feel.client.ui.admin.HistoryNotificationView create_Key$type$com$epam$feel$client$ui$admin$HistoryNotificationView$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.client.ui.admin.HistoryNotificationView.class);
    assert created instanceof com.epam.feel.client.ui.admin.HistoryNotificationView;
    com.epam.feel.client.ui.admin.HistoryNotificationView result = (com.epam.feel.client.ui.admin.HistoryNotificationView) created;
    
    memberInject_Key$type$com$epam$feel$client$ui$admin$HistoryNotificationView$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.ui.admin.HistoryNotificationView declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.admin.HistoryNotificationView, annotation=[none]]
   */
  private com.epam.feel.client.ui.admin.HistoryNotificationView get_Key$type$com$epam$feel$client$ui$admin$HistoryNotificationView$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$ui$admin$HistoryNotificationView$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.EpamFeelResources declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:116)
   */
  private void memberInject_Key$type$com$epam$feel$client$EpamFeelResources$_annotation$$none$$(com.epam.feel.client.EpamFeelResources injectee) {
    
  }
  
  private com.epam.feel.client.EpamFeelResources create_Key$type$com$epam$feel$client$EpamFeelResources$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.client.EpamFeelResources.class);
    assert created instanceof com.epam.feel.client.EpamFeelResources;
    com.epam.feel.client.EpamFeelResources result = (com.epam.feel.client.EpamFeelResources) created;
    
    memberInject_Key$type$com$epam$feel$client$EpamFeelResources$_annotation$$none$$(result);
    return result;
  }
  
  private com.epam.feel.client.EpamFeelResources singleton_Key$type$com$epam$feel$client$EpamFeelResources$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:116)
   */
  private com.epam.feel.client.EpamFeelResources get_Key$type$com$epam$feel$client$EpamFeelResources$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$EpamFeelResources$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$EpamFeelResources$_annotation$$none$$ = create_Key$type$com$epam$feel$client$EpamFeelResources$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$EpamFeelResources$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.activity.FooterActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.FooterActivity, annotation=[none]]
   */
  private native void com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection____________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.MenuInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::menuInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection____________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.ViewFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::viewFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection____________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.AppPlaceFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::placeFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection____________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.HistoryInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::historyInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection____________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.RequestInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::requestInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection____________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.ClientInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::clientInfoServiceAsync = value;
  }-*/;
  
  private void memberInject_Key$type$com$epam$feel$client$activity$FooterActivity$_annotation$$none$$(com.epam.feel.client.activity.FooterActivity injectee) {
    com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection____________(injectee, get_Key$type$com$epam$feel$shared$service$MenuInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection____________(injectee, get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection____________(injectee, get_Key$type$com$epam$feel$client$mvp$AppPlaceFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection____________(injectee, get_Key$type$com$epam$feel$shared$service$HistoryInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection____________(injectee, get_Key$type$com$epam$feel$shared$service$RequestInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection____________(injectee, get_Key$type$com$epam$feel$shared$service$ClientInfoServiceAsync$_annotation$$none$$());
    
  }
  
  private com.epam.feel.client.activity.FooterActivity com$epam$feel$client$activity$FooterActivity_FooterActivity_methodInjection(com.epam.feel.client.mvp.ClientFactory _0, com.epam.feel.client.mvp.ViewFactory _1) {
    return new com.epam.feel.client.activity.FooterActivity(_0, _1);
  }
  
  private com.epam.feel.client.activity.FooterActivity create_Key$type$com$epam$feel$client$activity$FooterActivity$_annotation$$none$$() {
    com.epam.feel.client.activity.FooterActivity result = com$epam$feel$client$activity$FooterActivity_FooterActivity_methodInjection(get_Key$type$com$epam$feel$client$mvp$ClientFactory$_annotation$$none$$(), get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    memberInject_Key$type$com$epam$feel$client$activity$FooterActivity$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.activity.FooterActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.FooterActivity, annotation=[none]]
   */
  private com.epam.feel.client.activity.FooterActivity get_Key$type$com$epam$feel$client$activity$FooterActivity$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$activity$FooterActivity$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.place.HistoryBalancePlace$Tokenizer declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.place.HistoryBalancePlace$Tokenizer, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$client$place$HistoryBalancePlace$Tokenizer$_annotation$$none$$(com.epam.feel.client.place.HistoryBalancePlace.Tokenizer injectee) {
    
  }
  
  private com.epam.feel.client.place.HistoryBalancePlace.Tokenizer com$epam$feel$client$place$HistoryBalancePlace$Tokenizer_Tokenizer_methodInjection(com.google.inject.Provider _0) {
    return new com.epam.feel.client.place.HistoryBalancePlace.Tokenizer(_0);
  }
  
  private com.epam.feel.client.place.HistoryBalancePlace.Tokenizer create_Key$type$com$epam$feel$client$place$HistoryBalancePlace$Tokenizer$_annotation$$none$$() {
    com.epam.feel.client.place.HistoryBalancePlace.Tokenizer result = com$epam$feel$client$place$HistoryBalancePlace$Tokenizer_Tokenizer_methodInjection(get_Key$type$com$google$inject$Provider$com$epam$feel$client$place$HistoryBalancePlace$$_annotation$$none$$());
    memberInject_Key$type$com$epam$feel$client$place$HistoryBalancePlace$Tokenizer$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.place.HistoryBalancePlace$Tokenizer declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.place.HistoryBalancePlace$Tokenizer, annotation=[none]]
   */
  private com.epam.feel.client.place.HistoryBalancePlace.Tokenizer get_Key$type$com$epam$feel$client$place$HistoryBalancePlace$Tokenizer$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$place$HistoryBalancePlace$Tokenizer$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.view.IHistoryNotificationView$IHistoryNotificationPresenter declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:102)
   */
  private com.epam.feel.client.view.IHistoryNotificationView.IHistoryNotificationPresenter create_Key$type$com$epam$feel$client$view$IHistoryNotificationView$IHistoryNotificationPresenter$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$activity$HistoryNotificationActivity$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.IHistoryNotificationView.IHistoryNotificationPresenter singleton_Key$type$com$epam$feel$client$view$IHistoryNotificationView$IHistoryNotificationPresenter$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:102)
   */
  private com.epam.feel.client.view.IHistoryNotificationView.IHistoryNotificationPresenter get_Key$type$com$epam$feel$client$view$IHistoryNotificationView$IHistoryNotificationPresenter$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$IHistoryNotificationView$IHistoryNotificationPresenter$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$IHistoryNotificationView$IHistoryNotificationPresenter$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$IHistoryNotificationView$IHistoryNotificationPresenter$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$IHistoryNotificationView$IHistoryNotificationPresenter$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.shared.service.ClientInfoServiceAsync declared at:
   *   Implicit binding for Key[type=com.epam.feel.shared.service.ClientInfoServiceAsync, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$shared$service$ClientInfoServiceAsync$_annotation$$none$$(com.epam.feel.shared.service.ClientInfoServiceAsync injectee) {
    
  }
  
  private com.epam.feel.shared.service.ClientInfoServiceAsync create_Key$type$com$epam$feel$shared$service$ClientInfoServiceAsync$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.shared.service.ClientInfoService.class);
    assert created instanceof com.epam.feel.shared.service.ClientInfoServiceAsync;
    com.epam.feel.shared.service.ClientInfoServiceAsync result = (com.epam.feel.shared.service.ClientInfoServiceAsync) created;
    
    memberInject_Key$type$com$epam$feel$shared$service$ClientInfoServiceAsync$_annotation$$none$$(result);
    return result;
  }
  
  private com.epam.feel.shared.service.ClientInfoServiceAsync singleton_Key$type$com$epam$feel$shared$service$ClientInfoServiceAsync$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   Implicit binding for Key[type=com.epam.feel.shared.service.ClientInfoServiceAsync, annotation=[none]]
   */
  private com.epam.feel.shared.service.ClientInfoServiceAsync get_Key$type$com$epam$feel$shared$service$ClientInfoServiceAsync$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$shared$service$ClientInfoServiceAsync$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$shared$service$ClientInfoServiceAsync$_annotation$$none$$ = create_Key$type$com$epam$feel$shared$service$ClientInfoServiceAsync$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$shared$service$ClientInfoServiceAsync$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.view.ICreateMenuView$ICreateMenuPresenter declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:87)
   */
  private com.epam.feel.client.view.ICreateMenuView.ICreateMenuPresenter create_Key$type$com$epam$feel$client$view$ICreateMenuView$ICreateMenuPresenter$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$activity$CreateMenuActivity$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.ICreateMenuView.ICreateMenuPresenter singleton_Key$type$com$epam$feel$client$view$ICreateMenuView$ICreateMenuPresenter$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:87)
   */
  private com.epam.feel.client.view.ICreateMenuView.ICreateMenuPresenter get_Key$type$com$epam$feel$client$view$ICreateMenuView$ICreateMenuPresenter$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$ICreateMenuView$ICreateMenuPresenter$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$ICreateMenuView$ICreateMenuPresenter$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$ICreateMenuView$ICreateMenuPresenter$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$ICreateMenuView$ICreateMenuPresenter$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.view.IMainHeaderView$IMainHeaderPresenter declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:81)
   */
  private com.epam.feel.client.view.IMainHeaderView.IMainHeaderPresenter create_Key$type$com$epam$feel$client$view$IMainHeaderView$IMainHeaderPresenter$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$activity$MainHeaderActivity$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.IMainHeaderView.IMainHeaderPresenter singleton_Key$type$com$epam$feel$client$view$IMainHeaderView$IMainHeaderPresenter$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:81)
   */
  private com.epam.feel.client.view.IMainHeaderView.IMainHeaderPresenter get_Key$type$com$epam$feel$client$view$IMainHeaderView$IMainHeaderPresenter$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$IMainHeaderView$IMainHeaderPresenter$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$IMainHeaderView$IMainHeaderPresenter$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$IMainHeaderView$IMainHeaderPresenter$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$IMainHeaderView$IMainHeaderPresenter$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.view.IClientListView$IClientListViewPresenter declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:107)
   */
  private com.epam.feel.client.view.IClientListView.IClientListViewPresenter create_Key$type$com$epam$feel$client$view$IClientListView$IClientListViewPresenter$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$activity$ClientListViewActivity$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.IClientListView.IClientListViewPresenter singleton_Key$type$com$epam$feel$client$view$IClientListView$IClientListViewPresenter$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:107)
   */
  private com.epam.feel.client.view.IClientListView.IClientListViewPresenter get_Key$type$com$epam$feel$client$view$IClientListView$IClientListViewPresenter$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$IClientListView$IClientListViewPresenter$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$IClientListView$IClientListViewPresenter$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$IClientListView$IClientListViewPresenter$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$IClientListView$IClientListViewPresenter$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.ui.admin.HistoryBalanceView declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.admin.HistoryBalanceView, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$client$ui$admin$HistoryBalanceView$_annotation$$none$$(com.epam.feel.client.ui.admin.HistoryBalanceView injectee) {
    
  }
  
  private com.epam.feel.client.ui.admin.HistoryBalanceView create_Key$type$com$epam$feel$client$ui$admin$HistoryBalanceView$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.client.ui.admin.HistoryBalanceView.class);
    assert created instanceof com.epam.feel.client.ui.admin.HistoryBalanceView;
    com.epam.feel.client.ui.admin.HistoryBalanceView result = (com.epam.feel.client.ui.admin.HistoryBalanceView) created;
    
    memberInject_Key$type$com$epam$feel$client$ui$admin$HistoryBalanceView$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.ui.admin.HistoryBalanceView declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.admin.HistoryBalanceView, annotation=[none]]
   */
  private com.epam.feel.client.ui.admin.HistoryBalanceView get_Key$type$com$epam$feel$client$ui$admin$HistoryBalanceView$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$ui$admin$HistoryBalanceView$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.ui.admin.HistoryMenuView declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.admin.HistoryMenuView, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$client$ui$admin$HistoryMenuView$_annotation$$none$$(com.epam.feel.client.ui.admin.HistoryMenuView injectee) {
    
  }
  
  private com.epam.feel.client.ui.admin.HistoryMenuView create_Key$type$com$epam$feel$client$ui$admin$HistoryMenuView$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.client.ui.admin.HistoryMenuView.class);
    assert created instanceof com.epam.feel.client.ui.admin.HistoryMenuView;
    com.epam.feel.client.ui.admin.HistoryMenuView result = (com.epam.feel.client.ui.admin.HistoryMenuView) created;
    
    memberInject_Key$type$com$epam$feel$client$ui$admin$HistoryMenuView$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.ui.admin.HistoryMenuView declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.admin.HistoryMenuView, annotation=[none]]
   */
  private com.epam.feel.client.ui.admin.HistoryMenuView get_Key$type$com$epam$feel$client$ui$admin$HistoryMenuView$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$ui$admin$HistoryMenuView$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.IEpamFeelStatusConstants declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:113)
   */
  private void memberInject_Key$type$com$epam$feel$client$IEpamFeelStatusConstants$_annotation$$none$$(com.epam.feel.client.IEpamFeelStatusConstants injectee) {
    
  }
  
  private com.epam.feel.client.IEpamFeelStatusConstants create_Key$type$com$epam$feel$client$IEpamFeelStatusConstants$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.client.IEpamFeelStatusConstants.class);
    assert created instanceof com.epam.feel.client.IEpamFeelStatusConstants;
    com.epam.feel.client.IEpamFeelStatusConstants result = (com.epam.feel.client.IEpamFeelStatusConstants) created;
    
    memberInject_Key$type$com$epam$feel$client$IEpamFeelStatusConstants$_annotation$$none$$(result);
    return result;
  }
  
  private com.epam.feel.client.IEpamFeelStatusConstants singleton_Key$type$com$epam$feel$client$IEpamFeelStatusConstants$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:113)
   */
  private com.epam.feel.client.IEpamFeelStatusConstants get_Key$type$com$epam$feel$client$IEpamFeelStatusConstants$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$IEpamFeelStatusConstants$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$IEpamFeelStatusConstants$_annotation$$none$$ = create_Key$type$com$epam$feel$client$IEpamFeelStatusConstants$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$IEpamFeelStatusConstants$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.view.IHistoryRequestView$IHistoryRequestPresenter declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:97)
   */
  private com.epam.feel.client.view.IHistoryRequestView.IHistoryRequestPresenter create_Key$type$com$epam$feel$client$view$IHistoryRequestView$IHistoryRequestPresenter$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$activity$HistoryRequestActivity$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.IHistoryRequestView.IHistoryRequestPresenter singleton_Key$type$com$epam$feel$client$view$IHistoryRequestView$IHistoryRequestPresenter$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:97)
   */
  private com.epam.feel.client.view.IHistoryRequestView.IHistoryRequestPresenter get_Key$type$com$epam$feel$client$view$IHistoryRequestView$IHistoryRequestPresenter$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$IHistoryRequestView$IHistoryRequestPresenter$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$IHistoryRequestView$IHistoryRequestPresenter$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$IHistoryRequestView$IHistoryRequestPresenter$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$IHistoryRequestView$IHistoryRequestPresenter$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.place.HistoryBalancePlace declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.place.HistoryBalancePlace, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$client$place$HistoryBalancePlace$_annotation$$none$$(com.epam.feel.client.place.HistoryBalancePlace injectee) {
    
  }
  
  private com.epam.feel.client.place.HistoryBalancePlace create_Key$type$com$epam$feel$client$place$HistoryBalancePlace$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.client.place.HistoryBalancePlace.class);
    assert created instanceof com.epam.feel.client.place.HistoryBalancePlace;
    com.epam.feel.client.place.HistoryBalancePlace result = (com.epam.feel.client.place.HistoryBalancePlace) created;
    
    memberInject_Key$type$com$epam$feel$client$place$HistoryBalancePlace$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.place.HistoryBalancePlace declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.place.HistoryBalancePlace, annotation=[none]]
   */
  private com.epam.feel.client.place.HistoryBalancePlace get_Key$type$com$epam$feel$client$place$HistoryBalancePlace$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$place$HistoryBalancePlace$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.place.PersonalAccountPlace declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.place.PersonalAccountPlace, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$client$place$PersonalAccountPlace$_annotation$$none$$(com.epam.feel.client.place.PersonalAccountPlace injectee) {
    
  }
  
  private com.epam.feel.client.place.PersonalAccountPlace create_Key$type$com$epam$feel$client$place$PersonalAccountPlace$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.client.place.PersonalAccountPlace.class);
    assert created instanceof com.epam.feel.client.place.PersonalAccountPlace;
    com.epam.feel.client.place.PersonalAccountPlace result = (com.epam.feel.client.place.PersonalAccountPlace) created;
    
    memberInject_Key$type$com$epam$feel$client$place$PersonalAccountPlace$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.place.PersonalAccountPlace declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.place.PersonalAccountPlace, annotation=[none]]
   */
  private com.epam.feel.client.place.PersonalAccountPlace get_Key$type$com$epam$feel$client$place$PersonalAccountPlace$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$place$PersonalAccountPlace$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.mvp.MainActivityMapper declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:111)
   */
  private void memberInject_Key$type$com$epam$feel$client$mvp$MainActivityMapper$_annotation$$none$$(com.epam.feel.client.mvp.MainActivityMapper injectee) {
    
  }
  
  private com.epam.feel.client.mvp.MainActivityMapper com$epam$feel$client$mvp$MainActivityMapper_MainActivityMapper_methodInjection(com.google.inject.Provider _0, com.google.inject.Provider _1, com.google.inject.Provider _2) {
    return new com.epam.feel.client.mvp.MainActivityMapper(_0, _1, _2);
  }
  
  private com.epam.feel.client.mvp.MainActivityMapper create_Key$type$com$epam$feel$client$mvp$MainActivityMapper$_annotation$$none$$() {
    com.epam.feel.client.mvp.MainActivityMapper result = com$epam$feel$client$mvp$MainActivityMapper_MainActivityMapper_methodInjection(get_Key$type$com$google$inject$Provider$com$epam$feel$client$activity$ApplicationActivity$$_annotation$$none$$(), get_Key$type$com$google$inject$Provider$com$epam$feel$client$activity$PersonalAccountActivity$$_annotation$$none$$(), get_Key$type$com$google$inject$Provider$com$epam$feel$client$activity$HistoryBalanceActivity$$_annotation$$none$$());
    memberInject_Key$type$com$epam$feel$client$mvp$MainActivityMapper$_annotation$$none$$(result);
    return result;
  }
  
  private com.epam.feel.client.mvp.MainActivityMapper singleton_Key$type$com$epam$feel$client$mvp$MainActivityMapper$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:111)
   */
  private com.epam.feel.client.mvp.MainActivityMapper get_Key$type$com$epam$feel$client$mvp$MainActivityMapper$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$mvp$MainActivityMapper$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$mvp$MainActivityMapper$_annotation$$none$$ = create_Key$type$com$epam$feel$client$mvp$MainActivityMapper$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$mvp$MainActivityMapper$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.google.inject.Provider<com.epam.feel.client.place.PersonalAccountPlace> declared at:
   *   Implicit binding for Key[type=com.google.inject.Provider<com.epam.feel.client.place.PersonalAccountPlace>, annotation=[none]]
   */
  private com.google.inject.Provider<com.epam.feel.client.place.PersonalAccountPlace> create_Key$type$com$google$inject$Provider$com$epam$feel$client$place$PersonalAccountPlace$$_annotation$$none$$() {
    return new com.google.inject.Provider<com.epam.feel.client.place.PersonalAccountPlace>() { 
      public com.epam.feel.client.place.PersonalAccountPlace get() { 
        return get_Key$type$com$epam$feel$client$place$PersonalAccountPlace$_annotation$$none$$();
      }
    };
  }
  
  
  /**
   * Binding for com.google.inject.Provider<com.epam.feel.client.place.PersonalAccountPlace> declared at:
   *   Implicit binding for Key[type=com.google.inject.Provider<com.epam.feel.client.place.PersonalAccountPlace>, annotation=[none]]
   */
  private com.google.inject.Provider<com.epam.feel.client.place.PersonalAccountPlace> get_Key$type$com$google$inject$Provider$com$epam$feel$client$place$PersonalAccountPlace$$_annotation$$none$$() {
    return create_Key$type$com$google$inject$Provider$com$epam$feel$client$place$PersonalAccountPlace$$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.view.IApplicationView$IApplicationPresenter declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:78)
   */
  private com.epam.feel.client.view.IApplicationView.IApplicationPresenter create_Key$type$com$epam$feel$client$view$IApplicationView$IApplicationPresenter$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$activity$ApplicationActivity$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.IApplicationView.IApplicationPresenter singleton_Key$type$com$epam$feel$client$view$IApplicationView$IApplicationPresenter$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:78)
   */
  private com.epam.feel.client.view.IApplicationView.IApplicationPresenter get_Key$type$com$epam$feel$client$view$IApplicationView$IApplicationPresenter$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$IApplicationView$IApplicationPresenter$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$IApplicationView$IApplicationPresenter$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$IApplicationView$IApplicationPresenter$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$IApplicationView$IApplicationPresenter$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.view.IFooterView declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:84)
   */
  private com.epam.feel.client.view.IFooterView create_Key$type$com$epam$feel$client$view$IFooterView$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$ui$user$Footer$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.IFooterView singleton_Key$type$com$epam$feel$client$view$IFooterView$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:84)
   */
  private com.epam.feel.client.view.IFooterView get_Key$type$com$epam$feel$client$view$IFooterView$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$IFooterView$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$IFooterView$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$IFooterView$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$IFooterView$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.google.web.bindery.event.shared.SimpleEventBus declared at:
   *   Implicit binding for Key[type=com.google.web.bindery.event.shared.SimpleEventBus, annotation=[none]]
   */
  private void memberInject_Key$type$com$google$web$bindery$event$shared$SimpleEventBus$_annotation$$none$$(com.google.web.bindery.event.shared.SimpleEventBus injectee) {
    
  }
  
  private com.google.web.bindery.event.shared.SimpleEventBus create_Key$type$com$google$web$bindery$event$shared$SimpleEventBus$_annotation$$none$$() {
    Object created = GWT.create(com.google.web.bindery.event.shared.SimpleEventBus.class);
    assert created instanceof com.google.web.bindery.event.shared.SimpleEventBus;
    com.google.web.bindery.event.shared.SimpleEventBus result = (com.google.web.bindery.event.shared.SimpleEventBus) created;
    
    memberInject_Key$type$com$google$web$bindery$event$shared$SimpleEventBus$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.google.web.bindery.event.shared.SimpleEventBus declared at:
   *   Implicit binding for Key[type=com.google.web.bindery.event.shared.SimpleEventBus, annotation=[none]]
   */
  private com.google.web.bindery.event.shared.SimpleEventBus get_Key$type$com$google$web$bindery$event$shared$SimpleEventBus$_annotation$$none$$() {
    return create_Key$type$com$google$web$bindery$event$shared$SimpleEventBus$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.google.inject.Provider<com.epam.feel.client.activity.ApplicationActivity> declared at:
   *   Implicit binding for Key[type=com.google.inject.Provider<com.epam.feel.client.activity.ApplicationActivity>, annotation=[none]]
   */
  private com.google.inject.Provider<com.epam.feel.client.activity.ApplicationActivity> create_Key$type$com$google$inject$Provider$com$epam$feel$client$activity$ApplicationActivity$$_annotation$$none$$() {
    return new com.google.inject.Provider<com.epam.feel.client.activity.ApplicationActivity>() { 
      public com.epam.feel.client.activity.ApplicationActivity get() { 
        return get_Key$type$com$epam$feel$client$activity$ApplicationActivity$_annotation$$none$$();
      }
    };
  }
  
  
  /**
   * Binding for com.google.inject.Provider<com.epam.feel.client.activity.ApplicationActivity> declared at:
   *   Implicit binding for Key[type=com.google.inject.Provider<com.epam.feel.client.activity.ApplicationActivity>, annotation=[none]]
   */
  private com.google.inject.Provider<com.epam.feel.client.activity.ApplicationActivity> get_Key$type$com$google$inject$Provider$com$epam$feel$client$activity$ApplicationActivity$$_annotation$$none$$() {
    return create_Key$type$com$google$inject$Provider$com$epam$feel$client$activity$ApplicationActivity$$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.view.IListRequestView declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:88)
   */
  private com.epam.feel.client.view.IListRequestView create_Key$type$com$epam$feel$client$view$IListRequestView$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$ui$admin$ListRequestView$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.IListRequestView singleton_Key$type$com$epam$feel$client$view$IListRequestView$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:88)
   */
  private com.epam.feel.client.view.IListRequestView get_Key$type$com$epam$feel$client$view$IListRequestView$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$IListRequestView$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$IListRequestView$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$IListRequestView$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$IListRequestView$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.ui.admin.CreateMenuView declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.admin.CreateMenuView, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$client$ui$admin$CreateMenuView$_annotation$$none$$(com.epam.feel.client.ui.admin.CreateMenuView injectee) {
    
  }
  
  private com.epam.feel.client.ui.admin.CreateMenuView create_Key$type$com$epam$feel$client$ui$admin$CreateMenuView$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.client.ui.admin.CreateMenuView.class);
    assert created instanceof com.epam.feel.client.ui.admin.CreateMenuView;
    com.epam.feel.client.ui.admin.CreateMenuView result = (com.epam.feel.client.ui.admin.CreateMenuView) created;
    
    memberInject_Key$type$com$epam$feel$client$ui$admin$CreateMenuView$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.ui.admin.CreateMenuView declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.admin.CreateMenuView, annotation=[none]]
   */
  private com.epam.feel.client.ui.admin.CreateMenuView get_Key$type$com$epam$feel$client$ui$admin$CreateMenuView$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$ui$admin$CreateMenuView$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.IEpamFeelConstants declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:114)
   */
  private void memberInject_Key$type$com$epam$feel$client$IEpamFeelConstants$_annotation$$none$$(com.epam.feel.client.IEpamFeelConstants injectee) {
    
  }
  
  private com.epam.feel.client.IEpamFeelConstants create_Key$type$com$epam$feel$client$IEpamFeelConstants$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.client.IEpamFeelConstants.class);
    assert created instanceof com.epam.feel.client.IEpamFeelConstants;
    com.epam.feel.client.IEpamFeelConstants result = (com.epam.feel.client.IEpamFeelConstants) created;
    
    memberInject_Key$type$com$epam$feel$client$IEpamFeelConstants$_annotation$$none$$(result);
    return result;
  }
  
  private com.epam.feel.client.IEpamFeelConstants singleton_Key$type$com$epam$feel$client$IEpamFeelConstants$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:114)
   */
  private com.epam.feel.client.IEpamFeelConstants get_Key$type$com$epam$feel$client$IEpamFeelConstants$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$IEpamFeelConstants$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$IEpamFeelConstants$_annotation$$none$$ = create_Key$type$com$epam$feel$client$IEpamFeelConstants$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$IEpamFeelConstants$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.ui.ApplicationView declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.ApplicationView, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$client$ui$ApplicationView$_annotation$$none$$(com.epam.feel.client.ui.ApplicationView injectee) {
    
  }
  
  private com.epam.feel.client.ui.ApplicationView create_Key$type$com$epam$feel$client$ui$ApplicationView$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.client.ui.ApplicationView.class);
    assert created instanceof com.epam.feel.client.ui.ApplicationView;
    com.epam.feel.client.ui.ApplicationView result = (com.epam.feel.client.ui.ApplicationView) created;
    
    memberInject_Key$type$com$epam$feel$client$ui$ApplicationView$_annotation$$none$$(result);
    return result;
  }
  
  private com.epam.feel.client.ui.ApplicationView singleton_Key$type$com$epam$feel$client$ui$ApplicationView$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.ApplicationView, annotation=[none]]
   */
  private com.epam.feel.client.ui.ApplicationView get_Key$type$com$epam$feel$client$ui$ApplicationView$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$ui$ApplicationView$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$ui$ApplicationView$_annotation$$none$$ = create_Key$type$com$epam$feel$client$ui$ApplicationView$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$ui$ApplicationView$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.ui.user.PersonalAccountView declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.user.PersonalAccountView, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$client$ui$user$PersonalAccountView$_annotation$$none$$(com.epam.feel.client.ui.user.PersonalAccountView injectee) {
    
  }
  
  private com.epam.feel.client.ui.user.PersonalAccountView create_Key$type$com$epam$feel$client$ui$user$PersonalAccountView$_annotation$$none$$() {
    Object created = GWT.create(com.epam.feel.client.ui.user.PersonalAccountView.class);
    assert created instanceof com.epam.feel.client.ui.user.PersonalAccountView;
    com.epam.feel.client.ui.user.PersonalAccountView result = (com.epam.feel.client.ui.user.PersonalAccountView) created;
    
    memberInject_Key$type$com$epam$feel$client$ui$user$PersonalAccountView$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.ui.user.PersonalAccountView declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.ui.user.PersonalAccountView, annotation=[none]]
   */
  private com.epam.feel.client.ui.user.PersonalAccountView get_Key$type$com$epam$feel$client$ui$user$PersonalAccountView$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$ui$user$PersonalAccountView$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.google.gwt.place.shared.PlaceController declared at:
   *   public com.google.gwt.place.shared.PlaceController com.epam.feel.client.gin.GINClientModule.getPlaceController(com.google.web.bindery.event.shared.EventBus)
   */
  private com.google.gwt.place.shared.PlaceController com$epam$feel$client$gin$GINClientModule_getPlaceController_methodInjection(com.epam.feel.client.gin.GINClientModule injectee, com.google.web.bindery.event.shared.EventBus _0) {
    return injectee.getPlaceController(_0);
  }
  
  private com.google.gwt.place.shared.PlaceController create_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$() {
    return com$epam$feel$client$gin$GINClientModule_getPlaceController_methodInjection(new com.epam.feel.client.gin.GINClientModule(), get_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$());
  }
  
  private com.google.gwt.place.shared.PlaceController singleton_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   public com.google.gwt.place.shared.PlaceController com.epam.feel.client.gin.GINClientModule.getPlaceController(com.google.web.bindery.event.shared.EventBus)
   */
  private com.google.gwt.place.shared.PlaceController get_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$() {
    if (singleton_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$ == null) {
      singleton_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$ = create_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$();
    }
    return singleton_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.view.IFooterView$IFooterPresenter declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:85)
   */
  private com.epam.feel.client.view.IFooterView.IFooterPresenter create_Key$type$com$epam$feel$client$view$IFooterView$IFooterPresenter$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$activity$FooterActivity$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.IFooterView.IFooterPresenter singleton_Key$type$com$epam$feel$client$view$IFooterView$IFooterPresenter$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:85)
   */
  private com.epam.feel.client.view.IFooterView.IFooterPresenter get_Key$type$com$epam$feel$client$view$IFooterView$IFooterPresenter$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$IFooterView$IFooterPresenter$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$IFooterView$IFooterPresenter$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$IFooterView$IFooterPresenter$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$IFooterView$IFooterPresenter$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.view.IHistoryBalanceView declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:91)
   */
  private com.epam.feel.client.view.IHistoryBalanceView create_Key$type$com$epam$feel$client$view$IHistoryBalanceView$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$ui$admin$HistoryBalanceView$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.IHistoryBalanceView singleton_Key$type$com$epam$feel$client$view$IHistoryBalanceView$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:91)
   */
  private com.epam.feel.client.view.IHistoryBalanceView get_Key$type$com$epam$feel$client$view$IHistoryBalanceView$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$IHistoryBalanceView$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$IHistoryBalanceView$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$IHistoryBalanceView$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$IHistoryBalanceView$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.view.IListGroupRequestView declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:104)
   */
  private com.epam.feel.client.view.IListGroupRequestView create_Key$type$com$epam$feel$client$view$IListGroupRequestView$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$ui$admin$ListGroupRequestView$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.IListGroupRequestView singleton_Key$type$com$epam$feel$client$view$IListGroupRequestView$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:104)
   */
  private com.epam.feel.client.view.IListGroupRequestView get_Key$type$com$epam$feel$client$view$IListGroupRequestView$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$IListGroupRequestView$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$IListGroupRequestView$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$IListGroupRequestView$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$IListGroupRequestView$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.place.ApplicationPlace$Tokenizer declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.place.ApplicationPlace$Tokenizer, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$client$place$ApplicationPlace$Tokenizer$_annotation$$none$$(com.epam.feel.client.place.ApplicationPlace.Tokenizer injectee) {
    
  }
  
  private com.epam.feel.client.place.ApplicationPlace.Tokenizer com$epam$feel$client$place$ApplicationPlace$Tokenizer_Tokenizer_methodInjection(com.google.inject.Provider _0) {
    return new com.epam.feel.client.place.ApplicationPlace.Tokenizer(_0);
  }
  
  private com.epam.feel.client.place.ApplicationPlace.Tokenizer create_Key$type$com$epam$feel$client$place$ApplicationPlace$Tokenizer$_annotation$$none$$() {
    com.epam.feel.client.place.ApplicationPlace.Tokenizer result = com$epam$feel$client$place$ApplicationPlace$Tokenizer_Tokenizer_methodInjection(get_Key$type$com$google$inject$Provider$com$epam$feel$client$place$ApplicationPlace$$_annotation$$none$$());
    memberInject_Key$type$com$epam$feel$client$place$ApplicationPlace$Tokenizer$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.place.ApplicationPlace$Tokenizer declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.place.ApplicationPlace$Tokenizer, annotation=[none]]
   */
  private com.epam.feel.client.place.ApplicationPlace.Tokenizer get_Key$type$com$epam$feel$client$place$ApplicationPlace$Tokenizer$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$place$ApplicationPlace$Tokenizer$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.place.PersonalAccountPlace$Tokenizer declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.place.PersonalAccountPlace$Tokenizer, annotation=[none]]
   */
  private void memberInject_Key$type$com$epam$feel$client$place$PersonalAccountPlace$Tokenizer$_annotation$$none$$(com.epam.feel.client.place.PersonalAccountPlace.Tokenizer injectee) {
    
  }
  
  private com.epam.feel.client.place.PersonalAccountPlace.Tokenizer com$epam$feel$client$place$PersonalAccountPlace$Tokenizer_Tokenizer_methodInjection(com.google.inject.Provider _0) {
    return new com.epam.feel.client.place.PersonalAccountPlace.Tokenizer(_0);
  }
  
  private com.epam.feel.client.place.PersonalAccountPlace.Tokenizer create_Key$type$com$epam$feel$client$place$PersonalAccountPlace$Tokenizer$_annotation$$none$$() {
    com.epam.feel.client.place.PersonalAccountPlace.Tokenizer result = com$epam$feel$client$place$PersonalAccountPlace$Tokenizer_Tokenizer_methodInjection(get_Key$type$com$google$inject$Provider$com$epam$feel$client$place$PersonalAccountPlace$$_annotation$$none$$());
    memberInject_Key$type$com$epam$feel$client$place$PersonalAccountPlace$Tokenizer$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.place.PersonalAccountPlace$Tokenizer declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.place.PersonalAccountPlace$Tokenizer, annotation=[none]]
   */
  private com.epam.feel.client.place.PersonalAccountPlace.Tokenizer get_Key$type$com$epam$feel$client$place$PersonalAccountPlace$Tokenizer$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$place$PersonalAccountPlace$Tokenizer$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.epam.feel.client.mvp.ClientFactory declared at:
   *   public com.epam.feel.client.mvp.ClientFactory com.epam.feel.client.gin.GINClientModule.getClientFactory(com.google.gwt.place.shared.PlaceController,com.google.web.bindery.event.shared.EventBus)
   */
  private com.epam.feel.client.mvp.ClientFactory com$epam$feel$client$gin$GINClientModule_getClientFactory_methodInjection(com.epam.feel.client.gin.GINClientModule injectee, com.google.gwt.place.shared.PlaceController _0, com.google.web.bindery.event.shared.EventBus _1) {
    return injectee.getClientFactory(_0, _1);
  }
  
  private com.epam.feel.client.mvp.ClientFactory create_Key$type$com$epam$feel$client$mvp$ClientFactory$_annotation$$none$$() {
    return com$epam$feel$client$gin$GINClientModule_getClientFactory_methodInjection(new com.epam.feel.client.gin.GINClientModule(), get_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$(), get_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$());
  }
  
  private com.epam.feel.client.mvp.ClientFactory singleton_Key$type$com$epam$feel$client$mvp$ClientFactory$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   public com.epam.feel.client.mvp.ClientFactory com.epam.feel.client.gin.GINClientModule.getClientFactory(com.google.gwt.place.shared.PlaceController,com.google.web.bindery.event.shared.EventBus)
   */
  private com.epam.feel.client.mvp.ClientFactory get_Key$type$com$epam$feel$client$mvp$ClientFactory$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$mvp$ClientFactory$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$mvp$ClientFactory$_annotation$$none$$ = create_Key$type$com$epam$feel$client$mvp$ClientFactory$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$mvp$ClientFactory$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.view.IHistoryRequestGroupView$IHistoryRequestGroupPresenter declared at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:99)
   */
  private com.epam.feel.client.view.IHistoryRequestGroupView.IHistoryRequestGroupPresenter create_Key$type$com$epam$feel$client$view$IHistoryRequestGroupView$IHistoryRequestGroupPresenter$_annotation$$none$$() {
    return get_Key$type$com$epam$feel$client$activity$HistoryRequestGroupActivity$_annotation$$none$$();
  }
  
  private com.epam.feel.client.view.IHistoryRequestGroupView.IHistoryRequestGroupPresenter singleton_Key$type$com$epam$feel$client$view$IHistoryRequestGroupView$IHistoryRequestGroupPresenter$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.epam.feel.client.gin.GINClientModule.configure(GINClientModule.java:99)
   */
  private com.epam.feel.client.view.IHistoryRequestGroupView.IHistoryRequestGroupPresenter get_Key$type$com$epam$feel$client$view$IHistoryRequestGroupView$IHistoryRequestGroupPresenter$_annotation$$none$$() {
    if (singleton_Key$type$com$epam$feel$client$view$IHistoryRequestGroupView$IHistoryRequestGroupPresenter$_annotation$$none$$ == null) {
      singleton_Key$type$com$epam$feel$client$view$IHistoryRequestGroupView$IHistoryRequestGroupPresenter$_annotation$$none$$ = create_Key$type$com$epam$feel$client$view$IHistoryRequestGroupView$IHistoryRequestGroupPresenter$_annotation$$none$$();
    }
    return singleton_Key$type$com$epam$feel$client$view$IHistoryRequestGroupView$IHistoryRequestGroupPresenter$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.epam.feel.client.activity.MainHeaderActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.MainHeaderActivity, annotation=[none]]
   */
  private native void com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection_____________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.MenuInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::menuInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection_____________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.ViewFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::viewFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection_____________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.client.mvp.AppPlaceFactory value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::placeFactory = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection_____________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.HistoryInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::historyInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection_____________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.RequestInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::requestInfoServiceAsync = value;
  }-*/;
  
  private native void com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection_____________(com.epam.feel.client.activity.SuperActivity injectee, com.epam.feel.shared.service.ClientInfoServiceAsync value) /*-{
    injectee.@com.epam.feel.client.activity.SuperActivity::clientInfoServiceAsync = value;
  }-*/;
  
  private void memberInject_Key$type$com$epam$feel$client$activity$MainHeaderActivity$_annotation$$none$$(com.epam.feel.client.activity.MainHeaderActivity injectee) {
    com$epam$feel$client$activity$SuperActivity_menuInfoServiceAsync_fieldInjection_____________(injectee, get_Key$type$com$epam$feel$shared$service$MenuInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_viewFactory_fieldInjection_____________(injectee, get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_placeFactory_fieldInjection_____________(injectee, get_Key$type$com$epam$feel$client$mvp$AppPlaceFactory$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_historyInfoServiceAsync_fieldInjection_____________(injectee, get_Key$type$com$epam$feel$shared$service$HistoryInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_requestInfoServiceAsync_fieldInjection_____________(injectee, get_Key$type$com$epam$feel$shared$service$RequestInfoServiceAsync$_annotation$$none$$());
    com$epam$feel$client$activity$SuperActivity_clientInfoServiceAsync_fieldInjection_____________(injectee, get_Key$type$com$epam$feel$shared$service$ClientInfoServiceAsync$_annotation$$none$$());
    
  }
  
  private com.epam.feel.client.activity.MainHeaderActivity com$epam$feel$client$activity$MainHeaderActivity_MainHeaderActivity_methodInjection(com.epam.feel.client.mvp.ClientFactory _0, com.epam.feel.client.mvp.ViewFactory _1) {
    return new com.epam.feel.client.activity.MainHeaderActivity(_0, _1);
  }
  
  private com.epam.feel.client.activity.MainHeaderActivity create_Key$type$com$epam$feel$client$activity$MainHeaderActivity$_annotation$$none$$() {
    com.epam.feel.client.activity.MainHeaderActivity result = com$epam$feel$client$activity$MainHeaderActivity_MainHeaderActivity_methodInjection(get_Key$type$com$epam$feel$client$mvp$ClientFactory$_annotation$$none$$(), get_Key$type$com$epam$feel$client$mvp$ViewFactory$_annotation$$none$$());
    memberInject_Key$type$com$epam$feel$client$activity$MainHeaderActivity$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.epam.feel.client.activity.MainHeaderActivity declared at:
   *   Implicit binding for Key[type=com.epam.feel.client.activity.MainHeaderActivity, annotation=[none]]
   */
  private com.epam.feel.client.activity.MainHeaderActivity get_Key$type$com$epam$feel$client$activity$MainHeaderActivity$_annotation$$none$$() {
    return create_Key$type$com$epam$feel$client$activity$MainHeaderActivity$_annotation$$none$$();
  }
  
  
  public GINinjectorImpl() {
    
  }
  
}
