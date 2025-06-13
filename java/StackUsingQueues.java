import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a LIFO stack using only two queues. The implemented stack should support
 * all the functions of a normal stack (push, top, pop, and empty).
 *
 * Methods explained:
 *  - `void push(int x)` Pushes element x to the top of the stack
 *  - `int pop()` Removes the element on the top of the stack and returns it
 *  - `int peek()` Returns the element on the top of the stack
 *  - `boolean empty()` Returns true if the stack is empty, false otherwise
 */
public class StackUsingQueues {
    static class MyStack {
        Queue<Integer> q1;
        Queue<Integer> q2;

        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void push(int x) {
            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }
            q1.offer(x);
            while (!q2.isEmpty()) {
                q1.offer(q2.poll());
            }
        }

        public int pop() {
            return q1.poll();
        }

        public int top() {
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.top()); // 2
        System.out.println(obj.pop()); // 2
        System.out.println(obj.empty()); // false

        System.out.println();

        MyStack obj2 = new MyStack();
        obj2.push(1);
        obj2.push(2);
        obj2.push(3);
        System.out.println(obj2.top()); // 3
    }
}
