import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private static class Node<T> {
        T data; Node<T> next;
        Node(T data) { this.data = data; }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public void addFirst(T x) {
        Node<T> n = new Node<>(x);
        n.next = head;
        head = n;
        if (tail == null) tail = head;
        size++;
    }

    public void addLast(T x) {
        Node<T> n = new Node<>(x);
        if (tail == null) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        T val = head.data;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return val;
    }

    public boolean remove(T x) {
        Node<T> prev = null, cur = head;
        while (cur != null) {
            if ((x == null && cur.data == null) || (x != null && x.equals(cur.data))) {
                if (prev == null) head = cur.next;
                else prev.next = cur.next;
                if (cur == tail) tail = prev;
                size--;
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false;
    }

    public boolean contains(T x) {
        Node<T> cur = head;
        while (cur != null) {
            if ((x == null && cur.data == null) || (x != null && x.equals(cur.data))) return true;
            cur = cur.next;
        }
        return false;
    }

    public T getFirst() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        return head.data;
    }

    public T getLast() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        return tail.data;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
}
