class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length == 0 || nums.length * nums[0].length != r * c) {
            return nums;
        }
        int[][] result = new int[r][c];
        int n = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[0].length; j++) {
                result[n / c][n % c] = nums[i][j];
                n++;
            }
        }
        return result;
    }
}
