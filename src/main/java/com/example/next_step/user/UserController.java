package com.example.next_step.user;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@Controller
@RequiredArgsConstructor
//@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/user/join")
    public String getForm() {
        return "user/form";
    }

    @PostMapping("/user/join")
    public String join(HttpServletRequest request) {
        userService.join("nextstep2", "1234", "넥스트스탭", "이메일");
        return "redirect:/";
    }

    @GetMapping("/user/login")
    public String login() {
        return "user/login";
    }

    @GetMapping("/user/profile")
    public String profile() {
        return "user/profile";
    }

}