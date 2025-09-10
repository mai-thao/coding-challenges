import configs.Config.*;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the roots of two binary trees `root` and `subRoot`, return true if there is a subtree of `root` with `subRoot` and false otherwise.
 * A subtree of a binary tree has the same structure and node values. A subtree could be a subtree of itself.
 */
public class SubtreeOfAnotherTree {

    /**
     * Time complexity: O(n*m) because traversing all nodes in both `root` and `subRoot` trees
     * Space complexity: O(max(w,h)) because largest value of width (queue stores all leaf nodes in perfectly balanced BT) or height (call stack in skewed tree)
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> rQueue = new LinkedList<>();
        rQueue.add(root);

        while(!rQueue.isEmpty()) {
            TreeNode popped = rQueue.poll();
            if (popped.val == subRoot.val) {
                if (isSame(popped, subRoot)) {
                    return true;
                }
            }
            if (popped.left != null) {
                rQueue.add(popped.left);
            }
            if (popped.right != null) {
                rQueue.add(popped.right);
            }
        }
        return false;
    }

    /**
     * Time complexity: O(n*m) because traversing all nodes in both `root` and `subRoot` trees
     * Space complexity: O(h) because of the height of call stack in skewed tree (aka O(n) too)
     */
    public boolean isSubtreeRecursive(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSame(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Helper function to check equality of two trees: same structure and same values
    private boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (subRoot == null || root == null) return false;
        if (root.val != subRoot.val) return false;

        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }
}
