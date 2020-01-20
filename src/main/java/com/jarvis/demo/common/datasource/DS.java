package com.jarvis.demo.common.datasource;

import java.lang.annotation.*;

/**
 * @author yangkang
 * @version 2020年01月19日
 * @since
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DS {
    String value() default "defaultDS";
}
