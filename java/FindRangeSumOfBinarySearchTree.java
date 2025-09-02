import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root node of a binary search tree and two integers low and high,
 * return the sum of values of all nodes with a value in the inclusive range [low, high].
 *
 * - All nodes are unique
 * - Number of nodes in the BST is between [1, 20000]
 */
public class FindRangeSumOfBinarySearchTree {
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
     * Iterative approach using BFS with Queue!
     *
     * Time complexity: O(n) because visiting each node
     * Space complexity: O(h) because of queue potentially holding all nodes in skewed tree
     */
    public static int rangeSumBSTWithBFS(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int sum = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            TreeNode currNode = nodes.poll();
            if (currNode.val >= low && currNode.val <= high) {
                sum += currNode.val;
            }
            if (currNode.left != null) {
                nodes.offer(currNode.left);
            }
            if (currNode.right != null) {
                nodes.offer(currNode.right);
            }
        }
        return sum;
    }

    /**
     * DFS with recursion!
     *
     * Time complexity: O(n) because visiting each node
     * Space complexity: O(h) because of call stack potentially holding all nodes in skewed tree
     */
    public static int rangeSumBSTWithDFS(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int sum = 0;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        if (root.left != null) {
            sum += rangeSumBSTWithDFS(root.left, low, high);
        }
        if (root.right != null) {
            sum += rangeSumBSTWithDFS(root.right, low, high);
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode p1Node3 = new TreeNode(3);
        TreeNode P1Node7 = new TreeNode(7);
        TreeNode p1Node5 = new TreeNode(5, p1Node3, P1Node7);
        TreeNode p1Node18 = new TreeNode(18);
        TreeNode p1Node15 = new TreeNode(15, null, p1Node18);
        TreeNode p1rootNode10 = new TreeNode(10, p1Node5, p1Node15);
        System.out.println(rangeSumBSTWithBFS(p1rootNode10, 7, 15)); // 32
        System.out.println(rangeSumBSTWithDFS(p1rootNode10, 7, 15)); // 32

        TreeNode p2Node1 = new TreeNode(1);
        TreeNode p2Node3 = new TreeNode(3, p2Node1, null);
        TreeNode p2Node6 = new TreeNode(6);
        TreeNode p2Node7 = new TreeNode(7, p2Node6, null);
        TreeNode p2Node5 = new TreeNode(5, p2Node3, p2Node7);
        TreeNode p2Node13 = new TreeNode(13);
        TreeNode p2Node18 = new TreeNode(18);
        TreeNode p2Node15 = new TreeNode(15, p2Node13, p2Node18);
        TreeNode p2rootNode10 = new TreeNode(10, p2Node5, p2Node15);
        System.out.println(rangeSumBSTWithBFS(p2rootNode10, 6, 10)); // 23
        System.out.println(rangeSumBSTWithDFS(p2rootNode10, 6, 10)); // 23
    }
}
