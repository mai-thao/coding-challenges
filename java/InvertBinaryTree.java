import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class InvertBinaryTree {
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
     * Time complexity: O(n) because traversing every node
     * Space complexity: O(n/2) -> O(n) because in perfectly balanced BT all leaf nodes are in the queue
     */
    public static TreeNode invertTree(TreeNode root) {
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
                } else if (popped.left != null) {
                    popped.right = popped.left;
                    popped.left = null;
                    queue.add(popped.right);
                } else if (popped.right != null) {
                    popped.left = popped.right;
                    popped.right = null;
                    queue.add(popped.left);
                }
            }
        }
        return root;
    }

    /**
     * Time complexity: O(n) because traversing every node
     * Space complexity: O(h) because in a skewed tree, the recursive call stack grows with the height
     */
    public static TreeNode invertTreeRecursive(TreeNode root) {
        if (root == null) return root;

        invertTreeRecursive(root.left);
        invertTreeRecursive(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    public static void printTreeNode(TreeNode root) {
        if (root == null) {
            System.out.print("Empty");
            return; // Break out of void method
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode popped = queue.poll();
                System.out.print(popped.val + ",");
                if (popped.left != null) {
                    queue.add(popped.left);
                }
                if (popped.right != null) {
                    queue.add(popped.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode t1Node1 = new TreeNode(1);
        TreeNode t1Node3 = new TreeNode(3);
        TreeNode t1Node2 = new TreeNode(2, t1Node1, t1Node3);
        TreeNode t1Node6 = new TreeNode(6);
        TreeNode t1Node9 = new TreeNode(9);
        TreeNode t1Node7 = new TreeNode(7, t1Node6, t1Node9);
        TreeNode t1root = new TreeNode(4, t1Node2, t1Node7);
        printTreeNode(t1root);
        System.out.print(" -> ");
        printTreeNode(invertTree(t1root)); // [4,2,7,1,3,6,9] -> [4,7,2,9,6,3,1]

        System.out.println();

        TreeNode t2Node1 = new TreeNode(1);
        TreeNode t2Node3 = new TreeNode(3);
        TreeNode t2root = new TreeNode(2, t2Node1, t2Node3);
        printTreeNode(t2root);
        System.out.print(" -> ");
        printTreeNode(invertTree(t2root)); // [2,1,3] -> [2,3,1]

        System.out.println();

        TreeNode t3Node2 = new TreeNode(2);
        TreeNode t3root = new TreeNode(1, t3Node2, null);
        printTreeNode(t3root);
        System.out.print(" -> ");
        printTreeNode(invertTree(t3root)); // [1,2] -> [1,null,2] ** The null is not printed

        System.out.println();
        printTreeNode(null);
        System.out.print(" -> ");
        printTreeNode(invertTree(null)); // [] -> []
    }
}
