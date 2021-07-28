package leetcode.java;

public class problem125 {
    // https://leetcode-cn.com/problems/valid-palindrome/
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char lc = s.charAt(left), rc = s.charAt(right);
            if (lc == rc) {
                left ++;
                right --;
            } else {
                if (!isCharOrNum(lc)) {
                    left++;
                } else if (!isCharOrNum(rc)) {
                    right--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isCharOrNum(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        return false;
    }
}
