package leetcode.old;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = matrix.length - 1;
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int column = 0;
        while (low <= high) {
            int middle = (high + low + 1) / 2;
            if(matrix[middle][0] == target){
                return true;
            }
            if ((middle == matrix.length - 1 && matrix[middle][0] < target) || (middle < matrix.length - 1 && matrix[middle+1][0] > target && matrix[middle][0] < target)) {
                column = middle;
                break;
            }
            if(matrix[middle][0] < target) {
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        low = 0;
        high = matrix[0].length - 1;
        while (low <= high) {
            int middle = (high + low + 1) / 2;
            if(matrix[column][middle] == target){
                return true;
            }
            if(matrix[column][middle] < target) {
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        return false;
    }
}
