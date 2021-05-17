package leetcode.java;

public class problem198 {

    public int rob(int[] nums) {
        int[] rets = new int[nums.length];
        return rob(nums, nums.length -1, rets);
    }

    public int rob(int[] nums, int n, int[] rets) {
        if (n < 0) return 0;
        if (n == 0) {
            return nums[0];
        }
        if (n == 1) {
            return Math.max(nums[0], nums[1]);
        }
        if (rets[n] != 0) {
            return rets[n];
        }

        int ret = rob(nums, n - 1, rets);
        if (nums[n] != 0) {
            ret = Math.max(ret, rob(nums, n - 2, rets) + nums[n]);
        }
        rets[n] = ret;
        return ret;
    }

    public static void main(String [] args) {
        System.out.println(new problem198().rob(new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240}));
    }
}
