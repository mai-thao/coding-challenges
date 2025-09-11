import configs.Config.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static configs.Config.buildTree;

public class BinaryTreeTraversal {

    /**
     * Given the root of a binary tree, return the level order traversal of
     * its nodes' values. (i.e., from left to right, level by level).
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new LinkedList<>();
        if (root == null) return results;

        Queue<TreeNode> toBeVisited = new LinkedList<>();
        toBeVisited.offer(root);

        while (!toBeVisited.isEmpty()) {
            int currLevelNodeSize = toBeVisited.size();
            LinkedList<Integer> result = new LinkedList<>();
            for (int i = 0; i < currLevelNodeSize; i++) {
                TreeNode currNode = toBeVisited.poll();
                result.add(currNode.val);
                if (currNode.left != null) toBeVisited.offer(currNode.left);
                if (currNode.right != null) toBeVisited.offer(currNode.right);
            }
            results.add(result);
        }
        return results;
    }

    public static void main(String[] args) {
        // Level order traversal
        TreeNode levelOrderP1 = buildTree(Arrays.asList(3,9,20,null,null,15,7));
        System.out.println(levelOrder(levelOrderP1));
        TreeNode levelOrderP2 = new TreeNode(1);
        System.out.println(levelOrder(levelOrderP2));
        System.out.println(levelOrder(null));
    }
}
