package com.epam.feel.server.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.epam.feel.shared.WebAppConstants;
import com.epam.feel.shared.enums.RequestStatus;
import com.google.common.base.Objects;
import com.google.gwt.user.datepicker.client.CalendarUtil;

/**
 * Entity for Request table.
 * 
 * @author Evgeny_Neustroev
 */
@Entity (name = "Request")
@Table (name = "request")
@NamedQueries ({
        @NamedQuery (name = Request.QUERY_FIND_BY_CLIENT_AND_STATUS, query = "SELECT r FROM Request r WHERE r.client ="
            + " :client AND r.status in (:statuses)"),
        @NamedQuery (name = Request.QUERY_FIND_ALL, query = "SELECT r FROM Request r"),
        @NamedQuery (name = Request.QUERY_FIND_BEFORE_DATE_WITH_STATUSES, query = "SELECT r FROM Request r " +
            "WHERE r.deliveryDate < :date and r.status in (:statuses)"),
        @NamedQuery (name = Request.QUERY_FIND_BY_MENU_CLIENT_AND_STATUSES, query = "select r from Request r "
            + " where exists(select rd from RequestDetails rd where r.id = rd.request.id"
            + " and rd.menuDetails.menu = :menu) "
            + " and r.client = :client "
            + " and r.status in (:statuses)"),
        @NamedQuery (name = Request.QUERY_FIND_BY_MENU_DETAILS_AND_STATUSES, query = "SELECT r FROM Request r " +
            "WHERE exists(select rd from RequestDetails rd where r.id = rd.request.id " +
            "and rd.menuDetails in (:details) and r.status in (:statuses))")})
public class Request extends BaseEntityImpl implements IRequest {

    private static final long serialVersionUID = -6188974149205013547L;

    public static final String QUERY_FIND_BY_CLIENT_AND_STATUS = "findRequestByClientAndStatus";
    public static final String QUERY_FIND_BY_MENU_CLIENT_AND_STATUSES = "findRequestByMenuDateAndStatuses";
    public static final String QUERY_FIND_BEFORE_DATE_WITH_STATUSES = "findBeforeDateWithStatuses";
    public static final String QUERY_FIND_ALL = "findAllRequests";
    public static final String QUERY_FIND_BY_MENU_DETAILS_AND_STATUSES = "findRequestsByMenuDetailsAndStatuses";

    @Id
    @SequenceGenerator (name = "request_gen", sequenceName = "request_seq")
    @GeneratedValue (generator = "request_gen", strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "client_id")
    private Client client;

    @Column (name = "create_date")
    private Date createDate;

    @Column (name = "delivery_date")
    private Date deliveryDate;

    @Column (name = "cost")
    private Double cost;

    @Column (name = "status")
    @Enumerated (EnumType.ORDINAL)
    private RequestStatus status;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "request", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<RequestDetails> requestDetails;

    public Request() {}

    public Request(Client client, Date createDate, RequestStatus status) {
        super();
        this.client = client;
        this.createDate = createDate;
        this.status = status;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("Request id", id).add("Request client", client)
            .add("Request date", createDate).add("Request status", status).toString();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public Set<RequestDetails> getRequestDetails() {
        return requestDetails;
    }

    public void setRequestDetails(Set<RequestDetails> requestDetails) {
        this.requestDetails = requestDetails;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void calculateCost() {
        Double cost = 0.0;
        for (RequestDetails dish : requestDetails) {
            cost += dish.getMenuDetails().getPrice() * dish.getCount();
        }
        setCost(cost);
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void calculateDeliveryDate() {
        deliveryDate = null;
        for (RequestDetails requestDetail : getRequestDetails()) {
            if (requestDetail.getMenuDetails().getMenu() != null) {
                Date requestDetailDate = requestDetail.getMenuDetails().getMenu().getDeliveryTo();
                if (deliveryDate == null)
                    deliveryDate = requestDetailDate;
                else if (requestDetailDate != null && deliveryDate.before(requestDetailDate)) {
                    deliveryDate = requestDetail.getMenuDetails().getMenu().getDeliveryTo();
                }
            }
        }
        if (deliveryDate == null) {
            deliveryDate = (Date) createDate.clone();
            CalendarUtil.addDaysToDate(deliveryDate, WebAppConstants.AVERAGE_DELIVERY_DAYS);
        }
    }

}
