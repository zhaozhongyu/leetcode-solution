class Solution {
public:
    int search(vector<int>& nums, int target) {
        for(vector<int>::iterator it = nums.begin(); it<nums.end(); it++){
            if(*it == target){
                return (it - nums.begin());
            }
        }
        return -1;
    }
};