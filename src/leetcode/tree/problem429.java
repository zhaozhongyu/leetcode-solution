package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class problem429 {

    /**
     * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
     * */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(root);
        int n = 1;
        int temp = 0;
        List<Integer> list = new ArrayList<>();
        while (!nodes.isEmpty()) {
            Node node = nodes.pollFirst();
            n--;
            list.add(node.val);
            nodes.addAll(node.children);
            temp += node.children.size();
            if (n == 0) {
                lists.add(list);
                list = new ArrayList<>();
                n = temp;
                temp = 0;
            }
        }
        return lists;
    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
