package kbh.com.practice.level2;

public class ContinuousNumberCombination {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }
    private static int solution(int number) {
        int count = 1;
        int sum = 0;
        int searchIndex = number / 2 + 1;

        for (int i = 1; i < searchIndex; i++) {
            sum = i;
            for (int j = i + 1; j <= searchIndex; j++) {
                sum += j;
                if (sum == number) { count++; }
                if (sum > number) { break; }
            }
        }

        return count;
    }
}
