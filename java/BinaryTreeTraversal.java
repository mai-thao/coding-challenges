import configs.Config.*;

import java.util.*;

import static configs.Config.buildTree;

public class BinaryTreeTraversal {

    /**
     * Given the root of a binary tree, return the level order traversal of
     * its nodes' values. (i.e., from left to right, level by level).
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> orders = new LinkedList<>();
        if (root == null) return orders;

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
            orders.add(result);
        }
        return orders;
    }

    /**
     * Given the root of a binary tree, return the preorder traversal of its nodes' values.
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> orders = new ArrayList<>();

        if (root != null) {
            orders.add(root.val);
            orders.addAll(preorderTraversal(root.left));
            orders.addAll(preorderTraversal(root.right));
        }
        return orders;
    }

    /**
     * Given the root of a binary tree, return the inorder traversal of its nodes' values.
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> orders = new ArrayList<>();

        if (root != null) {
            orders.addAll(inorderTraversal(root.left));
            orders.add(root.val);
            orders.addAll(inorderTraversal(root.right));
        }
        return orders;
    }


    public static void main(String[] args) {
        // Level order traversal
        TreeNode levelOrderP1 = buildTree(Arrays.asList(3,9,20,null,null,15,7));
        System.out.println(levelOrder(levelOrderP1));                                        // [[3], [9, 20], [15, 7]]
        TreeNode levelOrderP2 = new TreeNode(1);
        System.out.println(levelOrder(levelOrderP2));                                        // [[1]]
        System.out.println(levelOrder(null));                                           // []

        System.out.println();

        // Pre-order traversal (Root, Left, Right)
        TreeNode preOrderP1 = buildTree(Arrays.asList(1,null,2,3));
        System.out.println(preorderTraversal(preOrderP1));                                  // [1,2,3]
        TreeNode preOrderP2 = buildTree(Arrays.asList(1,2,3,4,5,null,8,null,null,6,7,9));
        System.out.println(preorderTraversal(preOrderP2));                                  // [1,2,4,5,6,7,3,8,9]
        TreeNode preOrderP3 = new TreeNode(1);
        System.out.println(preorderTraversal(preOrderP3));                                  // [1]
        System.out.println(preorderTraversal(null));                                   // []

        System.out.println();

        // Inorder traversal (Left, Root, Right)
        TreeNode inOrderP1 = buildTree(Arrays.asList(1,null,2,3));
        System.out.println(inorderTraversal(inOrderP1));                                    // [1,3,2]
        TreeNode inOrderP2 = buildTree(Arrays.asList(1,2,3,4,5,null,8,null,null,6,7,9));
        System.out.println(inorderTraversal(inOrderP2));                                    // [1,2,3,4,5,null,8,null,null,6,7,9]
        TreeNode inOrderP3 = new TreeNode(1);
        System.out.println(inorderTraversal(inOrderP3));                                    // [1]
        System.out.println(inorderTraversal(null));                                    // []

        System.out.println();
    }
}
