package com.example.next_step.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/join")
    public String join() {
        return "user/form";
    }

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @GetMapping("/profile")
    public String profile() {
        return "user/profile";
    }

}