class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        vector<int>::iterator it = nums.begin() + (nums.end() - nums.begin())/2;
        vector<int>::iterator left = nums.begin(), right = nums.end() -1;
        while(left < right && *it != target){
            if(*it > target){
                right = it - 1;
            } else {
                left = it + 1;
            }
            it = nums.begin() + ((left - nums.begin())+(right - nums.begin()))/2;
        }
        if(*it >= target){
            return (it - nums.begin());
        } else {
            return (it - nums.begin()) + 1;
        }
        
    }
};