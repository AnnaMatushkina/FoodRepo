package com.epam.feel.client.view;

import com.epam.feel.client.view.IHistoryBalanceView.IHistoryBalancePresenter;
import com.google.gwt.user.client.ui.IsWidget;

public interface IPersonalHistoryBalanceView extends IsWidget {

    public void setPresenter(IHistoryBalancePresenter presenter);

    public void refreshData();
}
