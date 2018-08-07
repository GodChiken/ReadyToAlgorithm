package kbh.com.practice.level1;

import java.util.ArrayList;
import java.util.List;

public class FindDivisor {
    public static void main(String[] args) {
        System.out.println(solution(12));
        System.out.println(solution(5));
    }
    public static int solution(int n){
        int answer = 0;
        if (n == 0) {return n;}
        List<Integer> yac = new ArrayList<>();
        for (int i = 1; i < 28; i++) {
            if(n % i == 0) {yac.add(i);}
        }
        return yac.stream().mapToInt(Integer::intValue).sum();
    }
}
