package com.practice.jpapraticerepo.practice.JPAprac.domain;

import com.practice.jpapraticerepo.practice.JPAprac.domain.enumType.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserHistory extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
