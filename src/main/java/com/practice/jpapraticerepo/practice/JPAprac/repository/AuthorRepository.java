package com.practice.jpapraticerepo.practice.JPAprac.repository;

import com.practice.jpapraticerepo.practice.JPAprac.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
