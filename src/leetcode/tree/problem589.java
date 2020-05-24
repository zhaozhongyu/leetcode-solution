package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class problem589 {

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<Node> list = new LinkedList<>();
        list.addLast(root);
        while (!list.isEmpty()) {
            Node node = list.pollFirst();
            result.add(node.val);
            list.addAll(0, node.children);
        }
        return result;
    }
}
