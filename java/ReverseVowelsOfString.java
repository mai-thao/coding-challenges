import java.util.Set;
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
        // Straightforward and fastest way to check vowel equality
        // return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U';

        // Another approach using set, most suited for when set is huge and dynamically changing
        // Set<Character> vowels = Set.of('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U');
        // return vowels.contains(c);

        // Another approach using String.indexOf, more concise and easier to read (indexOf returns -1 if not found, index position otherwise)
        return "aeiouAEIOU".indexOf(c) >= 0;
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
