package com.epam.feel.server.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.epam.feel.shared.enums.OperationType;
import com.google.common.base.Objects;

/**
 * Represents history of changing anything (menu, requests and request groups, etc.) across application.
 * 
 * @author Evgeny_Neustroev
 */
@Entity (name = "Operation")
@Table (name = "operation")
@NamedQueries ({
        @NamedQuery (name = Operation.QUERY_FIND_ALL, query = "FROM Operation o ORDER BY o.createDate DESC"),
        @NamedQuery (name = Operation.QUERY_FIND_BY_TYPE, query = "SELECT o FROM Operation o WHERE o.type = :type"),
        @NamedQuery (name = Operation.QUERY_FIND_BY_USER_NAME, query = "SELECT o FROM Operation o WHERE o.userName = :userName ORDER BY o.createDate DESC"),
        @NamedQuery (name = Operation.QUERY_DELETE_BEFORE_DATE, query = "DELETE FROM Operation o WHERE o.createDate < :date")})
public class Operation extends BaseEntityImpl {

    private static final long serialVersionUID = 8363125851260185883L;

    public static final String QUERY_FIND_ALL = "findAllOperations";
    public static final String QUERY_FIND_BY_TYPE = "findOperationsByType";
    public static final String QUERY_FIND_BY_USER_NAME = "findOperationsByUserName";
    public static final String QUERY_DELETE_BEFORE_DATE = "deleteOperationsBeforeDate";

    public static final String DATE_COLUMN = "o.createDate";
    public static final String USER_NAME_COLUMN = "o.userName";
    public static final String TEXT_COLUMN = "o.text";

    @Id
    @SequenceGenerator (name = "operation_gen", sequenceName = "operation_seq")
    @GeneratedValue (generator = "operation_gen", strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "create_date")
    private Date createDate;

    @Column (name = "user_name")
    private String userName;

    @Column (name = "change_type")
    @Enumerated (EnumType.ORDINAL)
    private OperationType type;

    @Column (name = "text")
    private String text;

    public Operation() {}

    public Operation(Date createDate, String userName, OperationType type, String text) {
        super();
        this.createDate = createDate;
        this.userName = userName;
        this.type = type;
        this.text = text;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("Id", id).add("Creation date", createDate).add("User name", userName)
            .add("Operation type", type).add("Text", text).toString();
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
