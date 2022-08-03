package com.example.next_step.user;

import com.example.next_step.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Commit
    @Transactional
    void test(){

        //given
        User user = new User();
        user.setNickname("nextstep");
        user.setEmail("email@gmail.com");
        user.setPassword("7070");

        //when
        Long savedUserId = userRepository.save(user);
        User findUser = userRepository.findOne(savedUserId);

        //then
        Assertions.assertThat(findUser.getId()).isEqualTo(user.getId());
    }
}
