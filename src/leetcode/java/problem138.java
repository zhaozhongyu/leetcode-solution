package leetcode.java;

import java.util.ArrayList;
import java.util.HashMap;

public class problem138 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        ArrayList<Node> list = new ArrayList<>();
        HashMap<Node, Integer> map = new HashMap<>();
        Node node = head;
        int index = 0;
        Node temp = null;
        Node last = null;
        while (node != null) {
            temp = new Node(node.val);
            list.add(temp);
            map.put(node, index++);
            node = node.next;
            if (last != null) {
                last.next = temp;
            }
            last = temp;
        }
        node = head;
        int cur = 0;
        while (node != null) {
            if (node.random != null) {
                index = map.get(node.random);
                list.get(cur).random = list.get(index);
            }
            cur++;
            node = node.next;
        }
        return list.get(0);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
