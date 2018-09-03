package kbh.com.practice.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FindExit {

    private static int IS_VISIT = -1;

    private static int fourWaySearchDirection[][] = {{1, 0}, {-1, 0},{0, 1}, {0, -1}};
    private static int eightWaySearchDirection[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    private static int entrance[] = {0, 0};
    private static int exit[] = {0 , 4};

    private static int maze[][] = {
            {1, 1, 1, 1, 5},
            {1, 0, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1},
            {1, 1, 0, 0, 1}
    };

    public static void main(String[] args) {
        solution(maze, entrance, exit, fourWaySearchDirection);
        solution(maze, entrance, exit, eightWaySearchDirection);
    }

    private static void solution(int[][] maze, int[] entrance, int[] exit, int[][] manyWaySearchDirection) {
        int maxXPoint = maze[0].length; // x
        int maxYPoint = maze.length;    // y

        Queue<Integer[]> queue = new LinkedList<>();

        int startX = entrance[0];
        int startY = entrance[1];

        maze[startX][startY] = IS_VISIT;

        //초기 시작점 진입
        queue.add(new Integer[]{startX, startY, 1});

        while (!(queue.isEmpty())) {
            Integer[] standardPointInformation = queue.remove();

            int standardX = standardPointInformation[0];
            int standardY = standardPointInformation[1];
            int exitX = exit[0];
            int exitY = exit[1];

            System.out.println(standardX+"::"+standardY);

            boolean isExit = (standardX == exitX) && (standardY == exitY);
            if (isExit) {
                maze[standardX][standardY] = 9;
                System.out.println("출구까지지 결과값 : "+standardPointInformation[2]++);
                printMazeState(maze);
                break;
            }

            for (int k = 0; k < manyWaySearchDirection.length; k++) {

                int directionX = manyWaySearchDirection[k][0];
                int directionY = manyWaySearchDirection[k][1];

                // 0 보다 작냐
                // 각 좌표와 진행방향을 더한 값이 실제 배열의 최대 접근 가능한 인덱스보다 크냐
                // 범위 내에 있다면
                boolean isThisWayPassCondition = false;
                boolean isOverMinMazeSize = standardX + directionX < 0 || standardY + directionY < 0;
                boolean isOverMaxMazeSize = standardX + directionX > maxXPoint - 1 || standardY + directionY > maxYPoint - 1;
                boolean isOutMazeSize = !isOverMaxMazeSize && !isOverMinMazeSize;

                //방문했는지 통로가 아닌건지 값을 따진다.
                if (isOutMazeSize) {
                    isThisWayPassCondition =
                            maze[standardY + directionY][standardX + directionX] == IS_VISIT ||
                                    maze[standardY + directionY][standardX + directionX] == 0;
                }
                // 방문이나 통로가 아닌경우 다음 루프를 진행하게한다.
                if (isThisWayPassCondition) {
                    continue;
                } else {
                    if (isOutMazeSize) {
                        //큐에서 접근한 거리 값을 가져온 후
                        int distance = standardPointInformation[2];
                        //거리값을 하나 증가시켜 큐에 추가한다.
                        queue.add(new Integer[]{standardX + directionX, standardY + directionY, ++distance});
                        //큐에 추가한다 == 방문을 했다.
                        maze[standardY + directionY][standardX + directionX] = IS_VISIT;
                        printMazeState(maze);
                    }
                }
            }
            maze[standardX][standardY] = IS_VISIT;

            if(queue.isEmpty()) { System.out.println("\n\n통로가 없다"); }
        }
    }
    /**
     * 미로 상태 출력
     */
    private static void printMazeState(int[][] maze) {
        System.out.println();
        for (int i = 0; i < maze.length; i++) {
            System.out.println(Arrays.toString(maze[i]));
        }
        System.out.println();
    }
}
