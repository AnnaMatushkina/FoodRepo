package com.epam.feel.shared.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Represents Account of user across the application.
 * 
 * @author Evgeny_Kincharov
 */
public class AccountDTO extends BaseDTO implements Serializable {
    private static final long serialVersionUID = -1456324328391427731L;

    private String name;
    private Double balance;
    private Date createDate;
    private Double advance;

    public AccountDTO() {
        super();
    }

    public AccountDTO(ClientDTO client) {
        this(client.getId(), client.getName(), client.getBalance(), client.getCreateDate(), client.getAdvance());
    }

    public AccountDTO(Long id, String name, Double balance, Date createDate, Double advance) {
        super(id);
        this.name = name;
        this.balance = balance;
        this.createDate = createDate;
        this.advance = advance;
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

    @Override
    public String toString() {
        return new StringBuilder().append("[").append(super.toString()).append("name=").append(name)
            .append("; balance=").append(balance).append("; advance=").append(advance).append("; creation date=")
            .append(createDate).append("]").toString();
    }
}
