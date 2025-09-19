import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an integer array `nums` and an integer `val`, remove all occurrences
 * of `val` in `nums` in-place. The order of the elements may be changed. Then
 * return the number of elements in `nums` which are not equal to `val`.
 */
public class RemoveElement {
    /**
     * Since we don't care about elements after the returned answer, we can just use two pointer approach!
     *
     * Time complexity: O(n) because visiting each integer once
     * Space complexity: O(1) because not using extra memory or dataset (in-place!)
     */
    public static int removeElement(int[] nums, int val) {
        int openSpaceIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[openSpaceIdx] = nums[i];
                openSpaceIdx++;
            }
        }
        return openSpaceIdx;
    }

    /**
     * This solution is not in-place since it uses a queue and not optimal!
     *
     * Time complexity: O(n) because visiting each integer at most once
     * Space complexity: O(n) because of the queue where in worst case it can hold numbers
     */
    public static int removeElementWithQueue(int[] nums, int val) {
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

        System.out.println();

        System.out.println(removeElementWithQueue(new int[]{3,2,2,3}, 3));           // 2
        System.out.println(removeElementWithQueue(new int[]{0,1,2,2,3,0,4,2}, 2));   // 5
        System.out.println(removeElementWithQueue(new int[]{3,3,3}, 3));             // 0
        System.out.println(removeElementWithQueue(new int[]{3,3,3}, 1));             // 3
        System.out.println(removeElementWithQueue(new int[0], 1));                   // 0
    }
}
