import configs.Config.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static configs.Config.buildTree;

/**
 * Given the roots of two binary trees `root` and `subRoot`, return true if there is a subtree of `root` with `subRoot` and false otherwise.
 * A subtree of a binary tree has the same structure and node values. A subtree could be a subtree of itself.
 */
public class SubtreeOfAnotherTree {

    /**
     * Time complexity: O(n*m) because traversing all nodes in both `root` and `subRoot` trees
     * Space complexity: O(max(w,h)) because largest value of width (queue stores all leaf nodes in perfectly balanced BT) or height (call stack in skewed tree)
     */
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
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
    public static boolean isSubtreeRecursive(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSame(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Helper function to check equality of two trees: same structure and same values
    private static boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (subRoot == null || root == null) return false;
        if (root.val != subRoot.val) return false;

        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }

    public static void main(String[] args) {
        TreeNode p1Root = buildTree(Arrays.asList(3,4,5,1,2));
        TreeNode p1SubRoot = buildTree(Arrays.asList(4,1,2));
        System.out.println(isSubtree(p1Root, p1SubRoot)); // true
        System.out.println(isSubtreeRecursive(p1Root, p1SubRoot)); // true

        TreeNode p2Root = buildTree(Arrays.asList(3,4,5,1,2,null,null,null,null,0));
        TreeNode p2SubRoot = buildTree(Arrays.asList(4,1,2));
        System.out.println(isSubtree(p2Root, p2SubRoot)); // false
        System.out.println(isSubtreeRecursive(p2Root, p2SubRoot)); // false
    }
}
