package com.example.crm.model;

public class CURDResult {

    private int success=1;
    private String msg = "";

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CURDResult(int success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public CURDResult() {
    }
}
