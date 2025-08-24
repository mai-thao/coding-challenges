/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer
 * range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 * Time complexity: O(n) because iterating each digit in the int
 * Space complexity: O(1) because not using extra memory, no extra data structures
 */
public class ReverseInteger {
    public static  int reverse(int x) {
        long reversed = 0;

        while (x != 0) {
            int popped = x % 10;                // get last digit
            x = x / 10;                         // remove last digit
            reversed = reversed * 10 + popped;  // add last digit in reverse order
        }

        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)reversed;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));           // 321
        System.out.println(reverse(-123));          // -321
        System.out.println(reverse(120));           // 21
        System.out.println(reverse(1534236469));    // 0 because exceed the Integer.MAX_VALUE
    }
}
