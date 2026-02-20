import java.util.NoSuchElementException;

/**
 * Unbounded (dynamic) array stack.
 * - grows when full
 * - shrinks when usage is low (but never below 2)
 */
public class UnboundedArrayStack<T> {
    private Object[] a;
    private int top; // points to next free index

    public UnboundedArrayStack() {
        this.a = new Object[2];
        this.top = 0;
    }

    public void push(T x) {
        if (top == a.length) resize(a.length * 2);
        a[top++] = x;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        T val = (T) a[--top];
        a[top] = null;

        if (a.length > 2 && top <= a.length / 4) resize(a.length / 2);
        return val;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        return (T) a[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int size() {
        return top;
    }

    private void resize(int newCap) {
        Object[] b = new Object[newCap];
        System.arraycopy(a, 0, b, 0, top);
        a = b;
    }
}
