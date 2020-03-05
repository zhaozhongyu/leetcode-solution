package leetcode.old;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if(candidates.length == 0){
            return lists;
        }
        if(target == candidates[candidates.length-1]){
            List<Integer> list = new ArrayList<>();
            list.add(target);
            lists.add(list);
            List<List<Integer>> next = combinationSum(Arrays.copyOfRange(candidates, 0, candidates.length-1), target); 
            if(next.size() != 0){
                lists.addAll(next);
            }
            return lists;
        }
        if(target < candidates[candidates.length - 1]){
            return combinationSum(Arrays.copyOfRange(candidates, 0, candidates.length-1), target);
        }
        List<List<Integer>> sum = combinationSum(candidates, target-candidates[candidates.length - 1]);
        for(int i = 0; i < sum.size(); i++){
            sum.get(i).add(candidates[candidates.length - 1]);
        }
        lists.addAll(sum);

        sum = combinationSum(Arrays.copyOfRange(candidates, 0, candidates.length-1), target);

        lists.addAll(sum);

        return  lists;
    }
}