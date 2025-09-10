import configs.Config.*;

import java.util.LinkedList;
import java.util.Queue;

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
         
        TreeNode t1PNode2 = new TreeNode(2);
        TreeNode t1PNode3 = new TreeNode(3);
        TreeNode t1PNode1 = new TreeNode(1, t1PNode2, t1PNode3); // [1,2,3]

        TreeNode t1QNode2 = new TreeNode(2);
        TreeNode t1QNode3 = new TreeNode(3);
        TreeNode t1QNode1 = new TreeNode(1, t1QNode2, t1QNode3); // [1,2,3]

        System.out.println("Test 1: " + isSameTree(t1PNode1, t1QNode1)); // true
        System.out.println("Test 1 (Recursive): " + isSameTreeRecursive(t1PNode1, t1QNode1)); // true

        // ------------- TEST 2 ---------------
         
        TreeNode t2PNode2 = new TreeNode(2);
        TreeNode t2PNode1 = new TreeNode(1, t2PNode2, null); // [1,2]

        TreeNode t2QNode2 = new TreeNode(2);
        TreeNode t2QNode1 = new TreeNode(1, null, t2QNode2); // [1,null,2]

        System.out.println("Test 2: " + isSameTree(t2PNode1, t2QNode1)); // false
        System.out.println("Test 2 (Recursive): " + isSameTreeRecursive(t2PNode1, t2QNode1)); // false

        // ------------- TEST 3 ---------------
         
        TreeNode t3PNode2 = new TreeNode(2);
        TreeNode t3PNode3 = new TreeNode(1);
        TreeNode t3PNode1 = new TreeNode(1, t3PNode2, t3PNode3); // [1,2,1]

        TreeNode t3QNode2 = new TreeNode(1);
        TreeNode t3QNode3 = new TreeNode(2);
        TreeNode t3QNode1 = new TreeNode(1, t3QNode2, t3QNode3); // [1,1,2]

        System.out.println("Test 3: " + isSameTree(t3PNode1, t3QNode1)); // false
        System.out.println("Test 3 (Recursive): " + isSameTreeRecursive(t3PNode1, t3QNode1)); // false
    }
}
