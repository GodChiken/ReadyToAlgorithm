package kbh.com.practice.search;

import java.util.NoSuchElementException;

/**
 * 기본적인 큐 자료구조를 구현한다.
 */
public class BasicQueue<T> {

    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;

    /**
     * queue 에 data enQueue
     */
    public void enQueue(T item) {
        Node<T> t = new Node<>(item);

        if (last != null) {
            last.next = t;
        }
        last = t;
        if (first == null) {
            first = last;
        }
    }
    /**
     * queue 에 data deQueue
     */
    public T deQueue() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        T data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return data;
    }

    public T peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
