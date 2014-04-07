package com.epam.feel.shared.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.epam.feel.shared.enums.MenuStatus;

/**
 * Represents menu DTO across the application.
 * 
 * @author Evgeny_Neustroev
 */
public class MenuDTO extends BaseDTO implements Serializable, Cloneable {
    private static final long serialVersionUID = 3319514702268673169L;

    private Date menuOnDate;
    private String menuName;
    private Date createDate;
    private Date receiptStartDate;
    private Date receiptEndDate;
    private Date deliveryStartDate;
    private Date deliveryEndDate;
    private List<MenuDetailsDTO> menuDetails;
    private MenuStatus status;

    public MenuDTO(Long id, MenuStatus status, Date createDate, Date menuOnDate, String menuName,
        Date receiptStartDate, Date receiptEndDate, Date deliveryStartDate, Date deliveryEndDate) {
        super(id);
        this.status = status;
        this.createDate = createDate;
        this.menuOnDate = menuOnDate;
        this.menuName = menuName;
        this.receiptStartDate = receiptStartDate;
        this.receiptEndDate = receiptEndDate;
        this.deliveryStartDate = deliveryStartDate;
        this.deliveryEndDate = deliveryEndDate;
    }

    public MenuDTO() {
        super();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<MenuDetailsDTO> getMenuDetails() {
        if (menuDetails == null) {
            menuDetails = new ArrayList<MenuDetailsDTO>();
        }
        return menuDetails;
    }

    public void setMenuDetails(List<MenuDetailsDTO> menuDetails) {
        this.menuDetails = menuDetails;
    }

    public Date getReceiptStartDate() {
        return receiptStartDate;
    }

    public void setReceiptStartDate(Date receiptStartDate) {
        this.receiptStartDate = receiptStartDate;
    }

    public Date getReceiptEndDate() {
        return receiptEndDate;
    }

    public void setReceiptEndDate(Date receiptEndDate) {
        this.receiptEndDate = receiptEndDate;
    }

    public Date getDeliveryStartDate() {
        return deliveryStartDate;
    }

    public void setDeliveryStartDate(Date deliveryStartDate) {
        this.deliveryStartDate = deliveryStartDate;
    }

    public Date getDeliveryEndDate() {
        return deliveryEndDate;
    }

    public void setDeliveryEndDate(Date deliveryEndDate) {
        this.deliveryEndDate = deliveryEndDate;
    }

    public Date getMenuOnDate() {
        return menuOnDate;
    }

    public void setMenuOnDate(Date menuOnDate) {
        this.menuOnDate = menuOnDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public MenuStatus getStatus() {
        return status;
    }

    public void setStatus(MenuStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("[").append(super.toString()).append("Menu name=").append(menuName)
            .append("; Menu on date=").append(menuOnDate).append("; creation date=").append(createDate)
            .append("; Disches=").append(menuDetails).append("]").toString();
    }

    public MenuDTO clone() {
        MenuDTO result = new MenuDTO(null, status, createDate == null ? null : (Date) createDate.clone(),
            menuOnDate == null ? null : (Date) menuOnDate.clone(), menuName == null ? null : new String(menuName),
            receiptStartDate == null ? null : (Date) receiptStartDate.clone(),
            receiptEndDate == null ? null : (Date) receiptEndDate.clone(),
            deliveryStartDate == null ? null : (Date) deliveryStartDate.clone(),
            deliveryEndDate == null ? null : (Date) deliveryEndDate.clone());
        if (menuDetails != null) {
            List<MenuDetailsDTO> dishes = new ArrayList<MenuDetailsDTO>(menuDetails.size());
            for (MenuDetailsDTO dish : menuDetails) {
                dishes.add(dish.clone(result));
            }
            result.setMenuDetails(dishes);
        }
        result.setId(null);
        return result;
    }
}
