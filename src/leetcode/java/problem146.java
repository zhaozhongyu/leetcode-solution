package leetcode.java;
import java.util.HashMap;

public class problem146 {
    public static void main(String[] ar) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,0);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }
}
class LRUCache {
    class Node {
        public int key;
        public int val;
        public Node next;
        public Node pre;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    HashMap<Integer, Node> map;
    Node first;
    Node last;
    int size;
    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        size = 0;
        first = new Node(-1, -1);
        last = new Node(-1, -1);
        first.next = last;
        last.pre = first;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;

            last.pre.next = node;
            node.pre = last.pre;
            last.pre = node;
            node.next = last;
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (size == capacity) {
                Node node = first.next;
                node.next.pre = first;
                first.next = node.next;
                map.remove(node.key);
            } else {
                size ++;
            }
            Node node = new Node(key, value);
            node.pre = last.pre;
            last.pre.next = node;
            last.pre = node;
            node.next = last;
            map.put(key, node);
        } else {
            Node node = map.get(key);
            node.val = value;
            node.pre.next = node.next;
            node.next.pre = node.pre;

            last.pre.next = node;
            node.pre = last.pre;
            last.pre = node;
            node.next = last;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */