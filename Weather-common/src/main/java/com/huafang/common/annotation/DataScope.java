package com.huafang.common.annotation;

import java.lang.annotation.*;

/**
 * 数据权限过滤注解
 *
 * @author yuluxingchen
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope {
    /**
     * 用户表的别名
     */
    public String userAlias() default "";
}
