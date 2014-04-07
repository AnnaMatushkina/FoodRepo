package com.epam.feel.shared.dto;

import java.io.Serializable;
import java.util.Date;
import com.epam.feel.shared.enums.TransactionType;

/**
 * Represents history transaction DTO of personal account across the application.
 * 
 * @author Anna_Gavrilina
 */
public class TransactionDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = -930928031734537880L;

    private AccountDTO account;
    private Date createDate;
    private String operatorName;
    private Double balance;
    private Double amount;
    private TransactionType type;

    public TransactionDTO() {
        super();
    }

    public TransactionDTO(Long id, AccountDTO account, Date createDate, String operatorName, Double balance,
        Double amount, TransactionType text) {
        super(id);
        this.account = account;
        this.createDate = createDate;
        this.operatorName = operatorName;
        this.balance = balance;
        this.amount = amount;
        this.type = text;

    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString()).append("Account = ").append(account)
            .append("Creation date = ").append(createDate).append("Operator name = ").append(operatorName)
            .append("Balance before = ").append(balance).append("Amount = ").append(amount).append("Description = ")
            .append(type).toString();
    }

    public AccountDTO getAccount() {
        return account;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

}
