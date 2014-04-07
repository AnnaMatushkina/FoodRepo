package com.epam.feel.shared.exception;

import java.io.Serializable;
import com.epam.feel.shared.dto.MenuDetailsDTO;

/**
 * Exception class. Used to retrieve information about lack of requested dishes to client.
 * 
 * @author Michael_Silvanovich
 */
public class EstimatedRequestDetailsException extends Exception implements Serializable {

    private static final long serialVersionUID = 8835600303466571171L;

    private Integer availableCount;
    private MenuDetailsDTO details;

    public EstimatedRequestDetailsException() {}

    public EstimatedRequestDetailsException(MenuDetailsDTO details, Integer availableCount) {
        this.details = details;
        this.availableCount = availableCount;
    }

    /**
     * Returns real available dishes count (corresponding to MenuDetailsDTO @see #getDetails())
     * 
     * @return real available dishes count
     */
    public Integer getAvailableCount() {
        return availableCount;
    }

    /**
     * Returns MenuDetailsDTO for dish
     * 
     * @return MenuDetailsDTO for dish
     */
    public MenuDetailsDTO getDetails() {
        return details;
    }

}
