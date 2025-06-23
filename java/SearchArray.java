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

    /**
     * Time complexity: O(log n) because halving the array each time
     * Space complexity: O(1) because no extra dataset needed
     */
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1; // Don't need to check mid again
            } else {
                left = mid + 1; // Don't need to check mid again
            }
        }
        return -1;
    }

    /**
     * Time complexity: O(log n) because halving the array each time
     * Space complexity: O(log n) because using the recursive call stack with each halving step
     */
    public static int recursiveSearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return recursiveSearch(nums, left, mid - 1, target);
        } else {
            return recursiveSearch(nums, mid + 1, right, target);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{-1,0,3,5,9,12};
        int[] arr2 = new int[]{5};
        int[] arr3 = new int[]{1,3,5,6};

        System.out.println(linearSearch(arr1, 9)); // 4
        System.out.println(linearSearch(arr1, 2)); // -1
        System.out.println(linearSearch(arr2, 5)); // 0
        System.out.println(linearSearch(arr3, 7)); // -1

        System.out.println();

        System.out.println(binarySearch(arr1, 9)); // 4
        System.out.println(binarySearch(arr1, 2)); // -1
        System.out.println(binarySearch(arr2, 5)); // 0
        System.out.println(binarySearch(arr3, 7)); // -1

        System.out.println();

        System.out.println(recursiveSearch(arr1, 0, arr1.length-1, 9)); // 4
        System.out.println(recursiveSearch(arr1, 0, arr1.length-1, 2)); // -1
        System.out.println(recursiveSearch(arr2, 0, arr2.length-1,  5)); // 0
        System.out.println(recursiveSearch(arr3, 0, arr3.length-1, 7)); // -1
    }
}
