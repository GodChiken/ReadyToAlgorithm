package kbh.com.practice.level1;

import java.util.LinkedList;
import java.util.List;

public class DuplicateBeforeNumber {
    public static void main(String[] args) {
        solution(new int[]{1, 1, 3, 3, 0, 1, 1});
        solution(new int[]{4, 4, 4, 3, 3});
    }

    public static int[] solution(int[] array) {
        List<Integer> answer = new LinkedList<>();
        answer.add(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i-1]) {
                continue;
            } else {
                answer.add(array[i]);
            }
        }
        return answer.stream().mapToInt(element -> element).toArray();
    }
}
