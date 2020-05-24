package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class problem590 {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<Node> list = new LinkedList<>();
        list.addLast(root);
        while (!list.isEmpty()) {
            Node node = list.pollFirst();
            if (node.children == null) {
                result.add(node.val);
            } else {
                list.addFirst(node);
                list.addAll(0,node.children);
                node.children = null;
            }
        }
        return result;
    }
}
