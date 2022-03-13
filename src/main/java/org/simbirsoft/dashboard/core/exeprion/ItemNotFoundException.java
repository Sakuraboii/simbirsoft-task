package org.simbirsoft.dashboard.core.exeprion;

public class ItemNotFoundException extends RestApiException{

    public ItemNotFoundException() {
        super();
    }

    public ItemNotFoundException(String message) {
        super(message);
    }

    public ItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getCode() {
        return ErrorCodes.ITEM_NOT_FOUND_ERROR;
    }
}
