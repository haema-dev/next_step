package com.example.next_step.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "member")
@Getter @Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String password;

    private String nickname;

    private String email;

    @Builder
    public User(Long id, String userId, String password, String nickname, String email) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }
}
