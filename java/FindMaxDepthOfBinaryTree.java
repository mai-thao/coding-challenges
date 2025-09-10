import configs.Config.*;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, return its maximum depth. A binary tree's maximum depth is the
 * number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class FindMaxDepthOfBinaryTree {

    /**
     * This solution uses an iterative Breadth-First Search approach: traverses level-by-level and count the depth!
     *
     * Time complexity: O(n) where n is the number of nodes where all nodes are traversed once
     * Space complexity: O(n/2) -> O(n) after dropping constants, for when it's a perfectly balanced binary tree where all leaf nodes are stored in the queue
     */
    public static int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) return depth;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode popped = queue.poll();
                if (popped.left != null) {
                    queue.add(popped.left);
                }
                if (popped.right != null) {
                    queue.add(popped.right);
                }
            }
            depth++;
        }
        return depth;
    }

    /**
     * This solution uses recursive Depth-First Search approach: add 1 to account for current node and
     * calculating the maximum DEPTH between the left and right sides!
     *
     * Time complexity: O(n) where n is the number of nodes where all nodes are traversed once
     * Space complexity: O(h) for the recursive stack from the height of the tree (skewed tree)
     */
    public static int maxDepthRecursive(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepthRecursive(root.left),  maxDepthRecursive(root.right));
    }

    public static void main(String[] args) {
        TreeNode t1Node15 = new TreeNode(15);
        TreeNode t1Node7 = new TreeNode(7);
        TreeNode t1Node20 = new TreeNode(20, t1Node15, t1Node7);
        TreeNode t1Node9 = new TreeNode(9);
        TreeNode t1Node3 = new TreeNode(3, t1Node9, t1Node20);
        System.out.println(maxDepth(t1Node3)); // [3,9,20,null,null,15,7] -> 3
        System.out.println(maxDepthRecursive(t1Node3));

        System.out.println("-----");

        TreeNode t2Node2 = new TreeNode(2);
        TreeNode t2Node1 = new TreeNode(1, null, t2Node2);
        System.out.println(maxDepth(t2Node1)); // [1,null,2] -> 2
        System.out.println(maxDepthRecursive(t2Node1));

        System.out.println("-----");

        System.out.println(maxDepth(null)); // [] -> 0
        System.out.println(maxDepthRecursive(null));

        System.out.println("-----");

        TreeNode t4Node5 = new TreeNode(5);
        System.out.println(maxDepth(t4Node5)); // [5] -> 1
        System.out.println(maxDepthRecursive(t4Node5));
    }
}
