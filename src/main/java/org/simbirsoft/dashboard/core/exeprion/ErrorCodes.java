package org.simbirsoft.dashboard.core.exeprion;

public final class ErrorCodes {
    private ErrorCodes() {}

    public static final String ITEM_NOT_FOUND_ERROR = "err.item_not_found";
    public static final String GLOBAL_ERROR = "err.global";
    public static final String AUTHENTICATION_GLOBAL_ERROR = "err.auth_global";
    public static final String AUTHENTICATION_BAD_CREDENTIALS_ERROR = "err.auth_bad_credentials";
    public static final String AUTHENTICATION_JWT_TOKEN_INVALID = "err.auth_jwt_invalid";
    public static final String VALIDATION_FAILED_ERROR = "err.validation_failed";
    public static final String ITEM_ALREADY_EXIST = "err.item_already_exist";
}
