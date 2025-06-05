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
