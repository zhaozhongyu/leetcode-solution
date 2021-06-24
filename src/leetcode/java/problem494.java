package leetcode.java;

public class problem494 {
    // dp形式写法, 记数组的元素和为 \textit{sum}sum，添加 \texttt{-}- 号的元素之和为 \textit{neg}neg，则其余添加 \texttt{+}+ 的元素之和为 \textit{sum}-\textit{neg}sum−neg
    // 其中 \textit{dp}[i][j]dp[i][j] 表示在数组 \textit{nums}nums 的前 ii 个数中选取元素，使得这些元素之和等于 jj 的方案数
    public int findTargetSumWays1(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int n = nums.length, neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }

    // 动态规划?
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums, target, 0);
    }

    // (回溯)递归形式写法
    public int findTargetSumWays(int[] nums, int target, int begin) {
        if (begin == nums.length - 1) {
            if (nums[begin] == 0 && target ==0) {
                return 2;
            }
            if (nums[begin] == target || nums[begin] == -target) {
                return 1;
            } else {
                return 0;
            }
        }
        int plus = findTargetSumWays(nums, target - nums[begin], begin + 1);
        int divide = findTargetSumWays(nums, target + nums[begin], begin + 1);
        return plus + divide;
    }

    public static void main(String[] strs) {
        System.out.println(new problem494().findTargetSumWays(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 6));
    }
}
