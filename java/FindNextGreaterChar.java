/**
 * Given an array of characters `letters` sorted in non-decreasing order, and a character `target`.
 * There are at least two different characters in `letters`.
 *
 * Return the smallest character in `letters` that is lexicographically greater than `target`. If
 * such a character does not exist, return the first character in `letters`.
 *
 * Time complexity: O(n) because traversing each character in the `letters` character array
 * Space complexity: O(1) because not creating extra dataset
 */
public class FindNextGreaterChar {
    public static char nextGreatestLetter(char[] letters, char target) {
        for (char letter: letters) {
            if (letter > target) {
                return letter;
            }
        }
        return letters[0];
    }

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a')); // c
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c')); // f
        System.out.println(nextGreatestLetter(new char[]{'x', 'x', 'y', 'y'}, 'z')); // x b/c there are no characters that is lexicographically greater so return letters[0]
        System.out.println(nextGreatestLetter(new char[]{'a', 'b'}, 'a')); // b
        System.out.println(nextGreatestLetter(new char[]{'a', 'a'}, 'a')); // a
        System.out.println(nextGreatestLetter(new char[]{'a', 'a', 'b'}, 'b')); // a
    }
}
