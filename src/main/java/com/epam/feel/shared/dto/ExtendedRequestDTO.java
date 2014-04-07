package com.epam.feel.shared.dto;

import java.io.Serializable;
import java.util.Date;
import com.epam.feel.shared.enums.RequestStatus;

/**
 * Represents extended request DTO in application in some cases.
 * 
 * @author Michael_Silvanovich
 */
public class ExtendedRequestDTO extends RequestDTO implements Serializable {

    private static final long serialVersionUID = -5091717005203216939L;

    private String menuName;

    /**
     * Needed to satisfy serialization requirements
     */
    public ExtendedRequestDTO() {
        super();
    }

    public ExtendedRequestDTO(Long id, Date createDate, Date deliveryDate, RequestStatus status, Double cost,
        ClientDTO client, String menuName) {
        super(id, createDate, deliveryDate, status, cost, client);
        this.menuName = menuName;
    }

    public ExtendedRequestDTO(Long id, Date dateRequest, RequestStatus requestStatus, ClientDTO client, String menuName) {
        super(id, dateRequest, requestStatus, client);
        this.menuName = menuName;
    }

    /**
     * Returns menu name for this request
     * 
     * @return menu name
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * Sets menu name not for menu of this request, but for this dto
     * 
     * @param menuName
     *            menu name
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

}
