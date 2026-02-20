import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Pop-friendly Stack using two Queues.
 */
public class QueueStackPopFriendly<T> {
    private final Queue<T> main = new ArrayDeque<>();
    private final Queue<T> aux  = new ArrayDeque<>();

    public void push(T x) {
        aux.add(x);
        while (!main.isEmpty()) aux.add(main.remove());
        // swap main and aux by moving back
        while (!aux.isEmpty()) main.add(aux.remove());
    }

    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        return main.remove();
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        return main.element();
    }

    public boolean isEmpty() {
        return main.isEmpty();
    }

    public int size() {
        return main.size();
    }
}
