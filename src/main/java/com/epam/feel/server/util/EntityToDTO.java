package com.epam.feel.server.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import com.epam.feel.server.model.Account;
import com.epam.feel.server.model.Client;
import com.epam.feel.server.model.DishType;
import com.epam.feel.server.model.ExtendedRequest;
import com.epam.feel.server.model.ExtendedRequestGroup;
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
import com.epam.feel.shared.dto.ExtendedRequestDTO;
import com.epam.feel.shared.dto.ExtendedRequestGroupDTO;
import com.epam.feel.shared.dto.GroupRequestDTO;
import com.epam.feel.shared.dto.MenuDTO;
import com.epam.feel.shared.dto.MenuDetailsDTO;
import com.epam.feel.shared.dto.NotificationDTO;
import com.epam.feel.shared.dto.OperationDTO;
import com.epam.feel.shared.dto.RequestDTO;
import com.epam.feel.shared.dto.RequestDetailsDTO;
import com.epam.feel.shared.dto.TransactionDTO;

/**
 * Utility for generate DTO from Entity.
 * 
 * @author Evgeny_Kincharov
 */
public class EntityToDTO {

    private EntityToDTO() {}

    public static AccountDTO convertAccount(Account account) {
        AccountDTO result = null;
        if (account != null) {
            result = new AccountDTO(account.getId(), account.getName(), account.getBalance(), account.getCreateDate(),
                account.getAdvance());
        }
        return result;
    }

    public static ClientDTO convertClient(Client client) {
        ClientDTO result = null;

        if (client != null) {
            result = new ClientDTO(client.getId(), client.getBalance(), client.getAdvance(), client.getRole(),
                client.getName(), client.getEmail(), client.getAdvised(), client.getCreateDate());
        }
        return result;
    }

    public static MenuDTO convertMenu(Menu menu) {
        MenuDTO result = null;
        if (menu != null) {
            result = new MenuDTO(menu.getId(), menu.getStatus(), menu.getCreateDate(), menu.getMenuOnDate(),
                menu.getName(), menu.getReceptionFrom(), menu.getReceptionTo(), menu.getDeliveryFrom(),
                menu.getDeliveryTo());
            List<MenuDetailsDTO> menuDetails = new ArrayList<MenuDetailsDTO>();
            for (MenuDetails menuDetail : menu.getMenuDetails()) {
                menuDetails.add(convertMenuDetails(menuDetail, result));
            }
            result.setMenuDetails(menuDetails);
        }
        return result;
    }

    public static List<MenuDTO> convertMenuList(List<Menu> list) {
        List<MenuDTO> result = new ArrayList<MenuDTO>();

        if (list != null) {
            for (Menu menu : list) {
                result.add(convertMenu(menu));
            }
        }

        return result;
    }

    private static MenuDetailsDTO convertMenuDetails(MenuDetails menuDetail, MenuDTO menu) {
        MenuDetailsDTO result = null;
        if (menuDetail != null) {
            DishTypeDTO dishType = convertDishType(menuDetail.getDishType());
            result = new MenuDetailsDTO(menuDetail.getId(), menuDetail.getDishName(), menuDetail.getIsChiefChoice(),
                menuDetail.getAlive(), menuDetail.getPrice(), menuDetail.getWeight(), menuDetail.getMaxCount(),
                menuDetail.getStructure(), menuDetail.getUrl(), menuDetail.getImageId(), menu, dishType);
        }
        return result;
    }

    public static DishTypeDTO convertDishType(DishType dishType) {
        DishTypeDTO result = null;
        if (dishType != null) {
            result = new DishTypeDTO(dishType.getId(), dishType.getText());
        }
        return result;
    }

    public static List<DishTypeDTO> convertDishTypeList(List<DishType> list) {
        List<DishTypeDTO> result = new ArrayList<DishTypeDTO>();

        if (list != null) {
            for (DishType type : list) {
                result.add(convertDishType(type));
            }
        }

        return result;
    }

    public static List<RequestDTO> convertRequestList(Collection<Request> list) {
        List<RequestDTO> result = new ArrayList<RequestDTO>();
        if (list != null) {
            for (Request request : list) {
                ClientDTO clientDTO = convertClient(request.getClient());
                result.add(convertRequest(request, clientDTO));
            }
        }
        return result;
    }

    public static List<ExtendedRequestDTO> convertExtendedRequestList(List<ExtendedRequest> list) {
        List<ExtendedRequestDTO> result = new ArrayList<ExtendedRequestDTO>();
        if (list != null) {
            for (ExtendedRequest request : list) {
                ClientDTO clientDTO = convertClient(request.getClient());
                result.add(convertExtendedRequest(request, clientDTO));
            }
        }
        return result;
    }

    public static ExtendedRequestDTO convertExtendedRequest(ExtendedRequest request, ClientDTO client) {
        ExtendedRequestDTO result = null;
        if (request != null) {
            result = new ExtendedRequestDTO(request.getId(), request.getCreateDate(), request.getDeliveryDate(),
                request.getStatus(), request.getCost(), client, request.getMenuName());
            result.setRequestDetails(new ArrayList<RequestDetailsDTO>());
            if (!request.getRequestDetails().isEmpty()) {
                MenuDTO menu = convertMenu(request.getRequestDetails().iterator().next().getMenuDetails().getMenu());
                result.setRequestDetails(convertRequestDetailsList(request.getRequestDetails(), result, menu));
            }

        }
        return result;
    }

    public static RequestDTO convertRequest(Request request, ClientDTO client) {
        RequestDTO result = null;
        if (request != null) {
            result = new RequestDTO(request.getId(), request.getCreateDate(), request.getDeliveryDate(),
                request.getStatus(), request.getCost(), client);
            result.setRequestDetails(new ArrayList<RequestDetailsDTO>());
            if (!request.getRequestDetails().isEmpty()) {
                MenuDTO menu = convertMenu(request.getRequestDetails().iterator().next().getMenuDetails().getMenu());
                result.setRequestDetails(convertRequestDetailsList(request.getRequestDetails(), result, menu));
            }

        }
        return result;
    }

    public static RequestDTO convertRequest(Request request) {
        return convertRequest(request, convertClient(request.getClient()));
    }

    public static List<RequestDetailsDTO> convertRequestDetailsList(Set<RequestDetails> requestDetails,
        RequestDTO request, MenuDTO menu) {
        List<RequestDetailsDTO> result = new ArrayList<RequestDetailsDTO>();
        if (requestDetails != null) {
            for (RequestDetails detail : requestDetails) {
                result.add(new RequestDetailsDTO(detail.getId(), detail.getCount(), request, menu.getMenuDetails().get(
                    detail.getMenuDetails().getMenu().getMenuDetails().indexOf(detail.getMenuDetails()))));
            }
        }
        return result;
    }

    public static List<ClientDTO> convertClients(List<Client> clients) {
        List<ClientDTO> result = new ArrayList<ClientDTO>();
        if (clients != null) {
            for (Client client : clients) {
                result.add(convertClient(client));
            }
        }
        return result;
    }

    public static GroupRequestDTO convertRequestGroup(RequestGroup requestGroup) {
        if (requestGroup == null) {
            return null;
        }
        List<RequestDTO> requestDTO = convertRequestList(requestGroup.getRequests());
        GroupRequestDTO result = new GroupRequestDTO(requestGroup.getId(), requestGroup.getCreateDate(),
            requestGroup.getStatus(), requestDTO);
        return result;
    }

    public static List<GroupRequestDTO> convertRequestGroupList(List<RequestGroup> list) {
        List<GroupRequestDTO> result = new ArrayList<GroupRequestDTO>();

        for (RequestGroup requestGroup : list) {
            result.add(convertRequestGroup(requestGroup));
        }
        return result;
    }

    public static List<ExtendedRequestGroupDTO> convertExtendedRequestGroupList(List<ExtendedRequestGroup> list) {
        List<ExtendedRequestGroupDTO> result = new ArrayList<ExtendedRequestGroupDTO>();

        for (ExtendedRequestGroup requestGroup : list) {
            result.add(convertExtendedRequestGroup(requestGroup));
        }
        return result;
    }

    public static ExtendedRequestGroupDTO convertExtendedRequestGroup(ExtendedRequestGroup requestGroup) {
        if (requestGroup == null) {
            return null;
        }
        List<RequestDTO> requestDTO = convertRequestList(requestGroup.getRequests());
        ExtendedRequestGroupDTO result = new ExtendedRequestGroupDTO(requestGroup.getId(),
            requestGroup.getCreateDate(), requestGroup.getStatus(), requestDTO, requestGroup.getMenu().getName());
        return result;
    }

    public static TransactionDTO convertTransaction(Transaction transaction) {
        return new TransactionDTO(transaction.getId(), EntityToDTO.convertAccount(transaction.getAccount()),
            transaction.getCreateDate(), transaction.getOperatorName(), transaction.getBalance(),
            transaction.getAmount(), transaction.getType());
    }

    public static List<TransactionDTO> convertTrasactionList(List<Transaction> list) {
        List<TransactionDTO> result = new ArrayList<TransactionDTO>();

        for (Transaction transaction : list) {
            result.add(convertTransaction(transaction));
        }

        return result;
    }

    public static NotificationDTO convertNotification(Notification notification) {
        return new NotificationDTO(notification.getId(), notification.getCreateDate(), notification.getSenderName(),
            notification.getEmail(), notification.getText());
    }

    public static List<NotificationDTO> convertNotificationList(List<Notification> list) {
        List<NotificationDTO> result = new ArrayList<NotificationDTO>();

        for (Notification notification : list) {
            result.add(convertNotification(notification));
        }

        return result;
    }

    public static OperationDTO convertOperation(Operation operation) {
        return new OperationDTO(operation.getId(), operation.getCreateDate(), operation.getUserName(),
            operation.getType(), operation.getText());
    }

    public static List<OperationDTO> convertOperationList(List<Operation> list) {
        List<OperationDTO> result = new ArrayList<OperationDTO>();

        for (Operation operation : list) {
            result.add(convertOperation(operation));
        }

        return result;
    }

}
