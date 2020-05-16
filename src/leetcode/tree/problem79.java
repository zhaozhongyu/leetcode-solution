package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class problem79 {
//    public boolean exist(char[][] board, String word) {
//        if (word.length() == 0) return true;
//        char begin = word.charAt(0);
//        for (int i = 0; i < board.length; i ++) {
//            for(int j = 0; j < board[0].length; j++) {
//                if (board[i][j] == begin) {
//                    int[][] temp = new int[board.length][board[0].length];
//                    temp[i][j] = 1;
//                    if (exist(board, i, j, temp, word, 0)) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }

    // 深度优先搜索
    // 当temp[i][j] ==1时表示已占用, 0表示未占用
    public boolean exist (char[][] board, int i, int j, int[][] temp, String word, int at) {
        Stack<Character> stack = new Stack<>();
        for(int n = 1; n < word.length(); n++) {
            char c = word.charAt(n);
            // 右, stack中存放r
            if (i < board.length - 1 && board[i+1][j] == c && temp[i+1][j] != 1 ) {
                temp[i+1][j] = 1;
                stack.push('r');
                i++;
            }
            // 左
            else if (i > 0 && board[i-1][j] == c && temp[i-1][j] != 1 ) {
                temp[i-1][j] = 1;
                stack.push('l');
                i--;
            }
            // 上
            else if (j > 0 && board[i][j-1] == c && temp[i][j-1] != 1 ) {
                temp[i][j-1] = 1;
                stack.push('u');
                j--;
            }
            // 下
            else if (j < board[0].length-1 && board[i][j+1] == c && temp[i][j+1] != 1 ) {
                temp[i][j+1] = 1;
                stack.push('d');
                j--;
            }
            // 上下左右都没有找到, 此时回退到上一个位置
            else {

            }
        }
        return true;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return  false;
    }

    boolean search(char[][] board, String word, int i, int j, int k) {
        if (k >= word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)) return false;
        board[i][j] += 256;
        boolean result = search(board, word, i - 1, j, k + 1) || search(board, word, i + 1, j, k + 1)
                || search(board, word, i, j - 1, k + 1) || search(board, word, i, j + 1, k + 1);
        board[i][j] -= 256;
        return result;
    }
}
