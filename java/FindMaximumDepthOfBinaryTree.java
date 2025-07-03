import java.util.LinkedList;
import java.util.Queue;

public class FindMaximumDepthOfBinaryTree {
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

    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) return depth;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode popped = queue.poll();
                if (popped.left != null) {
                    queue.add(popped.left);
                } else if (popped.right != null) {
                    queue.add(popped.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
