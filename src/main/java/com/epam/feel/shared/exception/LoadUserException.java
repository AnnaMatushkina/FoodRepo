package com.epam.feel.shared.exception;

import org.apache.commons.lang.exception.NestableRuntimeException;

/**
 * Exception to indicate an error while loading user information.
 * 
 * @author Anna_Gavrilina
 */
public class LoadUserException extends NestableRuntimeException {

    private static final long serialVersionUID = -6236460423974905577L;

    /**
     * Constructs a new instance of the {@link LoadUserException}
     * 
     * @param message
     *            the error message
     */
    public LoadUserException(String message) {
        super(message);
    }

    /**
     * Constructs a new instance of the {@link LoadUserException}
     * 
     * @param message
     *            the error message.
     * @param cause
     *            the exception or error that caused this exception to be thrown
     */
    public LoadUserException(String message, Throwable cause) {
        super(message, cause);
    }
}
