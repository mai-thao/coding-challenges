import java.util.ArrayList;
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
         ArrayList<Integer> srList = buildList(subRoot);

        Queue<TreeNode> rQueue = new LinkedList<>();
        rQueue.add(root);
        while(!rQueue.isEmpty()) {
            TreeNode popped = rQueue.poll();
            if (popped.val == subRoot.val) {
                 ArrayList<Integer> poppedList = buildList(popped);
                 if (poppedList.equals(srList)) {
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


    private ArrayList<Integer> buildList(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode popped = queue.poll();
            list.add(popped.val);
            if (popped.left != null) {
                queue.add(popped.left);
            }
            if (popped.right != null) {
                queue.add(popped.right);
            }
        }
        return list;
    }
}
