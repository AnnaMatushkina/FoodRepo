package com.epam.feel.client.view;

import com.epam.feel.shared.dto.ClientDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;

public interface ICashManagementView extends IsWidget {

    public interface ICashManagementPresenter extends ISuperPresenter {
        public void makeAdvancePayment(Long clientId, double value, AsyncCallback<ClientDTO> callbackPaymentOrder);

        public void outputBalance(Long clientId, AsyncCallback<Double> callbackPayback);
    }

    public void setPresenter(ICashManagementPresenter presenter);
}
