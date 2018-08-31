package kbh.com.practice.sort;

import java.util.Arrays;

public class Insert {
    public static void main(String[] args) {
        int[] array = {8, 5, 6, 1, 2, 3, 7, 9, 4};
        solution(array);
    }

    private static int[] solution(int[] array) {

        int temp = 0;
        int j = 0;

        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            j = i;
            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
            System.out.println((i) + "회전 결과: " + Arrays.toString(array));

        }
        return new int[0];
    }
}
