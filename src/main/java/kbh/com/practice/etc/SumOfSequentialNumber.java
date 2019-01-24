package kbh.com.practice.etc;

import java.util.stream.LongStream;

public class SumOfSequentialNumber {
    public static void main(String[] args) {
        solution(100000000000L);
    }

    public static void solution(Long number) {
        System.out.println("반복문으로 돌렸을 때");
        long loopStartTime = System.currentTimeMillis();
        System.out.println(getSumByLoop(number));
        long loopEndTime = System.currentTimeMillis();
        System.out.println("실행 시간 : " + (loopEndTime - loopStartTime) + "\n");

        System.out.println("스트림으로 돌렸을 때");
        long streamStartTime = System.currentTimeMillis();
        System.out.println(getSumByStream(number));
        long streamEndTime = System.currentTimeMillis();
        System.out.println("실행 시간 : " + (streamEndTime - streamStartTime) + "\n");

        System.out.println("병렬스트림으로 돌렸을 때");
        long parallelStreamStartTime = System.currentTimeMillis();
        System.out.println(getSumByParallelStream(number));
        long parallelStreamEndTime = System.currentTimeMillis();
        System.out.println("실행 시간 : " + (parallelStreamEndTime - parallelStreamStartTime) + "\n");

        System.out.println("수식을 활용할 때");
        long calculateStartTime = System.currentTimeMillis();
        System.out.println(getSumByCalculate(number));
        long calculateEndTime = System.currentTimeMillis();
        System.out.println("실행 시간 : " + (calculateEndTime - calculateStartTime) + "\n");
    }

    public static Long getSumByLoop(Long number) {
        long sum = 0;
        for (long i = 1; i <= number; i++) {
            sum += i;
        }
        return sum;
    }

    public static Long getSumByStream(Long number) {
        return LongStream.range(1, number + 1).sum();
    }

    public static Long getSumByParallelStream(Long number) {
        return LongStream.range(1, number + 1).parallel().sum();
    }

    public static Long getSumByCalculate(Long number) {
        return number % 2 == 0 ? (number + 1) * (number / 2) : (number * (number - 1) / 2) + number;
    }
}
