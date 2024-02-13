package done;

import common.TreeNode;

public class DiametrBinaryTree {


    public static void main(String[] args) {

        Integer[] nodes = new Integer[] {1, 2, 3, 4, 5};
        TreeNode root = TreeNode.getRootFromArray(nodes);

        System.out.println(diameterOfBinaryTree(root));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];

        diameter(root, diameter);

        return diameter[0];
    }

    public static int diameter(TreeNode root, int[] diameter) {
        if (root == null)
            return 0;

        int left = diameter(root.left, diameter);
        int right = diameter(root.right, diameter);

        diameter[0] = Math.max(diameter[0], left + right);

        return Math.max(left, right) + 1;
    }
}
