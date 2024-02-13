package common;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public int hashCode() {
        return val;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (this == obj)
            return true;

        if (!(obj instanceof TreeNode))
            return false;

        return this.val == ((TreeNode) obj).val;
    }

    public static TreeNode getRootFromArray(Integer[] nodes){
        if (nodes.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(nodes[0]);
        loadTree(root, 0, nodes);

        return root;
    }

    public static void loadTree(TreeNode root, int pointer, Integer[] nodes) {
        if (root == null)
            return;

        if (2 * pointer + 1 >= nodes.length || nodes[2 * pointer + 1] == null)
            root.left = null;
        else {
            root.left = new TreeNode(nodes[2 * pointer + 1]);
            loadTree(root.left, 2 * pointer + 1, nodes);
        }

        if (2 * pointer + 2 >= nodes.length || nodes[2 * pointer + 2] == null)
            root.right = null;
        else {
            root.right = new TreeNode(nodes[2 * pointer + 2]);
            loadTree(root.right, 2 * pointer + 2, nodes);
        }
    }
    public static String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        addToList(root, list);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(String.valueOf(list.get(i))).append(',');
        }
        return sb.toString();
    }

    private static void addToList(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            list.add(node.left != null ? node.left.val : null);
            list.add(node.right != null ? node.right.val : null);
            if (node.left != null)
                addToList(node.left, list);
            if (node.right != null)
                addToList(node.right, list);
        }
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.equals(""))
            return null;

        String[] strings = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(strings[0]));
        Map<Integer, TreeNode> nodes = new HashMap<>();
        nodes.put(root.val, root);
        for (int i = 0; i < strings.length / 3 ; i++) {
            if (strings[i].equals("null"))
                continue;

            TreeNode node = nodes.get(Integer.valueOf(strings[3 * i]));

            if (!strings[3 * i + 1].equals("null")) {
                node.left = new TreeNode(Integer.valueOf(strings[3 * i + 1]));
                nodes.put(node.left.val, node.left);
            }

            if (!strings[3 * i + 2].equals("null")) {
                node.right = new TreeNode(Integer.valueOf(strings[3 * i + 2]));
                nodes.put(node.right.val, node.right);
            }
        }

        return root;
    }

 }
