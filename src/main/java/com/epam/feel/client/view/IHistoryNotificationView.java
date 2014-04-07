package com.epam.feel.client.view;

import com.epam.feel.client.ui.util.pagination.SortablePagingDataProvider;
import com.epam.feel.shared.dto.NotificationDTO;

public interface IHistoryNotificationView {

    public interface IHistoryNotificationPresenter extends ISuperPresenter, SortablePagingDataProvider<NotificationDTO> {}

    public void setPresenter(IHistoryNotificationPresenter presenter);
}
