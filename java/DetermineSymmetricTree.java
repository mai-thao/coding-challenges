import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e. symmetric around its center).
 */
public class DetermineSymmetricTree {
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

    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int currLevelNodes = queue.size();
            if (currLevelNodes == 1) {
                TreeNode currNode = queue.poll();
                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            } else {
                Stack<TreeNode> stack = new Stack<>();
                for (int i = 0 ; i < currLevelNodes/2; i++) {
                    TreeNode currNode = queue.poll();
                    if (currNode.left != null) queue.add(currNode.left);
                    if (currNode.right != null) queue.add(currNode.right);
                    stack.push(currNode);
                }
                for (int i = 0; i < currLevelNodes/2; i++) {
                    TreeNode leftCurrNode = queue.poll();
                    if (leftCurrNode.left != null) queue.add(leftCurrNode.left);
                    if (leftCurrNode.right != null) queue.add(leftCurrNode.right);
                    TreeNode rightCurrNode = stack.pop();
                    if (leftCurrNode.val != rightCurrNode.val) return false;
                }
            }
        }
        return true;
    }

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
        System.out.println(isSymmetricRecursive(t1Root)); // [1,2,2,3,4,4,3] -> true

        TreeNode t2LeftNode3 = new TreeNode(3);
        TreeNode t2LeftNode2 = new TreeNode(2, null, t2LeftNode3);
        TreeNode t2RightNode3 = new TreeNode(3);
        TreeNode t2RightNode2 = new TreeNode(2, null, t2RightNode3);
        TreeNode t2Root = new TreeNode(1, t2LeftNode2, t2RightNode2);
        System.out.println(isSymmetricRecursive(t2Root)); // [1,2,2,null,3,null,3] -> false

        System.out.println(isSymmetricRecursive(new TreeNode(5))); // [5] -> true
    }
}
