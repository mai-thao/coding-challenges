/**
 * Given a roman numeral, convert it to an integer.
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * I -> 1
 * V -> 5
 * X -> 10
 * L -> 50
 * C -> 100
 * D -> 500
 * M -> 1000
 *
 * Roman numerals are usually written largest to smallest from left to right. However,
 * the numeral for four is not IIII. Instead, the number four is written as IV. Because
 * the one is before the five we subtract it making four. The same principle applies to
 * the number nine, which is written as IX. There are 6 instances for subtraction:
 * - I can be placed before V (5) and X (10) to make 4 and 9
 * - X can be placed before L (50) and C (100) to make 40 and 90
 * - C can be placed before D (500) and M (1000) to make 400 and 900
 *
 * Time complexity: O(n) because visiting each character in the string once
 * Space complexity: O(1) because no extra dataset or memory used
 */
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
