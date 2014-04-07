package com.epam.feel.shared.dto;

import java.io.Serializable;
import java.util.Date;
import com.epam.feel.shared.enums.Role;

/**
 * Represents client DTO across the application.
 * 
 * @author Evgeny_Kincharov
 */

public class ClientDTO extends AccountDTO implements Serializable {
    private static final long serialVersionUID = -2147601885394526744L;

    private String email;
    private boolean advised;
    private Role role;

    public ClientDTO() {
        super();
    }

    public ClientDTO(Long id, Double balance, Double advance, Role role, String name, String email, Boolean advised,
        Date createDate) {
        super(id, name, balance, createDate, advance);
        this.role = role;
        this.email = email;
        this.advised = advised;
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

    public boolean isAdvised() {
        return advised;
    }

    public void setAdvised(boolean advised) {
        this.advised = advised;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("[").append(super.toString()).append("Email=").append(email)
            .append("; To send=").append(advised).append("; Role=").append(role).append("]").toString();
    }
}
