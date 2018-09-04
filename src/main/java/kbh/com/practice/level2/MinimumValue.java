package kbh.com.practice.level2;

public class MinimumValue {
    public static void main(String[] args) {
        solution(new int[]{1, 4, 2}, new int[]{5, 4, 4});
        solution(new int[]{1, 2}, new int[]{3, 4});

    }

    public static int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        for (int i = 0; i < arr1.length; i++) {
            answer += arr1[i] * arr2[(arr2.length - 1) - i];
        }
        return answer;
    }
}
