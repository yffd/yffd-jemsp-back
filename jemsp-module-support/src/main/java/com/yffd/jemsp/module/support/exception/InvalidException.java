package com.yffd.jemsp.module.support.exception;

public class InvalidException extends SysException {
    private static final long serialVersionUID = 8262173866930694925L;
    private Integer code;//异常编号
    private String tip;//异常提示，主要用于前端提示
    private String msg;//异常信息，主要用于后端日志

    private InvalidException(Integer code, String tip, String msg) {
        super(code, tip, msg);
        this.code = code;
        this.tip = tip;
        this.msg = msg;
    }

    private InvalidException(Integer code, String tip, String msg, Throwable cause) {
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


    public static InvalidException PARAM_IS_EMPTY() {
        return new InvalidException(SysExceptionEnum.PARAM_IS_EMPTY.code(), SysExceptionEnum.PARAM_IS_EMPTY.tip(),
                SysExceptionEnum.PARAM_IS_EMPTY.msg());
    }
    public static InvalidException PARAM_IS_EMPTY(String tip) {
        return new InvalidException(SysExceptionEnum.PARAM_IS_EMPTY.code(), tip, SysExceptionEnum.PARAM_IS_EMPTY.msg());
    }

    public static InvalidException PARAM_IS_INVALID() {
        return new InvalidException(SysExceptionEnum.PARAM_IS_INVALID.code(), SysExceptionEnum.PARAM_IS_INVALID.tip(),
                SysExceptionEnum.PARAM_IS_INVALID.msg());
    }
    public static InvalidException PARAM_IS_INVALID(String tip) {
        return new InvalidException(SysExceptionEnum.PARAM_IS_INVALID.code(), tip,
                SysExceptionEnum.PARAM_IS_INVALID.msg());
    }

    public static InvalidException DATA_EXSIST() {
        return new InvalidException(SysExceptionEnum.DATA_EXSIST.code(), SysExceptionEnum.DATA_EXSIST.tip(),
                SysExceptionEnum.DATA_EXSIST.msg());
    }
    public static InvalidException DATA_EXSIST(String tip) {
        return new InvalidException(SysExceptionEnum.DATA_EXSIST.code(), tip,
                SysExceptionEnum.DATA_EXSIST.msg());
    }

    public static InvalidException DATA_NOT_EXSIST() {
        return new InvalidException(SysExceptionEnum.DATA_NOT_EXSIST.code(), SysExceptionEnum.DATA_NOT_EXSIST.tip(),
                SysExceptionEnum.DATA_NOT_EXSIST.msg());
    }
    public static InvalidException DATA_NOT_EXSIST(String tip) {
        return new InvalidException(SysExceptionEnum.DATA_NOT_EXSIST.code(), tip,
                SysExceptionEnum.DATA_NOT_EXSIST.msg());
    }

    public static InvalidException OPERATION_UNSUPPORT() {
        return new InvalidException(SysExceptionEnum.OPERATION_UNSUPPORT.code(), SysExceptionEnum.OPERATION_UNSUPPORT.tip(),
                SysExceptionEnum.OPERATION_UNSUPPORT.msg());
    }

}
