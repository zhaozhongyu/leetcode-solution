package leetcode.java;

public class problem238 {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        int left = 1, right = 1;
        for (int i = 0; i < nums.length; i++) {
            ret[i] = 1;
        }
        // left 代表从nums[0] 到nums[i-1]的乘积
        for (int i = 0; i < nums.length; i++) {
            ret[i] *= left;
            left *= nums[i];
        }
        // right 代表从nums[len - 1]到nums[i+1]的乘积
        for (int i = 0; i < nums.length; i++) {
            ret[nums.length - i - 1] *= right;
            right *= nums[nums.length - i - 1];
        }
        return ret;
    }

    public static void main(String[] args) {
        new problem238().productExceptSelf(new int[]{2,3,4,5});
    }
}
