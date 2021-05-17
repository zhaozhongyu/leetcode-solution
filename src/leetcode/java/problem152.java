package leetcode.java;

import java.util.LinkedList;

public class problem152 {
    /**
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * */
    // 很显然, 例外情况是0, 和负数, 负数有单数和双数两种
    public int maxProduct(int[] nums) {
        int a=1;
        int max=nums[0];

        for(int num:nums){
            a=a*num;
            if(max<a)max=a;
            if(num==0)a=1;
        }
        a=1;
        for(int i=nums.length-1;i>=0;i--){
            a=a*nums[i];
            if(max<a)max=a;
            if(nums[i]==0)a=1;
        }
        return max;
    }
}
