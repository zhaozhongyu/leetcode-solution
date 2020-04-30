package leetcode;

import java.util.ArrayList;
import java.util.List;

public class problem77 {
    /*
    * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

    示例:

    输入: n = 4, k = 2
    输出:
    [
      [2,4],
      [3,4],
      [2,3],
      [1,2],
      [1,3],
      [1,4],
    ]

    /**
     * 思路: 先将1-n加入到一个list, 这时k=1. 然后依次取出来, 从再加一个值, 此时要判断最后一个值不能大于当前循环, 比如2之后不加1, 依次类推
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        for (int j = 1; j <= n; j++) {
            l = new ArrayList<>();
            l.add(j);
            result.add(l);
        }
        for (int i = 1; i < k; i++){
            for (int j = 0; j < result.size(); j++) {
                for (int m = result.get(j).get(result.get(j).size() - 1) + 1; m <= n; m ++) {
                    l = new ArrayList<>();
                    l.addAll(result.get(j));
                    l.add(m);
                    temp.add(l);
                }

            }
            result = temp;
            temp = new ArrayList<>();
        }
        return result;
    }

//    public static void main(String[] args) {
//        problem77 p = new problem77();
//        System.out.print(p.combine(3,3));
//    }
}
