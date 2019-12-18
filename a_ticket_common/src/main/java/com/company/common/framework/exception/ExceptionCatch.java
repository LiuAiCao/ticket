package com.company.common.framework.exception;

import com.company.common.framework.model.response.BaseResponse;
import com.company.common.framework.model.response.code.BaseResultCode;
import com.company.common.framework.model.response.ResultCode;
import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ExceptionCatch {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatch.class);

    //使用EXCEPTIONS存放异常类型和错误代码的映射，ImmutableMap的特点的一旦创建不可改变，并且线程安全
    private static ImmutableMap<Class<? extends Throwable>,ResultCode> EXCEPTIONS;
    //使用builder来构建一个异常类型和错误代码的异常
    protected static ImmutableMap.Builder<Class<? extends Throwable>,ResultCode> builder = ImmutableMap.builder();



    //捕获 CustomException
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public BaseResponse customException(CustomException  e){
        LOGGER.error("catch exception : {}\r\nexception: ",e.getMessage(), e);
        ResultCode resultCode = e.getResultCode();
        BaseResponse baseResponse = new BaseResponse(resultCode);
        return baseResponse;
    }

    //捕获不可预知异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponse exception(Exception e){
        LOGGER.error("catch exception : {}\r\nexception: ",e.getMessage(), e);

        if(EXCEPTIONS == null){
            EXCEPTIONS = builder.build();
        }
        final ResultCode resultCode= EXCEPTIONS.get(e.getClass());
        final BaseResponse baseResponse;
        if(resultCode!=null){
            baseResponse = new BaseResponse(resultCode);
        }else{
            baseResponse = new BaseResponse(BaseResultCode.SERVER_ERROR);
        }
        return baseResponse;
    }

    static{ //在这里加入一些基础的异常类型判断
         builder.put(HttpMessageNotReadableException.class,BaseResultCode.INVALIDPARAM);
    }

}
