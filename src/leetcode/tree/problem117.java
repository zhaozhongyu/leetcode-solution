package leetcode.tree;

public class problem117 {


//    public Node connect(Node root) {
//        if (root == null || (root.left == null && root.right == null)) return root;
//        Node temp = root; //
//        Node leftChild = root.left; //
//        Node tempChild = root.left;
//        if (root.left == null) {
//            leftChild = root.right; //
//            tempChild = root.right;
//        }
//        while (temp != null ) {
//            if (temp.left != null && temp.left != tempChild) {
//                tempChild.next = temp.left;
//                tempChild = temp.left;
//            }
//            if (temp.right != null && tempChild != temp.right) {
//                tempChild.next = temp.right;
//                tempChild = temp.right;
//            }
//            if (temp.next != null ) {
//                temp = temp.next;
//            } else {
//                temp = leftChild;
//                while (temp != null) {
//                    if (temp.left != null) {
//                        leftChild = temp.left;
//                        tempChild = temp.left;
//                        break;
//                    } else if (temp.right != null) {
//                        leftChild = temp.right;
//                        tempChild = temp.right;
//                        break;
//                    } else {
//                        temp = temp.next;
//                    }
//                }
//            }
//
//        }
//        return root;
//    }
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