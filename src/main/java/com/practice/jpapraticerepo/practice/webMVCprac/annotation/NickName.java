package com.practice.jpapraticerepo.practice.webMVCprac.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target(value = {ElementType.PARAMETER})
public @interface NickName {
    String message() default "{javax.validation.constraints.Email.message}";



}
