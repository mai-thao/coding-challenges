import java.util.LinkedList;
import java.util.Queue;

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
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.add(root);
        queue2.add(subRoot);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode popped1 = queue1.poll();
            TreeNode popped2 = queue2.poll();
            if (popped1 == null && popped2 != null) {
                return false;
            } else if (popped1 != null && popped2 == null) {
                return false;
            }
            if (popped1 != null && popped2 != null) {
                if (popped1.val != popped2.val) {
                    return false;
                }
                queue1.add(popped1.left);
                queue1.add(popped1.right);
                queue2.add(popped2.left);
                queue2.add(popped2.right);
            }
        }
        return true;
    }
}
