package leetcode.tree;

public class problem116 {
    /**
     * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
     *
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     *
     * 初始状态下，所有 next 指针都被设置为 NULL。
     *
     * */

    public Node connect(Node root) {
        if (root == null || root.left == null || root.right == null) return root;
        Node temp = root;
        Node leftNode = root;
        // 按层指向, 抵达下一层时, 以最左边节点开始
        while (temp != null && temp.left != null) { //到达最后一层时已经不需要继续了
            temp.left.next = temp.right;
            if (temp.next != null) {
                temp.right.next = temp.next.left;
                temp = temp.next;
            } else {
                temp = leftNode.left; // 下一层
                leftNode = leftNode.left;
            }
        }
        return root;
    }
}

//class Node {
//    public int val;
//    public Node left;
//    public Node right;
//    public Node next;
//
//    public Node() {}
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, Node _left, Node _right, Node _next) {
//        val = _val;
//        left = _left;
//        right = _right;
//        next = _next;
//    }
//};
