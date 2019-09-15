package com.yffd.jemsp.module.support.log;

import org.slf4j.Logger;

public class LogHelper {

    public static void info(Logger logger, String msg, Throwable... throwable) {
        if (logger.isInfoEnabled()) logger.info(msg, throwable[0]);
    }

    public static void warn(Logger logger, String msg, Throwable... throwable) {
        if (logger.isWarnEnabled()) logger.warn(msg, throwable[0]);
    }

    public static void debug(Logger logger, String msg, Throwable... throwable) {
        if (logger.isDebugEnabled()) logger.debug(msg, throwable[0]);
    }

    public static void error(Logger logger, String msg, Throwable... throwable) {
        if (logger.isErrorEnabled()) logger.error(msg, throwable[0]);
    }
}
