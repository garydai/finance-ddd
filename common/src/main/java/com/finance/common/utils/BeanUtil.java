package com.finance.common.utils;

import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @author hx_jrdz01
 */
public class BeanUtil extends org.springframework.beans.BeanUtils {

    /**
     * 实例化对象
     *
     * @param clazz 类
     * @return 对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T newInstance(Class<?> clazz) {
        return (T) instantiate(clazz);
    }
}
