import configs.Config.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static configs.Config.buildTree;

/**
 * Given a binary tree, find its minimum depth. The minimum depth is the number of nodes along shortest
 * path from the root node down to the nearest leaf node. Note: A leaf is a node with no children.
 */
public class FindMinDepthOfBinaryTree {

    /**
     * Time complexity: O(n) because traversing every node
     * Space complexity: O(n/2) -> O(n) because will be storing all leaf nodes in queue in a perfectly balanced BT
     */
    public static int minTree(TreeNode root) {
        if (root == null) return 0;
        int minDepth = Integer.MAX_VALUE;
        int currDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int levelNodes = queue.size();
            currDepth++;
            for (int i = 0; i < levelNodes; i++) {
                TreeNode currNode = queue.poll();
                if (currNode.left == null && currNode.right == null) {
                    minDepth = Math.min(minDepth, currDepth);
                }
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }
        return minDepth;
    }

    /**
     * Time complexity: O(n) because traversing every node
     * Space complexity: O(h) for skewed tree where recursion call stack grows with the height
     */
    public static int minTreeRecursive(TreeNode root) {
        if (root == null) return 0;

        // If one subtree is null, must not take the min of left and right
        // because that would return  0 for the missing subtree
        if (root.left == null) return 1 + minTreeRecursive(root.right);
        if (root.right == null) return 1 + minTreeRecursive(root.left);

        return 1 + Math.min(minTreeRecursive(root.left), minTreeRecursive(root.right));
    }

    public static void main(String[] args) {
        TreeNode t1Root = buildTree(Arrays.asList(3,9,20,null,null,15,7));
        System.out.println(minTree(t1Root)); // [3,9,20,null,null,15,7] -> 2
        System.out.println(minTreeRecursive(t1Root));

        System.out.println();

        TreeNode t2Root = buildTree(Arrays.asList(1,null,2));
        System.out.println(minTree(t2Root)); // [1,null,2] -> 2
        System.out.println(minTreeRecursive(t2Root));

        System.out.println();

        System.out.println(minTree(null)); // [] -> 0
        System.out.println(minTreeRecursive(null));

        System.out.println();

        TreeNode t4Root = new TreeNode(5);
        System.out.println(minTree(t4Root)); // [5] -> 1
        System.out.println(minTreeRecursive(t4Root));

        System.out.println();

        // Skewed tree test case
        TreeNode t5Root = buildTree(Arrays.asList(2,null,3,null,4,null,5,null,6));
        System.out.println(minTree(t5Root)); // [2,null,3,null,4,null,5,null,6] -> 5
        System.out.println(minTreeRecursive(t5Root));

        System.out.println();

        TreeNode t6Root = buildTree(Arrays.asList(1,2,3,4,5));
        System.out.println(minTree(t6Root)); // [1,2,3,4,5] -> 2
        System.out.println(minTreeRecursive(t6Root));
    }
}
