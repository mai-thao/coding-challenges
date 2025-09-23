import configs.Config.*;

import java.util.Arrays;

import static configs.Config.buildTree;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * Diameter of a binary tree = length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * Length of a path between two nodes is represented by the number of edges between them.
 *
 * Time complexity: O(n) because visiting each node in the tree
 * Space complexity: O(n) because of the recursive call stack
 */
public class DiameterOfBinaryTree {
    private static int maxDiameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
    }

    private static int height(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int currDiameter = leftHeight + rightHeight;
        maxDiameter = Math.max(maxDiameter, currDiameter);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        TreeNode t1Node = buildTree(Arrays.asList(1,2,3,4,5));
        System.out.println(diameterOfBinaryTree(t1Node));   // 3
        maxDiameter = 0; // Have to explicitly reset the global var

        TreeNode t2Node = buildTree(Arrays.asList(1,2));
        System.out.println(diameterOfBinaryTree(t2Node));   // 1
        maxDiameter = 0;

        TreeNode t3Node = buildTree(Arrays.asList(1));
        System.out.println(diameterOfBinaryTree(t3Node));   // 0
        maxDiameter = 0;

        TreeNode t4Node = buildTree(Arrays.asList(2,null,3,null,4,null,5,null,6)); // Skewed tree
        System.out.println(diameterOfBinaryTree(t4Node));   // 4
    }
}
