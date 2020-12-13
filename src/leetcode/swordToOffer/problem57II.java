package leetcode.swordToOffer;

import java.util.ArrayList;

public class problem57II {

    public int[][] findContinuousSequence(int target) {
        int mid = (target + 1) / 2;
        ArrayList<Integer[]> list = new ArrayList<>();
        int sum = 0;
        for (int i = mid; i > 0; i--) {
            sum = 0;
            for (int j = i; j > 0; j--) {
                sum += j;
                if (sum == target) {
                    Integer[] res = new Integer[i - j + 1];
                    for (int k = i; k >= j; k --) {
                        res[i - k] = k;
                    }
                    list.add(res);
                } else if (j == 1) {
                    i = 1;
                } else if (sum > target) {
                    break;
                }
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = res.length - 1; i >= 0; i--) {
            Integer[] integers = list.get(i);
            int[] nums = new int[integers.length];
            for (int j = integers.length - 1; j >= 0; j--) {
                nums[nums.length - j - 1] = integers[j];
            }
            res[res.length - i - 1] = nums;
        }
        return res;
    }
}
