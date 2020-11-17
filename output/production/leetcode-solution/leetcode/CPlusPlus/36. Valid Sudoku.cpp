class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int num;
        vector<vector<bool>> checkH(9,vector<bool>(9)), checkW(9,vector<bool>(9)), check(9,vector<bool>(9));
        for(int i = 0; i < board.size(); i++){
            for(int j = 0; j < board[0].size(); j++){
                if(board[i][j] == '.'){
                    continue;
                }
                num = board[i][j] - '0';
                if(checkH[i][num-1] != false || checkW[num-1][j] != false || check[i/3*3+(num-1)/3][j/3*3+(num-1)%3] != false){
                    return false;
                }
                checkH[i][num-1] = checkW[num-1][j] = check[i/3*3+(num-1)/3][j/3*3+(num-1)%3] = true;
            }
        }
        return true;
    }
};