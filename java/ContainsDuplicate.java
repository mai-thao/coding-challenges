import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an integer array nums, return true if any value appears 
 * more than once in the array, otherwise return false.
 * 
 * Examples:
 * nums = [1,2,3,3] 
 * Output: true
 * 
 * nums = [1,2,3,4]
 * Output: false
 *
 * Time complexity: O(n) because looping whole array in worst case
 * Space complexity: O(n) because extra memory for HashSet & worst case storing all unique nums in it
 */
class ContainsDuplicate {
    public static boolean hasDuplicate(int[] nums) {
        HashSet<Integer> uniqueNums = new HashSet<>(); // HashSet contains only unique elem by default
        for (int i = 0; i < nums.length; i++) {
            if (uniqueNums.contains(nums[i])) { // Dupe found
                return true;
            } else {
                uniqueNums.add(nums[i]);
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
