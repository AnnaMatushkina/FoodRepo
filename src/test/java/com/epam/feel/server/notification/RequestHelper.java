package com.epam.feel.server.notification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.epam.feel.shared.dto.ClientDTO;
import com.epam.feel.shared.dto.GroupRequestDTO;
import com.epam.feel.shared.dto.MenuDetailsDTO;
import com.epam.feel.shared.dto.RequestDTO;
import com.epam.feel.shared.dto.RequestDetailsDTO;
import com.epam.feel.shared.enums.RequestStatus;

/**
 * Utility for create test request entity.
 * 
 * @author Sergey_Klyosov
 */
public class RequestHelper {

    private RequestHelper() {}

    public static RequestDTO getRequestDTO() {

        ClientDTO client = new ClientDTO();
        client.setAdvised(true);
        client.setEmail("email@mail.ru");
        client.setName("XXX");

        MenuDetailsDTO menuDetailsDTO = new MenuDetailsDTO();
        menuDetailsDTO.setPrice(100.0);

        List<RequestDetailsDTO> requestDetails = new ArrayList<RequestDetailsDTO>();
        requestDetails.add(new RequestDetailsDTO(1L, 1, null, menuDetailsDTO));

        RequestDTO request = new RequestDTO(1L, new Date(), RequestStatus.IN_PROCESS, client);
        request.setRequestDetails(requestDetails);

        return request;

    }

    public static GroupRequestDTO getGroupRequestDTO(RequestDTO request) {

        GroupRequestDTO groupRequestDTO = new GroupRequestDTO();
        groupRequestDTO.setCreateDate(new Date());
        List<RequestDTO> requests = new ArrayList<RequestDTO>();
        requests.add(request);
        groupRequestDTO.setRequests(requests);

        return groupRequestDTO;
    }

}
