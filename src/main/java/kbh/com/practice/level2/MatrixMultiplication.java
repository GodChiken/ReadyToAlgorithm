package kbh.com.practice.level2;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};
        solution(arr1, arr2);
        arr1 = new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        arr2 = new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
        solution(arr1, arr2);

    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};

        int arr1Height = arr1.length;
        int arr1Length = arr1[0].length;
        int arr2Height = arr2.length;
        int arr2Length = arr2[0].length;

        boolean isCanMultiplication = arr1Length == arr2Height;

        if (isCanMultiplication) {
            answer = new int[arr1Height][arr2Length];

            for (int i = 0; i < arr1Height; i++) {
                for (int j = 0; j < arr2Length; j++) {
                    for (int k = 0; k < arr1Length; k++) {
                        answer[i][j] += arr1[i][k] * arr2[k][j];
                    }
                }
            }
        }

        return answer;
    }
}

