package kbh.com.practice.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FindExit {
    public static void main(String[] args) {

        int fourWaySearchDirection[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int eightWaySearchDirection[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int entrance[] = {0, 0};
        int exit[] = {0 , 2};

        int maze[][] = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 1, 0, 0, 1}
        };

        /*System.out.println(maze[0][3]);
        System.out.println(maze[3][0]);
        System.out.println(maze.length); // 높이
        System.out.println(maze[0].length); // 넓이*/
        solution(maze, entrance, exit, fourWaySearchDirection);
        //solution(maze, entrance, exit, eightWaySearchDirection);
    }

    private static void solution(int[][] maze, int[] entrance, int[] exit, int[][] manyWaySearchDirection) {
        int maxMazeHeight = maze.length;
        int maxMazeLength = maze[0].length;

        System.out.println(maxMazeLength+":::"+maxMazeHeight);

        int isVisit = -1;

        Queue<Integer[]> queue = new LinkedList<>();

        int startX = entrance[0];
        int startY = entrance[1];

        maze[startX][startY] = -1;

        //초기 시작점 처리
        queue.add(new Integer[]{startX, startY, 1});
        while (!(queue.isEmpty())) {
            Integer[] standardPointInformation = queue.remove();

            int standardX = standardPointInformation[0];
            int standardY = standardPointInformation[1];
            int exitX = exit[0];
            int exitY = exit[1];


            boolean isExit = (standardX == exitX) && (standardY == exitY);
            if (isExit) {
                System.out.println("출구까지지 결과값 : "+standardPointInformation[2]++);
                break;
            }

            for (int k = 0; k < manyWaySearchDirection.length; k++) {

                int directionX = manyWaySearchDirection[k][0];
                int directionY = manyWaySearchDirection[k][1];

                boolean isThisWayPassCondition = false;
                // 0 보다 작냐
                boolean isOverMinMazeSize = standardX + directionX < 0 || standardY + directionY < 0;
                // 각 좌표와 진행방향을 더한 값이 실제 배열의 최대 접근 가능한 인덱스보다 크냐
                boolean isOverMaxMazeSize = standardX + directionX > maxMazeLength - 1 || standardY + directionY > maxMazeHeight - 1;
                // 범위 내에 있다면
                boolean isOutMazeSize = !isOverMaxMazeSize && !isOverMinMazeSize;

                if (isOutMazeSize) {
                    //방문했는지 통로가 아닌건지 값을 따진다.
                    isThisWayPassCondition =
                            maze[standardX + directionX][standardY + directionY] == isVisit ||
                                    maze[standardX + directionX][standardY + directionY] == 0;
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
                        maze[standardX + directionX][standardY + directionY] = isVisit;
                        System.out.println();
                        System.out.println(Arrays.toString(maze[0]));
                        System.out.println(Arrays.toString(maze[1]));
                        System.out.println(Arrays.toString(maze[2]));
                        System.out.println(Arrays.toString(maze[3]));
                        //System.out.println(Arrays.toString(maze[4]));
                        System.out.println();
                    }
                }
            }
            maze[standardX][standardY] = isVisit;

            System.out.println("\n\n통로가 없냐 : " + queue.isEmpty());
        }
    }
}
