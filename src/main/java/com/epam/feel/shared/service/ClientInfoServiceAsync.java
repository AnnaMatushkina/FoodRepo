package com.epam.feel.shared.service;

import java.util.List;
import java.util.Map;
import com.epam.feel.shared.dto.ClientDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * GWT-RPC service asynchronous (client-side) interface.
 * 
 * @see com.epam.feel.shared.service.ClientInfoService
 */
public interface ClientInfoServiceAsync {

    void getAdministrators(AsyncCallback<java.util.List<ClientDTO>> callback);

    void getCurrentClient(AsyncCallback<ClientDTO> callback);

    void makeAdvancePayment(Long id, double value, AsyncCallback<ClientDTO> callback);

    void outputBalance(Long id, AsyncCallback<Double> callback);

    void reloadCurrentClient(AsyncCallback<ClientDTO> callback);

    void adviseClient(Long id, Boolean advised, AsyncCallback<ClientDTO> callback);

    void logout(AsyncCallback<Map<String, String>> callback);

    void getClientsByName(int startRow, int maxRows, String name, Map<String, Boolean> orderList,
        AsyncCallback<List<ClientDTO>> callback);

    void getClientsByNameCount(String name, AsyncCallback<Integer> callback);

}
