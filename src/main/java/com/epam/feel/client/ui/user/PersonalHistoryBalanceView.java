package com.epam.feel.client.ui.user;

import com.epam.feel.client.ui.admin.HistoryBalanceView;
import com.epam.feel.client.ui.util.pagination.FixedPager;
import com.epam.feel.client.view.IHistoryBalanceView.IHistoryBalancePresenter;
import com.epam.feel.client.view.IPersonalHistoryBalanceView;
import com.epam.feel.shared.WebAppConstants;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * History of balance layout view implementation.
 * 
 * @author Anna_Gavrilina
 */
public class PersonalHistoryBalanceView extends Composite implements IPersonalHistoryBalanceView {

    private static PersonalHistoryBalanceViewUiBinder uiBinder = GWT.create(PersonalHistoryBalanceViewUiBinder.class);

    private IHistoryBalancePresenter presenter;

    interface PersonalHistoryBalanceViewUiBinder extends UiBinder<Widget, PersonalHistoryBalanceView> {}

    @UiField
    HistoryBalanceView historyBalance;
    @UiField
    FixedPager balancePager;
    @UiField
    MainHeader header;
    @UiField
    Footer footer;
    @UiField
    Label label;

    public PersonalHistoryBalanceView() {
        initWidget(uiBinder.createAndBindUi(this));
        historyBalance.setHeight("750px");
    }

    @Override
    public void setPresenter(IHistoryBalancePresenter presenter) {
        this.presenter = presenter;
        header.setPresenter(this.presenter.getHeader());
        footer.setPresenter(this.presenter.getFooter());
        historyBalance.setPresenter(presenter);
        balancePager.setDisplay(historyBalance);
        balancePager.setPageSize(WebAppConstants.ROWS_PER_PAGE);
    }

    @UiHandler ("goToMain")
    void onGoToMain(ClickEvent e) {
        presenter.getHeader().goMainMenuUserView();
    }

    @UiHandler ("goToArchiveRequests")
    void onGoToArchiveRequests(ClickEvent e) {
        header.getMainHeaderPresenter().goToPersonalAccount();
    }

    @Override
    public void refreshData() {
        historyBalance.refreshData();
    }

}
