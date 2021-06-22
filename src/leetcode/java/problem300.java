package leetcode.java;

import java.util.HashMap;

public class problem300 {

    // 每一个值, 等于前面的小于它的最后一个值的数字+1
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] ret = new int[nums.length];
        ret[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i] && ret[i] <= ret[j]) {
                    ret[i] = ret[j] + 1;
                }
            }
            if (ret[i] == 0) {
                ret[i] = 1;
            }
        }
        int result = 0;
        for (int num: ret) {
            result = Math.max(num, result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new problem300().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
