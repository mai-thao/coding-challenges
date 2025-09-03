import java.util.HashSet;

/**
 * Write an algorithm to determine if a number `n` is happy. Return true if `n` is a happy number, and false if not.
 *
 * A happy number is a number defined by the following process:
 * - Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * - Repeat the process until the number equals 1, or it loops endlessly in a cycle.
 * - Those numbers for which this process ends in 1 are happy.
 *
 * Time complexity: O(log n) because given integer collapse into smaller number pretty quickly
 * Space complexity: O(log n) because set can hold all unique squared sums before detecting cycle or reaching 1
 */
public class HappyNumber {
    public static boolean isHappy(int n) {
        HashSet<Integer> visitedSquaredSums = new HashSet<>();
        while (n != 1) {
            n = squaredSum(n);
            if (visitedSquaredSums.contains(n)) {
                return false;
            }
            visitedSquaredSums.add(n);
        }
        return true;
    }

    public static int squaredSum(int n) {
        int squaredSum = 0;
        while (n != 0) {
            int popped = n % 10;
            n /= 10;
            squaredSum += (popped * popped);
        }
        return squaredSum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));        // true
        System.out.println(isHappy(7));         // true
        System.out.println(isHappy(1));         // true
        System.out.println(isHappy(2));         // false
        System.out.println(isHappy(200));       // false
        System.out.println(isHappy(9999999));   // false
    }
}
