/**
 * Given an integer `n`, return the sum of all its digits.
 *
 * Examples-
 *
 * INPUT: n = 12345
 * OUTPUT: 15
 *
 * INPUT: nums = -123
 * OUTPUT: -6
 */
public class SumOfDigits {
    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n != 0) {
            int last = n % 10;
            sum += last;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigits(12345)); // 15
        System.out.println(sumOfDigits(9));     // 9
        System.out.println(sumOfDigits(0));     // 0
        System.out.println(sumOfDigits(9999));  // 36
        System.out.println(sumOfDigits(1001));  // 2
        System.out.println(sumOfDigits(-123));  // -6
    }
}
