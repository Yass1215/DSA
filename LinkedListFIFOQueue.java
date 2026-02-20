import java.util.NoSuchElementException;

public class LinkedListFIFOQueue<T> {
    private static class Node<T> { T data; Node<T> next; Node(T d){data=d;} }
    private Node<T> front, rear;
    private int size = 0;

    public void enqueue(T x) {
        Node<T> n = new Node<>(x);
        if (rear == null) {
            front = rear = n;
        } else {
            rear.next = n;
            rear = n;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        T val = front.data;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return val;
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return front.data;
    }

    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }
}
