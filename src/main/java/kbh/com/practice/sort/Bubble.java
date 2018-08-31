package kbh.com.practice.sort;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] array = {8,5,6,1,2,3,7,9,4};
        solution(array);
    }

    private static void solution(int[] array) {
        for (int i = array.length-2; i >= 0; i--) {
            int temp = 0;
            for (int j = array.length-1; j >= 0 ; j--) {
                if(array[j]>array[i]){
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        Arrays.stream(array).forEach(ele -> System.out.println(ele));
        int[] b = Arrays.stream(array).sorted().toArray();
    }
}
