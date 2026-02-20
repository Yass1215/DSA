import java.util.NoSuchElementException;

public class CircularDoublyLinkedList<T> {
    private static class Node<T> {
        T data; Node<T> prev, next;
        Node(T data) { this.data = data; }
    }

    private Node<T> head; // if not null, head.prev is tail and tail.next is head
    private int size = 0;

    public void addFirst(T x) {
        Node<T> n = new Node<>(x);
        if (head == null) {
            n.next = n.prev = n;
            head = n;
        } else {
            Node<T> tail = head.prev;
            n.next = head;
            n.prev = tail;
            tail.next = n;
            head.prev = n;
            head = n;
        }
        size++;
    }

    public void addLast(T x) {
        if (head == null) { addFirst(x); return; }
        Node<T> tail = head.prev;
        Node<T> n = new Node<>(x);
        n.next = head;
        n.prev = tail;
        tail.next = n;
        head.prev = n;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        T val = head.data;
        if (size == 1) {
            head = null;
        } else {
            Node<T> tail = head.prev;
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        size--;
        return val;
    }

    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        if (size == 1) return removeFirst();
        Node<T> tail = head.prev;
        T val = tail.data;
        Node<T> newTail = tail.prev;
        newTail.next = head;
        head.prev = newTail;
        size--;
        return val;
    }

    public T getFirst() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        return head.data;
    }

    public T getLast() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        return head.prev.data;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
}
