package done;

import common.TreeNode;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        Integer[] nodes = new Integer[] {6,2,8,0,4,7,9,null,null,3,5};
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);

        TreeNode root = TreeNode.getRootFromArray(nodes);

        System.out.println(lowestCommonAncestor(root, p , q).val);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.equals(p) || root.equals(q)) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);

        if (left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;
    }

}

