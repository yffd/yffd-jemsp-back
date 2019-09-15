package com.yffd.jemsp.module.support.exception;

public class ApiException extends SysException {
    private static final long serialVersionUID = 1115614811704338422L;
    private Integer code;//异常编号
    private String tip;//异常提示，主要用于前端提示
    private String msg;//异常信息，主要用于后端日志

    public ApiException(Integer code, String tip, String msg) {
        super(code, tip, msg);
        this.code = code;
        this.tip = tip;
        this.msg = msg;
    }

    public ApiException(Integer code, String tip, String msg, Throwable cause) {
        super(code, tip, msg, cause);
        this.code = code;
        this.tip = tip;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getTip() {
        return tip;
    }

    @Override
    public String getMsg() {
        return msg;
    }


    public static ApiException instance() {
        return new ApiException(SysExceptionEnum.API_EXCEPTION.code(), SysExceptionEnum.API_EXCEPTION.tip(),
                SysExceptionEnum.API_EXCEPTION.msg());
    }

    public static ApiException instance(String tip) {
        return new ApiException(SysExceptionEnum.API_EXCEPTION.code(), tip,
                SysExceptionEnum.API_EXCEPTION.msg());
    }

    public static ApiException instance(String tip, Throwable cause) {
        return new ApiException(SysExceptionEnum.API_EXCEPTION.code(), tip,
                SysExceptionEnum.API_EXCEPTION.msg(), cause);
    }


    public static ApiException API_EXCEPTION() {
        return new ApiException(SysExceptionEnum.API_EXCEPTION.code(), SysExceptionEnum.API_EXCEPTION.tip(),
                SysExceptionEnum.API_EXCEPTION.msg());
    }

    public static ApiException API_NOT_FOUND() {
        return new ApiException(SysExceptionEnum.API_NOT_FOUND.code(), SysExceptionEnum.API_NOT_FOUND.tip(),
                SysExceptionEnum.API_NOT_FOUND.msg());
    }

    public static ApiException API_NOT_SUPPORTED_METHOD() {
        return new ApiException(SysExceptionEnum.API_NOT_SUPPORTED_METHOD.code(), SysExceptionEnum.API_NOT_SUPPORTED_METHOD.tip(),
                SysExceptionEnum.API_NOT_SUPPORTED_METHOD.msg());
    }

    public static ApiException API_NOT_SUPPORTED_MEDIA_TYPE() {
        return new ApiException(SysExceptionEnum.API_NOT_SUPPORTED_MEDIA_TYPE.code(), SysExceptionEnum.API_NOT_SUPPORTED_MEDIA_TYPE.tip(),
                SysExceptionEnum.API_NOT_SUPPORTED_MEDIA_TYPE.msg());
    }

    public static ApiException API_NOT_ACCEPTABLE_MEDIA_TYPE() {
        return new ApiException(SysExceptionEnum.API_NOT_ACCEPTABLE_MEDIA_TYPE.code(),
                SysExceptionEnum.API_NOT_ACCEPTABLE_MEDIA_TYPE.tip(),
                SysExceptionEnum.API_NOT_ACCEPTABLE_MEDIA_TYPE.msg());
    }

    public static ApiException API_MISSING_REQUEST_PARAMETER() {
        return new ApiException(SysExceptionEnum.API_MISSING_REQUEST_PARAMETER.code(),
                SysExceptionEnum.API_MISSING_REQUEST_PARAMETER.tip(),
                SysExceptionEnum.API_MISSING_REQUEST_PARAMETER.msg());
    }

    public static ApiException API_NOT_SUPPORTED_CONVERSION() {
        return new ApiException(SysExceptionEnum.API_NOT_SUPPORTED_CONVERSION.code(),
                SysExceptionEnum.API_NOT_SUPPORTED_CONVERSION.tip(),
                SysExceptionEnum.API_NOT_SUPPORTED_CONVERSION.msg());
    }

    public static ApiException API_MESSAGE_NOT_READABLE() {
        return new ApiException(SysExceptionEnum.API_MESSAGE_NOT_READABLE.code(),
                SysExceptionEnum.API_MESSAGE_NOT_READABLE.tip(),
                SysExceptionEnum.API_MESSAGE_NOT_READABLE.msg());
    }

    public static ApiException API_MESSAGE_NOT_WRITABLE() {
        return new ApiException(SysExceptionEnum.API_MESSAGE_NOT_WRITABLE.code(),
                SysExceptionEnum.API_MESSAGE_NOT_WRITABLE.tip(),
                SysExceptionEnum.API_MESSAGE_NOT_WRITABLE.msg());
    }

    public static ApiException API_NOT_VALID_METHOD_ARGUMENT() {
        return new ApiException(SysExceptionEnum.API_NOT_VALID_METHOD_ARGUMENT.code(),
                SysExceptionEnum.API_NOT_VALID_METHOD_ARGUMENT.tip(),
                SysExceptionEnum.API_NOT_VALID_METHOD_ARGUMENT.msg());
    }


    public static ApiException API_ASYNC_REQUEST_TIMEOUT() {
        return new ApiException(SysExceptionEnum.API_ASYNC_REQUEST_TIMEOUT.code(),
                SysExceptionEnum.API_ASYNC_REQUEST_TIMEOUT.tip(),
                SysExceptionEnum.API_ASYNC_REQUEST_TIMEOUT.msg());
    }


}
