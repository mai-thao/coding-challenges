import java.util.Stack;

/**
 * Given a String of lowercase letters, remove all two adjacent letters until we no longer can, then return the final String.
 *
 * Examples-
 *
 * INPUT: s = "abbaca"
 * OUTPUT: "ca" because we removed bb, then aa
 *
 * INPUT: s = "azxxzy"
 * OUTPUT: "ay" because we removed xx, then zz
 *
 * Time complexity: O(n) because we traverse the entire String
 * Space complexity: O(n) because we create extra Stack and StringBuilder datasets (both grow separately)
 */
public class RemoveAdjacentDuplicates {
    public static String removeDupes(String s) {
        Stack<Character> letters = new Stack<>();
        for (char c: s.toCharArray()) {
            if (!letters.isEmpty() && letters.peek() == c) {
                letters.pop();
            } else {
                letters.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!letters.isEmpty()) {
            sb.append(letters.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDupes("abbaca")); // ca
        System.out.println(removeDupes("azxxzy")); // ay
        System.out.println(removeDupes("azxxzyz")); // ayz
        System.out.println(removeDupes("a")); // a
    }
}
