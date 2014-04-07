package com.epam.feel.server.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.google.common.base.Objects;

/**
 * Entity for Notice_Sender table.
 * 
 * @author Evgeny_Neustroev
 */
@Entity (name = "Notification")
@Table (name = "notification")
@NamedQueries ({
        @NamedQuery (name = Notification.QUERY_FIND_ALL, query = "FROM Notification n"),
        @NamedQuery (name = Notification.QUERY_DELETE_BEFORE_DATE, query = "DELETE FROM Notification n WHERE n.createDate < :date")})
public class Notification extends BaseEntityImpl {

    private static final long serialVersionUID = 2261762136383015436L;

    public static final String QUERY_FIND_ALL = "findAllNotifications";
    public static final String QUERY_DELETE_BEFORE_DATE = "deleteNotificationsBeforeDate";

    public static final String DATE_COLUMN = "n.createDate";
    public static final String SENDER_NAME_COLUMN = "n.senderName";
    public static final String EMAIL_COLUMN = "n.email";
    public static final String TEXT_COLUMN = "n.text";

    @Id
    @SequenceGenerator (name = "notification_gen", sequenceName = "notification_seq")
    @GeneratedValue (generator = "notification_gen", strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "create_date")
    private Date createDate;

    @Column (name = "sender")
    private String senderName;

    @Column (name = "email")
    private String email;

    @Column (name = "text")
    private String text;

    public Notification() {}

    public Notification(Date createDate, String senderName, String email, String text) {
        this.createDate = createDate;
        this.senderName = senderName;
        this.email = email;
        this.text = text;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("Id", id).add("Creation date", createDate)
            .add("Sender name", senderName).add("Recepient email", email).add("Description", text)

            .toString();
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

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
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
