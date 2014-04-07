package com.epam.feel.shared.dto;

import java.io.Serializable;

/**
 * Abstract class for DTOs in application.
 * 
 * @author Evgeny_Kincharov
 */
public abstract class BaseDTO implements Serializable {

    private static final long serialVersionUID = -8731511394256575420L;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BaseDTO() {}

    public BaseDTO(Long id) {
        this();
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        if (id == null)
            result = super.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BaseDTO other = (BaseDTO) obj;
        if (id == null) {
            return super.equals(obj);
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "; ID=" + id + "; ";
    }

}
