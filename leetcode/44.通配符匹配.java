class Solution {
    public boolean isMatch(String s, String p) {
        if(! p.contains("*") && p.length() != s.length()){
            return false;
        }
        if(p.length() > 0 && p.charAt(0) != '*'){ // "*" 不在第一位
            for(int i = 0; i < p.length();i++){
                if(p.charAt(i) == '*'){
                    s = s.substring(i);
                    p = p.substring(i);
                    break;
                }
                if(i >= s.length() || (p.charAt(i) != s.charAt(i) && p.charAt(i) != '?')){
                    return false;
                }
            }
        }
        if(p.length() > 0 && p.charAt(p.length() - 1) != '*'){
            for(int i = 0; i < p.length(); i++){
                if(p.charAt(p.length()-1-i) == '*'){
                    s = s.substring(0, s.length() -i);
                    p = p.substring(0, p.length() -i);
                    break;
                }
                if(i >= s.length() || (p.charAt(p.length() - 1 - i) != s.charAt(s.length() - 1 - i) && p.charAt(p.length() - 1 - i) != '?')){
                    return false;
                }
            }
        }
        if(p.length() == 0){
            return true;
        }
        //经过前两步后, p的类型全部被变为*str*或者str的问题, 即前后必然有*或者str中必然没有*, 此时不再需要考虑*匹配多少个字符的问题, 直接匹配*后面的字符即可
        String[] patterns = p.split("\\*");
        for(int i = 1; i < patterns.length; i++){
            if(patterns[i].equals("")){
                continue;
            }
            s = removeMatch(s, patterns[i]);
            if(s == null){
                return false;
            }
        }
        return true;
    }
    //用于匹配字符串, 并且删除掉匹配到字符串之前的部分
    public static String removeMatch(String s, String p){
        for(int i = 0; i < s.length() - p.length() + 1; i++){
            if(s.charAt(i) == p.charAt(0) || p.charAt(0) == '?'){
                for(int j = 0; j < p.length(); j++){
                    if(s.charAt(i+j) != p.charAt(j) && p.charAt(j) != '?'){
                        break;
                    }
                    if(j == p.length() -1 ){
                        return s.substring(i+j+1);
                    }
                }
            }
        }
        return null;
    }

}