package com.epam.feel.client.ui.admin;

import static com.epam.feel.client.EpamFeelResources.INSTANCE;
import static com.epam.feel.client.IEpamFeelConstants.CONSTANTS;
import static com.epam.feel.client.IEpamFeelMessages.MESSAGES;
import com.epam.feel.client.activity.ApplicationActivity;
import com.epam.feel.client.view.ICashManagementView.ICashManagementPresenter;
import com.epam.feel.shared.WebAppConstants;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Output balance layout view implementation like dialog box.
 * 
 * @author Evgeny_Neustroev
 */
public class OutputBalanceView extends DialogBox {

    private final static int SPACING = 5;

    private AsyncCallback<Double> paymentCallback;
    private ICashManagementPresenter presenter;
    private Long clientId;

    public OutputBalanceView(Long clientId, String name, Double balance, AsyncCallback<Double> paymentCallback,
        ApplicationActivity activity) {
        super();
        this.presenter = activity.cashManagementrPresenter;
        this.paymentCallback = paymentCallback;
        this.clientId = clientId;
        setAnimationEnabled(true);
        setGlassEnabled(true);
        setModal(true);
        setText(CONSTANTS.outputBalance());
        add(createContent(clientId, name, balance));
        center();
    }

    private VerticalPanel createContent(Long clientId, String name, Double balance) {
        Label paLabel = new Label(MESSAGES.personalAccountLabel(name));
        Label sumLabel = new Label(CONSTANTS.balanceLabel());
        Label pa = new Label(clientId.toString());
        Label sum = new Label(WebAppConstants.CURRENCY_FORMATTER.format(balance));
        Label total = new Label(CONSTANTS.outputBalanceQuestion());

        Button ok = new Button(CONSTANTS.ok());
        ok.addClickHandler(addHandler);
        Button cancel = new Button(CONSTANTS.cancel());
        cancel.addClickHandler(hideHandler);

        HorizontalPanel hpanelPa = new HorizontalPanel();
        HorizontalPanel hpanelSum = new HorizontalPanel();
        HorizontalPanel hpanelTotal = new HorizontalPanel();
        HorizontalPanel hpanelButton = new HorizontalPanel();
        hpanelButton.setStyleName(INSTANCE.global().floatRight());

        hpanelPa.setSpacing(SPACING);
        hpanelSum.setSpacing(SPACING);
        hpanelTotal.setSpacing(SPACING);
        hpanelButton.setSpacing(SPACING);

        VerticalPanel panel = new VerticalPanel();
        panel.setWidth("100%");

        hpanelPa.add(paLabel);
        hpanelPa.add(pa);

        hpanelSum.add(sumLabel);
        hpanelSum.add(sum);

        hpanelTotal.add(total);

        hpanelButton.add(ok);
        hpanelButton.add(cancel);

        panel.add(hpanelPa);
        panel.add(hpanelSum);
        panel.add(hpanelTotal);
        panel.add(hpanelButton);

        return panel;
    }

    private ClickHandler hideHandler = new ClickHandler() {
        @Override
        public void onClick(ClickEvent paramClickEvent) {
            hide();
        }
    };

    private ClickHandler addHandler = new ClickHandler() {
        @Override
        public void onClick(ClickEvent paramClickEvent) {
            hide();
            presenter.outputBalance(clientId, paymentCallback);
        }
    };
}
