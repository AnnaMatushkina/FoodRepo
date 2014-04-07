package com.epam.feel.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.google.common.base.Objects;

/**
 * Entity for Request_Details table.
 * 
 * @author Evgeny_Neustroev
 */
@Entity (name = "RequestDetails")
@Table (name = "request_details")
@NamedQueries ({
        @NamedQuery (name = RequestDetails.QUERY_REQUESTED_MENU_DETAILS_COUNT, query = "SELECT sum(rd.count) FROM RequestDetails rd WHERE rd.menuDetails = :menuDetails and rd.request.status not in :excluded_statuses"),
        @NamedQuery (name = RequestDetails.QUERY_ALL_REQUESTED_MENU_DETAILS_COUNT, query = "SELECT sum(rd.count) FROM RequestDetails rd WHERE rd.menuDetails = :menuDetails"),
        @NamedQuery (name = RequestDetails.QUERY_REQUESTED_MENU_DETAILS_EXCLUDING_CURRENT_COUNT, query = "SELECT sum(rd.count) FROM RequestDetails rd WHERE rd.menuDetails = :menuDetails and rd.request.status not in :excluded_statuses and rd.request != :request"),
        @NamedQuery (name = RequestDetails.QUERY_REQUESTED_MENU_DETAILS_BY_MENU_COUNT, query = "SELECT count(distinct rd.count) FROM RequestDetails rd inner join rd.menuDetails as md WHERE rd.menuDetails.menu = :menu and rd.request.status in :statuses")})
public class RequestDetails extends BaseEntityImpl {

    public static final String QUERY_REQUESTED_MENU_DETAILS_COUNT = "getRequestedCountForMenuDetails";
    public static final String QUERY_REQUESTED_MENU_DETAILS_EXCLUDING_CURRENT_COUNT = "getRequestedExcludingRequestCountForMenuDetails";
    public static final String QUERY_REQUESTED_MENU_DETAILS_BY_MENU_COUNT = "getRequestedMenuDetailsByMenuCount";
    public static final String QUERY_ALL_REQUESTED_MENU_DETAILS_COUNT = "getAllRequestedCountForMenuDetails";

    private static final long serialVersionUID = -8369700025137121743L;

    @Id
    @SequenceGenerator (name = "request_details_gen", sequenceName = "request_details_seq")
    @GeneratedValue (generator = "request_details_gen", strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "count")
    private int count;

    @ManyToOne
    @JoinColumn (name = "request_id")
    private Request request;

    @ManyToOne
    @JoinColumn (name = "menu_details_id")
    private MenuDetails menuDetails;

    public RequestDetails() {}

    public RequestDetails(int count, Request request, MenuDetails menuDetails) {
        super();
        this.count = count;
        this.request = request;
        this.menuDetails = menuDetails;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("Request details id", id).add("Request count", count)
            .add("Request", request).add("Menu details", menuDetails).toString();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public MenuDetails getMenuDetails() {
        return menuDetails;
    }

    public void setMenuDetails(MenuDetails menuDetails) {
        this.menuDetails = menuDetails;
    }

}
