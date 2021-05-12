package leetcode.java;

public class problem647 {

    int num = 0;
    // 暴力方法的更简单写法
    public int countSubstrings(String s) {
        for (int i=0; i < s.length(); i++){
            count(s, i, i);//回文串长度为奇数
            count(s, i, i+1);//回文串长度为偶数
        }
        return num;
    }

    public void count(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            num++;
            left--;
            right++;
        }
    }

    // 暴力方法了..
    public int countSubstrings1(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // 以i为中心, 向两边扩展
            count ++;
            for (int j = 1; i - j >=0 && i + j < s.length(); j++) {
                if (isValidStr(s, i - j, i + j)) {
                    count ++;
                } else {
                    break;
                }
            }
            // 以i和i的右侧元素为中心, 向两边扩展
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                count ++;
                for (int j = 1; i - j >=0 && i + j + 1 < s.length(); j++) {
                    if (isValidStr(s, i - j, i + j + 1)) {
                        count ++;
                    } else {
                        break;
                    }
                }
            }

        }
        return count;
    }

    public boolean isValidStr(String s, int start, int end) {
        if (start == end) {
            return false;
        }
        if (start > end) {
            return false;
        }
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end --;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new problem647().countSubstrings("abc"));
    }
}
