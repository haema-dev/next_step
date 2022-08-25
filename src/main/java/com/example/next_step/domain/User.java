package com.example.next_step.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.common.aliasing.qual.Unique;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter @Setter
@NoArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Unique
    //@Column(nullable = false)
    private String user_id;

    //@Column(nullable = false)
    private String password;

    //@Unique
    private String nickname;

    //@Unique
    private String email;

    @Builder
    public User(Long id, String user_id, String password, String nickname, String email) {
        this.id = id;
        this.user_id = user_id;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }
}
