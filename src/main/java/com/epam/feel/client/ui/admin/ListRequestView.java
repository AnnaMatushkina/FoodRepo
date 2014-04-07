package com.epam.feel.client.ui.admin;

import static com.epam.feel.client.IEpamFeelConstants.CONSTANTS;
import java.util.Map;
import com.epam.feel.client.activity.ApplicationActivity;
import com.epam.feel.client.ui.util.pagination.CollectionUtils;
import com.epam.feel.client.ui.util.pagination.SortableColumn;
import com.epam.feel.server.model.ExtendedRequest;
import com.epam.feel.shared.WebAppConstants;
import com.epam.feel.shared.dto.ExtendedRequestDTO;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * List of requests layout view implementation for administrator.
 * 
 * @author Evgeny_Kincharov
 */
public class ListRequestView extends AbstractListRequestView<ExtendedRequestDTO> {

    interface ListRequestsViewUiBinder extends UiBinder<Widget, ListRequestView> {}

    private static final int MENU_NAME_COLUMN_INDEX = 4;

    private static ListRequestsViewUiBinder uiBinder = GWT.create(ListRequestsViewUiBinder.class);

    @UiField
    TextBox filterBox;
    @UiField
    Button submitFilter;

    public ListRequestView() {
        initWidget(uiBinder.createAndBindUi(this));
        initUi();
        noData(true);
    }

    @Override
    protected void initUi() {
        filterBox.setMaxLength(WebAppConstants.MAX_FILTER_BOX_LENGTH);
        super.initUi();
    }

    @Override
    public void setPresenter(ApplicationActivity activity) {
        super.setPresenter(activity);
        requests.setProvider(getPresenter().getArchiveRequestsProvider());
    }

    @UiHandler ("submitFilter")
    void onFilterSubmitted(ClickEvent e) {
        applyFilter();
    }

    @UiHandler ("filterBox")
    void onFilterSubmitted(KeyUpEvent e) {
        if (e.getNativeEvent().getKeyCode() == KeyCodes.KEY_ENTER) {
            applyFilter();
        }
    }

    private void applyFilter() {
        getPresenter().setDishFilterString(filterBox.getText());
        reset();
    }

    @Override
    protected void initDataGridRequests() {
        super.initDataGridRequests();
        Column<ExtendedRequestDTO, String> menuNameColumn = new SortableColumn<ExtendedRequestDTO, String>(
            new TextCell()) {
            @Override
            public String getValue(ExtendedRequestDTO object) {
                return object.getMenuName();
            }

            @Override
            public Map<String, Boolean> getOrderList(boolean asc) {
                return CollectionUtils.getOrderList(ExtendedRequest.MENU_NAME_COLUMN, asc);
            }
        };
        requests.insertColumn(MENU_NAME_COLUMN_INDEX, menuNameColumn, CONSTANTS.menuNameColumn());
    }

}
