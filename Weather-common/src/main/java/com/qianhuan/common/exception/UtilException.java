package com.qianhuan.common.exception;

/**
 * 工具类异常
 *
 * @author yuluxingchen
 */
public class UtilException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public UtilException(Throwable e)
    {
        super(e.getMessage(), e);
    }

    public UtilException(String message)
    {
        super(message);
    }

    public UtilException(String message, Throwable throwable)
    {
        super(message, throwable);
    }
}
