/**
 * Given a two-digit integer `n`. Return the sum of its digits.
 *
 * Note: `n` is only a positive two-digit integer and is between 10 <= n <= 99.
 *
 * Time complexity: O(n) because visiting each digit in the int
 * Space complexity: O(1) because not creating extra memory or dataset
 */
public class SumUpDigits {
    public static int digitSum(int n) {
        int sum = 0;
        while (n != 0) {
            int popped = n % 10;
            sum += popped;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(digitSum(29)); // 11
        System.out.println(digitSum(10)); // 1
        System.out.println(digitSum(25)); // 7
        System.out.println(digitSum(99)); // 18
        System.out.println(digitSum(55)); // 10
    }
}
