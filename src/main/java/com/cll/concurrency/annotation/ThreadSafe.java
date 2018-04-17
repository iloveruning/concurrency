package com.cll.concurrency.annotation;

import java.lang.annotation.*;

/**
 * 线程安全注解(做标记用)
 *
 * @author chenliangliang
 * @date 2018/4/17
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface ThreadSafe {

    String value() default "";
}
