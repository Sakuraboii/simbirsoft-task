package org.simbirsoft.dashboard.core.exeprion;

public class ItemAlreadyExistException extends RestApiException{

    public ItemAlreadyExistException() {
        super();
    }

    public ItemAlreadyExistException(String message) {
        super(message);
    }

    public ItemAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getCode() {
        return ErrorCodes.ITEM_ALREADY_EXIST;
    }
}
