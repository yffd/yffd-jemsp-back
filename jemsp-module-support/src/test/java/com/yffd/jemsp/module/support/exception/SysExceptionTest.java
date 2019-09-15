package com.yffd.jemsp.module.support.exception;

import org.junit.Test;

public class SysExceptionTest {

    @Test
    public void test() {
        try {
            m1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m1() {
        if (true)
//            throw JemspException.instance("测试异常");
            throw JemspException.instance("测试异常",
                    JemspException.instance("测试异常www"));

    }
}
