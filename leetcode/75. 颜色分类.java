class Solution {
    public void sortColors(int[] nums) {
        int one = -1, two = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                if(one >= 0 && two >= 0){
                    nums[one++] = 0;
                    nums[two++] = 1;
                    nums[i] = 2;
                }
                else if(two >= 0){
                    nums[two++] = 0;
                    nums[i] = 2;
                }
                else if(one >= 0){
                    nums[one++] = 0;
                    nums[i] = 1;
                }
            }
            else if(nums[i] == 1){
                if(two >= 0){
                    nums[two++] = 1;
                    nums[i] = 2;
                    if (one == -1) {
                        one = two - 1;
                    }
                }
                else if(one == -1) {
                    one = i;
                }
            }
            else {
                if (two == -1){
                    two = i;
                }
            }
        }
    }
}
