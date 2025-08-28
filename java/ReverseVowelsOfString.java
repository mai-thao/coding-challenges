import java.util.Stack;

/**
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * Vowels: 'a', 'e', 'i', 'o', and 'u'
 * They can appear in both lower and upper cases, more than once.
 *
 * Time complexity: O(n) because iterating each character in the string
 * Space complexity: O(n) because created stack to store vowels where in worst case, all char in string are vowels
 */
public class ReverseVowelsOfString {
    public static String reverseVowels(String s) {
        Stack<Character> vowelChars = new Stack<>();
        char[] sArray = s.toCharArray();

        for (char c: sArray) {
            if (isVowel(c)) {
                vowelChars.push(c);
            }
        }

        for (int i = 0; i < sArray.length; i++) {
            if (isVowel(sArray[i])) {
                char popped = vowelChars.pop();
                sArray[i] = popped;
            }
        }

        return String.valueOf(sArray);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U';
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("IceCreAm"));  // AceCreIm
        System.out.println(reverseVowels("leetcode"));  // leotcede
        System.out.println(reverseVowels("a"));         // a
        System.out.println(reverseVowels("racecar"));   // racecar
        System.out.println(reverseVowels("aeiou"));     // uoiea
        System.out.println(reverseVowels("AEIOU"));     // UOIEA
    }
}
