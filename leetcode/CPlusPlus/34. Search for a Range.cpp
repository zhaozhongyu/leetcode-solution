class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> vector1;
        if(nums.empty()){
            return {-1,-1};
        }
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
        if(*it != target){
            return {-1, -1};
        }
        for(vector<int>::iterator it1 = it; it1 >= nums.begin(); it1 -- ){
            if(*it1 != target){
                vector1.push_back(it1 - nums.begin()+1);
                break;
            } else if(it1 == nums.begin()){
                vector1.push_back(0);
            }
        }
        for(vector<int>::iterator it1 = it; it1 < nums.end(); it1 ++ ){
            if(*it1 != target){
                vector1.push_back(it1 - nums.begin() - 1);
                break;
            } else if(it1 == nums.end() -1){
                vector1.push_back(it1 - nums.begin());
            }
        }
        return vector1;
    }
};