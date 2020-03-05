package leetcode.old;

class Solution {
    public int jump(int[] nums) {
        int n = 0;
        int temp ;
        int steps = 0;
        for(int i = 0; i < nums.length; ){
            temp = 0;
            if(i >= nums.length - 1){
                return steps; //这个分支处理0的情况
            }
            else if(i + nums[i] >= nums.length - 1){ //如果可以直接跳到底部
                return steps+1;
            }
            for(int j = 1; j <= nums[i]; j++){
                if( j + nums[i+j] > temp){ //获取下一步能跳到的最长距离
                    temp = j + nums[i+j];
                    n = i+j; //保存跳动后的位置
                }
            }
            i = n;
            steps += 1;
        }
        return steps;
    }
}