package com.epam.feel.client.gin;

import com.epam.feel.client.EpamFeelResources;
import com.epam.feel.client.IEpamFeelConstants;
import com.epam.feel.client.IEpamFeelMessages;
import com.epam.feel.client.IEpamFeelStatusConstants;
import com.epam.feel.client.activity.ApplicationActivity;
import com.epam.feel.client.activity.CashManagementActivity;
import com.epam.feel.client.activity.ClientListViewActivity;
import com.epam.feel.client.activity.CreateMenuActivity;
import com.epam.feel.client.activity.FooterActivity;
import com.epam.feel.client.activity.HistoryBalanceActivity;
import com.epam.feel.client.activity.HistoryMenuActivity;
import com.epam.feel.client.activity.HistoryNotificationActivity;
import com.epam.feel.client.activity.HistoryRequestActivity;
import com.epam.feel.client.activity.HistoryRequestGroupActivity;
import com.epam.feel.client.activity.ListGroupRequestActivity;
import com.epam.feel.client.activity.ListOrderActivity;
import com.epam.feel.client.activity.MainHeaderActivity;
import com.epam.feel.client.activity.PersonalAccountActivity;
import com.epam.feel.client.mvp.AppPlaceFactory;
import com.epam.feel.client.mvp.AppPlaceHistoryMapper;
import com.epam.feel.client.mvp.ClientFactory;
import com.epam.feel.client.mvp.ClientFactoryImpl;
import com.epam.feel.client.mvp.MainActivityMapper;
import com.epam.feel.client.mvp.ViewFactory;
import com.epam.feel.client.mvp.ViewFactoryImpl;
import com.epam.feel.client.ui.ApplicationView;
import com.epam.feel.client.ui.admin.CreateMenuView;
import com.epam.feel.client.ui.admin.HistoryBalanceView;
import com.epam.feel.client.ui.admin.HistoryMenuView;
import com.epam.feel.client.ui.admin.HistoryNotificationView;
import com.epam.feel.client.ui.admin.HistoryRequestGroupView;
import com.epam.feel.client.ui.admin.HistoryRequestView;
import com.epam.feel.client.ui.admin.ListGroupRequestView;
import com.epam.feel.client.ui.admin.ListRequestView;
import com.epam.feel.client.ui.user.Footer;
import com.epam.feel.client.ui.user.MainHeader;
import com.epam.feel.client.ui.user.PersonalAccountView;
import com.epam.feel.client.ui.user.PersonalHistoryBalanceView;
import com.epam.feel.client.view.IApplicationView;
import com.epam.feel.client.view.ICashManagementView;
import com.epam.feel.client.view.IClientListView;
import com.epam.feel.client.view.ICreateMenuView;
import com.epam.feel.client.view.IFooterView;
import com.epam.feel.client.view.IHistoryBalanceView;
import com.epam.feel.client.view.IHistoryMenuView;
import com.epam.feel.client.view.IHistoryNotificationView;
import com.epam.feel.client.view.IHistoryRequestGroupView;
import com.epam.feel.client.view.IHistoryRequestView;
import com.epam.feel.client.view.IListGroupRequestView;
import com.epam.feel.client.view.IListRequestView;
import com.epam.feel.client.view.IMainHeaderView;
import com.epam.feel.client.view.IPersonalAccountView;
import com.epam.feel.client.view.IPersonalHistoryBalanceView;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.activity.shared.CachingActivityMapper;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.inject.Provider;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

/**
 * Gin module for epam-feel application. It contains bindings for all views.
 * 
 * @author Artem Tumasov (Artem_Tumasov@epam.com)
 */
public class GINClientModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(IApplicationView.class).to(ApplicationView.class).in(Singleton.class);
        bind(IApplicationView.IApplicationPresenter.class).to(ApplicationActivity.class).in(Singleton.class);
        bind(IPersonalAccountView.class).to(PersonalAccountView.class).in(Singleton.class);
        bind(IMainHeaderView.class).to(MainHeader.class).in(Singleton.class);
        bind(IMainHeaderView.IMainHeaderPresenter.class).to(MainHeaderActivity.class).in(Singleton.class);
        bind(IPersonalAccountView.IPersonalAccountPresenter.class).to(PersonalAccountActivity.class)
            .in(Singleton.class);
        bind(IFooterView.class).to(Footer.class).in(Singleton.class);
        bind(IFooterView.IFooterPresenter.class).to(FooterActivity.class).in(Singleton.class);
        bind(ICreateMenuView.class).to(CreateMenuView.class).in(Singleton.class);
        bind(ICreateMenuView.ICreateMenuPresenter.class).to(CreateMenuActivity.class).in(Singleton.class);
        bind(IListRequestView.class).to(ListRequestView.class).in(Singleton.class);
        bind(IListRequestView.IListRequestPresenter.class).to(ListOrderActivity.class).in(Singleton.class);
        bind(ICashManagementView.ICashManagementPresenter.class).to(CashManagementActivity.class).in(Singleton.class);
        bind(IHistoryBalanceView.class).to(HistoryBalanceView.class).in(Singleton.class);
        bind(IHistoryBalanceView.IHistoryBalancePresenter.class).to(HistoryBalanceActivity.class).in(Singleton.class);
        bind(IPersonalHistoryBalanceView.class).to(PersonalHistoryBalanceView.class).in(Singleton.class);
        bind(IHistoryMenuView.class).to(HistoryMenuView.class).in(Singleton.class);
        bind(IHistoryMenuView.IHistoryMenuPresenter.class).to(HistoryMenuActivity.class).in(Singleton.class);
        bind(IHistoryRequestView.class).to(HistoryRequestView.class).in(Singleton.class);
        bind(IHistoryRequestView.IHistoryRequestPresenter.class).to(HistoryRequestActivity.class).in(Singleton.class);
        bind(IHistoryRequestGroupView.class).to(HistoryRequestGroupView.class).in(Singleton.class);
        bind(IHistoryRequestGroupView.IHistoryRequestGroupPresenter.class).to(HistoryRequestGroupActivity.class).in(
            Singleton.class);
        bind(IHistoryNotificationView.class).to(HistoryNotificationView.class).in(Singleton.class);
        bind(IHistoryNotificationView.IHistoryNotificationPresenter.class).to(HistoryNotificationActivity.class).in(
            Singleton.class);
        bind(IListGroupRequestView.class).to(ListGroupRequestView.class).in(Singleton.class);
        bind(IListGroupRequestView.IListGroupRequestPresenter.class).to(ListGroupRequestActivity.class).in(
            Singleton.class);
        bind(IClientListView.IClientListViewPresenter.class).to(ClientListViewActivity.class).in(Singleton.class);

        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
        bind(AppPlaceFactory.class).in(Singleton.class);
        bind(MainActivityMapper.class).in(Singleton.class);

        bind(IEpamFeelStatusConstants.class).in(Singleton.class);
        bind(IEpamFeelConstants.class).in(Singleton.class);
        bind(IEpamFeelMessages.class).in(Singleton.class);
        bind(EpamFeelResources.class).in(Singleton.class);
    }

    @Provides
    @Singleton
    public PlaceHistoryHandler getHistoryHandler(PlaceController placeController, AppPlaceHistoryMapper historyMapper,
        EventBus eventBus, AppPlaceFactory factory) {
        historyMapper.setFactory(factory);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, factory.getApplicationProviderPlace());
        return historyHandler;
    }

    @Provides
    @Singleton
    public PlaceController getPlaceController(EventBus eventBus) {
        return new PlaceController(eventBus);
    }

    @Provides
    @Singleton
    public ActivityManager getActivityManager(ActivityMapper activityMapper, EventBus eventBus) {
        CachingActivityMapper caching = new CachingActivityMapper(activityMapper);
        return new ActivityManager(caching, eventBus);
    }

    @Provides
    @Singleton
    public ActivityMapper getActivityMapper(ClientFactory clientFactory,
        Provider<ApplicationActivity> applicationActivityProvider,
        Provider<PersonalAccountActivity> personalAccountActivityProvider,
        Provider<HistoryBalanceActivity> historyBalanceActivityProvider) {
        return new MainActivityMapper(applicationActivityProvider, personalAccountActivityProvider,
            historyBalanceActivityProvider);
    }

    @Provides
    @Singleton
    public ClientFactory getClientFactory(final PlaceController placeController, EventBus eventBus) {
        return new ClientFactoryImpl(eventBus, placeController);
    }

    @Provides
    @Singleton
    public ViewFactory getViewFactory(IApplicationView applicationView, IPersonalAccountView personalAccountView,
        IPersonalHistoryBalanceView historyBalanceview) {
        return new ViewFactoryImpl(applicationView, personalAccountView, historyBalanceview);
    }
}
