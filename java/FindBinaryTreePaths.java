import configs.Config.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static configs.Config.buildTree;

/**
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * A leaf is a node with no children.
 *
 * Constraint: The number of nodes in the tree is in the range [1, 100].
 *
 * Time complexity: O(n) because visiting each node once
 * Space complexity: O(n) because of recursive call stack in worst case of skewed tree
 */
public class FindBinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        dfs(root, paths, "");
        return paths;
    }

    private static void dfs(TreeNode root, List<String> paths, String path) {
        if (root == null) return;
        path = path + root.val; // In-order so check root node first
        if (root.left == null && root.right == null) {
            paths.add(path);
            return;
        }
        dfs(root.left, paths, path + "->");
        dfs(root.right, paths, path + "->");
    }

    public static void main(String[] args) {
        TreeNode p1Root = buildTree(Arrays.asList(1,2,3,null,5));
        System.out.println(binaryTreePaths(p1Root));    // ["1->2->5","1->3"]

        TreeNode p2Root = buildTree(Arrays.asList(1));
        System.out.println(binaryTreePaths(p2Root));    // ["1"]

        TreeNode p3Root = buildTree(Arrays.asList(1,2,null,3));
        System.out.println(binaryTreePaths(p3Root));    // ["1->2->3"]

        TreeNode p4Root = buildTree(Arrays.asList(0,-2,3));
        System.out.println(binaryTreePaths(p4Root));    // ["0->-2", "0->3"]
    }
}
