package leetcode.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class problem131 {
    HashMap<String, List<List<String>>> map = new HashMap<>();
    public List<List<String>> partition(String s) {
        if (map.containsKey(s)) {
            List<List<String>> lists = map.get(s);
            List<List<String>> copys = new ArrayList<>();
            for (List<String> list : lists) {
                List<String> copy = new LinkedList<>();
                copy.addAll(list);
                copys.add(copy);
            }
            return copys;
        }
        List<List<String>> lists = new ArrayList<>();
        if (s.length() == 0) {
            return lists;
        }
        if (s.length() == 1 || isPalin(s)) {
            List<String> list = new LinkedList<>();
            list.add(s);
            lists.add(list);
        }
        if (s.length() == 1) {
            return lists;
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
        List<List<String>> copys = new ArrayList<>();
        for (List<String> list : lists) {
            List<String> copy = new LinkedList<>();
            copy.addAll(list);
            copys.add(copy);
        }
        map.put(s, copys);
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
        List<List<String>> l = new problem131().partition("abbab");
        System.out.println(l);
    }
}
