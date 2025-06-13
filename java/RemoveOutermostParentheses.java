import java.util.Stack;

/**
 * Given a String s of valid parentheses pair (an open and close), remove the outermost parentheses pair, and return it.
 *
 * Examples-
 *
 * INPUT: "(())()"
 * OUTPUT: ()
 *
 * INPUT: "(()(()))"
 * OUTPUT: ()(())
 *
 * Time complexity: O(n) because traversing each character in the String
 * Space complexity: O(n) because created extra StringBuilder and Stack datasets whose size grows separately
 */
public class RemoveOutermostParentheses {
    public static String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == ')') {
                stack.pop();
                if (!stack.isEmpty()) {
                    sb.append(c);
                }
            } else {
                if (!stack.isEmpty()) {
                    sb.append(c);
                }
                stack.push(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())")); // ()()()
        System.out.println(removeOuterParentheses("(()())(())(()(()))")); // ()()()()(())
        System.out.println(removeOuterParentheses("(())()")); // ()
        System.out.println(removeOuterParentheses("()()")); // empty
        System.out.println(removeOuterParentheses("")); // empty
    }
}
