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
        user.setUser_id("nextstep");
        user.setPassword("1234");
        user.setNickname("넥스트스탭");
        user.setEmail("이메일@gmail.com");

        //when
        Long savedUserId = userRepository.save(user);
        User findUser = userRepository.findOne(savedUserId);

        //then
        Assertions.assertThat(findUser.getId()).isEqualTo(user.getId());
    }
}
