import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Deque;

/**
 * Enqueue-friendly Queue using two Stacks.
 **/
public class StackQueueEnqueueFriendly<T> {
    private final Deque<T> main = new ArrayDeque<>();
    private final Deque<T> aux  = new ArrayDeque<>();

    public void enqueue(T x) {
        main.push(x);
    }

    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        while (main.size() > 1) aux.push(main.pop());
        T front = main.pop();               // oldest item
        while (!aux.isEmpty()) main.push(aux.pop());
        return front;
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        while (main.size() > 1) aux.push(main.pop());
        T front = main.pop();
        aux.push(front);
        while (!aux.isEmpty()) main.push(aux.pop());
        return front;
    }

    public boolean isEmpty() {
        return main.isEmpty();
    }

    public int size() {
        return main.size();
    }
}
