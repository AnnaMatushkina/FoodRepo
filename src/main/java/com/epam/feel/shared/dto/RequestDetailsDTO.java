package com.epam.feel.shared.dto;

import java.io.Serializable;

/**
 * Represents ordered requests DTO across the application.
 * 
 * @author Anna_Gavrilina
 */
public class RequestDetailsDTO extends BaseDTO implements Serializable {
    private static final long serialVersionUID = -8369700025137121743L;

    private int count;
    private RequestDTO request;
    private MenuDetailsDTO menuDetails;

    public RequestDetailsDTO() {
        super();
    }

    public RequestDetailsDTO(Long id, int count, RequestDTO request, MenuDetailsDTO menuDetails) {
        super(id);
        this.count = count;
        this.request = request;
        this.menuDetails = menuDetails;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public RequestDTO getRequest() {
        return request;
    }

    public void setRequest(RequestDTO request) {
        this.request = request;
    }

    public MenuDetailsDTO getMenuDetails() {
        return menuDetails;
    }

    public void setMenuDetails(MenuDetailsDTO menuDetails) {
        this.menuDetails = menuDetails;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("[").append(super.toString()).append("count=").append(count)
            .append("; request=").append(request).append("; menuDetails=").append(menuDetails).append("]").toString();
    }
}
