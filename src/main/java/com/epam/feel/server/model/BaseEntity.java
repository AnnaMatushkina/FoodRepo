package com.epam.feel.server.model;

import java.io.Serializable;

/**
 * Interface for persistent entities.
 * 
 * @author Maxim Tulupov (maxim_tulupov@epam.com)
 */
public interface BaseEntity extends Serializable {

    Long getId();

    void setId(Long id);
}
