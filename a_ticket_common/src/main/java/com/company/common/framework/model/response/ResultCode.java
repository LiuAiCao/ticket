package com.company.common.framework.model.response;

public interface ResultCode {

    boolean success();

    long code();

    String message();
}
