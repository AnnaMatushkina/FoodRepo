package com.epam.feel.server.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity for Account table.
 * 
 * @author Evgeny_Neustroev
 */
@Entity (name = "Account")
@Table (name = "client")
public class Account extends AbstractClient implements Cloneable {

    private static final long serialVersionUID = -1456324328391427731L;

    public Account() {}

    public Account(AbstractClient client) {
        super(client.getName(), client.getBalance(), client.getCreateDate(), client.getAdvance());
        setId(client.getId());
    }

    public Account(String name, Double balance, Date createDate, Double advance) {
        super(name, balance, createDate, advance);
    }

    @Override
    public Account clone() {
        return new Account(this);
    }

}
