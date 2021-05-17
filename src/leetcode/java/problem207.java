package leetcode.java;

import java.util.*;

public class problem207 {
    // 不看评论不会写系列
    // 图的算法
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] count = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            count[prerequisite[0]] ++;
            if (map.containsKey(prerequisite[1])) {
                map.get(prerequisite[1]).add(prerequisite[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisite[0]);
                map.put(prerequisite[1], list);
            }
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                list.add(i);
            }
        }
        while (!list.isEmpty()) {
            int n = list.pollFirst();
            if (map.containsKey(n)) {
                List<Integer> prerequisite = map.get(n);
                for (int i : prerequisite) {
                    count[i]--;
                    if (count[i] == 0) {
                        list.add(i);
                    }
                }
            }
        }
        for (int value : count) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

}
