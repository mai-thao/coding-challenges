import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings, check if they are anagrams of each other.
 *
 * Anagram: a word formed by rearranging the letters of a different word or phrase,
 * using all the original letters exactly once.
 *
 * Examples-
 *
 * INPUT: s = "anagram", t = "nagaram"
 * OUTPUT: true
 *
 * INPUT: s = "rat", t = "car"
 * OUTPUT: false
 *
 * Time complexity: O(n) because looping through entire String (no nested loops)
 * Space complexity: O(2n) -> drop constants -> O(n) for worst case when all characters are distinct
 */
class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) { // Base case if they're not same length
            return false;
        }
        HashMap<Character, Integer> sOccurrence = new HashMap<>();
        HashMap<Character, Integer> tOccurrence = new HashMap<>();

        // Set up the occurrence maps
        for (char c: s.toCharArray()) {
            if (sOccurrence.containsKey(c)) {
                sOccurrence.put(c, sOccurrence.get(c) + 1);
            } else {
                sOccurrence.put(c, 1);
            }
        }
        for (char c: t.toCharArray()) {
            if (tOccurrence.containsKey(c)) {
                tOccurrence.put(c, tOccurrence.get(c) + 1);
            } else {
                tOccurrence.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry: sOccurrence.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (tOccurrence.containsKey(key)) {
                if (!tOccurrence.get(key).equals(value)) {
                    return false; // Key exists but occurrence mismatch so not anagram
                }
            } else {
                return false; // Key doesn't exist in one string, so not anagram
            }

        }
        return true; // Reached the end of occurrence comparison so both are anagrams
    }

    public static void main(String[] args) {
        System.out.println("Strings: rat & cat, output: " + isAnagram("rat", "car"));
        System.out.println("Strings: anagram & nagaram, output: " + isAnagram("anagram", "nagaram"));
    }
}
