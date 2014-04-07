package com.epam.feel.client.ui.admin;

import static com.epam.feel.client.IEpamFeelConstants.CONSTANTS;
import java.util.Date;
import java.util.Map;
import com.epam.feel.client.activity.ApplicationActivity;
import com.epam.feel.client.ui.util.pagination.CollectionUtils;
import com.epam.feel.client.ui.util.pagination.SortableColumn;
import com.epam.feel.client.ui.util.table.HistoryDataGrid;
import com.epam.feel.client.view.IHistoryNotificationView;
import com.epam.feel.server.model.Notification;
import com.epam.feel.shared.WebAppConstants;
import com.epam.feel.shared.dto.NotificationDTO;
import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.user.cellview.client.Column;

/**
 * History of changes Notification layout view implementation for administrator.
 * 
 * @author Evgeny_Neustroev
 */
public class HistoryNotificationView extends HistoryDataGrid<NotificationDTO> implements IHistoryNotificationView {

    public HistoryNotificationView() {
        initUI();
    }

    public HistoryNotificationView(ApplicationActivity applicationActivity) {
        this();
        setPresenter(applicationActivity.historyNotificationPresenter);
    }

    @Override
    public void setPresenter(IHistoryNotificationPresenter presenter) {
        setProvider(presenter);
    }

    private void initUI() {
        Column<NotificationDTO, String> actionColumn = new SortableColumn<NotificationDTO, String>(new TextCell()) {
            @Override
            public String getValue(NotificationDTO object) {
                return object.getText();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(Notification.TEXT_COLUMN, asc);
            }
        };
        addColumn(actionColumn, CONSTANTS.eventColumn());

        Column<NotificationDTO, String> emailColumn = new SortableColumn<NotificationDTO, String>(new TextCell()) {
            @Override
            public String getValue(NotificationDTO object) {
                return object.getEmail();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(Notification.EMAIL_COLUMN, asc);
            }
        };
        addColumn(emailColumn, CONSTANTS.recipientAddress());

        Column<NotificationDTO, Date> dateColumn = new SortableColumn<NotificationDTO, Date>(new DateCell(
            WebAppConstants.DATE_TIME_FORMATTER)) {
            @Override
            public Date getValue(NotificationDTO object) {
                return object.getCreateDate();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(Notification.DATE_COLUMN, asc);
            }
        };
        addColumn(dateColumn, CONSTANTS.dateColumn());

        Column<NotificationDTO, String> userColumn = new SortableColumn<NotificationDTO, String>(new TextCell()) {
            @Override
            public String getValue(NotificationDTO object) {
                return object.getSender();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(Notification.SENDER_NAME_COLUMN, asc);
            }
        };
        addColumn(userColumn, CONSTANTS.userColumn());
    }
}
