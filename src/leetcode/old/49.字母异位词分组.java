package leetcode.old;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] chars = new int[26]; //使用不排序法判断每个字符串的字母
            for(int i = 0; i < str.length(); i++){
                chars[str.charAt(i) - 97] ++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i : chars){
                sb.append(i);
            }
            String string = sb.toString();
            if(map.containsKey(string)) {
                map.get(string).add(str);
            } else {
                List<String> l = new ArrayList<>();
                l.add(str);
                map.put(string, l);
            }

        }
        List<List<String>> lists = new ArrayList<>();
        for(List<String> list : map.values()){
            lists.add(list);
        }
        return lists;
    }
}