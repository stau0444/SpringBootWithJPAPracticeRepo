package com.practice.jpapraticerepo.practice.webMVCprac.validator;

public class MustHaveException extends RuntimeException {

    private String message;


    public MustHaveException(String message) {
        super(message);
        this.message = message;
    }
}
