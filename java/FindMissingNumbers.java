import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Given an array `nums` of n integers where `nums[i]` is in the range [1, n], return an array
 * of all the integers in the range [1, n] that do not appear in `nums`.
 *
 * Time complexity: O(n) because traversing the entire nums array
 * Space complexity: O(n) because needed HashSet where in worst case all nums are unique so they're stored into it
 */
public class FindMissingNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> uniqueNums = new HashSet<>();
        for (int num: nums) {
            uniqueNums.add(num);
        }
        ArrayList<Integer> missingNums = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!uniqueNums.contains(i)) {
                missingNums.add(i);
            }
        }
        return missingNums;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1})); // [5,6]
        System.out.println(findDisappearedNumbers(new int[]{1,1})); // [2]
        System.out.println(findDisappearedNumbers(new int[]{2})); // [2]
        System.out.println(findDisappearedNumbers(new int[]{1})); // []
    }
}
