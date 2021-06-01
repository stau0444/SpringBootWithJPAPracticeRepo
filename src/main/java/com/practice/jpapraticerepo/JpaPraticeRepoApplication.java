package com.practice.jpapraticerepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@EnableJpaAuditing
@ServletComponentScan
public class JpaPraticeRepoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaPraticeRepoApplication.class, args);
    }

}
