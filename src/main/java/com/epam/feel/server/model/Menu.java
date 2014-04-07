package com.epam.feel.server.model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.epam.feel.shared.enums.MenuStatus;
import com.google.common.base.Objects;

/**
 * Entity for <code>Menu</code> table.
 * 
 * @author Evgeny_Neustroev
 */
@Entity (name = "Menu")
@Table (name = "menu")
@NamedQueries ({
        @NamedQuery (name = Menu.QUERY_FIND_ALL, query = "FROM Menu"),
        @NamedQuery (name = Menu.QUERY_CHECK_REQUEST_TIME, query = "FROM Menu m WHERE m.receptionTo<:date"),
        @NamedQuery (name = Menu.QUERY_FIND_LAST_MENU_EXCLUDING_STATUS, query = "FROM Menu m WHERE (m.menuOnDate >= :date OR :date <= deliveryTo) AND m.status not in :statuses order by m.menuOnDate desc"),
        @NamedQuery (name = Menu.QUERY_FIND_BY_STATUS_AND_DATE_OR_HAS_OPENED_REQUESTS, query = "SELECT m FROM Menu m WHERE exists (SELECT md FROM MenuDetails md, RequestDetails rd WHERE m.id = md.menu.id AND rd.menuDetails.id = md.id AND rd.request.status in (:request_statuses))"),
        @NamedQuery (name = Menu.QUERY_FIND_BY_STATUS_AND_DATE, query = "FROM Menu m WHERE m.status in (:statuses) AND m.receptionFrom <= :date AND m.receptionTo >= :date"),
        @NamedQuery (name = Menu.QUERY_FIND_ESTIMATED_MENUS_BY_DATE, query = "FROM Menu m WHERE m.deliveryTo < :date"),
        @NamedQuery (name = Menu.QUERY_FIND_MENU_BY_PERIOD, query = "FROM Menu m WHERE m.menuOnDate between :dateStart and :dateEnd AND m.status not in :statuses order by m.menuOnDate desc"),
        @NamedQuery (name = Menu.QUERY_FIND_MENU_FOR_CLONE_ON_NEXT_DAY, query = "FROM Menu m WHERE m.menuOnDate = :currentDate AND m.status = :status")})
public class Menu extends BaseEntityImpl {

    private static final long serialVersionUID = 3319514702268673169L;

    public static final String QUERY_FIND_ALL = "findAllMenusExcludingStatuses";
    public static final String QUERY_CHECK_REQUEST_TIME = "checkRequestTime";
    public static final String QUERY_FIND_LAST_MENU_EXCLUDING_STATUS = "findLastMenu";
    public static final String QUERY_FIND_ESTIMATED_MENUS_BY_DATE = "findEstimatedMenusByDate";
    public static final String QUERY_FIND_MENU_BY_PERIOD = "findMenuByPeriod";
    public static final String QUERY_FIND_BY_STATUS_AND_DATE = "findMenusByStatusAndDate";
    public static final String QUERY_FIND_MENU_FOR_CLONE_ON_NEXT_DAY = "findMenusForCloneOnnextDay";
    public static final String QUERY_FIND_BY_STATUS_AND_DATE_OR_HAS_OPENED_REQUESTS = "findMenusByStatusAndDateOrByHavingOpenedRequests";

    @Id
    @SequenceGenerator (name = "menu_gen", sequenceName = "menu_seq")
    @GeneratedValue (generator = "menu_gen", strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "status")
    @Enumerated (EnumType.ORDINAL)
    private MenuStatus status;

    @Column (name = "create_date")
    private Date createDate;

    @Column (name = "menu_on_date")
    private Date menuOnDate;

    @Column (name = "reception_from")
    private Date receptionFrom;

    @Column (name = "reception_to")
    private Date receptionTo;

    @Column (name = "delivery_from")
    private Date deliveryFrom;

    @Column (name = "delivery_to")
    private Date deliveryTo;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "menu", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<MenuDetails> menuDetails;

    public Menu() {}

    public Menu(String name, MenuStatus status, Date createDate, Date menuOnDate, Date receptionFrom, Date receptionTo,
        Date deliveryFrom, Date deliveryTo) {
        super();
        this.name = name;
        this.status = status;
        this.createDate = createDate;
        this.menuOnDate = menuOnDate;
        this.receptionFrom = receptionFrom;
        this.receptionTo = receptionTo;
        this.deliveryFrom = deliveryFrom;
        this.deliveryTo = deliveryTo;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("Menu id", id).add("Menu name", name).add("Menu status", status)
            .add("Menu creation date", createDate).add("Menu on date", menuOnDate).add("Reception from", receptionFrom)
            .add("Reception to", receptionTo).add("Delivery from", deliveryFrom).add("Delivery to", deliveryTo)
            .add("Menu details", menuDetails).toString();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public MenuStatus getStatus() {
        return status;
    }

    public void setStatus(MenuStatus status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getMenuOnDate() {
        return menuOnDate;
    }

    public void setMenuOnDate(Date menuOnDate) {
        this.menuOnDate = menuOnDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReceptionFrom() {
        return receptionFrom;
    }

    public void setReceptionFrom(Date receptionFrom) {
        this.receptionFrom = receptionFrom;
    }

    public Date getReceptionTo() {
        return receptionTo;
    }

    public void setReceptionTo(Date receptionTo) {
        this.receptionTo = receptionTo;
    }

    public Date getDeliveryFrom() {
        return deliveryFrom;
    }

    public void setDeliveryFrom(Date deliveryFrom) {
        this.deliveryFrom = deliveryFrom;
    }

    public Date getDeliveryTo() {
        return deliveryTo;
    }

    public void setDeliveryTo(Date deliveryTo) {
        this.deliveryTo = deliveryTo;
    }

    public List<MenuDetails> getMenuDetails() {
        return menuDetails;
    }

    public void setMenuDetails(List<MenuDetails> menuDetails) {
        this.menuDetails = menuDetails;
    }

    public void addMenuDetails(MenuDetails details) {
        if (this.menuDetails != null) {
            this.menuDetails.add(details);
        }
    }

}
