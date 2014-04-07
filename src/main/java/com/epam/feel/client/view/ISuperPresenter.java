package com.epam.feel.client.view;

import com.epam.feel.client.view.IFooterView.IFooterPresenter;
import com.epam.feel.client.view.IMainHeaderView.IMainHeaderPresenter;

public interface ISuperPresenter {
    IMainHeaderPresenter getHeader();

    IFooterPresenter getFooter();
}
