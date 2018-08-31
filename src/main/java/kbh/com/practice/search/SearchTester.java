package kbh.com.practice.search;

/**
 *  예시 그래프를 세팅해보자.
    0
   /
  1 -- 3     7
  |  / | \ /
  | /  |  5
  2 -- 4   \
            6 - 8
 DFS(0)
 0  1   3   5   7   6   8   4   2
 DFS(3)
 3  5   7   6   8   4   2   1   0

 BFS(0)
 0  1   2   3   4   5   6   7   8
 BFS(3)
 3  1   2   4   5   0   6   7   8

 DFSR(0)
 0  1   2   4   3   5   6   8   7
 DFSR(3)
 3  1   0   2   4   5   6   8   7
 */
public class SearchTester {
    public static void main(String[] args) {

        //basicQueueTest();

        Graph graph = new Graph(9);
        graph.breadthFindSearch();
        graph = new Graph(9);
        graph.breadthFindSearch(3);
        graph = new Graph(9);
        graph.depthFindSearch();
        graph = new Graph(9);
        graph.depthFindSearch(3);
        graph = new Graph(9);
        graph.depthFindSearchByRecursive();
        graph = new Graph(9);
        graph.depthFindSearchByRecursive(3);
    }

    private static void basicQueueTest() {
        BasicQueue<Integer> q = new BasicQueue<>();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.peek());
        System.out.println(q.deQueue());
        System.out.println(q.isEmpty());
        System.out.println(q.deQueue());
        System.out.println(q.isEmpty());
    }
}
