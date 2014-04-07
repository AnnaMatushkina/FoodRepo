package com.epam.feel.shared.dto;

import java.io.Serializable;
import java.util.Date;
import com.epam.feel.shared.enums.OperationType;

/**
 * Represents history DTO of menu across the application.
 * 
 * @author Anna_Gavrilina
 */
public class OperationDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = -6212812070647108085L;

    private Date createDate;
    private String userName;
    private OperationType type;
    private String text;

    public OperationDTO() {
        super();
    }

    public OperationDTO(Long id, Date createDate, String userName, OperationType type, String text) {
        super(id);
        this.createDate = createDate;
        this.userName = userName;
        this.type = type;
        this.text = text;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString()).append("Creation date = ").append(createDate)
            .append("User name = ").append(userName).append("Operation type").append(type).append("Text").append(text)
            .toString();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
