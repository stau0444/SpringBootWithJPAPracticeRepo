package com.practice.jpapraticerepo.practice.JPAprac.repository;

import com.practice.jpapraticerepo.practice.JPAprac.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
