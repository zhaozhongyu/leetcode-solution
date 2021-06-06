package leetcode.java;

import java.util.HashMap;
import java.util.PriorityQueue;

public class problem347 {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 构造最小堆
        int[] rets = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> map.get(o1)-map.get(o2));
        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(pq.peek()) < map.get(key)) {
                pq.poll();
                pq.add(key);
            }
        }
        for (int i = 0; i < k; i++) {
            rets[i] = pq.remove();
        }
        return rets;
    }

    public static void main(String[] args) {
        new problem347().topKFrequent(new int[]{3,0,1,0}, 1);
    }

}
