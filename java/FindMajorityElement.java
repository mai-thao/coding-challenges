import java.util.HashMap;

/**
 * Given an array `nums` of size `n`, return the majority element. The majority element is the element that appears
 * more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 * Time complexity: O(n) because traversing entire array
 * Space complexity: O(n) because creating a HashMap where worst case it'll store all unique elements in array
 */
public class FindMajorityElement {
    public static int majorityElement(int[] nums) {
        double majorPercentage = nums.length / 2;
        HashMap<Integer, Integer> numToOccurr = new HashMap<>();

        for (int num: nums) {
            numToOccurr.put(num, numToOccurr.getOrDefault(num, 0) + 1);
            if (numToOccurr.get(num) > majorPercentage) {
                return num;
            }
        }

        throw new IllegalArgumentException("There must be a solution!");
    }

    public static void main(String[] args) {
        try {
            System.out.println(majorityElement(new int[]{1,2,3})); // IllegalArgumentException thrown
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(majorityElement(new int[]{3,2,3})); // 3
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2})); // 2
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2})); // 2
        System.out.println(majorityElement(new int[]{4})); // 4
    }
}
