package com.yffd.jemsp.module.support.exception;

public class JemspException extends SysException {
    private static final long serialVersionUID = 6827315044993641890L;
    private Integer code;//异常编号
    private String tip;//异常提示，主要用于前端提示
    private String msg;//异常信息，主要用于后端日志

    public JemspException(Integer code, String tip, String msg) {
        super(code, tip, msg);
        this.code = code;
        this.tip = tip;
        this.msg = msg;
    }

    public JemspException(Integer code, String tip, String msg, Throwable cause) {
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

    public static JemspException instance() {
        return new JemspException(SysExceptionEnum.JESMP_EXCEPTION.code(),
                SysExceptionEnum.JESMP_EXCEPTION.tip(),
                SysExceptionEnum.JESMP_EXCEPTION.msg());
    }

    public static JemspException instance(String tip) {
        return new JemspException(SysExceptionEnum.JESMP_EXCEPTION.code(), tip,
                SysExceptionEnum.JESMP_EXCEPTION.msg());
    }

    public static JemspException instance(Throwable cause) {
        return new JemspException(SysExceptionEnum.JESMP_EXCEPTION.code(),
                SysExceptionEnum.JESMP_EXCEPTION.tip(),
                SysExceptionEnum.JESMP_EXCEPTION.msg(), cause);
    }

    public static JemspException instance(String tip, Throwable cause) {
        return new JemspException(SysExceptionEnum.JESMP_EXCEPTION.code(), tip,
                SysExceptionEnum.JESMP_EXCEPTION.msg(), cause);
    }
}
