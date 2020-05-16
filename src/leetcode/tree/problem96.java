package leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problem96 {

//    public static void main(String[] args) {
//        System.out.print(new problem96().numTrees1(3));
//    }

    // 迭代法
    public int numTrees1(int n ) {
        if (n == 0 ) return 0;
        int [] results = new int[n+1];
        results[0] = 1;
        results[1] = 1;
        for (int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                results[i] += results[j] * results[i-j-1];
            }
        }
        return results[n];
    }

    // 递归法
    public int numTrees(int n) {
        if (n == 0) return 0;
        int [] results = new int[n];
        results[0] = 1;
        return recursion(results, 1, n);

    }

    public int recursion (int [] results, int start, int end) {
        if (start > end) {
            return 1;
        }
        if (results[end - start] != 0) {
            return results[end - start];
        }
        int result = 0;
        for (int i = start; i <= end; i++) {
            int leftNodes = recursion(results, start, i-1);
            int rightNodes = recursion(results, i+1, end);
            result += leftNodes * rightNodes;
        }
        results[end-start] = result;
        return result;
    }
}
