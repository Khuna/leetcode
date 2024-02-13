package done;

import common.TreeNode;

public class MaxDepthBinaryTree {

    public static void main(String[] args) {
        Integer[] nodes = new Integer[] {1, 2, 3, 4, 5};
        TreeNode root = TreeNode.getRootFromArray(nodes);

        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
