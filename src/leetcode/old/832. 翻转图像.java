package leetcode.old;

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int len = A[i].length;
            for (int j = 0; j < len/2;j++){
                    int temp = A[i][j];
                    A[i][j] = A[i][len-j-1];
                    A[i][len-j-1] = temp;
            }
            for (int j = 0; j < len;j++){
                if(A[i][j] == 1){
                    A[i][j] = 0;
                }else {
                    A[i][j] = 1;
                }
            }
        }
        return A;
    }
}
