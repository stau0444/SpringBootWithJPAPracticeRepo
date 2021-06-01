package com.practice.jpapraticerepo.practice.webMVCprac.advice;

import com.practice.jpapraticerepo.practice.webMVCprac.validator.MustHaveException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class GlobalAdvice {
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity<String> MissingServletRequestParameterException(MissingServletRequestParameterException e, HttpServletRequest request){

        return ResponseEntity.status(400).body("값이 잘못 입력되었습니다 돌아가기:");
    }

    @ExceptionHandler(value = MustHaveException.class)
    public ResponseEntity<String> MustHaveException(MustHaveException mhe){
        return ResponseEntity.status(400).body(mhe.getMessage());
    }
}
