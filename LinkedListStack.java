import java.util.NoSuchElementException;

public class LinkedListStack<T> {
    private static class Node<T> { T data; Node<T> next; Node(T d){data=d;} }
    private Node<T> top;
    private int size = 0;

    public void push(T x) {
        Node<T> n = new Node<>(x);
        n.next = top;
        top = n;
        size++;
    }

    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        T val = top.data;
        top = top.next;
        size--;
        return val;
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        return top.data;
    }

    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }
}
