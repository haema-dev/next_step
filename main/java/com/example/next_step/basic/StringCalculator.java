package com.example.next_step.basic;

public class StringCalculator {

    /**
     * 세부 구현은 모두 private 메소드로 분리 (일단 관심사에서 제외)
     * */

    public int add(String text) {
        if(isBlank(text)){
            return 0;
        }

        String[] values = text.split(",|:|;"); // , or : or ; 로 split 하겠다는 의미 ( | 는 or )
        return sum(toInts(values));
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers){
            sum += number;
        }
        return sum;
    }

    private int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i=0; i< numbers.length; i++){
            numbers[i] = toPositive(values[i]);
        }
        return numbers;
    }

    private int toPositive(String value) {
        int number = Integer.parseInt(value);
        if (number < 0){
            throw new RuntimeException("Runtime Error");
        }
        return number;
    }

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        stringCalculator.add("1,2:3;4"); //13,:|314;134:134|3
    }


}
