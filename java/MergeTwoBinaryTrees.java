import java.util.*;

import static configs.Config.*;

/**
 * Merge two binary trees into a new binary tree. If two nodes overlap, then
 * sum the values up. Otherwise, the non-null node will be used as the node
 * of the new tree. Return the merged tree.
 *
 * Note: The merging process must start from the root nodes of both trees.
 *
 * Time complexity: O(n) because visiting each node once
 * Space complexity: O(n) because of recursion stack in the worst case of unbalanced tree
 */
public class MergeTwoBinaryTrees {
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        TreeNode newNode = new TreeNode(root1.val + root2.val);
        newNode.left = mergeTrees(root1.left, root2.left);
        newNode.right = mergeTrees(root1.right, root2.right);

        return newNode;
    }

    public static void main(String[] args) {
        TreeNode q1LeftRoot = buildTree(Arrays.asList(1,3,2,5));
        TreeNode q1RightRoot = buildTree(Arrays.asList(2,1,3,null,4,null,7));
        printLevelOrder(q1LeftRoot); // [1,3,2,5]
        printLevelOrder(q1RightRoot); // [2,1,3,null,4,null,7]
        printLevelOrder(mergeTrees(q1LeftRoot, q1RightRoot)); // [3,4,5,5,4,null,7]

        TreeNode q2LeftRoot = buildTree(Arrays.asList(1));
        TreeNode q2RightRoot = buildTree(Arrays.asList(1,2));
        printLevelOrder(q2LeftRoot); // [1]
        printLevelOrder(q2RightRoot); // [1,2]
        printLevelOrder(mergeTrees(q2LeftRoot, q2RightRoot)); // [2,2]

        TreeNode q3LeftRoot = buildTree(Arrays.asList(1,3,2,5));
        printLevelOrder(q3LeftRoot); // [1,3,2,5]
        printLevelOrder(mergeTrees(null, q3LeftRoot)); // [1,3,2,5]
    }
}
