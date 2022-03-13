package org.simbirsoft.dashboard.core.entity;


public class ValidationErrorInfo {
    private String fieldName;
    private String errorCode;
    private Object rejectedValue;
    private String errorMessage;

    public ValidationErrorInfo(String fieldName, String errorCode, Object rejectedValue, String errorMessage) {
        this.fieldName = fieldName;
        this.errorCode = errorCode;
        this.rejectedValue = rejectedValue;
        this.errorMessage = errorMessage;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
