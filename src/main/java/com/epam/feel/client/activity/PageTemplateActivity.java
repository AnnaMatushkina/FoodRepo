package com.epam.feel.client.activity;

import com.epam.feel.client.mvp.ClientFactory;
import com.epam.feel.client.mvp.ViewFactory;
import com.epam.feel.client.view.IFooterView;
import com.epam.feel.client.view.IFooterView.IFooterPresenter;
import com.epam.feel.client.view.IMainHeaderView;
import com.epam.feel.client.view.IMainHeaderView.IMainHeaderPresenter;
import com.epam.feel.client.view.ISuperPresenter;
import com.google.inject.Inject;

/**
 * Abstract activity for full page in web-application, new activities must be extend this class to access header and
 * footer presenters
 * 
 * @author Anna_Gavrilina
 */
// public abstract class SuperActivity extends NoHeaderFooterActivity implements ISuperPresenter {
public abstract class PageTemplateActivity extends SuperActivity implements ISuperPresenter {
    @Inject
    private IMainHeaderView.IMainHeaderPresenter mainHeaderPresenter;
    @Inject
    private IFooterView.IFooterPresenter footerPresenter;

    @Inject
    public PageTemplateActivity(ClientFactory clientFactory, ViewFactory viewFactory) {
        super(clientFactory, viewFactory);
    }

    @Override
    public IMainHeaderPresenter getHeader() {
        return mainHeaderPresenter;
    }

    @Override
    public IFooterPresenter getFooter() {
        return footerPresenter;
    }

}
