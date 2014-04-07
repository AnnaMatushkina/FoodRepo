package com.epam.feel.server.model;

import com.google.common.base.Objects;

/**
 * Base class for persistent entities.
 * 
 * @author Evgeny_Neustroev
 */
@SuppressWarnings ("serial")
public abstract class BaseEntityImpl implements BaseEntity {

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        BaseEntity that = (BaseEntity) obj;
        return Objects.equal(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        if (getId() == null)
            return super.hashCode();
        else return Objects.hashCode(getId());
    }
}
