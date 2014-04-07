package com.epam.feel.client.ui.admin;

import static com.epam.feel.client.IEpamFeelConstants.CONSTANTS;
import java.util.Date;
import java.util.Map;
import com.epam.feel.client.activity.ApplicationActivity;
import com.epam.feel.client.ui.util.pagination.CollectionUtils;
import com.epam.feel.client.ui.util.pagination.SortableColumn;
import com.epam.feel.client.ui.util.table.HistoryDataGrid;
import com.epam.feel.client.view.IHistoryBalanceView;
import com.epam.feel.server.model.Transaction;
import com.epam.feel.shared.WebAppConstants;
import com.epam.feel.shared.dto.TransactionDTO;
import com.epam.feel.shared.enums.TransactionType;
import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.user.cellview.client.Column;

/**
 * History of changes client's balance layout view implementation for administrator.
 * 
 * @author Anna_Gavrilina
 */
public class HistoryBalanceView extends HistoryDataGrid<TransactionDTO> implements IHistoryBalanceView {

    private Boolean forAdmin = false;

    public HistoryBalanceView() {
        initUI();
    }

    public HistoryBalanceView(ApplicationActivity applicationActivity) {
        this();
        setPresenter(applicationActivity.historyBalancePresenter);
    }

    @Override
    public void setPresenter(IHistoryBalancePresenter presenter) {
        if (!forAdmin) {
            setProvider(presenter.getProviderForClient());
        } else {
            setProvider(presenter);
        }
    }

    public void setForAdmin(boolean forAdmin) {
        this.forAdmin = forAdmin;
    }

    public boolean getForAdmin() {
        return forAdmin;
    }

    private void initUI() {

        Column<TransactionDTO, Date> dateColumn = new SortableColumn<TransactionDTO, Date>(new DateCell(
            WebAppConstants.DATE_TIME_FORMATTER)) {
            @Override
            public Date getValue(TransactionDTO object) {
                return object.getCreateDate();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(Transaction.DATE_COLUMN, asc);
            }
        };
        addColumn(dateColumn, CONSTANTS.dateColumn());

        Column<TransactionDTO, String> userNameColumn = new SortableColumn<TransactionDTO, String>(new TextCell()) {
            @Override
            public String getValue(TransactionDTO object) {
                return object.getAccount().getName();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(Transaction.USER_NAME_COLUMN, asc);
            }
        };
        addColumn(userNameColumn, CONSTANTS.clientNameColumn());

        Column<TransactionDTO, Number> balanceColumn = new SortableColumn<TransactionDTO, Number>(new NumberCell(
            WebAppConstants.CURRENCY_FORMATTER)) {

            @Override
            public Number getValue(TransactionDTO object) {
                return object.getBalance();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(Transaction.BALANCE_COLUMN, asc);
            }
        };
        addColumn(balanceColumn, CONSTANTS.balanceColumn());

        Column<TransactionDTO, Number> amountColumn = new SortableColumn<TransactionDTO, Number>(new NumberCell(
            WebAppConstants.PLUS_MINUS_CURRENCY_FORMATTER)) {
            @Override
            public Number getValue(TransactionDTO object) {
                return (TransactionType.OUTPUT_BALANCE.equals(object.getType()) ? -1 : 1) * object.getAmount();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(Transaction.AMOUNT_COLUMN, asc);
            }
        };
        addColumn(amountColumn, CONSTANTS.amountChangeColumn());

        Column<TransactionDTO, String> operatorColumn = new SortableColumn<TransactionDTO, String>(new TextCell()) {
            @Override
            public String getValue(TransactionDTO object) {
                return object.getOperatorName();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(Transaction.OPERATOR_NAME_COLUMN, asc);
            }
        };
        addColumn(operatorColumn, CONSTANTS.operatorColumn());

        Column<TransactionDTO, String> actionColumn = new SortableColumn<TransactionDTO, String>(new TextCell()) {
            @Override
            public String getValue(TransactionDTO object) {
                return getTransactionTypeDescription(object.getType());
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(Transaction.TYPE_COLUMN, asc);
            }
        };
        addColumn(actionColumn, CONSTANTS.actionColumn());
    }

    private static String getTransactionTypeDescription(TransactionType type) {
        switch (type) {
            case ADVANCE_PAYMENT:
                return CONSTANTS.advancePayment();
            case OUTPUT_BALANCE:
                return CONSTANTS.outputBalance();
            case PAY_FOR_REQUEST:
                return CONSTANTS.payingForRequestGroup();
            case PAYBACK:
                return CONSTANTS.payback();
            default:
                throw new IllegalArgumentException();
        }
    }

}
