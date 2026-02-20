import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Push-friendly Stack using two Queues.
 */
public class QueueStackPushFriendly<T> {
    private final Queue<T> q1 = new ArrayDeque<>();
    private final Queue<T> q2 = new ArrayDeque<>();

    public void push(T x) {
        q1.add(x);
    }

    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        moveExceptLast(q1, q2);
        T removed = q1.remove();      // last pushed element
        swapQueues();
        return removed;
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        moveExceptLast(q1, q2);
        T top = q1.remove();
        q2.add(top);
        swapQueues();
        return top;
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public int size() {
        return q1.size();
    }

    private void moveExceptLast(Queue<T> from, Queue<T> to) {
        while (from.size() > 1) to.add(from.remove());
    }

    private void swapQueues() {
        // swap contents 
        Queue<T> tmp = new ArrayDeque<>(q1);
        q1.clear(); q1.addAll(q2);
        q2.clear(); q2.addAll(tmp);
    }
}
