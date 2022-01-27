package com.github.smartretry.core;

import com.github.smartretry.core.handler.RetryHandler;

/**
 * @author yuni[mn960mn@163.com]
 */
@FunctionalInterface
public interface RetryTaskFactory {

    RetryTask create(RetryHandler<?, ?> retryHandler, Object params);
}
