package com.mmnttech.ma.merchant.server.common.exception;

/**
 * @author Stelo
 * @createAt 2018/1/12
 **/
public class DatabaseException extends RuntimeException {

    private final transient Object[] parameters;

    public DatabaseException(String message) {
        this(message, null);
    }

    /**
     * @param message    异常信息
     * @param parameters parameters
     */
    public DatabaseException(String message, Object... parameters) {
        super(message);
        this.parameters = parameters;
    }

    public Object[] getParameters() {
        return parameters;
    }
}
