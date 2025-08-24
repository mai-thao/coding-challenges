/**
 * Given an array of strings `words`, return the first palindromic string in the array.
 * If there is no such string, return an empty string "".
 *
 * A string is palindromic if it reads the same forward and backward.
 *
 * Time complexity: O(n * m) where n = number of strings in `words` and m = max length of a string. We iterate over each character in each string
 * Space complexity: O(1) because not using extra data structures
 */
public class FirstPalindromeString {
    public static String firstPalindrome(String[] words) {
        for (String s: words) {
            if (isPalindrome(s)) {
                return s;
            }
        }
        return "";
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(firstPalindrome(new String[]{"abc","car","ada","racecar","cool"}));  // ada
        System.out.println(firstPalindrome(new String[]{"notapalindrome","racecar"}));          // racecar
        System.out.println(firstPalindrome(new String[]{"def","ghi"}));                         // ""
        System.out.println(firstPalindrome(new String[]{"lool"}));                              // "lool"
    }
}
