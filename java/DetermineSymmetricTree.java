import configs.Config.*;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e. symmetric around its center).
 */
public class DetermineSymmetricTree {

    /**
     * Time complexity: O(n) because traversing every node in the tree
     * Space complexity: O(n) because storing every node in both queues
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;

        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();

        leftQueue.add(root.left);
        rightQueue.add(root.right);

        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            TreeNode leftCurrNode = leftQueue.poll();
            TreeNode rightCurrNode = rightQueue.poll();

            if (leftCurrNode == null && rightCurrNode == null) continue; // `continue` keyword skips current iteration
            if (leftCurrNode == null || rightCurrNode == null) return false;
            if (leftCurrNode.val != rightCurrNode.val) return false;

            // Order matters for symmetry so pay special attention!
            leftQueue.add(leftCurrNode.left);
            leftQueue.add(leftCurrNode.right);
            rightQueue.add(rightCurrNode.right);
            rightQueue.add(rightCurrNode.left);
        }
        return true;
    }

    /**
     * Time complexity: O(n) because traversing every node in the tree
     * Space complexity: O(n/2) -> O(n) dropping constants where in perfect BT at leaf level, all nodes are stored into queues
     */
    public static boolean isSymmetricRecursive(TreeNode root) {
        return isMirror(root, root);
    }

    // Helper fxn for recursive approach
    private static boolean isMirror(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot == null && rightRoot == null) return true;
        if (leftRoot == null || rightRoot == null) return false;
        return (leftRoot.val == rightRoot.val) && isMirror(leftRoot.left, rightRoot.right) && isMirror(leftRoot.right, rightRoot.left);
    }

    public static void main(String[] args) {
        TreeNode t1LeftNode3 = new TreeNode(3);
        TreeNode t1LeftNode4 = new TreeNode(4);
        TreeNode t1LeftNode2 = new TreeNode(2, t1LeftNode3, t1LeftNode4);
        TreeNode t1RightNode4 = new TreeNode(4);
        TreeNode t1RightNode3 = new TreeNode(3);
        TreeNode t1RightNode2 = new TreeNode(2, t1RightNode4, t1RightNode3);
        TreeNode t1Root = new TreeNode(1, t1LeftNode2, t1RightNode2);
        System.out.println(isSymmetric(t1Root)); // [1,2,2,3,4,4,3] -> true
        System.out.println(isSymmetricRecursive(t1Root));

        System.out.println();

        TreeNode t2LeftNode3 = new TreeNode(3);
        TreeNode t2LeftNode2 = new TreeNode(2, null, t2LeftNode3);
        TreeNode t2RightNode3 = new TreeNode(3);
        TreeNode t2RightNode2 = new TreeNode(2, null, t2RightNode3);
        TreeNode t2Root = new TreeNode(1, t2LeftNode2, t2RightNode2);
        System.out.println(isSymmetric(t2Root)); // [1,2,2,null,3,null,3] -> false
        System.out.println(isSymmetricRecursive(t2Root));

        System.out.println();

        System.out.println(isSymmetric(new TreeNode(5))); // [5] -> true
        System.out.println(isSymmetricRecursive(new TreeNode(5)));
    }
}
