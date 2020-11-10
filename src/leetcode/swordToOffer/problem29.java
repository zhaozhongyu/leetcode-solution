package leetcode.swordToOffer;

import java.util.LinkedList;
import java.util.List;

public class problem29 {

    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * 示例 2：
     *
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     * */
    public int[] spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<Integer>();
        if(matrix.length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        // 计算圈数
        int lvl = (Math.min(m, n) + 1) / 2;
        for(int i = 0; i < lvl; i++){
            // 计算相对应的该圈最后一行
            int lastRow = m - i - 1;
            // 计算相对应的该圈最后一列
            int lastCol = n - i - 1;
            // 如果该圈第一行就是最后一行，说明只剩下一行
            if(i == lastRow){
                for(int j = i; j <= lastCol; j++){
                    res.add(matrix[i][j]);
                }
                // 如果该圈第一列就是最后一列，说明只剩下一列
            } else if(i == lastCol){
                for(int j = i; j <= lastRow; j++){
                    res.add(matrix[j][i]);
                }
            } else {
                // 第一行
                for(int j = i; j < lastCol; j++){
                    res.add(matrix[i][j]);
                }
                // 最后一列
                for(int j = i; j < lastRow; j++){
                    res.add(matrix[j][lastCol]);
                }
                // 最后一行
                for(int j = lastCol; j > i; j--){
                    res.add(matrix[lastRow][j]);
                }
                // 第一列
                for(int j = lastRow; j > i; j--){
                    res.add(matrix[j][i]);
                }
            }
        }
        return res;
    }
}
