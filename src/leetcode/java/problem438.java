package leetcode.java;

import java.util.ArrayList;
import java.util.List;

public class problem438 {

    public List<Integer> findAnagrams(String s, String p) {
        int[] chars = new int[26];
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            chars[c - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            char c = s.charAt(i);
            if (chars[c - 'a'] == 0) {
                continue;
            }
            if (checkAnagrams(s.substring(i,  i + p.length()), chars)) {
                res.add(i);
            }
        }
        return res;
    }

    public boolean checkAnagrams(String s, int[] chars) {
        int[] chars1 = chars.clone();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars1[c - 'a']--;
            if (chars1[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
