    public static boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = matrix.length;
        int column = 0;
        while (low <= high) {
            int middle = (high + low) / 2;
            if(matrix[middle][0] == target){
                return true;
            }
            if(matrix[middle][0] < target) {
                if (matrix[middle+1][0] > target) {
                    column = middle;
                    break;
                }
                low = middle + 1;
            }
            else if(matrix[middle][0] > target) {
                high = middle - 1;
            }
        }
        low = 0;
        high = matrix[0].length;
        while (low <= high) {
            int middle = (high + low) / 2;
            if(matrix[column][middle] == target){
                return true;
            }
            if(matrix[column][middle] < target) {
                low = middle + 1;
            }
            else if(matrix[column][middle] > target) {
                high = middle - 1;
            }
        }
        return false;
    }
