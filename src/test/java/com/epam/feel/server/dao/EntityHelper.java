package com.epam.feel.server.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang.time.DateUtils;
import org.joda.time.LocalDate;
import com.epam.feel.server.model.Account;
import com.epam.feel.server.model.Client;
import com.epam.feel.server.model.DishType;
import com.epam.feel.server.model.ExtendedRequest;
import com.epam.feel.server.model.Menu;
import com.epam.feel.server.model.MenuDetails;
import com.epam.feel.server.model.Notification;
import com.epam.feel.server.model.Operation;
import com.epam.feel.server.model.Request;
import com.epam.feel.server.model.RequestDetails;
import com.epam.feel.server.model.RequestGroup;
import com.epam.feel.server.model.Transaction;
import com.epam.feel.shared.enums.GroupStatus;
import com.epam.feel.shared.enums.MenuStatus;
import com.epam.feel.shared.enums.OperationType;
import com.epam.feel.shared.enums.RequestStatus;
import com.epam.feel.shared.enums.Role;
import com.epam.feel.shared.enums.TransactionType;

/**
 * Helper class for create entities on test.
 * 
 * @author Evgeny_Neustroev
 */
public final class EntityHelper {

    public static final int MAX_COUNT = 3;

    public static final Long DEFAULT_ID = 0l;
    public static final String DEFAULT_TEXT = "Default text";
    public static final TransactionType DEFAULT_TRANSACTION_TYPE = TransactionType.ADVANCE_PAYMENT;
    public static final Date DEFAULT_DATE = new Date();
    public static final Date DEFAULT_MENU_ON_DATE = new LocalDate().toDate();
    public static final Integer DEFAULT_INT = 500 + MAX_COUNT;
    public static final Double DEFAULT_DOUBLE = 13.53;
    public static final Boolean DEFAULT_BOOLEAN = false;
    public static final Boolean DEFAULT_MENU_DETAILS_ALIVE = true;

    public static final MenuStatus DEFAULT_MENU_STATUS = MenuStatus.AVAILABLE;
    public static final RequestStatus DEFAULT_REQUEST_STATUS = RequestStatus.IN_PROCESS;
    public static final GroupStatus DEFAULT_GROUP_STATUS = GroupStatus.DRAFT;
    public static final Role DEFAULT_ROLE = Role.CLIENT;
    public static final OperationType DEFAULT_OPERATION_TYPE = OperationType.MENU_CHANGED;

    /**
     * Creates new Account entity
     * 
     * @return Account entity
     */
    public static Account createAccount() {
        Account account = new Account(DEFAULT_TEXT, DEFAULT_DOUBLE, DEFAULT_DATE, DEFAULT_DOUBLE);
        account.setId(EntityHelper.DEFAULT_ID);
        return account;
    }

    /**
     * Creates new Client entity without requests
     * 
     * @return Client entity
     */
    public static Client createClient(Role role) {
        Client client = new Client(DEFAULT_DOUBLE, DEFAULT_DOUBLE, role, DEFAULT_TEXT, DEFAULT_TEXT, DEFAULT_DATE,
            false);
        client.setId((long) role.getId() + 1000);
        // ADMIN - 1000, CLIENT - 1001
        return client;
    }

    /**
     * Creates new Client entity with Requests
     * 
     * @return Client entity
     */
    public static Client createClient(Role role, Menu menu) {
        Client result = createClient(role);
        List<Request> reqList = new ArrayList<Request>();
        reqList.add(EntityHelper.createRequest(RequestStatus.IN_PROCESS, result, menu));
        return result;
    }

    /**
     * Creates new DishType entity
     * 
     * @return DishType entity
     */
    public static DishType createDishType() {
        return new DishType(0L, DEFAULT_TEXT);
    }

    /**
     * Creates new Operation entity
     * 
     * @return Operation entity
     */
    public static Operation createOperation() {
        return new Operation(DEFAULT_DATE, DEFAULT_TEXT, DEFAULT_OPERATION_TYPE, DEFAULT_TEXT);
    }

    /**
     * Creates new Menu entity
     * 
     * @return v entity
     */
    public static Menu createMenu(MenuStatus status) {
        Menu menu = new Menu(DEFAULT_TEXT, status, DEFAULT_DATE, DEFAULT_MENU_ON_DATE, DEFAULT_DATE, DateUtils.addDays(
            DEFAULT_DATE, 1), DEFAULT_DATE, DEFAULT_DATE);

        List<MenuDetails> menuDetails = new ArrayList<MenuDetails>();
        for (int i = 0; i < MAX_COUNT; i++) {
            menuDetails.add(createMenuDetails(menu));
        }
        menu.setMenuDetails(menuDetails);

        return menu;
    }

    /**
     * Creates new MenuDetails entity
     * 
     * @return MenuDetails entity
     */
    public static MenuDetails createMenuDetails(Menu menu) {
        MenuDetails result = new MenuDetails(menu, DEFAULT_BOOLEAN, DEFAULT_MENU_DETAILS_ALIVE, createDishType(),
            DEFAULT_TEXT, new Double(DEFAULT_DOUBLE), DEFAULT_INT, DEFAULT_INT, DEFAULT_TEXT, null, DEFAULT_TEXT);
        return result;
    }

    /**
     * Creates new NoticeSender entity
     * 
     * @return NoticeSender entity
     */
    public static Notification createNotification() {
        return new Notification(DEFAULT_DATE, DEFAULT_TEXT, DEFAULT_TEXT, DEFAULT_TEXT);
    }

    /**
     * Creates new Request entity
     * 
     * @return Request entity
     */
    public static Request createRequest(RequestStatus status, Client client, Menu menu) {
        Request request = new Request(client, DEFAULT_DATE, status);

        MenuDetails details = menu.getMenuDetails().get(0);

        Set<RequestDetails> requestDetails = new HashSet<RequestDetails>();
        for (int i = 0; i < MAX_COUNT; ++i) {
            requestDetails.add(createRequestDetails(request, details));
        }

        request.setRequestDetails(requestDetails);
        request.calculateCost();
        request.calculateDeliveryDate();

        return request;
    }

    public static ExtendedRequest createExtendedRequest(RequestStatus status, Client client, Menu menu) {
        ExtendedRequest extRequest = new ExtendedRequest(client, DEFAULT_DATE, status);
        Request request = new Request(client, DEFAULT_DATE, status);

        MenuDetails details = menu.getMenuDetails().get(0);

        Set<RequestDetails> requestDetails = new HashSet<RequestDetails>();
        for (int i = 0; i < MAX_COUNT; ++i) {
            requestDetails.add(createRequestDetails(request, details));
        }

        extRequest.setRequestDetails(requestDetails);
        extRequest.calculateCost();
        extRequest.calculateDeliveryDate();

        return extRequest;
    }

    /**
     * Creates new RequestDetails entity
     * 
     * @return RequestDetails entity
     */
    public static RequestDetails createRequestDetails(Request request, MenuDetails details) {
        return new RequestDetails(MAX_COUNT, request, details);
    }

    /**
     * Creates new RequestGroup entity
     * 
     * @return RequestGroup entity
     */
    public static RequestGroup createRequestGroup(GroupStatus status, List<Request> requests) {
        return new RequestGroup(DEFAULT_DATE, status, new HashSet<Request>(
            requests != null ? requests : Collections.<Request> emptySet()));
    }

    /**
     * Creates new Transaction entity
     * 
     * @return Transaction entity
     */
    public static Transaction createTransaction(Account account) {
        return new Transaction(account, DEFAULT_DATE, DEFAULT_TEXT, DEFAULT_DOUBLE, (DEFAULT_DOUBLE / 2),
            DEFAULT_TRANSACTION_TYPE);
    }

}
