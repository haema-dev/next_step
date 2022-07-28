package com.example.next_step.basic;

public class Calculator {

    /**
     * 메소드가 한 가지 책임만 가지도록 구현
     * 인덴트(indent, 들여쓰기) 깊이를 1단계로 유지
     * else 사용하지 마라.
     * */

    public static void main(String[] args) {
        Calculator cal = new Calculator();
        System.out.println(cal.add(3,4));
        System.out.println(cal.subtract(5,4));
    }

    int add(int i, int j) {
        System.out.println("add");
        return i + j;
    }

    int subtract(int i, int j) {
        System.out.println("subtract");
        return i - j;
    }

}
