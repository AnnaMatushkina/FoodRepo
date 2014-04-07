package com.epam.feel.client.mvp;

import com.epam.feel.client.view.IApplicationView;
import com.epam.feel.client.view.IPersonalAccountView;
import com.epam.feel.client.view.IPersonalHistoryBalanceView;

/**
 * @author Artem Tumasov (Artem_Tumasov@epam.com)
 */
public interface ViewFactory {
    public IApplicationView getApplicationView();

    public IPersonalAccountView getPersonalAccountView();

    public IPersonalHistoryBalanceView getHistoryBalanceView();
}
