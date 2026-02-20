import java.util.NoSuchElementException;

/**
 * Fixed-size circular queue using array.
 */
public class ArrayCircularQueue<T> {
    private final Object[] a;
    private int front = 0;
    private int size = 0;

    public ArrayCircularQueue(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity must be > 0");
        a = new Object[capacity];
    }

    public void enqueue(T x) {
        if (isFull()) throw new IllegalStateException("Queue is full");
        int rearIndex = (front + size) % a.length;
        a[rearIndex] = x;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        T val = (T) a[front];
        a[front] = null;
        front = (front + 1) % a.length;
        size--;
        return val;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return (T) a[front];
    }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == a.length; }
    public int size() { return size; }
    public int capacity() { return a.length; }
}
