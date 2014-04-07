package com.epam.feel.shared.exception;

/**
 * Exception used to signal that request can't be saved.
 * 
 * @author Michael_Silvanovich
 */
public class RequestCantBeSavedException extends Exception {

    private static final long serialVersionUID = 1900097111883554561L;

    public static final int EMPTY_REQUEST = 0;
    public static final int REGISTRED_REQUEST = 1;
    public static final int NOT_IN_PROCESS_REQUEST = 2;

    private Type type;

    /**
     * Needed to satisfy serialization rules
     */
    public RequestCantBeSavedException() {}

    public RequestCantBeSavedException(Type type) {
        this.type = type;
    }

    /**
     * Returns type of exception
     * 
     * @return type of exception
     */
    public Type getType() {
        return type;
    }

    public static enum Type {
        EMPTY_REQUEST, REGISTRED_REQUEST, NOT_IN_PROCESS_REQUEST;
    }

}
