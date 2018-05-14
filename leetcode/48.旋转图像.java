class Solution {
    public void rotate(int[][] matrix) {
        int temp;
        for(int i = 0; i < matrix.length; i++){ //这个控制圈数
            for(int j = i; j < matrix.length -1 - i ; j++){ //这个控制每个边的循环
                //左上角[i][j], 右上角[j][matrix.length -1 - i], 右下角[matrix.length -1 - i][matrix.length -1 - j], 左下角[matrix.length -1 - j][i] 依次修改

                temp = matrix[j][matrix.length -1 - i]; //
                matrix[j][matrix.length -1 - i] = matrix[i][j] ; //设置右上角
                matrix[i][j] = matrix[matrix.length -1 - i][matrix.length -1 - j]; //保存右下角
                matrix[matrix.length -1 - i][matrix.length -1 - j] = temp; //设置右下角
                temp = matrix[matrix.length -1 - j][i]; //保存左下角
                matrix[matrix.length -1 - j][i] = matrix[i][j]; //设置左下角
                matrix[i][j] = temp;  //设置左上角

            }
        }
    }
}