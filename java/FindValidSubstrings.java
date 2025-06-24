/**
 * Given a string, return the number of distinct substrings of length 3.
 * - A string is valid if there are no repeated characters.
 * - A substring is a contiguous sequence of characters in a string.
 * - Count every valid occurrences even if it's a duplicate.
 *
 * Examples-
 *
 * INPUT: s = "xyzzaz"
 * OUTPUT: 1 because only substring "xyz" is valid
 *
 * INPUT: s = "aababcabc"
 * OUTPUT: 4 because substrings "abc", "bca", "cab", and "abc" are valid
 */
public class FindValidSubstrings {
    public static int countGoodSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            char first = s.charAt(i);
            char second = s.charAt(i+1);
            char third = s.charAt(i+2);

            if (first != second && second != third && third != first) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("xyzzaz")); // 1
        System.out.println(countGoodSubstrings("aababcabc")); // 4
        System.out.println(countGoodSubstrings("abc")); // 1
        System.out.println(countGoodSubstrings("zy")); // 0
    }
}
