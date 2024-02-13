package done;

import common.TreeNode;

public class SerializingBinaryTree {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getRootFromArray(new Integer[] {1, 2, 3, null, null, 5, 7});;

        String serialized = TreeNode.serialize(root);
        System.out.println(serialized);

        TreeNode newRoot = TreeNode.deserialize(serialized);
        String serialized2 = TreeNode.serialize(newRoot);
        System.out.println(serialized2);
    }

}
