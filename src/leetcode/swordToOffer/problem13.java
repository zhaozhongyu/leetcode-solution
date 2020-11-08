package leetcode.swordToOffer;

import java.util.HashSet;
import java.util.Stack;

public class problem13 {

    /**
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     *
     *  
     *
     * 示例 1：
     *
     * 输入：m = 2, n = 3, k = 1
     * 输出：3
     * 示例 2：
     *
     * 输入：m = 3, n = 1, k = 0
     * 输出：1
     * */
    // 题目的关键是如果当前的值合法, 则当前值的左边/上边必然要有一个合法, 但从(9,0)->(10,0)这种也需要判断, 每一行的第一个不合法时,后面也不行
    public static int movingCount(int m, int n, int k) {
        HashSet<String> set = new HashSet<>();
        int count = 1;
        set.add(String.valueOf(0) + ',' + 0);
        for (int j = 1; j < n; j++) {
            if (check(0, j, k) && (set.contains(String.valueOf(0) + ',' + (j - 1)))) {
                count ++;
                set.add(String.valueOf(0) + ',' + j);
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check(i, j, k) && (set.contains(String.valueOf(i - 1) + ',' + j) || set.contains(String.valueOf(i) + ',' + (j - 1)))) {
                    count ++;
                    set.add(String.valueOf(i) + ',' + j);
                }
            }
        }
        return count;
    }

    public static boolean check(int i, int j, int k) {
        int n = 0;
        while (i > 9) {
            n += i % 10;
            i = i / 10;
        }
        n += i;
        while(j > 9) {
            n += j % 10;
            j = j / 10;
        }
        n += j;
        return n <= k;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(38, 15, 9));
    }
}
