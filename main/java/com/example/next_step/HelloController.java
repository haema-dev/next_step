package com.example.next_step;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    @GetMapping(value = "/")
    public String start(){
        System.out.println("성공!");
        return "index";
    }

}
