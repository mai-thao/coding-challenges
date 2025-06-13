import java.util.Stack;

public class QueueUsingStacks {
    static class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            if (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            stack1.push(x);
        }

        public int pop() {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }

        public int peek() {
            if (!stack2.isEmpty()) {
                return stack2.peek();
            } else {
                while(!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.peek();
            }
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek()); // 1
        System.out.println(obj.pop()); // 1
        System.out.println(obj.empty()); // false
    }
}
