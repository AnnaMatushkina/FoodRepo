package com.epam.feel.server.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.epam.feel.shared.enums.TransactionType;
import com.google.common.base.Objects;

/**
 * Entity for Transactions table.
 * 
 * @author Evgeny_Neustroev
 */
@Entity (name = "Transaction")
@Table (name = "transaction")
@NamedQueries ({
        @NamedQuery (name = Transaction.QUERY_FIND_ALL, query = "FROM Transaction t"),
        @NamedQuery (name = Transaction.QUERY_FIND_BY_ACCOUNT, query = "SELECT t FROM Transaction t WHERE t.account = :account"),
        @NamedQuery (name = Transaction.QUERY_FIND_BY_OPERATOR_NAME, query = "SELECT t FROM Transaction t WHERE t.operatorName = :operatorName"),
        @NamedQuery (name = Transaction.QUERY_COUNT_BY_OPERATOR_NAME, query = "SELECT count(t.operatorName) FROM Transaction t WHERE t.operatorName = :operatorName")/*,
        @NamedQuery (name = Transaction.QUERY_DELETE_BEFORE_DATE, query = "DELETE FROM Transaction t WHERE t.createDate < :date")*/})
public class Transaction extends BaseEntityImpl {

    private static final long serialVersionUID = -9025774117136056491L;

    public static final String QUERY_FIND_ALL = "findAllTransactions";
    public static final String QUERY_FIND_BY_ACCOUNT = "findTransactionsByAccount";
    public static final String QUERY_FIND_BY_OPERATOR_NAME = "findTransactionsByOperatorName";
    public static final String QUERY_COUNT_BY_OPERATOR_NAME = "getTransactionsByOperatorNameCount";
    public static final String QUERY_DELETE_BEFORE_DATE = "deleteTransactionsBeforeDate";

    public static final String BALANCE_COLUMN = "t.balance";
    public static final String DATE_COLUMN = "t.createDate";
    public static final String AMOUNT_COLUMN = "t.amount";
    public static final String OPERATOR_NAME_COLUMN = "t.operatorName";
    public static final String TYPE_COLUMN = "t.type";
    public static final String USER_NAME_COLUMN = "t.account.name";

    @Id
    @SequenceGenerator (name = "transaction_gen", sequenceName = "transaction_seq")
    @GeneratedValue (generator = "transaction_gen", strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "client_id")
    private Account account;

    @Column (name = "create_date")
    private Date createDate;

    @Column (name = "operator_name")
    private String operatorName;

    @Column (name = "balance")
    private Double balance;

    @Column (name = "amount")
    private Double amount;

    @Column (name = "transaction_type")
    @Enumerated (EnumType.ORDINAL)
    private TransactionType type;

    public Transaction() {}

    public Transaction(Account account, Date createDate, String operatorName, Double balance, Double amount,
        TransactionType type) {
        this.account = account;
        this.createDate = createDate;
        this.operatorName = operatorName;
        this.balance = balance;
        this.amount = amount;
        this.type = type;

    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("Transaction id", id).add("Account", account)
            .add("Creation date", createDate).add("Operator name", operatorName).add("Balance before", balance)
            .add("Amount of change", amount).add("Type", type.name()).toString();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
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
