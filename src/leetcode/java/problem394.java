package leetcode.java;

import java.util.Stack;

public class problem394 {
    public String decodeString(String s) {
        int index = s.indexOf('[');
        if (index == -1) {
            return s;
        }
        StringBuilder ret = new StringBuilder();
        int repeattimes = 0;
        for (int i = index - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                repeattimes = Integer.parseInt(s.substring(i + 1, index));
                ret.append(s.substring(0, i + 1));
                break;
            } else if (i == 0) {
                repeattimes = Integer.parseInt(s.substring(0, index));
            }
        }
        int open = 1;
        for (int i = index + 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                open += 1;
            } else if (c == ']') {
                open -= 1;
            }
            if (open == 0) {
                String sub = decodeString(s.substring(index + 1, i));
                for (int j = 0; j < repeattimes; j ++) {
                    ret.append(sub);
                }
                ret.append(decodeString(s.substring(i + 1)));
                break;
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String s= "abc3[cd]xyz";
        System.out.println(new problem394().decodeString(s));
    }
}
