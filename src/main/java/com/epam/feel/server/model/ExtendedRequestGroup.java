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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.epam.feel.shared.enums.GroupStatus;
import com.google.common.base.Objects;

/**
 * Represents request's group information from ext_group_request_view view across application.
 * 
 * @author Michael_Silvanovich
 */
@Entity (name = "ExtendedRequestGroup")
@Table (name = "ext_group_request_view")
@NamedQueries ({
        @NamedQuery (name = ExtendedRequestGroup.QUERY_FIND_ALL, query = "SELECT rg FROM ExtendedRequestGroup rg"),
        @NamedQuery (name = ExtendedRequestGroup.QUERY_FIND_ACTIVE_GROUP_BY_MENU, query = "SELECT rg FROM ExtendedRequestGroup rg "
            + "where rg.status in (:statuses) and rg.menu = :menu")})
public class ExtendedRequestGroup extends BaseEntityImpl {

    private static final long serialVersionUID = -4998063305683572831L;

    public static final String QUERY_FIND_ALL = "getAllExtendedRequestGroups";
    public static final String QUERY_FIND_ACTIVE_GROUP_BY_MENU = "findExtendedActveGroupByMenu";

    public static final String ID_COLUMN = "rg.id";
    public static final String STATUS_COLUMN = "rg.status";
    public static final String DATE_COLUMN = "rg.createDate";
    public static final String MENU_NAME_COLUMN = "rg.menu.name";

    @Id
    @SequenceGenerator (name = "request_group_gen", sequenceName = "request_group_seq")
    @GeneratedValue (generator = "request_group_gen", strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "menu_id")
    private Menu menu;

    @OneToMany (orphanRemoval = false, fetch = FetchType.EAGER)
    @JoinColumn (name = "group_id")
    private Set<Request> requests;

    @Column (name = "create_date")
    private Date createDate;

    @Column (name = "status")
    @Enumerated (EnumType.ORDINAL)
    private GroupStatus status;

    public ExtendedRequestGroup() {}

    public ExtendedRequestGroup(Date createDate, GroupStatus status, Set<Request> requests) {
        super();
        this.createDate = createDate;
        this.status = status;
        this.requests = requests;
        Request request = requests.iterator().next();
        MenuDetails details = request.getRequestDetails().iterator().next().getMenuDetails();
        this.menu = details.getMenu();
    }

    public ExtendedRequestGroup(RequestGroup rg) {
        super();
        this.id = rg.getId();
        this.createDate = rg.getCreateDate();
        this.status = rg.getStatus();
        this.requests = rg.getRequests();
        Request request = requests.iterator().next();
        MenuDetails details = request.getRequestDetails().iterator().next().getMenuDetails();
        this.menu = details.getMenu();
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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

}
