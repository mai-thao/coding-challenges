import configs.Config.*;

import java.util.Arrays;

import static configs.Config.buildTree;

/**
 * Given the root of a binary tree that consists of exactly 3 nodes: the root,
 * its left child, and its right child. Return true if the value of the root is
 * equal to the sum of the values of its two children, or false otherwise.
 *
 * Time complexity: O(1) because just simple arithmetic
 * Space complexity: O(1) because not using extra memory or dataset
 */
public class RootEqualsChildrenSum {
    public static boolean checkTree(TreeNode root) {
        return root.left.val + root.right.val == root.val;
    }

    public static void main(String[] args) {
        TreeNode p1 = buildTree(Arrays.asList(10,4,6));
        System.out.println(checkTree(p1));  // true

        TreeNode p2 = buildTree(Arrays.asList(5,3,1));
        System.out.println(checkTree(p2));  // false

        TreeNode p3 = buildTree(Arrays.asList(0,0,0));
        System.out.println(checkTree(p3));  // true

        TreeNode p4 = buildTree(Arrays.asList(0,1,-1));
        System.out.println(checkTree(p4));  // true

        TreeNode p5 = buildTree(Arrays.asList(-3,-5,2));
        System.out.println(checkTree(p5));  // true

        TreeNode p6 = buildTree(Arrays.asList(8,10,-2));
        System.out.println(checkTree(p6));  // true

        TreeNode p7 = buildTree(Arrays.asList(0,-100,100));
        System.out.println(checkTree(p7));  // true

        TreeNode p8 = buildTree(Arrays.asList(200,100,100));
        System.out.println(checkTree(p8));  // true
    }
}
