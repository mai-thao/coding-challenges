import configs.Config.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static configs.Config.buildTree;
import static configs.Config.printLevelOrder;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class InvertBinaryTree {

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

    public static void main(String[] args) {
        TreeNode p1Root = buildTree(Arrays.asList(4,2,7,1,3,6,9));
        printLevelOrder(p1Root);
        System.out.print("->");
        printLevelOrder(invertTree(p1Root)); // [4,2,7,1,3,6,9] -> [4,7,2,9,6,3,1]

        System.out.println();

        TreeNode p2Root = buildTree(Arrays.asList(2,1,3));
        printLevelOrder(p2Root);
        System.out.print("->");
        printLevelOrder(invertTree(p2Root)); // [2,1,3] -> [2,3,1]

        System.out.println();

        TreeNode p3Root = buildTree(Arrays.asList(1,2));
        printLevelOrder(p3Root);
        System.out.print("->");
        printLevelOrder(invertTree(p3Root)); // [1,2] -> [1,null,2]

        System.out.println();
        printLevelOrder(invertTree(null)); // [] -> []
    }
}
