package com.epam.feel.server.model;

/**
 * Interface representing request entity constants (used to improve readability).
 * 
 * @author Michael_Silvanovich
 */
public interface IRequest {

    public static final String ID_COLUMN = "r.id";
    public static final String DATE_COLUMN = "r.createDate";
    public static final String DELIVERY_DATE_COLUMN = "r.deliveryDate";
    public static final String STATUS_COLUMN = "r.status";
    public static final String CLIENT_NAME_COLUMN = "r.client.name";
    public static final String COST_COLUMN = "r.cost";

}