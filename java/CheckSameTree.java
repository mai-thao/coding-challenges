import configs.Config.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static configs.Config.buildTree;

/**
 * Given the roots of two binary trees `p` and `q`, write a function to check if they are the same or not.
 * Two binarey trees are the same if they are structurally identical with all the same node values.
 */
public class CheckSameTree {

    /**
     * Time complexity: O(n) because traversing every node
     * Space complexity: O(2n) -> O(n) after dropping constants, and because both queues can hold up to all nodes
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.add(p);
        queue2.add(q);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode popped1 = queue1.poll();
            TreeNode popped2 = queue2.poll();
            if (popped1 == null && popped2 != null) {
                return false;
            } else if (popped1 != null && popped2 == null) {
                return false;
            }
            if (popped1 != null && popped2 != null) {
                if (popped1.val != popped2.val) {
                    return false;
                }
                queue1.add(popped1.left);
                queue1.add(popped1.right);
                queue2.add(popped2.left);
                queue2.add(popped2.right);
            }
        }
        return true;
    }

    /**
     * Time complexity: O(n) because traversing every node
     * Space complexity: O(h) where h is the height of the tree since the call stack grows with the height
     */
    public static boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        return p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        // ------------- TEST 1 ---------------
        TreeNode p1Node1 = buildTree(Arrays.asList(1,2,3));
        TreeNode p1Node2 = buildTree(Arrays.asList(1,2,3));

        System.out.println("Test 1: " + isSameTree(p1Node1, p1Node2)); // true
        System.out.println("Test 1 (Recursive): " + isSameTreeRecursive(p1Node1, p1Node2)); // true

        // ------------- TEST 2 ---------------

        TreeNode p2Node1 = buildTree(Arrays.asList(1,2));
        TreeNode p2Node2 = buildTree(Arrays.asList(1,null,2));

        System.out.println("Test 2: " + isSameTree(p2Node1, p2Node2)); // false
        System.out.println("Test 2 (Recursive): " + isSameTreeRecursive(p2Node1, p2Node2)); // false

        // ------------- TEST 3 ---------------

        TreeNode p3Node1 = buildTree(Arrays.asList(1,2,1));
        TreeNode p3Node2 = buildTree(Arrays.asList(1,1,2));

        System.out.println("Test 3: " + isSameTree(p3Node1, p3Node2)); // false
        System.out.println("Test 3 (Recursive): " + isSameTreeRecursive(p3Node1, p3Node2)); // false
    }
}
