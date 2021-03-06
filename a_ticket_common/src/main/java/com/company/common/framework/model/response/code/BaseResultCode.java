package com.company.common.framework.model.response.code;


import com.company.common.framework.model.response.ResultCode;

public enum  BaseResultCode implements ResultCode {
    SUSSESS(true,10000,"操作成功!"),
    FAIL(true,99999,"操作失败!"),
    SERVER_ERROR(false,500,"未知错误!"),
    INVALIDPARAM(false,99998,"传值错误");



    private boolean success;

    private long code;

    private String message;


    BaseResultCode(boolean success, long code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean success() {
        return this.success;
    }

    public long code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}
