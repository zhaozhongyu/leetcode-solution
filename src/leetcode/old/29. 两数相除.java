package leetcode.old;

class Solution {
    public int divide(int dividend, int divisor) {
        int result = 0;
        boolean flag = false; 
        if(getsign(dividend) != getsign(divisor)){
            flag = true; //flag为true时表示除数与被除数符号不一样
        }
        dividend = dividend > 0?-dividend:dividend; //将除数和被除数转换为负数(为了防止最大值溢出, 所以不能转换为正数)
        divisor = divisor > 0?-divisor:divisor;

        int n = 31; //int 类型的最大位数, 还有一位是符号位
        while(n >= 0){
            if((dividend>>n) <= divisor && (divisor<<n) >= dividend){ //(divisor<<n) >= dividend是用于判断数字不是2的整倍数的时候导致的溢出问题
                dividend -= divisor<<n ;
                result -= 1<<n;
            }
            n--;
        }
        if(!flag){
            if(result == Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            }
            return -result;
        }
        return result;
    }

    public static boolean getsign(int num){
        if(num >= 0){
            return true;
        }
        return false;
    }
}