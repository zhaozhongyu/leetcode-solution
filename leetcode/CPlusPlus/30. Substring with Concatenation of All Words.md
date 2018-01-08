class Solution {

public:
    vector<int> findSubstring(string s, vector<string>& words) {
        int len = words[0].size();
        vector<string> copy(words);
        sort(copy.begin(), copy.end());
        copy.erase(unique(copy.begin(),copy.end()), copy.end());
        vector<int> vector1;
        for(int j = 0; j < copy.size(); j++){
            for(int i = s.find(copy[j]); i < s.size() - words.size() * len+1; i = s.find(copy[j], i+1)){
                string sub = s.substr(i, words.size() * len);
                if(checkStr(sub, words, len)){
                    vector1.push_back(i);
                }
            }
        }
        sort(vector1.begin(), vector1.end());
        vector1.erase(unique(vector1.begin(),vector1.end()), vector1.end());
        return vector1;
    }
    bool checkStr(string s, vector<string>& words, int len){
        string str = s;
        for(int i = 0; i < words.size(); i++){
            int result = str.find(words[i]);
            while(result != -1 && result % len != 0) {
                result = str.find(words[i], result+1);
            }
            if(result == -1){
                return false;
            }
            str = str.substr(0,result) + str.substr(result+len, str.size()-result);
        }
        return true;
    }
};
