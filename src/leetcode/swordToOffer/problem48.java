package leetcode.swordToOffer;

import java.util.HashMap;
import java.util.HashSet;

public class problem48 {

    /**
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> set = new HashMap<>();
        int res = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (set.containsKey(c)) {
                if (res < sb.length()) {
                    res = sb.length();
                }
                sb = new StringBuffer();
                i = set.get(c);
                set.clear();
            } else {
                set.put(c, i);
                sb.append(c);
            }
        }
        if (res < sb.length()) {
            res = sb.length();
        }
        return res;
    }

    public static void main(String[] args) {
        new problem48().lengthOfLongestSubstring("dvdf");
    }
}
