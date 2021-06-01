package com.practice.jpapraticerepo.practice.JPAprac.domain.entityListener;


import com.practice.jpapraticerepo.practice.JPAprac.domain.User;
import com.practice.jpapraticerepo.practice.JPAprac.domain.UserHistory;
import com.practice.jpapraticerepo.practice.JPAprac.repository.UserHistoryRepository;
import com.practice.jpapraticerepo.practice.JPAprac.support.BeanUtil;
import org.springframework.stereotype.Component;

import javax.persistence.*;

//엔티티 리스너가 컴포넌트로
@Component
public class UserEntityListener {
    @PostPersist
    @PostUpdate
    public void postPersistAndPreUpdate(Object o){


        UserHistoryRepository userHistoryRepository = BeanUtil.getBean(UserHistoryRepository.class);
        UserHistory userHistory = new UserHistory();

        User user = null;

        if(o instanceof User && o != null){
            user = (User)o;
        }

        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());
        userHistory.setGender(user.getGender());

        userHistoryRepository.save(userHistory);

    }
}
