import java.util.HashSet;

class UniqueCharacters {
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
        System.out.println(isUnique("blahblah")); // false
        System.out.println(isUnique("hey")); // true
    }
}
