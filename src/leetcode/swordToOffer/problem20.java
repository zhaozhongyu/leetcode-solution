package leetcode.swordToOffer;

public class problem20 {
    /**
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    // 第一个字符单独处理, +-或者数字
    // e只能出现一次, .点号只能出现一次, .点号不能出现在e后面
    // -减号可以出现在第一个字符或者e后面第一个
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        boolean point = false;
        boolean echar = false;
        boolean hasNumber = false;
        char c = s.charAt(0);
        if (c == '.') {
            point = true;
        } else if (!(c == '+' || c == '-' || c == ' ' || (c <= '9' && c >= '0'))) {
            return false;
        } else if (c <= '9' && c >= '0'){
            hasNumber = true;
        }
        for (int i = 1; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == 'e') {
                if (echar) {
                    return false;
                }
                echar = true;
                if (i + 1 < s.length() && s.charAt(i + 1) == '-') {
                    i ++;
                }
            } else if (c == '.') {
                if (point || echar) {
                    return false;
                }
                point = true;
            } else if (c == ' ') {
            } else if (c <= '9' && c >= '0' ) {
                hasNumber = true;
            } else {
                return false;
            }
        }
        if (!hasNumber) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        isNumber(" ");
    }
}
