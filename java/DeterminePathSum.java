import configs.Config.*;

import java.util.Arrays;
import java.util.Stack;

import static configs.Config.buildTree;

/**
 * Given the root of a binary tree and an integer `targetSum`, return true if the tree has a root-to-leaf
 * path such that adding up all the values along the path equals `targetSum`. A leaf is a node with no
 * children.
 */
public class DeterminePathSum {

    /**
     * Time complexity: O(n) because we traverse every node
     * Space complexity: O(2h) -> O(h) because constants are dropped and the stacks grow/shrink together. Also only nodes along the current path are stored, not all nodes in the tree
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>(); // A stack helps to keep track of the running sum and helps ignore incorrect paths
        nodeStack.push(root);
        sumStack.push(targetSum - root.val);

        while (!nodeStack.isEmpty()) {
            TreeNode currNode = nodeStack.pop();
            int currSum = sumStack.pop();
            if (currNode.left == null && currNode.right == null && currSum == 0) {
                return true;
            }
            if (currNode.right != null) {
                nodeStack.push(currNode.right);
                sumStack.push(currSum - currNode.right.val);
            }
            if (currNode.left != null) {
                nodeStack.push(currNode.left);
                sumStack.push(currSum - currNode.left.val);
            }
        }
        return false;
    }

    /**
     * Time complexity: O(n) because we traverse every node
     * Space complexity: O(h) because in worst case for skewed trees where the call stack grows with the height
     */
    public static boolean hasPathSumRecursive(TreeNode root, int targetSum) {
        if (root == null) return false;
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) return true;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    public static void main(String[] args) {
        System.out.println(hasPathSum(null, 0)); // [], 0 -> false
        System.out.println(hasPathSumRecursive(null, 0));

        System.out.println();

        System.out.println(hasPathSum(new TreeNode(1), 1)); // [1], 1 = true
        System.out.println(hasPathSumRecursive(new TreeNode(1), 1));

        System.out.println();

        System.out.println(hasPathSum(new TreeNode(1), 2)); // [1], 2 = false
        System.out.println(hasPathSumRecursive(new TreeNode(1), 2));

        System.out.println();

        TreeNode t1Root = buildTree(Arrays.asList(5,4,8,11,null,13,4,7,2,null,null,null,1));
        System.out.println(hasPathSum(t1Root, 22)); // [5,4,8,11,null,13,4,7,2,null,null,null,1], 22 -> true
        System.out.println(hasPathSumRecursive(t1Root, 22));

        System.out.println();

        TreeNode t2Root = buildTree(Arrays.asList(1,2,3));
        System.out.println(hasPathSum(t2Root, 5)); // [1,2,3], 5 -> false
        System.out.println(hasPathSumRecursive(t2Root, 5));

        System.out.println();

        TreeNode t3Root = buildTree(Arrays.asList(1,-2,-3,1,3,-2));
        System.out.println(hasPathSum(t3Root, 3)); // [1,-2,-3,1,3,-2], 3 -> false
        System.out.println(hasPathSumRecursive(t3Root, 3));
    }
}
