package com.practice.jpapraticerepo.practice.JPAprac.domain;
import com.practice.jpapraticerepo.practice.JPAprac.domain.entityListener.UserEntityListener;
import com.practice.jpapraticerepo.practice.JPAprac.domain.enumType.Gender;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@EntityListeners(value = UserEntityListener.class)
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated
    private Gender gender;

    @OneToMany(mappedBy = "user")
    private List<UserHistory> userHistories = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();

}
