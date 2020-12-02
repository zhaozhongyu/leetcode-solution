package leetcode.java;

import java.util.ArrayList;

public class problem426 {

    public Node treeToDoublyList(Node root) {
        // 先中序优先遍历
        ArrayList<Node> list = new ArrayList<>();
        if (root == null) return null;
        inorder(root, list);
        for (int i = 0; i < list.size() - 1;i ++) {
            list.get(i).right = list.get(i+1);
            list.get(i+1).left = list.get(i);
        }
        list.get(list.size() - 1).right = list.get(0);
        list.get(0).left = list.get(list.size() - 1);
        return list.get(0);
    }

    public void inorder(Node root, ArrayList<Node> list) {
        if (root.left != null) {
            inorder(root.left, list);
        }
        list.add(root);
        if (root.right != null) {
            inorder(root.right, list);
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}

