/**
 * Given an array of integers `nums` (sorted in ascending order) and an integer `target`,
 * write a function to search `target` in `nums`. If `target` exists, then return its
 * index. Otherwise, return -1.
 *
 * Assume that all the integers in `nums` are unique!
 *
 * Examples-
 *
 * INPUT: nums = [-1,0,3,5,9,12], target = 9
 * OUTPUT: 4
 *
 * INPUT: nums = [-1,0,3,5,9,12], target = 2
 * OUTPUT: -1
 */
public class SearchArray {
    /**
     * Time complexity: O(n) because traversing all numbers in the entire array
     * Space complexity: O(1) because no extra dataset needed
     */
    public static int linearSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(linearSearch(new int[]{-1,0,3,5,9,12}, 9)); // 4
        System.out.println(linearSearch(new int[]{-1,0,3,5,9,12}, 2)); // -1
        System.out.println(linearSearch(new int[]{5}, 5)); // 0
    }
}
