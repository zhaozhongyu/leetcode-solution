package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class problem46 {
    /*
    * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。

        示例:

        输入: [1,2,3]
        输出:
        [
          [1,2,3],
          [1,3,2],
          [2,1,3],
          [2,3,1],
          [3,1,2],
          [3,2,1]
        ]
    *
    * */
//    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3};
//        System.out.print(new problem46().permute(nums));
//    }

    // 迭代法
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        List<List<Integer>> temp = new LinkedList<>();
        lists.add(new LinkedList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 0; j < lists.size(); j++) {
                List<Integer> list = lists.get(j);
                for (int k = 0; k <= list.size(); k ++) {
                    List<Integer> list1 = new LinkedList<>(list);
                    list1.add(k, num);
                    temp.add(list1);
                }
            }
            lists = new LinkedList<>(temp);
            temp = new LinkedList<>();
        }
        return lists;
    }

    // 递归法
    // 思想: [1,2]到[1,2,3]的方法, 在[1,2]的排列组合中的每个位置分别插入3后得到
    public List<List<Integer>> permuteRecursion(int[] nums) {
        return recursion(nums, nums.length-1);
    }

    public List<List<Integer>> recursion (int[] nums, int end) {
        int num = nums[end];
        List<List<Integer>> result = new ArrayList<>();
        if (end == 0) {
            List<Integer> list1 = new LinkedList<>();
            list1.add(num);
            result.add(list1);
            return result;
        }
        List<List<Integer>> lists = recursion(nums, end-1);
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            for (int j = 0; j <= list.size(); j++) {
                List<Integer> list1 = new LinkedList<>(list);
                list1.add(j, num);
                result.add(list1);
            }
        }
        return result;
    }

    // 回溯法
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track, res);
        return res;

    }

    void backtrack(int[] nums, List<Integer> track, List<List<Integer>> res) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track, res);
            // 取消选择
            track.remove(track.size()-1);
        }
    }
}
