import java.util.Stack;

/**
 * Given the root of a binary tree and an integer `targetSum`, return true if the tree has a root-to-leaf
 * path such that adding up all the values along the path equals `targetSum`. A leaf is a node with no
 * children.
 */
public class DeterminePathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>(); // A stack helps to ignore the wrong path
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
}
