package com.epam.feel.server.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import com.google.common.base.Objects;

/**
 * Entity for Abstract Class for account/client entity.
 * 
 * @author Michael_Silvanovich
 */
@MappedSuperclass
public class AbstractClient extends BaseEntityImpl {

    private static final long serialVersionUID = -1456324328391427731L;

    @Id
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "balance")
    private Double balance;

    @Column (name = "create_date")
    private Date createDate;

    @Column (name = "advance")
    private Double advance;

    public AbstractClient() {}

    public AbstractClient(String name, Double balance, Date createDate, Double advance) {
        super();
        this.name = name;
        this.balance = balance;
        this.createDate = createDate;
        this.advance = advance;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("Account id", id).add("Name", name).add("Account balance", balance)
            .add("Creation date", createDate).toString();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Double getAdvance() {
        return advance;
    }

    public void setAdvance(Double advance) {
        this.advance = advance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
