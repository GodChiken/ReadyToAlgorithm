package kbh.com.practice.search;

import java.util.LinkedList;

/**
 * data : 값
 * adjacent : 인접한 노드를 표현하기 위함
 * marked : 순회 됬는가 여부
 */

public class Node {
    int data;
    LinkedList<Node> adjacent;
    boolean marked;
    Node (int data){
        this.data = data;
        this.marked =false;
        adjacent = new LinkedList<>();
    }
}
