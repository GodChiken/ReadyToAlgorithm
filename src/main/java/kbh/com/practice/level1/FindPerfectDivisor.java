package kbh.com.practice.level1;

import java.util.Arrays;

public class FindPerfectDivisor {
    public static void main(String[] args) {
        solution(new int[]{5, 9, 7, 10},5);
        solution(new int[]{2, 36, 1, 3},1);
        solution(new int[]{3, 2, 6},10);
    }
    public static int[] solution(int[] arr, int divisor) {
        int[] answer =  Arrays.stream(arr).sorted().filter(number -> number%divisor==0).toArray();
        return answer.length == 0 ? new int[]{-1} : answer;
    }
}
