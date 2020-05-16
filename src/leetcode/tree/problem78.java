package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class problem78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        List<List<Integer>> t = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            result.add(temp);
        }
        int begin = 1;
        int end = result.size();
        for(int i = begin; i < end; i ++) {
            List<Integer> temp = result.get(i);
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > temp.get(temp.size() - 1)) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.addAll(temp);
                    tmp.add(nums[j]);
                    result.add(tmp);
                }
            }
            begin = end;
            end = result.size();
        }
        return result;
    }


//    public static void main (String [] args) {
//        int[] nums = new int[]{1,2,3};
//        System.out.print(new problem78().subsets(nums));
//    }
}
