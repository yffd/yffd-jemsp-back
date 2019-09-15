package com.yffd.jemsp.module.support.result;

public enum ResultCode {
    SUCCESS(1, "成功"),
    FAIL(2, "失败"),

    ;
    private Integer code;
    private String tip;

    ResultCode(Integer code, String tip) {
        this.code = code;
        this.tip = tip;
    }

    public Integer code() {
        return code;
    }

    public String tip() {
        return tip;
    }

}
