class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 1){
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            lists.add(list);
            return lists;
        }
        int []copy = new int[nums.length-1];

        for(int i = 0 ; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(j < i){
                    copy[j] = nums[j];
                } else if(j > i){
                    copy[j-1] = nums[j];
                }
            }
            lists = permuteUnique(copy);
            for(int j = 0; j < lists.size(); j++){
                lists.get(j).add(nums[i]);
            }
            //return lists;
            for(int k = 0; k < lists.size(); k++){
                if(!result.contains(lists.get(k))){
                    result.add(lists.get(k));
                }
            }
            //result.addAll(lists);
        }
        return result;
    }
}
