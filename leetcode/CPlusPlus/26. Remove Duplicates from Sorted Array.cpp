#include <algorithm>
class Solution {

public:
    int removeDuplicates(vector<int>& nums) {
        if(nums.size() == 0){
            return 0;
        }
        int num=0, tmp=nums[0]+1;
        sort(nums.begin(), nums.end() );
        for(vector<int>::iterator it=nums.begin();it != nums.end();it++){
            if(*it != tmp){
                num++;
                tmp = *it;
            } else {
               it = nums.erase(it);
                it--;
            }
        }
        return num;
    }
};