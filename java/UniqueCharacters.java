import java.util.HashSet;

/**
 * Given a string s, return true if it has all unique characters, or false otherwise.
 *
 * Examples-
 *
 * INPUT: s = "abcde"
 * OUTPUT: true because each character is unique
 *
 * INPUT: s = "abbcde"
 * OUTPUT: false because b is not unique
 */
class UniqueCharacters {
    /**
     * Time complexity: O(n^2) because the nested for-loop worst case traverses every possible pair of characters
     * Space complexity: O(1) because no extra dataset needed
     */
    public static boolean isUniqueBruteForce(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isUnique(String s) {
        HashSet<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (uniqueChars.contains(c)) {
                return false;
            }
            uniqueChars.add(c);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnique("abcde")); // true
        System.out.println(isUnique("a")); // true
        System.out.println(isUnique("hey")); // true
        System.out.println(isUnique("blahblah")); // false
        System.out.println("-----");
        System.out.println(isUniqueBruteForce("abcde")); // true
        System.out.println(isUniqueBruteForce("a")); // true
        System.out.println(isUniqueBruteForce("hey")); // true
        System.out.println(isUniqueBruteForce("blahblah")); // false
    }
}
