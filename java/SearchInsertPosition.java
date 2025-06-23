/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * Otherwise, return the index where it would be if it were inserted in order.\
 *
 * Examples-
 *
 * INPUT: nums = [1,3,5,6], target = 5
 * OUTPUT: 2
 *
 * INPUT: nums = [1,3,5,6], target = 2
 * OUTPUT: 1
 *
 * INPUT: nums = [1,3,5,6], target = 7
 * OUTPUT: 4
 *
 * Time complexity: O(log n) because halving the array during each loop
 * Space complexity: O(1) because no extra dataset needed
 */
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,5,6};
        int[] arr2 = new int[]{8};

        System.out.println(searchInsert(arr1, 5)); // 2
        System.out.println(searchInsert(arr1, 2)); // 1
        System.out.println(searchInsert(arr1, 7)); // 4
        System.out.println(searchInsert(arr2, 1)); // 0
        System.out.println(searchInsert(arr2, 9)); // 1
    }
}
