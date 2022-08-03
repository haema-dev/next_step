package com.example.next_step.user;

import com.example.next_step.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    //@PersistenceContext
    //private EntityManager entityManager;

    @Test
    @Commit
    @Transactional
    void test(){

        //given
        User user = new User();
        user.setNickname("nextstep");
        user.setEmail("email@gmail.com");
        user.setPassword("7070");

        //entityManager.persist(user);

        //when
        Long savedUserId = userRepository.save(user);
        User findUser = userRepository.findOne(savedUserId);

        //entityManager.flush();

        //then
        Assertions.assertThat(findUser.getId()).isEqualTo(user.getId());

    }

}
