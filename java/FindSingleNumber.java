import java.util.Arrays;

/**
 * Given a non-empty array of integers `nums`, every element appears twice except for one. Find that single one.
 *
 * Time complexity: O(n log n) because of using the built-in sorting algorithm
 * Space complexity: O(1) because not using any extra dataset
 */
public class FindSingleNumber {
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length) {
            if (i != nums.length - 1) {
                if (nums[i + 1] != nums[i]) {
                    return nums[i];
                }
                i += 2;
            } else {
                return nums[i];
            }
        }
        throw new IllegalStateException("There must be a solution!");
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,1})); // 1
        System.out.println(singleNumber(new int[]{4,1,2,1,2})); // 4
        System.out.println(singleNumber(new int[]{1})); // 1
    }
}
