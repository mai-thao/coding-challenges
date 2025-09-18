import configs.Config.*;

import java.util.Arrays;

import static configs.Config.buildTree;

public class RootEqualsChildrenSum {
    public static boolean checkTree(TreeNode root) {
        return root.left.val + root.right.val == root.val;
    }

    public static void main(String[] args) {
        TreeNode p1 = buildTree(Arrays.asList(10,4,6));
        System.out.println(checkTree(p1));

        TreeNode p2 = buildTree(Arrays.asList(5,3,1));
        System.out.println(checkTree(p2));
    }
}
