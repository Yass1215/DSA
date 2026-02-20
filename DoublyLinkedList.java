import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {
    private static class Node<T> {
        T data; Node<T> prev, next;
        Node(T data) { this.data = data; }
    }

    private Node<T> head, tail;
    private int size = 0;

    public void addFirst(T x) {
        Node<T> n = new Node<>(x);
        n.next = head;
        if (head != null) head.prev = n;
        head = n;
        if (tail == null) tail = head;
        size++;
    }

    public void addLast(T x) {
        Node<T> n = new Node<>(x);
        n.prev = tail;
        if (tail != null) tail.next = n;
        tail = n;
        if (head == null) head = tail;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        T val = head.data;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
        return val;
    }

    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        T val = tail.data;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
        size--;
        return val;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
}
