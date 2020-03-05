package leetcode.old;

class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        } else {
            StringBuilder sb = new StringBuilder();
            String string = countAndSay(n-1);
            int i = 0;
            while(i < string.length()){
                char c = string.charAt(i);
                int count = 0;
                for(int offset = i; offset < string.length(); offset++){
                    if(string.charAt(offset) == c){
                        count++;
                    }else{
                        break;
                    }
                }
                i += count;
                sb.append(count).append(c);
            }
            return sb.toString();
        }
    }
}