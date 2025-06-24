import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 * - Open brackets must be closed by the same type of brackets
 * - Open brackets must be closed in the correct order
 * - Every close bracket has a corresponding open bracket of the same type
 *
 * Examples:
 *
 * INPUT: s = "()"
 * OUTPUT: true
 *
 * INPUT: s = "()[]{}"
 * OUTPUT: true
 *
 * INPUT: s = "(]"
 * OUTPUT: false
 *
 * INPUT: s = "([])"
 * OUTPUT: true
 *
 * Time complexity: O(n) because for loop is traversing entire String
 * Space complexity: O(n) because needed a stack where worst case it stores all open brackets
 */
public class ValidParentheses {
    public static boolean isValidParentheses(String s) {
        Stack<Character> openBrackets = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') { // Save open brackets to stack
                openBrackets.push(c);
            } else {
                if (openBrackets.isEmpty()) { // Handles no matching open bracket for first close bracket
                    return false;
                }
                char popped = openBrackets.pop();
                if (c == ')' && popped != '(') {
                    return false;
                } else if (c == '}' && popped != '{') {
                    return false;
                } else if (c == ']' && popped != '[') {
                    return false;
                }
            }
        }
        return openBrackets.isEmpty(); // Stack must be empty to indicate all opened brackets are closed
    }

    public static void main(String[] args) {
        System.out.println(isValidParentheses("()")); // true
        System.out.println(isValidParentheses("()[]{}")); // true
        System.out.println(isValidParentheses("([])")); // true
        System.out.println(isValidParentheses("(]")); // false
        System.out.println(isValidParentheses("((")); // false
        System.out.println(isValidParentheses("(")); // false
        System.out.println(isValidParentheses("}")); // false
        System.out.println(isValidParentheses("}}")); // false
    }
}
