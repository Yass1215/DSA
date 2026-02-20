
package DSA;
import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPopFriendly {
    Queue<Integer> q = new LinkedList<>();

    // Push operation – a bit slower
    void push(int x) {
        q.add(x); // add element
        int size = q.size();
        // Rotate elements to move new element to front
        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
    }

    // Pop operation – easy
    int pop() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q.remove(); // first element is top
    }

    public static void main(String[] args) {
        QueueStackPopFriendly stack = new QueueStackPopFriendly();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop()); // 30
        System.out.println(stack.pop()); // 20
    
    }
    
}

