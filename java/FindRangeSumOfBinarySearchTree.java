import configs.Config.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static configs.Config.buildTree;

/**
 * Given the root node of a binary search tree and two integers low and high,
 * return the sum of values of all nodes with a value in the inclusive range [low, high].
 *
 * - All nodes are unique
 * - Number of nodes in the BST is between [1, 20000]
 */
public class FindRangeSumOfBinarySearchTree {

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
            if (currNode.left != null && currNode.val > low) {
                nodes.offer(currNode.left);
            }
            if (currNode.right != null && currNode.val < high) {
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
        if (root.val > low) {
            sum += rangeSumBSTWithDFS(root.left, low, high);
        }
        if (root.val < high) {
            sum += rangeSumBSTWithDFS(root.right, low, high);
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode p1Root = buildTree(Arrays.asList(10,5,15,3,7,null,18));
        System.out.println(rangeSumBSTWithBFS(p1Root, 7, 15)); // 32
        System.out.println(rangeSumBSTWithDFS(p1Root, 7, 15)); // 32

        System.out.println();

        TreeNode p2Root = buildTree(Arrays.asList(10,5,15,3,7,13,18,1,null,6));
        System.out.println(rangeSumBSTWithBFS(p2Root, 6, 10)); // 23
        System.out.println(rangeSumBSTWithDFS(p2Root, 6, 10)); // 23
    }
}
