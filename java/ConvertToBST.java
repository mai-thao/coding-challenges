import configs.Config.*;

import static configs.Config.printLevelOrder;

/**
 * Given an integer array nums where the elements are sorted in ascending
 * (strictly increasing) order, convert it to a binary search tree.
 *
 * Given constraint: 1 <= nums.length <= 104
 *
 * Time complexity: O(n) because visiting each node once
 * Space complexity: O(n) because of the recursive call stack from dfs algorithm
 */
public class ConvertToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return dfs(0, nums.length - 1, nums);
    }

    private static TreeNode dfs(int left, int right, int[] nums) {
        if (left > right) return null;
        int midIdx = (left + right) / 2;
        TreeNode midNode = new TreeNode(nums[midIdx]);
        midNode.left = dfs(left, midIdx - 1, nums);
        midNode.right = dfs(midIdx + 1, right, nums);
        return midNode;
    }

    public static void main(String[] args) {
        TreeNode p1 = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        printLevelOrder(p1);

        TreeNode p2 = sortedArrayToBST(new int[]{1,3});
        printLevelOrder(p2);

        TreeNode p3 = sortedArrayToBST(new int[]{10});
        printLevelOrder(p3);
    }
}
