class Solution {
public:
    int strStr(string haystack, string needle) {
        bool compare = true;
        if(haystack == needle || needle == ""){
            return 0;
        }
        if(haystack.size() < needle.size()){
            return -1;
        }
        for(int i = 0; i < haystack.size() - needle.size()+1; i++){
            if(haystack[i] == needle[0]){
                for(int j = 1; j < needle.size();j++){
                    if(haystack[i+j] != needle[j]){
                        compare = false;
                        break;
                    }
                }
                if(compare){
                    return i;
                }
                compare = true;
            }
        }
        return -1;
    }
};