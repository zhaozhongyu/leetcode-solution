package leetcode.swordToOffer;

public class problem16 {

    /**
     * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: 2.00000, 10
     * 输出: 1024.00000
     * 示例 2:
     *
     * 输入: 2.10000, 3
     * 输出: 9.26100
     * 示例 3:
     *
     * 输入: 2.00000, -2
     * 输出: 0.25000
     * 解释: 2-2 = 1/22 = 1/4 = 0.25
     *  
     *
     * 说明:
     *
     * -100.0 < x < 100.0
     * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    public static double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        double result = 1.0;
        double[] pows = new double[32];
        int[] nums = new int[32];
        nums[0] = -1;
        pows[0] = x;
        for(int i = 1;i<32;i++){
            nums[i] = nums[i-1]*2; //计算0到31次方
            pows[i] = pows[i-1] * pows[i-1]; //计算x从1到2的31次方的幂

        }
        int absn = n > 0?-n:n; //转换为负数
        for(int i = 31; i >= 0; i-- ){
            if(absn <= nums[i]){
                absn -= nums[i];
                result *= pows[i];
            }
        }
        if(n > 0){
            return result;
        }
        else {
            return 1/result;
        }
    }

    public static void main(String[] args) {
        myPow(2.0, -2147483648);
    }
}
