package kbh.com.practice.codeTestPractice.stackAndQueue;

public class SendingAndReceivingCenter {
    public static void main(String[] args) {
        solution(new int[]{6, 9, 5, 7, 4});
        solution(new int[]{3, 9, 9, 3, 5, 7, 2});
        solution(new int[]{1, 5, 3, 6, 7, 6, 5});
    }
    public static int[] solution(int[] heights) {

        int towerHeight = heights.length;
        int[] answer = new int[towerHeight];
        int[] workProcessQueue = new int[towerHeight];

        for (int i = 0; i < towerHeight; i++) {
            workProcessQueue[i] = heights[towerHeight - 1 - i];
        }

        for (int i = 0; i < workProcessQueue.length; i++) {
            int stand = workProcessQueue[i];
            int searchStartPoint = heights.length - 1 - i;
            for (int j = searchStartPoint; j >= 0; j--) {
                int searchElement = heights[j];
                if (stand < searchElement) {
                    int saveIndex = towerHeight - 1 - i;
                    answer[saveIndex] = j + 1;
                    break;
                }
            }
        }

        return answer;
    }
}
