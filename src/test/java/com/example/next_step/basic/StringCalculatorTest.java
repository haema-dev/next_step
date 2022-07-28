package com.example.next_step.basic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    private StringCalculator cal;

    @BeforeEach
    public void setup(){
        cal = new StringCalculator();
    }

    @Test
    public void add(){
        //assertEquals(0, cal.add(null));
        //assertEquals(10, cal.add("1,2:3;4"));

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            // 책에는 메소드 상단에 붙은 어노테이션이 @Test(expected = RuntimeException) 로 나와있다. 이건 Junit 4 버전
            // Junit 5 버전은 메소드 내부에 Assertions.assertThrows 사용
            // 참고 레퍼런스 : https://howtodoinjava.com/junit5/expected-exception-example/

            //cal.add("1,2,3"); //음수가 없을 경우, Console 창에 "Success!" 가 출력 (테스트 실패)
            cal.add("-1,2,3"); //음수가 들어갈 경우, RuntimeException 발생 시키기 (테스트 통과)
        }, "Success!");
        assertEquals("Runtime Error", thrown.getMessage());

    }



    @Test
    public void split(){
        //assertArrayEquals(new String[]{"1"}, "1".split(","));
        //assertArrayEquals(new String[]{"1","2"}, "1,2".split(","));
    }
}
