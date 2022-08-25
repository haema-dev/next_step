package com.example.next_step.user;


import com.example.next_step.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * 회원가입
     * */
    public Long join(String user_id, String password, String nickname, String email){

        User user = User.builder() // builder 는 값을 생성해주는 것 (setter 가 아님) // Java 객체 생성 부분 공부 필요
                .user_id(user_id)
                .password(password)
                .nickname(nickname)
                .email(email)
                .build();

        //validateDuplicateUser(user);
        userRepository.save(user);
        return user.getId();
    }


    private void validateDuplicateUser(User user) {
        //boolean findUserId = userRepository.existsById(user.getId());
        //if (findUserId){
        //    throw new IllegalStateException("이미 존재하는 회원입니다.");
        //}
    }


}
