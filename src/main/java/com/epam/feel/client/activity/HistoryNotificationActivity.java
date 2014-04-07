package com.epam.feel.client.activity;

import java.util.Map;
import com.epam.feel.client.mvp.ClientFactory;
import com.epam.feel.client.mvp.ViewFactory;
import com.epam.feel.client.ui.util.pagination.CollectionUtils;
import com.epam.feel.client.ui.util.pagination.ProvideredDataGrid.PagingCountAsyncCallback;
import com.epam.feel.client.ui.util.pagination.ProvideredDataGrid.PagingDataAsyncCallback;
import com.epam.feel.client.view.IHistoryNotificationView.IHistoryNotificationPresenter;
import com.epam.feel.server.model.Notification;
import com.epam.feel.shared.dto.NotificationDTO;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class HistoryNotificationActivity extends PageTemplateActivity implements IHistoryNotificationPresenter {

    private static final Map<String, Boolean> DEFAULT_ORDER = CollectionUtils.getOrderList(Notification.DATE_COLUMN, false);

    @Inject
    public HistoryNotificationActivity(ClientFactory clientFactory, ViewFactory viewFactory) {
        super(clientFactory, viewFactory);
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {}

    @Override
    public void updateRowData(final int startRow, final int maxRows, final RowDataAcceptor<NotificationDTO> acceptor) {
        updateRowData(startRow, maxRows, DEFAULT_ORDER, acceptor);
    }

    @Override
    public void updateRowCount(final RowDataAcceptor<NotificationDTO> acceptor) {
        getHistoryService().getAllNotificationsCount(new PagingCountAsyncCallback<NotificationDTO>(acceptor));
    }

    @Override
    public void updateRowData(int startRow, int maxRows, Map<String, Boolean> orderByList,
        RowDataAcceptor<NotificationDTO> acceptor) {
        getHistoryService().getAllNotifications(startRow, maxRows, orderByList,
            new PagingDataAsyncCallback<NotificationDTO>(startRow, acceptor));
    }

}
