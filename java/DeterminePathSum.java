import java.util.Stack;

/**
 * Given the root of a binary tree and an integer `targetSum`, return true if the tree has a root-to-leaf
 * path such that adding up all the values along the path equals `targetSum`. A leaf is a node with no
 * children.
 */
public class DeterminePathSum {
    public static class TreeNode {
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
        System.out.println(hasPathSum(new TreeNode(1), 1)); // [1], 1 = true
        System.out.println(hasPathSumRecursive(new TreeNode(1), 1));
        System.out.println(hasPathSum(new TreeNode(1), 2)); // [1], 2 = false
        System.out.println(hasPathSumRecursive(new TreeNode(1), 2));

        System.out.println();

        TreeNode t1Node7 = new TreeNode(7);
        TreeNode t1Node2 = new TreeNode(2);
        TreeNode t1Node11 = new TreeNode(11, t1Node7, t1Node2);
        TreeNode t1NodeLeft4 = new TreeNode(4, t1Node11, null);
        TreeNode t1Node1 = new TreeNode(1);
        TreeNode t1Node13 = new TreeNode(13);
        TreeNode t1NodeRight4 = new TreeNode(4, null, t1Node1);
        TreeNode t1Node8 = new TreeNode(8, t1Node13, t1NodeRight4);
        TreeNode t1Root = new TreeNode(5, t1NodeLeft4, t1Node8);
        System.out.println(hasPathSum(t1Root, 22)); // [5,4,8,11,null,13,4,7,2,null,null,null,1], 22 -> true
        System.out.println(hasPathSumRecursive(t1Root, 22));

        System.out.println();

        TreeNode t2Node2 = new TreeNode(2);
        TreeNode t2Node3 = new TreeNode(3);
        TreeNode t2Root = new TreeNode(1, t2Node2, t2Node3);
        System.out.println(hasPathSum(t2Root, 5)); // [1,2,3], 5 -> false
        System.out.println(hasPathSumRecursive(t2Root, 5));

        System.out.println();

        TreeNode t3Node1 = new TreeNode(1);
        TreeNode t3Node3 = new TreeNode(3);
        TreeNode t3NodeLeftNeg2 = new TreeNode(-2, t3Node1, t3Node3);
        TreeNode t3NodeRightNeg2 = new TreeNode(-2);
        TreeNode t3NodeNeg3 = new TreeNode(-3, t3NodeLeftNeg2, null);
        TreeNode t3Root = new TreeNode(1, t3NodeRightNeg2, t3NodeNeg3);
        System.out.println(hasPathSum(t3Root, 3)); // [1,-2,-3,1,3,-2], 3 -> false
        System.out.println(hasPathSumRecursive(t3Root, 3));
    }
}
