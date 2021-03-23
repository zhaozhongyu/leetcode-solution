package leetcode.DP;

public class problem343 {
    /**
     * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
     *
     * 示例 1:
     *
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1。
     * 示例 2:
     *
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
     * 说明: 你可以假设 n 不小于 2 且不大于 58。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/integer-break
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        nums[2] = 2;
        for (int i = 3; i <= n; i++) {
            // 大多数情况下, 最大值为n/2 * (n-n/2)
            nums[i] = Math.max(nums[i / 2], i / 2) * Math.max(nums[i - i / 2], i - i / 2);
            // 但少数情况下, n为偶数时需要兼容奇数的情况, 如8 = 3 * 5 而不是4 * 4
            nums[i] = Math.max(nums[i], Math.max(nums[i / 2 - 1], i / 2 -1) * Math.max(nums[i - i / 2 + 1], i - i / 2 + 1));
        }
        return nums[n];
    }
}
