package com.epam.feel.client.mvp;

import com.epam.feel.client.view.IApplicationView;
import com.epam.feel.client.view.IPersonalAccountView;
import com.epam.feel.client.view.IPersonalHistoryBalanceView;

/**
 * @author Artem Tumasov (Artem_Tumasov@epam.com)
 */
public class ViewFactoryImpl implements ViewFactory {

    private final IApplicationView applicationView;
    private final IPersonalAccountView personalAccountView;
    private final IPersonalHistoryBalanceView historyBalanceView;

    public ViewFactoryImpl(IApplicationView applicationView, IPersonalAccountView personalAccountView,
        IPersonalHistoryBalanceView historyBalanceView) {
        this.applicationView = applicationView;
        this.personalAccountView = personalAccountView;
        this.historyBalanceView = historyBalanceView;
    }

    @Override
    public IApplicationView getApplicationView() {
        return applicationView;
    }

    @Override
    public IPersonalAccountView getPersonalAccountView() {
        return personalAccountView;
    }

    @Override
    public IPersonalHistoryBalanceView getHistoryBalanceView() {
        return historyBalanceView;
    }

}
