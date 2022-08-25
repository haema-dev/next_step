package com.example.next_step.user;

import com.example.next_step.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepository {

    //Spring Data JPA 를 사용하지 않고 순수 JPA 로 EntityManager 를 직접 가져와 사용.
    @PersistenceContext
    private EntityManager em;

    public Long save(User user){
        em.persist(user);

        System.out.println(user.getUser_id());

        return user.getId();
    }

    // 책에서는 User 라는 데이터객체(VO)를 만들어서 데이터를 바인딩 했으나
    // JPA 를 사용할 때에는 영속성 컨택스트에서 데이터의 변경을 관리하고 엔티티 객체로 가져오기 때문에
    // return 을 String 이 아닌 엔티티 객체로 받아줘야 한다.
    // 메소드명이 findByUserId() 아닌 findOne 으로 바꿔준 이유도 위와 같다.
    public User findOne(Long id){
        return em.find(User.class, id);
    }

    public User findAll() {

        return null;
    }
}
