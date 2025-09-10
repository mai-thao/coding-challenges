import configs.Config.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the `root` of a binary tree, return the average value of the nodes on each level in the form of an array.
 *
 * Note: The number of nodes in the tree is in the range [1, 104].
 *
 * Time complexity: O(n) because traversing every node in the tree
 * Space complexity: O(n) because using a queue and ArrayList that grows proportionally to the number of nodes
 */
public class FindLevelAvgInBinaryTree {
    public static List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double total = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                total += curr.val;
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            result.add(total / levelSize);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode t1Node15 = new TreeNode(15);
        TreeNode t1Node7 = new TreeNode(7);
        TreeNode t1Node20 = new TreeNode(20, t1Node15, t1Node7);
        TreeNode t1Node9 = new TreeNode(9);
        TreeNode t1Root = new TreeNode(3, t1Node9, t1Node20);
        System.out.println(averageOfLevels(t1Root)); // [3,9,20,null,null,15,7] -> [3.0,14.5,11.0]

        TreeNode t2Node15 = new TreeNode(15);
        TreeNode t2Node7 = new TreeNode(7);
        TreeNode t2Node9 = new TreeNode(9, t2Node15, t2Node7);
        TreeNode t2Node20 = new TreeNode(20);
        TreeNode t2Root = new TreeNode(3, t2Node9, t2Node20);
        System.out.println(averageOfLevels(t2Root)); // [3,9,20,15,7] -> [3.0,14.5,11.0]

        System.out.println(averageOfLevels(new TreeNode(10))); // [10] -> [10]
    }
}
