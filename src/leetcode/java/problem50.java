package leetcode.java;

public class problem50 {

    public double myPow(double x, int n) {
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
}
