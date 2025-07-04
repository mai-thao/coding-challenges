import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given the roots of two binary trees `root` and `subRoot`, return true if there is a subtree of `root` with `subRoot` and false otherwise.
 * A subtree of a binary tree has the same structure and node values. A subtree could be a subtree of itself.
 */
public class SubtreeOfAnotherTree {
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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> rQueue = new LinkedList<>();
        rQueue.add(root);

        while(!rQueue.isEmpty()) {
            TreeNode popped = rQueue.poll();
            if (popped.val == subRoot.val) {
                if (checkNodes(popped, subRoot)) {
                    return true;
                }
            }
            if (popped.left != null) {
                rQueue.add(popped.left);
            }
            if (popped.right != null) {
                rQueue.add(popped.right);
            }
        }
        return false;
    }


    private boolean checkNodes(TreeNode root, TreeNode subRoot) {
        Stack<TreeNode> rStack = new Stack<>();
        Stack<TreeNode> sStack = new Stack<>();

        rStack.push(root);
        sStack.push(subRoot);

        while(!rStack.isEmpty() && !sStack.isEmpty()) {
            TreeNode rPopped = rStack.pop();
            TreeNode sPopped = sStack.pop();
            if (rPopped.val != sPopped.val) {
                return false;
            }
            if (rPopped.left != null) {
                if (sPopped.left == null) {
                    return false;
                }
                rStack.add(rPopped.left);
            }
            if (rPopped.right !=  null) {
                if (sPopped.right == null) {
                    return false;
                }
                rStack.add(rPopped.right);
            }
            if (sPopped.left != null) {
                if (rPopped.left == null) {
                    return false;
                }
                sStack.add(sPopped.left);
            }
            if (sPopped.right !=  null) {
                if (rPopped.right == null) {
                    return false;
                }
                sStack.add(sPopped.right);
            }
        }
        return true;
    }
}
