package leetcode.java;

import java.util.HashMap;

public class problem91 {
    // https://leetcode-cn.com/problems/decode-ways/
    HashMap<String, Integer> map = new HashMap<>();
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 1;
        }
        if (s.charAt(0) == '0') {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        char c0 = s.charAt(0), c1 = s.charAt(1);
        if (c0 == '1' || (c0 == '2' && c1 < '7')) {
            if (c1 == '0') {
                map.put(s, numDecodings(s.substring(2)));
            } else {
                map.put(s,  numDecodings(s.substring(1)) + numDecodings(s.substring(2)));
            }

        } else {
            map.put(s, numDecodings(s.substring(1)));
        }
        return map.get(s);
    }

    public static void main(String[] s) {
        int n = new problem91().numDecodings("111111111111111111111111111111111111111111111");
        System.out.println(n);
    }
}
