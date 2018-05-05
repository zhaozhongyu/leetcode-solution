class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<>();
        if(candidates.length == 0){
            return lists;
        }
        if(target == candidates[candidates.length-1]){
            List<Integer> list = new ArrayList<>();
            list.add(target);
            lists.add(list);
            List<List<Integer>> sum = combinationSum2(Arrays.copyOfRange(candidates, 0, candidates.length-1), target);
            for(int i = 0; i < sum.size();i++){
                if(! lists.contains(sum.get(i))){
                    lists.add(sum.get(i));
                }
            }
            return lists;
        }
        if(target < candidates[candidates.length - 1]){
            return combinationSum2(Arrays.copyOfRange(candidates, 0, candidates.length-1), target);
        }
        List<List<Integer>> sum = combinationSum2(Arrays.copyOfRange(candidates, 0, candidates.length-1), target-candidates[candidates.length - 1]);
        for(int i = 0; i < sum.size(); i++){
            sum.get(i).add(candidates[candidates.length - 1]);
        }
        for(int i = 0; i < sum.size();i++){
            if(! lists.contains(sum.get(i))){
                lists.add(sum.get(i));
            }
        }
        sum = combinationSum2(Arrays.copyOfRange(candidates, 0, candidates.length-1), target);
        for(int i = 0; i < sum.size();i++){
            if(! lists.contains(sum.get(i))){
                lists.add(sum.get(i));
            }
        }
        return  lists;
    }
}