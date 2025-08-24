/**
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 *
 * An integer is a palindrome when it reads the same forward and backward.
 * For example, 121 is a palindrome while 123 is not.
 *
 * Time complexity: O(n) because visiting every digit in the int
 * Space complexity: O(1) because no extra data structures needed
 */
public class ValidPalindromeNumber {
    public static boolean isPalindrome(int x) {
        String convertedX = Integer.toString(x);

        int left = 0;
        int right = convertedX.length()-1;

        while (left < right) {
            if (convertedX.charAt(left) != convertedX.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121)); // true
        System.out.println(isPalindrome(-121)); // false
        System.out.println(isPalindrome(10)); // false
        System.out.println(isPalindrome(11)); // true
        System.out.println(isPalindrome(0)); // true
    }
}
