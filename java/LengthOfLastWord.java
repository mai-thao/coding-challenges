/**
 * Given a string `s` consisting of words and spaces, return the length of
 * the last word in the string.
 *
 * A word is a maximal substring consisting of non-space characters only.
 *
 * Time complexity: O(n) because visiting each character once in separate while-loops
 * Space complexity: O(1) because no extra memory or dataset needed
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int lastCharIdx = s.length() - 1;
        while (s.charAt(lastCharIdx) == ' ') {
            lastCharIdx--;
        }

        int counter = 0;
        while (lastCharIdx >= 0 && s.charAt(lastCharIdx) != ' ') {
            counter++;
            lastCharIdx--;
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));                    // 5
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));    // 4
        System.out.println(lengthOfLastWord("luffy is still joyboy"));          // 6
        System.out.println(lengthOfLastWord("a"));                              // 1
        System.out.println(lengthOfLastWord("  abc  "));                        // 3
    }
}
