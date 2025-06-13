import java.util.HashMap;

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 * Time complexity: O(n) because traversed the entire String
 * Space complexity: O(n) because created a HashMap dataset
 */
public class FirstUniqueCharacter {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> charCounts = new HashMap<>();
        for (char c: s.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (charCounts.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("helloworld")); // h at index 0
        System.out.println(firstUniqChar("hellohelloworld")); // w at index 10
        System.out.println(firstUniqChar("helloworldhelloworld")); // -1
        System.out.println(firstUniqChar("aabb")); // -1
    }
}
