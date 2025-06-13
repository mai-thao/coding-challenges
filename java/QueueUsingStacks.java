import java.util.Stack;

public class QueueUsingStacks {
    static class MyQueue {
        Stack<Integer> mainStack;
        Stack<Integer> tempStack;

        public MyQueue() {
            mainStack = new Stack<>();
            tempStack = new Stack<>();
        }

        public void push(int x) {
            while (!mainStack.isEmpty()) {
                tempStack.push(mainStack.pop());
            }
            mainStack.push(x);
            while (!tempStack.isEmpty()) {
                mainStack.push(tempStack.pop());
            }
        }

        public int pop() {
            return mainStack.pop();
        }

        public int peek() {
            return mainStack.peek();
        }

        public boolean empty() {
            return mainStack.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek()); // 1
        System.out.println(obj.pop()); // 1
        System.out.println(obj.empty()); // false

        System.out.println();

        MyQueue obj2 = new MyQueue();
        obj2.push(1);
        obj2.push(2);
        obj2.push(3);
        obj2.push(4);
        System.out.println(obj2.pop()); // 1
        obj2.push(5);
        System.out.println(obj2.pop()); // 2
        System.out.println(obj2.pop()); // 3
        System.out.println(obj2.pop()); // 4
        System.out.println(obj2.pop()); // 5
    }
}
