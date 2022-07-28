package com.example.next_step.basic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    // Junit 은 build.gradle 의 testImplementation 'org.springframework.boot:spring-boot-starter-test' 에 포함되어있다.
    // version 을 확인하고 싶으면 External Libraries 에서 검색해보면 된다.
    private Calculator cal;

    // 책에서는 @Before 로 나와있다. 이건 Junit 4 버전
    // Junit 5 버전은 BeforeEach
    @BeforeEach
    public void setup(){
        cal = new Calculator();
        System.out.println("before");
    }

    @Test
    public void add() {
        // 책에는 Assert.assertEquals(); 로 나와있다. 이건 Junit 4 버전
        // Junit 5 버전은 Assertions.assertEquals()
        // static 이기 때문에 static 으로 import 하게 되면 assertEquals()만 적어줘도 무방하다.
        assertEquals(9, cal.add(6, 3));
        System.out.println("add");
    }

    @Test
    public void subtract() {
        assertEquals(3, cal.subtract(6, 3));
        System.out.println("subtract");
    }


    // 책에서는 @After 로 나와있다. 이건 Junit 4 버전
    // Junit 5 버전은 AfterEach
    @AfterEach
    public void teardown(){
        System.out.println("teardown");
    }
}
