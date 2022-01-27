package com.github.smartretry.core.exception;

/**
 * @author yuni[mn960mn@163.com]
 */
public class IllegalRetryException extends RuntimeException {

    public IllegalRetryException(String message) {
        super(message);
    }
}