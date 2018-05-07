class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int temp = 0;
        int leftmin = 0, rightmin = 0, min = 0;
        for(int i = 1; i < height.length -1;i++){
            //获取水位高度:通过判断左右两侧的箱子最大值来判断水位
            for(int j = temp; j < i;j++ ){
                leftmin = leftmin > height[j]? leftmin:height[j];
            }
            for(int j = i+1; j < height.length;j++){
                if(leftmin <= height[j]){
                    rightmin = height[j];
                    break;
                }
                rightmin = rightmin > height[j]? rightmin:height[j];
            }
            min = leftmin < rightmin? leftmin:rightmin; //水位
            leftmin = rightmin = 0;
            if(height[i] < min){
                sum += min - height[i];
            }
        }
        return sum;
    }
}
