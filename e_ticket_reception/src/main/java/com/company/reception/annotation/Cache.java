package com.company.reception.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Cache {

    String key() default "";

    Class type();

    long expire() default 60*60*2L;

}
