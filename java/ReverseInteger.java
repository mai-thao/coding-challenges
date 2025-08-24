/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer
 * range [-231, 231 - 1], then return 0.
 *
 * Time complexity:
 * Space complexity:
 */
public class ReverseInteger {
    public static  int reverse(int x) {
        int reversed = 0;

        while (x != 0) {
            int popped = x % 10;                // get last digit
            x = x / 10;                         // remove last digit
            reversed = reversed * 10 + popped;  // add last digit in reverse order
        }

        return reversed;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));   // 321
        System.out.println(reverse(-123));  // -321
        System.out.println(reverse(120));   // 21
    }
}
