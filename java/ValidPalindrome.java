/**
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * Palindrome is when all uppercase letters are converted to lowercase,
 * all non-alphanumeric characters are removed, and it still reads the same
 * forward and backward.
 *
 * Examples-
 *
 * INPUT: s = "A man, a plan, a canal: Panama"
 * OUTPUT: true because "amanaplanacanalpanama" is a palindrome
 *
 * INPUT: s = "race a car"
 * OUTPUT: false because "raceacar" is not a palindrome
 *
 * INPUT: s = " "
 * OUTPUT: true because an empty string reads the same backward and forward
 */
class ValidPalindrome {
    /**
     * Time complexity: O(n) because both the for-loop and while-loop traverses the entire String
     * Space complexity: O(n) because needed a StringBuilder where worst case could store all characters
     */
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        String lowercase = s.toLowerCase();
        for (char c: lowercase.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        String cleaned = sb.toString();
        int i = 0;
        int j = cleaned.length()-1;
        int half = cleaned.length()/2;
        while (i <= half && j >= half) {
            if (cleaned.charAt(i) != cleaned.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * Solution with better readability due to usage of regex but still SAME time and space complexities
     *
     * Time complexity: O(n) because while-loop traverses the entire String
     * Space complexity: O(n) because toLowerCase() and replaceAll() make new output Strings (since Strings are immutable)
     */
    public static boolean isPalindromeInPlace(String s) {
        // The ^ symbol in regex works like a "not"
        String cleaned = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int i = 0;
        int j = cleaned.length()-1;
        int half = cleaned.length()/2;
        while (i <= half && j >= half) {
            if (cleaned.charAt(i) != cleaned.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(" ")); // true
        System.out.println(isPalindrome("a.")); // true
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car")); // false
        System.out.println("------");
        System.out.println(isPalindromeInPlace(" ")); // true
        System.out.println(isPalindromeInPlace("a.")); // true
        System.out.println(isPalindromeInPlace("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindromeInPlace("race a car")); // false
    }
}
