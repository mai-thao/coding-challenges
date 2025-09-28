import configs.Config.*;

import java.util.Arrays;

import static configs.Config.buildTree;

/**
 * You are given the root of a full binary tree with the following properties:
 * - Leaf nodes have either the value 0 or 1, where 0 represents False and 1 represents True.
 * - Non-leaf nodes have either the value 2 or 3, where 2 represents the boolean OR and 3 represents the boolean AND.
 *
 * The evaluation of a node is as follows:
 * - If the node is a leaf node, the evaluation is the value of the node, i.e. True or False.
 * - Otherwise, evaluate the node's two children and apply the boolean operation of its value with the children's evaluations.
 *
 * Return the boolean result of evaluating the root node.
 *
 * A full binary tree is a binary tree where each node has either 0 or 2 children.
 *
 * A leaf node is a node that has zero children.
 *
 * Time complexity: O(n) because visiting each node once
 * Space complexity: O(n) because of recursive call stack
 */
public class EvaluateBinaryTree {
    public static boolean evaluateTree(TreeNode root) {
        if (root.val == 0) return false;
        else if (root.val == 1) return true;
        else if (root.val == 2) return evaluateTree(root.left) || evaluateTree(root.right);
        else return evaluateTree(root.left) && evaluateTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode p1Root = buildTree(Arrays.asList(2,1,3,null,null,0,1));
        System.out.println(evaluateTree(p1Root));   // true

        TreeNode p2Root = buildTree(Arrays.asList(0));
        System.out.println(evaluateTree(p2Root));   // false
    }
}
