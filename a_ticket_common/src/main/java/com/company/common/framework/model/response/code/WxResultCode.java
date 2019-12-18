package com.company.common.framework.model.response.code;


import com.company.common.framework.model.response.ResultCode;

public enum WxResultCode implements ResultCode {
    ERROR_IP(false,24000,"IP未加入公众号白名单!"),
    ERROR_AUTHENTICATION(false,240001,"公众号未实名认证");

    private boolean success;

    private long code;

    private String message;


    WxResultCode(boolean success, long code, String message) {
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
