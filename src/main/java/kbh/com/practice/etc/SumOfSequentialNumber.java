package kbh.com.practice.etc;

import java.util.stream.IntStream;

public class SumOfSequentialNumber {
    public static void main(String[] args) {
        solution(100);
        solution(101);
        //너무 미미해서 overflow 가된다해도 테스트
        System.out.println("==================================");
        solution(1000000000);
        solution(1000000001);
    }
    public static void solution(int number){
        System.out.println("반복문으로 돌렸을 때");
        long loopStartTime = System.currentTimeMillis();
        System.out.println(getSumByLoop(number));
        long loopEndTime = System.currentTimeMillis();
        System.out.println( "실행 시간 : " + ( loopEndTime - loopStartTime )+"\n");

        System.out.println("스트림으로 돌렸을 때");
        long streamStartTime = System.currentTimeMillis();
        System.out.println(getSumByStream(number));
        long streamEndTime = System.currentTimeMillis();
        System.out.println( "실행 시간 : " + ( streamEndTime - streamStartTime )+"\n");

        System.out.println("수식을 활용할 때");
        long calculateStartTime = System.currentTimeMillis();
        System.out.println(getSumByCalculate(number));
        long calculateEndTime = System.currentTimeMillis();
        System.out.println( "실행 시간 : " + ( calculateEndTime - calculateStartTime )+"\n");
    }
    public static int getSumByLoop(int number){
        int sum = 0;
        for (int i = 1; i <= number; i++) { sum+=i; }
        return sum;
    }
    public static int getSumByStream(int number){
        return IntStream.range(1,number+1).sum();
    }
    public static int getSumByCalculate(int number){
        return number%2==0 ? (number+1)*(number/2) : (number*(number-1)/2) + number;
    }
}
