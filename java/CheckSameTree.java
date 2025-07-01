import java.util.LinkedList;
import java.util.Queue;

public class CheckSameTree {
     public class TreeNode {
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
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
}
