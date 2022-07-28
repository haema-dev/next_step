package com.example.next_step;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
public class HelloController {

    @GetMapping(value = "/")
    public String start(){
        System.out.println("성공!");
        return "index";
    }

}
