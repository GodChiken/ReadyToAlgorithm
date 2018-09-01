package kbh.com.practice.search;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.IntStream;


/**
 * data 와 index 는 값이 같다는 전재하에 실습
 */
@Data
public class Graph {
    Node[] nodes;

    Graph(int size) {
        nodes = new Node[size];
        IntStream.range(0, size)
                .forEach(index -> nodes[index] = new Node(index));
        setTestData();
    }
    /**
     * init test data
     */
    private void setTestData() {
        this.addEdge(0,1);
        this.addEdge(1,2);
        this.addEdge(1,3);
        this.addEdge(2,4);
        this.addEdge(2,3);
        this.addEdge(3,4);
        this.addEdge(3,5);
        this.addEdge(5,6);
        this.addEdge(5,7);
        this.addEdge(6,8);
    }

    /**
     * 두 노드의 관계를 정의한다.
     * 존재여부를 확인후 없는 경우 서로의 관계를 추가한다.
     */
    void addEdge(int firstNode, int secondNode) {
        Node first = nodes[firstNode];
        Node second = nodes[secondNode];
        if (!(first.adjacent.contains(second))) {
            first.adjacent.add(second);
        }
        if (!(second.adjacent.contains(first))) {
            second.adjacent.add(first);
        }
    }

    void depthFindSearch() {
        depthFindSearch(0);
    }

    void depthFindSearch(int index) {
        System.out.println("DFS("+index+")");
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;
        while (!(stack.isEmpty())) {
            Node r = stack.pop();
            for (Node n :  r.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            visit(r);
        }
        System.out.println();
    }

    void breadthFindSearch() {
        breadthFindSearch(0);
    }

    void breadthFindSearch(int index) {
        System.out.println("BFS("+index+")");
        Node root = nodes[index];
        BasicQueue<Node> queue = new BasicQueue<>();
        queue.enQueue(root);
        root.marked = true;
        while (!queue.isEmpty()) {
            Node r = queue.deQueue();
            for (Node n : r.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    queue.enQueue(n);
                }
            }
            visit(r);
        }
        System.out.println();
    }

    void depthFindSearchByRecursive(Node recursiveNode) {
        if (recursiveNode == null) {
            return;
        }
        recursiveNode.marked = true;
        visit(recursiveNode);
        for (Node n : recursiveNode.adjacent) {
            if (n.marked == false) {
                depthFindSearchByRecursive(n);
            }
        }
    }
    /**
     * 시작 인덱스를 받아 그 지점부터 수행하기 위한 메서
     */
    void depthFindSearchByRecursive(int index) {
        System.out.println("BFSR("+index+")");
        Node r = nodes[index];
        depthFindSearchByRecursive(r);
        System.out.println();
    }
    void depthFindSearchByRecursive() {
        depthFindSearchByRecursive(0);
    }

    void visit(Node node) {
        System.out.print(node.data + " ");
    }

    public void breadthFindSearchByQueueInterface(){
        breadthFindSearchByQueueInterface(0);
    }
    public void breadthFindSearchByQueueInterface(int index) {
        System.out.println("BFSByQueueInterface : ");
        Queue<Node> queue = new LinkedList<>();
        queue.offer(nodes[0]);
        nodes[0].marked = true;
        while (!queue.isEmpty()) {
            Node r = queue.remove();
            for (Node n : r.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    queue.offer(n);
                }
            }
            visit(r);
        }
        System.out.println();
    }
}
