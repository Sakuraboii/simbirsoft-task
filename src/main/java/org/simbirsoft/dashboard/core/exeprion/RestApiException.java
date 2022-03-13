package org.simbirsoft.dashboard.core.exeprion;

public class RestApiException extends RuntimeException {
    protected String code;

    public RestApiException() {
    }

    public RestApiException(String message) {
        super(message);
    }

    public RestApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getCode() {
        return ErrorCodes.GLOBAL_ERROR;
    }
}
