package com.github.smartretry.core.processor.impl;

import com.github.smartretry.core.factory.impl.DefaultRetryTaskFactory;
import com.github.smartretry.core.handler.RetryHandler;
import com.github.smartretry.core.processor.RetryHandlerPostProcessor;
import com.github.smartretry.core.factory.RetryTaskFactory;
import com.github.smartretry.core.dao.RetryTaskMapper;
import com.github.smartretry.core.handler.impl.ImmediatelyRetryHandler;
import com.github.smartretry.core.handler.impl.def.DefaultRetryHandler;
import com.github.smartretry.core.handler.GenericRetryHandler;

/**
 * @author yuni[mn960mn@163.com]
 */
public class DefaultRetryHandlerPostProcessor implements RetryHandlerPostProcessor<Object, Object> {

    private RetryTaskFactory retryTaskFactory;

    private RetryTaskMapper retryTaskMapper;

    private boolean beforeTask;

    public DefaultRetryHandlerPostProcessor(RetryTaskMapper retryTaskMapper, boolean beforeTask) {
        this(new DefaultRetryTaskFactory(), retryTaskMapper, beforeTask);
    }

    public DefaultRetryHandlerPostProcessor(RetryTaskFactory retryTaskFactory, RetryTaskMapper retryTaskMapper, boolean beforeTask) {
        this.retryTaskFactory = retryTaskFactory;
        this.retryTaskMapper = retryTaskMapper;
        this.beforeTask = beforeTask;
    }

    @Override
    public RetryHandler<Object, Object> doPost(RetryHandler<Object, Object> retryHandler) {
        if (retryHandler instanceof GenericRetryHandler) {
            return new ImmediatelyRetryHandler((GenericRetryHandler) retryHandler, retryTaskFactory, retryTaskMapper, beforeTask);
        }
        return new ImmediatelyRetryHandler(new DefaultRetryHandler(retryHandler), retryTaskFactory, retryTaskMapper, beforeTask);
    }
}
