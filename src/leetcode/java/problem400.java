package leetcode.java;

public class problem400 {
    public int findNthDigit(int n) {
        if (n < 10) return n;
        int temp = 0;
        int digit = 1;
        int num = 0;
        // n位数要占用的数量, 如100-999的数量为900 * 3
        while (true) {
            num = ((int)Math.pow(10, digit - 1) * 9) * digit;
            if (num + temp > n || num < 0) {
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
}
