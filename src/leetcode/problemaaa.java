package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class problemaaa {

//    public static void main(String[] args) {
//        int[] nums = new int[]{2,2,2,2,1,1,1,1,3,3,3,3};
//        int target = 4;
//        List<List<Integer>> lists = new problemaaa().get(nums, target);
//        System.out.print(lists);
//
//    }

    public List<List<Integer>> get(int [] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i< nums.length; i++) {
            list.add(nums[i]);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= target / 2) {
                List<Integer> temp = new LinkedList<>(list);
                temp.remove(i);
                List<Integer> list1 = getNums(temp, list.get(i), target);
                if (list1 != null && !set.contains(list1.get(0))) {
                    set.add(list1.get(0));
                    result.add(list1);
                }
            }
        }
        return result;
    }

    public List<Integer> getNums(List<Integer> nums, int left, int target) {
        for (int i = 0; i < nums.size(); i++) {
            if (left + nums.get(i) == target) {
                List<Integer> result = new ArrayList<>();
                result.add(left);
                result.add(nums.get(i));
                return result;
            }
        }
        return null;
    }
}
