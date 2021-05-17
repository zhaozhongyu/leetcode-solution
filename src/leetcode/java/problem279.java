package leetcode.java;

import java.util.ArrayList;
import java.util.HashMap;

public class problem279 {


    public int numSquares(int n) {
        // f(n) = f
        ArrayList<Integer> list = new ArrayList<>();
        int[] rets = new int[n + 1];
        for (int i = 1; i < n; i++) {
            if (i * i > n) {
                break;
            }
            list.add(i * i);
        }
        int ret = knapsack(n, list, rets);
        return ret;
    }

    // 除非小于3, 否则不会使用1补位
    public int knapsack(int n, ArrayList<Integer> list, int[] rets) {
        if (n < 3) {
            return n;
        }
        if (rets[n] != 0) {
            return rets[n];
        }
        int ret = n;
        for (int i = 1; i < list.size();i++) {
            if (list.get(i) <= n) {
                ret = Math.min(ret, knapsack(n - list.get(i), list, rets) + 1);
            }
        }
        rets[n] = ret;
        return ret;
    }

    public static void main(String [] args) {
        System.out.println(new problem279().numSquares(127));
    }
}
