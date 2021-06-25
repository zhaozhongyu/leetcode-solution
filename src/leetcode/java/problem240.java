package leetcode.java;

public class problem240 {

    /**
     * 编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     *
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * 不看题解不知道自己蠢系列...
     * */
    public boolean searchMatrix(int[][] matrix, int target) {
        // start our "pointer" in the bottom-left
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { // found it
                return true;
            }
        }

        return false;
    }

    public static void main(String[] a) {
        new problem240().searchMatrix(new int[][]{{5,6,10,14},{6,10,13,18},{10,13,18,19}}, 14);
    }
}
