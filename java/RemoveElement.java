import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an integer array `nums` and an integer `val`, remove all occurrences
 * of `val` in `nums` in-place. The order of the elements may be changed. Then
 * return the number of elements in `nums` which are not equal to `val`.
 *
 * Time complexity: O(n) because visiting each integer at most once
 * Space complexity: O(n) because of the queue where in worst case it can hold numbers
 */
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        Queue<Integer> visitedNums = new LinkedList<>();

        for (int num: nums) {
            if (num != val) {
                visitedNums.offer(num);
            }
        }
        int totalNums = visitedNums.size();
        int i = 0;

        while (!visitedNums.isEmpty()) {
            nums[i] = visitedNums.poll();
            i++;
        }

        return totalNums;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3,2,2,3}, 3));           // 2
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));   // 5
        System.out.println(removeElement(new int[]{3,3,3}, 3));             // 0
        System.out.println(removeElement(new int[]{3,3,3}, 1));             // 3
        System.out.println(removeElement(new int[0], 1));                   // 0
    }
}
