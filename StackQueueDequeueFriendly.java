import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * Dequeue-friendly Queue using two stacks (classic).
 * */
public class StackQueueDequeueFriendly<T> {
    private final Deque<T> in  = new ArrayDeque<>();
    private final Deque<T> out = new ArrayDeque<>();

    public void enqueue(T x) {
        in.push(x);
    }

    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        shiftIfNeeded();
        return out.pop();
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        shiftIfNeeded();
        return out.peek();
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

    public int size() {
        return in.size() + out.size();
    }

    private void shiftIfNeeded() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) out.push(in.pop());
        }
    }
}
