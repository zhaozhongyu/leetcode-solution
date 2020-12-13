package leetcode.swordToOffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class problem50 {

    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     *
     * 示例:
     *
     * s = "abaccdeff"
     * 返回 "b"
     *
     * s = ""
     * 返回 " "
     */
    public char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char res = ' ';
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, Integer.MAX_VALUE);
            } else {
                map.put(c, i);
                list.add(c);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (map.get(list.get(i)) != Integer.MAX_VALUE) {
                res = list.get(i);
                break;
            }
        }
        return res;
    }
}
