package leetcode.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class problem621 {

    public int leastInterval(char[] tasks, int n) {
        if (n == 0 || tasks.length == 0) {
            return tasks.length;
        }
        int[] times = new int[26];
        for (char task : tasks) {
            times[task - 'A']++;
        }
        int num = 0;
        int largestTimes = 0;
        for (int time : times) {
            if (largestTimes < time) {
                largestTimes = time;
                num = 1;
            } else if (largestTimes == time) {
                num ++;
            }
        }

        // 思想是, 每隔n个值分割为一段, 在这一段中可以随意插入不影响, 因此..
        // 例如AB AB AB 和 ABCEDF ABEF A
        return Math.max(tasks.length, (largestTimes - 1) * (n + 1) + num);
    }

    public static void main(String[] strs) {
        System.out.println(new problem621().leastInterval(new char[]{'A','A','A','B','B','B', 'C','C','C', 'D', 'D', 'E'}, 2)); // 12
//        System.out.println(new problem621().leastInterval(new char[]{'A','A','A','B','B','B'}, 2)); // 8
    }
}
