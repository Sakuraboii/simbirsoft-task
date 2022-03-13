package org.simbirsoft.dashboard.core.entity;


public class ErrorInfo {

    private String code;
    private Object details;

    public ErrorInfo(String code, Object details) {
        this.code = code;
        this.details = details;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDetails(Object details) {
        this.details = details;
    }

    public String getCode() {
        return code;
    }

    public Object getDetails() {
        return details;
    }
}
