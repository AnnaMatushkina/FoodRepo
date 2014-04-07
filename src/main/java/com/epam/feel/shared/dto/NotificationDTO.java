package com.epam.feel.shared.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Represents history DTO of notice sending email messages across the application.
 * 
 * @author Anna_Gavrilina
 */
public class NotificationDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = -3080496096697647655L;

    private Date createDate;
    private String sender;
    private String email;
    private String text;

    public NotificationDTO() {
        super();
    }

    public NotificationDTO(Long id, Date createDate, String sender, String email, String text) {
        super(id);
        this.createDate = createDate;
        this.sender = sender;
        this.email = email;
        this.text = text;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString()).append("Creation date = ").append(createDate)
            .append("Sender name = ").append(sender).append("Recepient email = ").append(email)
            .append("Description = ").append(text).toString();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
