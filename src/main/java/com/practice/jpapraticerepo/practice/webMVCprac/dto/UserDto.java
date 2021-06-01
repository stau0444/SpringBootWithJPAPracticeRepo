package com.practice.jpapraticerepo.practice.webMVCprac.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.practice.jpapraticerepo.practice.webMVCprac.annotation.MustHave;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    private Long id;
    private String name;
    private String email;
    @MustHave(value = "10" , mustInclude = "ugo")
    private String nickname;
}
