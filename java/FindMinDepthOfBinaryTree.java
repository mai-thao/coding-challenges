import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth. The minimum depth is the number of nodes along shortest
 * path from the root node down to the nearest leaf node. Note: A leaf is a node with no children.
 */
public class FindMinDepthOfBinaryTree {
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
        TreeNode t1Node15 = new TreeNode(15);
        TreeNode t1Node7 = new TreeNode(7);
        TreeNode t1Node20 = new TreeNode(20, t1Node15, t1Node7);
        TreeNode t1Node9 = new TreeNode(9);
        TreeNode t1Root = new TreeNode(3, t1Node9, t1Node20);
        System.out.println(minTree(t1Root)); // [3,9,20,null,null,15,7] -> 2
        System.out.println(minTreeRecursive(t1Root));

        System.out.println("-----");

        TreeNode t2Node2 = new TreeNode(2);
        TreeNode t2Root = new TreeNode(1, null, t2Node2);
        System.out.println(minTree(t2Root)); // [1,null,2] -> 2
        System.out.println(minTreeRecursive(t2Root));

        System.out.println("-----");

        System.out.println(minTree(null)); // [] -> 0
        System.out.println(minTreeRecursive(null));

        System.out.println("-----");

        TreeNode t4Root = new TreeNode(5);
        System.out.println(minTree(t4Root)); // [5] -> 1
        System.out.println(minTreeRecursive(t4Root));

        System.out.println("-----");

        // Skewed tree test case
        TreeNode t5Node6 = new TreeNode(6);
        TreeNode t5Node5 = new TreeNode(5, null, t5Node6);
        TreeNode t5Node4 = new TreeNode(4, null, t5Node5);
        TreeNode t5Node3 = new TreeNode(3, null, t5Node4);
        TreeNode t5Root = new TreeNode(2, null, t5Node3);
        System.out.println(minTree(t5Root)); // [2,null,3,null,4,null,5,null,6] -> 5
        System.out.println(minTreeRecursive(t5Root));

        System.out.println("-----");

        TreeNode t6Node5 = new TreeNode(5);
        TreeNode t6Node4 = new TreeNode(4, null, t5Node6);
        TreeNode t6Node3 = new TreeNode(3);
        TreeNode t6Node2 = new TreeNode(2, t6Node4, t6Node5);
        TreeNode t6Root = new TreeNode(1, t6Node2, t6Node3);
        System.out.println(minTree(t6Root)); // [1,2,3,4,5] -> 2
        System.out.println(minTreeRecursive(t6Root));
    }
}
