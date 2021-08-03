package leetcode.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class problem131 {
    HashMap<String, List<List<String>>> map = new HashMap<>();
    public List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        if (s.length() == 0) {
            return lists;
        }
        if (s.length() == 1 || isPalin(s)) {
            List<String> list = new LinkedList<>();
            list.add(s);
            lists.add(list);
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<List<String>> sublists = partition(s.substring(1));
        String first = s.substring(0, 1);
        for (List<String> sublist : sublists) {
            sublist.add(0, first);
            lists.add(sublist);
        }
        for (int i = 2; i < s.length(); i++) {
            first = s.substring(0, i);
            // 判断一下first是否回文
            if (isPalin(first)) {
                sublists = partition(s.substring(i));
                for (List<String> sublist : sublists) {
                    sublist.add(0, first);
                    lists.add(sublist);
                }
            }
        }
        return lists;
    }

    public boolean isPalin(String s) {
        int len = s.length();
        boolean ret = true;
        for (int j = 0; j < len / 2; j++) {
            if (s.charAt(j) != s.charAt(len - j - 1)) {
                ret = false;
                break;
            }
        }
        return ret;
    }

    public static void main(String[] s) {
        List<List<String>> l = new problem131().partition("aa");
        System.out.println(l);
    }
}
