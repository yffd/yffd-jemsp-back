package com.yffd.jemsp.module.support.exception;

/**
 * 系统异常统一标准
 */
public abstract class SysException extends RuntimeException {
    private static final long serialVersionUID = -3218233739638650518L;

    public SysException(Integer code, String tip, String msg) {
        super(String.format("code:%s, tip:%s", code, tip));
    }

    public SysException(Integer code, String tip, String msg, Throwable cause) {
        super(String.format("code:%s, tip:%s", code, tip), cause);
    }

    @Override
    public String getMessage() {
        return String.format("code:%s, tip:%s, msg:%s", this.getCode(), this.getTip(), this.getMsg());
    }

    //异常编号
    public abstract Integer getCode();
    //异常提示，主要用于前端提示
    public abstract String getTip();
    //异常信息，主要用于后端日志
    public abstract String getMsg();

}
