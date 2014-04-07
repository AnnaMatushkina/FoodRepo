package com.epam.feel.shared.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.epam.feel.shared.WebAppConstants;
import com.epam.feel.shared.enums.RequestStatus;
import com.google.gwt.user.datepicker.client.CalendarUtil;

/**
 * Represents order across the application.
 * 
 * @author Evgeny_Kincharov
 */
public class RequestDTO extends BaseDTO implements Serializable {
    private static final long serialVersionUID = -6188974149205013547L;

    private Date createDate;
    private Date deliveryDate;
    private RequestStatus status;
    private Double cost;
    private ClientDTO client;
    private List<RequestDetailsDTO> requestDetails;

    public RequestDTO() {
        super();
        this.cost = -1.0;
    }

    public RequestDTO(Long id, Date createDate, RequestStatus status, ClientDTO client) {
        super(id);
        this.createDate = createDate;
        this.status = status;
        this.client = client;
        this.cost = -1.0;
        this.deliveryDate = null;
    }

    public RequestDTO(Long id, Date createDate, Date deliveryDate, RequestStatus status, Double cost, ClientDTO client) {
        super(id);
        this.createDate = createDate;
        this.status = status;
        this.client = client;
        this.cost = cost;
        this.deliveryDate = deliveryDate;
    }

    /**
     * Return date delivery of order. If order has dishes where have optional field deliveryDate in menu.
     * 
     * @return Date
     */
    public Date getDeliveryDate() {
        if (deliveryDate == null) {
            for (RequestDetailsDTO requestDetail : getRequestDetails()) {
                if (requestDetail.getMenuDetails().getMenu() != null) {
                    Date requestDetailDate = requestDetail.getMenuDetails().getMenu().getDeliveryEndDate();
                    if (deliveryDate == null)
                        deliveryDate = requestDetailDate;
                    else if (requestDetailDate != null && deliveryDate.before(requestDetailDate)) {
                        deliveryDate = requestDetail.getMenuDetails().getMenu().getDeliveryEndDate();
                    }
                }
            }
            if (deliveryDate == null) {
                deliveryDate = (Date) createDate.clone();
                CalendarUtil.addDaysToDate(deliveryDate, WebAppConstants.AVERAGE_DELIVERY_DAYS);
            }
        }
        return deliveryDate;
    }

    /**
     * Return cost of order in rubles
     * 
     * @return Double
     */
    public Double getCost() {
        if (cost < 0 && requestDetails != null) {
            cost = 0.0;
            for (RequestDetailsDTO dish : requestDetails) {
                cost += dish.getMenuDetails().getPrice() * dish.getCount();
            }
        }
        return cost;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public List<RequestDetailsDTO> getRequestDetails() {
        if (requestDetails == null) {
            requestDetails = new ArrayList<RequestDetailsDTO>();
        }
        return requestDetails;
    }

    public void setRequestDetails(List<RequestDetailsDTO> requestDetails) {
        this.requestDetails = requestDetails;
    }

    public MenuDTO getMenu() {
        MenuDTO result = null;
        for (RequestDetailsDTO detail : requestDetails) {
            if ((detail.getMenuDetails() != null) && (detail.getMenuDetails().getMenu() != null)) {
                result = detail.getMenuDetails().getMenu();
                break;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("[").append(super.toString()).append("date=").append(createDate)
            .append("; status=").append(status).append("; client=").append(client).append("; requestDetails.size=")
            .append(String.valueOf(requestDetails.size())).append("]").toString();
    }

    public void copy(RequestDTO dto) {
        setId(dto.getId());
        this.client = dto.client;
        this.status = dto.status;
        this.cost = dto.cost;
        this.createDate = dto.createDate;
        this.requestDetails = dto.requestDetails;
    }
}
