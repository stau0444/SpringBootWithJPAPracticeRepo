package com.practice.jpapraticerepo.practice.webMVCprac.controller;

import com.practice.jpapraticerepo.practice.webMVCprac.annotation.MustHave;
import com.practice.jpapraticerepo.practice.webMVCprac.dto.UserDto;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostPersist;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api")
public class TestController {


    @GetMapping("/test")
    public String ControllerTest(){
        return "testOK";
    }

    @PostMapping("/exception")
    public UserDto exceptionHandlerTest(@Valid @RequestBody UserDto userDto){

        log.info("user:{}",userDto);

        return userDto;
    }

    @PostMapping("/filter")
    public ResponseEntity<UserDto> filter(@RequestBody UserDto userDto){
        log.info("controller 들어옴");
        log.info("userDto:{}",userDto);
        return ResponseEntity.status(200).body(userDto);
    }



}
