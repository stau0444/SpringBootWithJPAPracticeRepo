package com.practice.jpapraticerepo.practice.JPAprac.repository;

import com.practice.jpapraticerepo.practice.JPAprac.domain.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHistoryRepository extends JpaRepository<UserHistory,Long> {
}
