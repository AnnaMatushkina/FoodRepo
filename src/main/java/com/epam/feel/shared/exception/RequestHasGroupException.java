package com.epam.feel.shared.exception;

/**
 * Exception used to signal that request can't be deleted without confirmation, because it is in group.
 * 
 * @author Michael_Silvanovich
 */
public class RequestHasGroupException extends Exception {

    private static final long serialVersionUID = 1631293261579741910L;

    /**
     * Needed to satisfy serialization rules
     */
    public RequestHasGroupException() {}

}
