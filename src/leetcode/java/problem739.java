package leetcode.java;

import java.util.HashMap;

public class problem739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ret = new int[temperatures.length];
        // 最后一个肯定是0
        for (int i = ret.length - 2; i >= 0; i--) {
            if (temperatures[i] < temperatures[i+1]) {
                ret[i] = 1;
            } else {
                int index = findLast(temperatures[i], i + 1, ret, temperatures);
                if (index == 0) {
                    ret[i] = 0;
                } else {
                    ret[i] = index - i;
                }
            }
        }
        return ret;
    }

    public int findLast(int target, int index, int[] daily, int[] temperatures) {
        while (index < daily.length) {
            if (daily[index] == 0) {
                break;
            }
            index = index + daily[index];
            if (temperatures[index] > target) {
                return index;
            }
        }
        return 0;
    }
}
