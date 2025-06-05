/**
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * Palindrome is when all uppercase letters are converted to lowercase,
 * all non-alphanumeric characters are removed, and it still reads the same
 * forward and backward.
 *
 * Examples:
 * s = "A man, a plan, a canal: Panama"
 * Output: true because "amanaplanacanalpanama" is a palindrome
 *
 * s = race a car
 * Output: false because "raceacar" is not a palindrome
 *
 * s = " "
 * Output: true because an empty string reads the same backward and forward
 *
 * Time complexity: O(n) because both the for-loop and while-loop traverses the entire String
 * Space complexity: O(n) because needed a StringBuilder where worst case could store all characters
 */
class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        String lowercase = s.toLowerCase();
        for (char c: lowercase.toCharArray()) {
            if (c != ' ' && c != ',' && c != ':' && c != '.') { // Need to refine this, too much hardcoding cases
                sb.append(c);
            }
        }
        if (sb.isEmpty()) return true; // Edge case where input String was empty spaces
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

    public static void main(String[] args) {
        System.out.println(isPalindrome(" ")); // true
        System.out.println(isPalindrome("a.")); // true
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car")); // false
    }
}
