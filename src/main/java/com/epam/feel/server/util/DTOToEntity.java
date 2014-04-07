package com.epam.feel.server.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.epam.feel.server.model.Account;
import com.epam.feel.server.model.Client;
import com.epam.feel.server.model.DishType;
import com.epam.feel.server.model.Menu;
import com.epam.feel.server.model.MenuDetails;
import com.epam.feel.server.model.Notification;
import com.epam.feel.server.model.Operation;
import com.epam.feel.server.model.Request;
import com.epam.feel.server.model.RequestDetails;
import com.epam.feel.server.model.RequestGroup;
import com.epam.feel.server.model.Transaction;
import com.epam.feel.shared.dto.AccountDTO;
import com.epam.feel.shared.dto.ClientDTO;
import com.epam.feel.shared.dto.DishTypeDTO;
import com.epam.feel.shared.dto.GroupRequestDTO;
import com.epam.feel.shared.dto.MenuDTO;
import com.epam.feel.shared.dto.MenuDetailsDTO;
import com.epam.feel.shared.dto.NotificationDTO;
import com.epam.feel.shared.dto.OperationDTO;
import com.epam.feel.shared.dto.RequestDTO;
import com.epam.feel.shared.dto.RequestDetailsDTO;
import com.epam.feel.shared.dto.TransactionDTO;

/**
 * Converter from DTO object to Entity.
 * 
 * @author Evgeny_Kincharov
 */
public class DTOToEntity {

    private DTOToEntity() {}

    public static Account convertAccount(AccountDTO dto) {
        Account result = null;
        if (dto != null) {
            result = new Account(dto.getName(), dto.getBalance(), dto.getCreateDate(), dto.getAdvance());
            result.setId(dto.getId());
        }
        return result;
    }

    public static Client convertClient(ClientDTO dto) {
        Client result = null;
        if (dto != null) {
            result = new Client(dto.getBalance(), dto.getAdvance(), dto.getRole(), dto.getName(), dto.getEmail(),
                dto.getCreateDate(), dto.isAdvised());
            result.setId(dto.getId());
        }
        return result;
    }

    private static RequestDetails convertRequestDetails(RequestDetailsDTO dto, Request request, Menu menu) {
        RequestDetails result = null;
        if (dto != null) {
            MenuDetails menuDetails = menu.getMenuDetails().get(
                dto.getMenuDetails().getMenu().getMenuDetails().indexOf(dto.getMenuDetails()));
            result = new RequestDetails(dto.getCount(), request, menuDetails);
            result.setId(dto.getId());
        }
        return result;
    }

    public static Request convertRequest(RequestDTO requestDTO, ClientDTO clientDTO) {
        Client client = DTOToEntity.convertClient(clientDTO);
        Request result = DTOToEntity.convertRequest(requestDTO, client);
        return result;
    }

    public static Request convertRequest(RequestDTO dto, Client client) {
        Request result = null;
        if (dto != null) {
            result = new Request(client, dto.getCreateDate(), dto.getStatus());
            result.setCost(dto.getCost());
            result.setDeliveryDate(dto.getDeliveryDate());
            Set<RequestDetails> details = new HashSet<RequestDetails>();
            if (!dto.getRequestDetails().isEmpty()) {
                Menu menu = convertMenu(dto.getMenu());
                for (RequestDetailsDTO detailsDto : dto.getRequestDetails()) {
                    details.add(convertRequestDetails(detailsDto, result, menu));
                }
            }
            result.setRequestDetails(details);
            result.setId(dto.getId());
        }
        return result;
    }

    private static MenuDetails convertMenuDetails(MenuDetailsDTO dto, Menu menu) {
        MenuDetails result = null;
        if (dto != null) {
            DishType dishType = convertDishType(dto.getDishType());
            result = new MenuDetails(menu, dto.getIsChiefChoice(), dto.getAlive(), dishType, dto.getDishName(),
                dto.getPrice(), dto.getWeight(), dto.getMaxCount(), dto.getStructure(), dto.getImageId(), dto.getUrl());
            result.setId(dto.getId());
        }
        return result;
    }

    public static MenuDetails convertMenuDetails(MenuDetailsDTO dto) {
        MenuDetails result = null;
        if (dto != null) {
            Menu menu = convertMenu(dto.getMenu());
            DishType dishType = convertDishType(dto.getDishType());
            result = new MenuDetails(menu, dto.getIsChiefChoice(), dto.getAlive(), dishType, dto.getDishName(),
                dto.getPrice(), dto.getWeight(), dto.getMaxCount(), dto.getStructure(), dto.getImageId(), dto.getUrl());
            result.setId(dto.getId());
        }
        return result;
    }

    public static Menu convertMenu(MenuDTO dto) {
        Menu result = null;
        if (dto != null) {
            result = new Menu(dto.getMenuName(), dto.getStatus(), dto.getCreateDate(), dto.getMenuOnDate(),
                dto.getReceiptStartDate(), dto.getReceiptEndDate(), dto.getDeliveryStartDate(),
                dto.getDeliveryEndDate());
            result.setId(dto.getId());
            List<MenuDetails> menuDetails = new ArrayList<MenuDetails>();
            for (MenuDetailsDTO detailsDto : dto.getMenuDetails()) {
                menuDetails.add(convertMenuDetails(detailsDto, result));
            }
            result.setMenuDetails(menuDetails);
        }
        return result;
    }

    private static DishType convertDishType(DishTypeDTO dto) {
        DishType result = null;
        if (dto != null) {
            result = new DishType(dto.getId(), dto.getText());
        }
        return result;
    }

    public static RequestGroup convertRequestGroup(GroupRequestDTO dto) {
        RequestGroup result = null;
        if (dto != null) {
            List<Request> requests = new ArrayList<Request>();
            for (RequestDTO req : dto.getRequests()) {
                requests.add(convertRequest(req, convertClient(req.getClient())));
            }
            result = new RequestGroup(dto.getCreateDate(), dto.getStatus(), new HashSet<Request>(requests));
            result.setId(dto.getId());
        }
        return result;
    }

    public static List<RequestGroup> convertRequestGroupList(List<GroupRequestDTO> list) {
        List<RequestGroup> result = new ArrayList<RequestGroup>();
        for (GroupRequestDTO requestDTO : list) {
            result.add(convertRequestGroup(requestDTO));
        }
        return result;
    }

    public static Transaction convertTransaction(TransactionDTO dto) {
        Transaction result = null;
        if (dto != null) {
            result = new Transaction(convertAccount(dto.getAccount()), dto.getCreateDate(), dto.getOperatorName(),
                dto.getBalance(), dto.getAmount(), dto.getType());
            result.setId(dto.getId());
        }
        return result;
    }

    public static Notification convertNotification(NotificationDTO dto) {
        Notification result = null;
        if (dto != null) {
            result = new Notification(dto.getCreateDate(), dto.getSender(), dto.getEmail(), dto.getText());
        }
        return result;
    }

    public static Operation convertOperation(OperationDTO dto) {
        Operation result = null;
        if (dto != null) {
            result = new Operation(dto.getCreateDate(), dto.getUserName(), dto.getType(), dto.getText());
        }
        return result;
    }

}
