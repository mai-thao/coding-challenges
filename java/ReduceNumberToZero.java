/**
 * Given an integer num, return the number of steps to reduce it to zero.
 *
 * In one step, if the current number is even, you have to divide it by 2,
 * otherwise, you have to subtract 1 from it.
 *
 * Time complexity: O(log n) because each division cuts the number in half each time
 * Space complexity: O(1) because no extra memory or dataset needed
 */
public class ReduceNumberToZero {
    public static int numberOfSteps(int num) {
        int result = 0;
        while (num != 0) {
            if (num % 2 == 0) { // Even
                num = num/2;
            } else { // Odd
                num -= 1;
            }
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));  // 6
        System.out.println(numberOfSteps(8));   // 4
        System.out.println(numberOfSteps(123)); // 12
        System.out.println(numberOfSteps(0));   // 0
    }
}
