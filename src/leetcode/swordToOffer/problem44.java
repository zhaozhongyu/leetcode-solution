package leetcode.swordToOffer;

public class problem44 {
    /**
     * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
     *
     * 请写一个函数，求任意第n位对应的数字。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：n = 3
     * 输出：3
     * 示例 2：
     *
     * 输入：n = 11
     * 输出：0
     * */
    public int findNthDigit(int n) {
        if (n < 10) return n;
        int temp = 0;
        int digit = 1;
        int num = 0;
        // n位数要占用的数量, 如100-999的数量为900 * 3
        while (true) {
            num = ((int)Math.pow(10, digit - 1) * 9) * digit;
            if (num + temp > n || num < 0) { // 小于0是防溢出
                break;
            }
            temp += num;
            digit ++;
        }
        num = (n - temp - 1) / digit + (int)Math.pow(10, digit - 1); // 最后一个数字
        temp = (n - temp - 1) % digit; // 最后一个数字的第几位
        int res = 0;
        for (int i = digit; i > temp; i --) {
            res = num % 10;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 1000000000;
        int d = new problem44().findNthDigit(n);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 1000; i++) {
            sb.append(i);
        }
        char c = sb.charAt(n);
        String s = sb.substring(0, 10);
        String s1 = sb.substring(10, 189 +1);
        String s2 = sb.substring(190, 2890);
        System.out.println(d);
    }
}
