package kbh.com.practice.level1;

/**
 * 소수 구하기 문제풀이
 */
public class FindDecimal {

    private int minNumber = 2;

    public static void main(String[] args) {
        System.out.println(new FindDecimal().solution(10));
        System.out.println(new FindDecimal().solution(5));

    }

    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            boolean isDivision = true;
            for (int j = minNumber; j < i; j++) {
                if (i % j == 0) {
                    isDivision = false;
                }
            }
            if (isDivision == true) {
                System.out.println(i);
                answer++;
            }
        }
        return answer;
    }
}
