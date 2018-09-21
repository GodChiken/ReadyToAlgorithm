package kbh.com.practice.codeTestPractice.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class FindDecreaseStock {
    public static void main(String[] args) {
        solution(new int[]{498, 501, 470, 489});
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < prices.length; i++) {
            int standard = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                int searchElement = prices[j];
                if (standard > searchElement) {
                    queue.add(searchElement);
                    break;
                } else {
                    queue.add(searchElement);
                }
            }
            answer[i] = queue.size();
            queue = new LinkedList<>();
        }
        return answer;
    }
}
