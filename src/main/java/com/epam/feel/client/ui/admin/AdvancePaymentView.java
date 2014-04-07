package com.epam.feel.client.ui.admin;

import static com.epam.feel.client.EpamFeelResources.INSTANCE;
import static com.epam.feel.client.IEpamFeelConstants.CONSTANTS;
import static com.epam.feel.client.IEpamFeelMessages.MESSAGES;
import com.epam.feel.client.activity.ApplicationActivity;
import com.epam.feel.client.ui.util.dialogs.DialogEvent;
import com.epam.feel.client.ui.util.dialogs.DialogEventHandler;
import com.epam.feel.client.ui.util.dialogs.MessageDialog;
import com.epam.feel.client.view.ICashManagementView.ICashManagementPresenter;
import com.epam.feel.shared.WebAppConstants;
import com.epam.feel.shared.dto.ClientDTO;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Advance payment layout view implementation like dialog box.
 * 
 * @author Anna_Gavrilina
 */
public class AdvancePaymentView extends DialogBox {

    private final static String INPUT_WIDTH = "75";
    private final static int SPACING = 5;

    private ICashManagementPresenter presenter;
    private TextBox total = new TextBox();
    private Long clientId;
    private String name;
    private AsyncCallback<ClientDTO> paymentCallback;

    public AdvancePaymentView(Long clientId, String name, Double balance, AsyncCallback<ClientDTO> paymentCallback,
        ApplicationActivity activity) {
        super();
        this.presenter = activity.cashManagementrPresenter;
        this.clientId = clientId;
        this.name = name;
        this.paymentCallback = paymentCallback;
        setGlassEnabled(true);
        setAnimationEnabled(true);
        setModal(true);
        setText(CONSTANTS.advancePayment());
        add(createContent(clientId, name, balance));
        center();
    }

    private VerticalPanel createContent(Long id, String name, Double balance) {
        Label paLabel = new Label(MESSAGES.personalAccountLabel(name));
        Label sumLabel = new Label(CONSTANTS.balanceLabel());
        Label totalLabel = new Label(CONSTANTS.replenishLabel());
        Label pa = new Label(id.toString());
        Label sum = new Label(WebAppConstants.CURRENCY_FORMATTER.format(balance));

        total.setWidth(INPUT_WIDTH);

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
        hpanelPa.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        hpanelSum.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        hpanelTotal.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        hpanelButton.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

        VerticalPanel panel = new VerticalPanel();
        panel.setWidth("100%");

        hpanelPa.add(paLabel);
        hpanelPa.add(pa);

        hpanelSum.add(sumLabel);
        hpanelSum.add(sum);

        hpanelTotal.add(totalLabel);
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

    private DialogEventHandler<MessageDialog> makeAdvancedPaymentConfirmation = new DialogEventHandler.PositiveListener<MessageDialog>() {

        @Override
        public void onPositiveButtonClick(DialogEvent<MessageDialog> event) {
            double value = Double.parseDouble(total.getValue());
            hide();
            presenter.makeAdvancePayment(clientId, value, paymentCallback);
        }

    };

    private ClickHandler addHandler = new ClickHandler() {

        @Override
        public void onClick(ClickEvent paramClickEvent) {
            if (validTotalValue()) {
                MessageDialog.confirm(MESSAGES.replenishConfirmation(total.getValue(), clientId.toString(), name),
                    makeAdvancedPaymentConfirmation);
            }
        }
    };

    private boolean validTotalValue() {
        String value = total.getValue();
        boolean result;
        try {
            double total = Double.parseDouble(value);
            result = total > 0;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
}