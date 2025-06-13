import java.util.HashSet;

/**
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 *
 * Examples:
 * nums = [3,0,1]
 * Output: 2 is the missing number
 *
 * nums = [0,1]
 * Output: 2 is the missing number
 *
 * nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8 is the missing number
 */
public class MissingNumber {
    /**
     * Time complexity: O(n) because traversing each int in the array
     * Space complexity: O(1) because not using any extra dataset
     */
    public static int missingNumberSummation(int[] nums) {
        int n = nums.length;
        int expectedSum = 0;
        for (int i = 0; i <= n; i++) {
            expectedSum += i;
        }
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        return expectedSum - sum;
    }

    /**
     * Time complexity: O(n) because traversing each int in the array
     * Space complexity: O(n) because using HashSet dataset to store each num
     */
    public static int missingNumberHashSet(int[] nums) {
        HashSet<Integer> existingNums = new HashSet<>();
        for (int num: nums) {
            existingNums.add(num);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!existingNums.contains(i)) {
                return i;
            }
        }
        throw new IllegalStateException("There must be a solution!");
    }

    public static void main(String[] args) {
        System.out.println(missingNumberSummation(new int[]{3,0,1})); // 2
        System.out.println(missingNumberSummation(new int[]{0,1})); // 2
        System.out.println(missingNumberSummation(new int[]{0})); // 1
        System.out.println(missingNumberSummation(new int[]{9,6,4,2,3,5,7,0,1})); // 8

        System.out.println();

        System.out.println(missingNumberHashSet(new int[]{3,0,1}));
        System.out.println(missingNumberHashSet(new int[]{0,1}));
        System.out.println(missingNumberHashSet(new int[]{0}));
        System.out.println(missingNumberHashSet(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}
