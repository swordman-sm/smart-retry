package com.github.smartretry.core.serializer;

import com.github.smartretry.core.factory.impl.DefaultRetryTaskFactory;

/**
 * 用于序列化、反序列化handle的请求参数
 *
 * @see DefaultRetryTaskFactory
 *
 * @author yuni[mn960mn@163.com]
 */
public interface RetrySerializer {

    /**
     * 序列化
     *
     * @param object
     * @return
     */
    String serialize(Object object);

    /**
     * 反序列化
     *
     * @param value
     * @param clazz
     * @return
     */
    Object deserialize(String value, Class<?> clazz);
}
