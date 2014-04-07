package com.epam.feel.client.ui.admin;

import static com.epam.feel.client.IEpamFeelConstants.CONSTANTS;
import java.util.Date;
import java.util.Map;
import com.epam.feel.client.activity.ApplicationActivity;
import com.epam.feel.client.ui.util.pagination.CollectionUtils;
import com.epam.feel.client.ui.util.pagination.SortableColumn;
import com.epam.feel.client.ui.util.table.HistoryDataGrid;
import com.epam.feel.client.view.IHistoryMenuView;
import com.epam.feel.server.model.Operation;
import com.epam.feel.shared.WebAppConstants;
import com.epam.feel.shared.dto.OperationDTO;
import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.user.cellview.client.Column;

/**
 * History of changes menu layout view implementation for administrator.
 * 
 * @author Anna_Gavrilina
 */
public class HistoryMenuView extends HistoryDataGrid<OperationDTO> implements IHistoryMenuView {

    public HistoryMenuView() {
        initUI();
    }

    public HistoryMenuView(ApplicationActivity applicationActivity) {
        this();
        setPresenter(applicationActivity.historyMenuPresenter);
    }

    @Override
    public void setPresenter(IHistoryMenuPresenter presenter) {
        setProvider(presenter);
    }

    private void initUI() {
        Column<OperationDTO, String> actionColumn = new SortableColumn<OperationDTO, String>(new TextCell()) {
            @Override
            public String getValue(OperationDTO object) {
                return object.getText();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(Operation.TEXT_COLUMN, asc);
            }
        };
        addColumn(actionColumn, CONSTANTS.eventColumn());

        Column<OperationDTO, Date> dateColumn = new SortableColumn<OperationDTO, Date>(new DateCell(
            WebAppConstants.DATE_TIME_FORMATTER)) {
            @Override
            public Date getValue(OperationDTO object) {
                return object.getCreateDate();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(Operation.DATE_COLUMN, asc);
            }

        };
        addColumn(dateColumn, CONSTANTS.dateColumn());

        Column<OperationDTO, String> userColumn = new SortableColumn<OperationDTO, String>(new TextCell()) {
            @Override
            public String getValue(OperationDTO object) {
                return object.getUserName();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(Operation.USER_NAME_COLUMN, asc);
            }

        };
        addColumn(userColumn, CONSTANTS.userColumn());
    }
}
