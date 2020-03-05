package leetcode.old;

class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int num;
        int i = 0, j = height.length-1;
        while(j > i){
            num = Math.min(height[j], height[i]) * (j-i); //获取当前的i,j中的短板
            max = max > num? max:num; //记录当前的最大值
            if(height[i] > height[j]){ //哪一边是短板, 就移动哪一边, 因为如果是短板的话移动后的高度一定小于等于短板, 但是长度小了, 导致面积变小, 所以一定要移动短板所在的边
                j--;
            }else{
                i++;
            }
        }
        return max;
    }
}