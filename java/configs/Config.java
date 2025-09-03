package configs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Config {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode buildTree(List<Integer> values) {
        TreeNode root = new TreeNode(values.getFirst());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.size()) {
            TreeNode current = queue.poll();

            if (i < values.size() && values.get(i) != null) {
                current.left = new TreeNode(values.get(i));
                queue.offer(current.left);
            }
            i++;

            if (i < values.size() && values.get(i) != null) {
                current.right = new TreeNode(values.get(i));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // Helper to visualize the tree with BFS traversal
    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.add("null");
            } else {
                result.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        System.out.println(result);
    }
}
