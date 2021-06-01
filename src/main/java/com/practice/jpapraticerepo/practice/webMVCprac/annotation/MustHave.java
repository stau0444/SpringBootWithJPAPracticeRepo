package com.practice.jpapraticerepo.practice.webMVCprac.annotation;

import com.practice.jpapraticerepo.practice.webMVCprac.validator.MustHaveValidator;
import com.sun.istack.Nullable;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Null;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = {MustHaveValidator.class})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface MustHave {
    String message() default "nickname 의 길이는 1자 이상 10자 이하이며 , 'ugo'를 포함해야합니다.";


    String value();

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String mustInclude();
}
