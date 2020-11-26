package leetcode.swordToOffer;

public class problem46 {

    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: 12258
     * 输出: 5
     * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     * */
    // 1-25时, 可以是1-2步, 否则1步
    // https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/ 的变种, 满足条件时, f(n) = f(n-1)+f(n-2) 或者f(n) = f(n-1)
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int last1 = 1;
        int last2 = 1;
        int res = 1;
        for (int i = 1; i < str.length(); i ++) {
            char c = str.charAt(i);
            char lastc = str.charAt(i - 1);
            if ((lastc == '1') || (lastc == '2' && c < '6' && c >= '0')) {
                res = last1 + last2;
            } else {
                res = last1;
            }
            last2 = last1;
            last1 = res;
        }
        return res;
    }

    public static void main(String[] agrs) {
        new problem46().translateNum(12258);
    }
}
