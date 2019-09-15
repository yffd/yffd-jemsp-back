package com.yffd.jemsp.module.support.exception;

public class ServiceException extends SysException {
    private static final long serialVersionUID = -1626647183352145000L;

    private Integer code;//异常编号
    private String tip;//异常提示，主要用于前端提示
    private String msg;//异常信息，主要用于后端日志

    private ServiceException(Integer code, String tip, String msg) {
        super(code, tip, msg);
        this.code = code;
        this.tip = tip;
        this.msg = msg;
    }

    private ServiceException(Integer code, String tip, String msg, Throwable cause) {
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


    public static ServiceException instance() {
        return new ServiceException(SysExceptionEnum.SERVICE_EXCEPTION.code(), SysExceptionEnum.SERVICE_EXCEPTION.tip(),
                SysExceptionEnum.SERVICE_EXCEPTION.msg());
    }

    public static ServiceException instance(String tip) {
        return new ServiceException(SysExceptionEnum.SERVICE_EXCEPTION.code(), tip, SysExceptionEnum.SERVICE_EXCEPTION.msg());
    }

    public static ServiceException instance(String tip, Throwable cause) {
        return new ServiceException(SysExceptionEnum.SERVICE_EXCEPTION.code(), tip, SysExceptionEnum.SERVICE_EXCEPTION.msg(), cause);
    }

}
