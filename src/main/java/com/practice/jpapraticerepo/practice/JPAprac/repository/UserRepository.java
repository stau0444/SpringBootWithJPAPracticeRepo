package com.practice.jpapraticerepo.practice.JPAprac.repository;


import com.practice.jpapraticerepo.practice.JPAprac.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
