import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers and target integer, return the indices of the
 * two numbers that add up to the target. There will be exactly one solution.
 * The same element may not be used twice. The answer can be in any order.
 *
 * Examples-
 *
 * INPUT: nums = [2,7,11,15], target = 9
 * OUTPUT: [0,1]
 *
 * INPUT: nums = [3,2,4], target = 6
 * OUTPUT: [1,2]
 *
 * INPUT: nums = [3,3], target = 6
 * OUTPUT: [0,1]
 */
class TwoSum {
    /**
     * Time complexity: O(n^2) because checking every possible num combination with nested loop where worst case answers are the last elements
     * Space complexity: O(1) no extra dataset needed
     */
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("There should be exactly one solution!");
    }

    /**
     * Time complexity: O(n) because worst case solutions are last elements so looping entire array
     * Space complexity: O(n) because need extra HashMap where worst case stores all elements
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numIdx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numIdx.containsKey(complement)) {
                return new int[]{i, numIdx.get(complement)};
            } else {
                numIdx.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("There should be exactly one solution!");
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSumBruteForce(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(twoSumBruteForce(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(twoSumBruteForce(new int[]{3,3}, 6)));
        System.out.println(Arrays.toString(twoSumBruteForce(new int[]{3,2,3}, 6)));
        System.out.println("-------");
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3,3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,3}, 6)));
    }
}
