package com.epam.feel.shared.service;

import java.util.List;
import java.util.Map;
import com.epam.feel.shared.dto.ClientDTO;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Interface for getting client information.
 * 
 * @author Evgeny_Neustroev
 */
@RemoteServiceRelativePath ("springGwtServices/clientinfoservice")
public interface ClientInfoService extends RemoteService {

    public List<ClientDTO> getAdministrators();

    public ClientDTO getCurrentClient();

    public ClientDTO makeAdvancePayment(Long id, double value);

    public Double outputBalance(Long id);

    public ClientDTO reloadCurrentClient();

    public ClientDTO adviseClient(Long id, Boolean advised);

    public Map<String, String> logout();

    public List<ClientDTO> getClientsByName(int startRow, int maxRows, String name, Map<String, Boolean> orderList);

    public Integer getClientsByNameCount(String name);

}
