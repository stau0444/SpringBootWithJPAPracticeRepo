package com.practice.jpapraticerepo.practice.JPAprac.repository;

import com.practice.jpapraticerepo.practice.JPAprac.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
