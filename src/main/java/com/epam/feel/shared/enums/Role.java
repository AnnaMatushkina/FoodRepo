package com.epam.feel.shared.enums;

/**
 * Represents role of users.
 * 
 * @author Anna_Gavrilina
 */
public enum Role {
    ADMIN(0), CLIENT(1);

    private Integer id;

    private Role(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

}
