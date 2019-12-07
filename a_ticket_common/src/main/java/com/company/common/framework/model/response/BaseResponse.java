package com.company.common.framework.model.response;


public class BaseResponse implements Response{

        private boolean success = SUCCESS;

        private long code = SUCCESS_CODE;

        private String message = "";

    public BaseResponse(ResultCode resultCode) {
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
    }


    public static Response SUCCESS(){
        return new BaseResponse(BaseResultCode.SUSSESS);
    }

    public static Response FAIL(){
        return new BaseResponse(BaseResultCode.FAIL);
    }
}
