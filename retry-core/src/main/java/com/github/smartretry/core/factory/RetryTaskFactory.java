package com.github.smartretry.core.factory;

import com.github.smartretry.core.RetryTask;
import com.github.smartretry.core.handler.RetryHandler;

/**
 * @author yuni[mn960mn@163.com]
 */
@FunctionalInterface
public interface RetryTaskFactory {

    RetryTask create(RetryHandler<?, ?> retryHandler, Object params);
}
