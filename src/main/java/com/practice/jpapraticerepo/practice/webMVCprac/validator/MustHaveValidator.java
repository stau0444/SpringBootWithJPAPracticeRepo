package com.practice.jpapraticerepo.practice.webMVCprac.validator;

import com.practice.jpapraticerepo.practice.webMVCprac.annotation.MustHave;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MustHaveValidator implements ConstraintValidator<MustHave,String> {

    private String value;
    private String mustInclude;
    private String message;

    @Override
    public void initialize(MustHave constraintAnnotation) {
        this.value = constraintAnnotation.value();
        this.mustInclude = constraintAnnotation.mustInclude();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(!(value.contains(mustInclude) && value.length()>0 && value.length() < Integer.parseInt(this.value))){
            throw new MustHaveException(message);
        }
        return true;
    }
}
