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

    public static void main(String[] args) {
        TreeNode t1Node15 = new TreeNode(15);
        TreeNode t1Node7 = new TreeNode(7);
        TreeNode t1Node20 = new TreeNode(20, t1Node15, t1Node7);
        TreeNode t1Node9 = new TreeNode(9);
        TreeNode t1Root = new TreeNode(3, t1Node9, t1Node20);
        System.out.println(minTree(t1Root)); // [3,9,20,null,null,15,7] -> 2
     }
}
