package com.epam.feel.server.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import com.epam.feel.shared.enums.Role;
import com.google.common.base.Objects;

/**
 * Entity for Client table.
 * 
 * @author Evgeny_Neustroev
 */
@Entity (name = "Client")
@Table (name = "client")
@NamedQueries ({@NamedQuery (name = Client.QUERY_FIND_ALL, query = "FROM Client c"),
        @NamedQuery (name = Client.QUERY_FIND_BY_ROLE, query = "SELECT c FROM Client c WHERE c.role = :role"),
        @NamedQuery (name = Client.QUERY_FIND_BY_NAME, query = "SELECT c FROM Client c WHERE lower(c.name) like :name")})
public class Client extends AbstractClient implements IClient {

    private static final long serialVersionUID = -2147601885394526744L;

    public static final String QUERY_FIND_BY_ROLE = "findClientByRole";
    public static final String QUERY_FIND_ALL = "findAllClients";
    public static final String QUERY_FIND_BY_NAME = "findClientsByName";

    @Column (name = "role")
    @Enumerated (EnumType.ORDINAL)
    private Role role;

    @Column (name = "email")
    private String email;

    @Column (name = "advised")
    private Boolean advised;

    public Client() {}

    public Client(Double balance, Double advance, Role role, String name, String email, Date createDate, Boolean advised) {
        super(name, balance, createDate, advance);
        this.role = role;
        this.email = email;
        this.advised = advised;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("Client id", getId()).add("Balance", getBalance())
            .add("Advance", getAdvance()).add("Role", role).add("Name", getName()).add("Email", email)
            .add("Is advised", advised).add("Creation date", getCreateDate()).toString();
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAdvised() {
        return advised;
    }

    public void setAdvised(Boolean advised) {
        this.advised = advised;
    }

}
