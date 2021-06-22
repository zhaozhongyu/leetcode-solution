package leetcode.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class problem128 {

    /**
     * 很明显, 这里考察的是并查集
     * */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int ret = 0;
        for (int num: nums) {
            int n = 0;
            if (!set.contains(num)) {
                continue;
            }
            n ++;
            set.remove(num);
            for (int i = 1; ;i++) {
                if (set.contains(num + i)) {
                    n ++;
                    set.remove(num + i);
                } else {
                    break;
                }
            }
            for (int i = 1; ;i++) {
                if (set.contains(num - i)) {
                    n ++;
                    set.remove(num - i);
                } else {
                    break;
                }
            }
            ret = Math.max(ret, n);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new problem128().longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}
