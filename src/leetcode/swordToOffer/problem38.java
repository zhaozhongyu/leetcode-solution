package leetcode.swordToOffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class problem38 {

    /**
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     *
     *  
     *
     * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     *
     *  
     *
     * 示例:
     *
     * 输入：s = "abc"
     * 输出：["abc","acb","bac","bca","cab","cba"]
     * */
    // 全排列问题
    public String[] permutation(String s) {
        HashSet<String> set = new HashSet<>();
        char[] chars = s.toCharArray();
        char[] res = new char[chars.length];
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
        StringBuffer sb = new StringBuffer();
        backtrack(chars, sb, set, map);
        return set.toArray(new String[0]);
    }

    public void backtrack(char[] chars, StringBuffer sb, HashSet<String> set, HashMap<Character, Integer> map) {
        if (sb.length() == chars.length) {
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 0) {
                continue;
            }
            sb.append(chars[i]); map.put(chars[i], map.get(chars[i]) - 1);
            backtrack(chars, sb, set, map);
            map.put(chars[i], map.get(chars[i]) + 1);sb.deleteCharAt(sb.length() - 1);
        }
    }


}
