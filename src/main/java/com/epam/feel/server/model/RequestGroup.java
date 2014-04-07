package com.epam.feel.server.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.epam.feel.shared.enums.GroupStatus;
import com.google.common.base.Objects;

/**
 * Entity for RequestGroup table.
 * 
 * @author Evgeny_Neustroev
 */
@Entity (name = "RequestGroup")
@Table (name = "request_group")
@NamedQueries ({
        @NamedQuery (name = RequestGroup.QUERY_FIND_ALL, query = "SELECT rg FROM RequestGroup rg"),
        @NamedQuery (name = RequestGroup.QUERY_FIND_GROUP_FOR_REQUEST, query = "SELECT rg FROM RequestGroup rg "
            + "inner join rg.requests as r " + "where r.id = :request "),
        @NamedQuery (name = RequestGroup.QUERY_FIND_CLOSED_GROUPS_BEFORE_DATE, query = "SELECT distinct rg FROM RequestGroup rg "
            + "where rg.status in (:statuses) and rg.createDate < :date")})
public class RequestGroup extends BaseEntityImpl {

    private static final long serialVersionUID = -4998063305683572831L;

    public static final String QUERY_FIND_ALL = "getAllRequestGroups";
    public static final String QUERY_FIND_GROUP_FOR_REQUEST = "findGroupForRequest";
    public static final String QUERY_FIND_CLOSED_GROUPS_BEFORE_DATE = "findClosedGroupsBeforeDate";

    public static final String ID_COLUMN = "rg.id";
    public static final String STATUS_COLUMN = "rg.status";
    public static final String DATE_COLUMN = "rg.createDate";

    @Id
    @SequenceGenerator (name = "request_group_gen", sequenceName = "request_group_seq")
    @GeneratedValue (generator = "request_group_gen", strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany (orphanRemoval = false, fetch = FetchType.EAGER)
    @JoinColumn (name = "group_id")
    private Set<Request> requests;

    @Column (name = "create_date")
    private Date createDate;

    @Column (name = "status")
    @Enumerated (EnumType.ORDINAL)
    private GroupStatus status;

    public RequestGroup() {}

    public RequestGroup(Date createDate, GroupStatus status, Set<Request> requests) {
        super();
        this.createDate = createDate;
        this.status = status;
        this.requests = requests;
    }

    public RequestGroup(ExtendedRequestGroup erg) {
        super();
        this.id = erg.getId();
        this.createDate = erg.getCreateDate();
        this.status = erg.getStatus();
        this.requests = erg.getRequests();
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("Request gruop id", id).add("Request group date", createDate)
            .add("Request group status", status).add("Request group requests", requests).toString();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Set<Request> getRequests() {
        return requests;
    }

    public void setRequests(Set<Request> requests) {
        this.requests = requests;
    }

    public GroupStatus getStatus() {
        return status;
    }

    public void setStatus(GroupStatus status) {
        this.status = status;
    }

}
