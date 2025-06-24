import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an integer array nums, return true if any value appears 
 * more than once in the array, otherwise return false.
 * 
 * Examples-
 *
 * INPUT: nums = [1,2,3,3]
 * OUTPUT: true
 * 
 * INPUT: nums = [1,2,3,4]
 * OUTPUT: false
 */
class ContainsDuplicate {

    /**
     * Brute force solution for small input array
     *
     * Time complexity: O(n^2) because of nested loop where in worst case, looping through every possible num combinations
     * Space complexity: O(1) because no extra dataset needed
     */
    public static boolean hasDuplicateBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Best solution for large input array
     *
     * Time complexity: O(n) because looping whole array in worst case
     * Space complexity: O(n) because extra memory for HashSet & worst case storing all unique nums in it
     */
    public static boolean hasDuplicate(int[] nums) {
        HashSet<Integer> uniqueNums = new HashSet<>(); // HashSet contains only unique elem by default
        for (int num : nums) {
            if (uniqueNums.contains(num)) { // Dupe found
                return true;
            } else {
                uniqueNums.add(num);
            }
        }
        return false; // Reached the end so must not have dupes
    }

    public static void main(String[] args) {
        int[] testCase1 = new int[]{1,2,3,4};
        int[] testCase2 = new int[]{1,2,3,1};
        int[] testCase3 = new int[]{1,1,1,3,3,4,3,2,4,2};
        boolean result1 = hasDuplicate(testCase1);
        boolean result2 = hasDuplicate(testCase2);
        boolean result3 = hasDuplicate(testCase3);
        System.out.println("Array: " + Arrays.toString(testCase1) + " Output: " +  result1);
        System.out.println("Array: " + Arrays.toString(testCase2) + " Output: " + result2);
        System.out.println("Array: " + Arrays.toString(testCase3) + " Output: " + result3);
    }
}
