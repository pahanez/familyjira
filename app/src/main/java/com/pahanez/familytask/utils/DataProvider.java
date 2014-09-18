package com.pahanez.familytask.utils;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by pindziukou on 17.09.14.
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DataProvider {
    String value() default "";
}
