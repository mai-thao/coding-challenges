public class RomanToInteger {
    public static int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int currCharInteger = conversion(s.charAt(i));
            if (i > 0) {
                int prevCharInteger = conversion(s.charAt(i-1));
                if (currCharInteger > prevCharInteger) {
                    sum -= (2*prevCharInteger); // undo the prev
                }
            }
            sum += currCharInteger;
        }
        return sum;
    }

    private static int conversion(char c) {
        if (c == 'I') return 1;
        else if (c == 'V') return 5;
        else if (c == 'X') return 10;
        else if (c == 'L') return 50;
        else if (c == 'C') return 100;
        else if (c == 'D') return 500;
        else return 1000;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("I"));        // 1
        System.out.println(romanToInt("III"));      // 3
        System.out.println(romanToInt("MMM"));      // 3000
        System.out.println(romanToInt("LVIII"));    // 58
        System.out.println(romanToInt("MCMXCIV"));  // 1994
    }
}
