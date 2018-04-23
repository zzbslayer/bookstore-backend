package com.zzbslayer.bookstore.model;

public class NaiveError {
    private String errorType;
    private String errorMsg;

    public NaiveError(String type, String msg){
        errorType = type;
        errorMsg = msg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorType() {
        return errorType;
    }
}
