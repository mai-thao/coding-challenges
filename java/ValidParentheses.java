import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }
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
        System.out.println(isValid("()")); // true
        System.out.println(isValid("()[]{}")); // true
        System.out.println(isValid("([])")); // true
        System.out.println(isValid("(]")); // false
        System.out.println(isValid("((")); // false
        System.out.println(isValid("(")); // false
        System.out.println(isValid("}")); // false
        System.out.println(isValid("}}")); // false

    }
}
