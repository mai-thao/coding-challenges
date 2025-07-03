import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode popped = queue.poll();
                if (popped.left != null && popped.right != null) {
                    TreeNode temp = popped.left;
                    popped.left = popped.right;
                    popped.right = temp;
                    queue.add(popped.left);
                    queue.add(popped.right);
                } else if (popped.left != null && popped.right == null) {
                    popped.right = popped.left;
                    queue.add(popped.right);
                } else if (popped.left == null && popped.right != null) {
                    popped.left = popped.right;
                    queue.add(popped.left);
                }
            }
        }
        return root;
    }
}
