package leetcode.java;

public class problem221 {
    /**
     * 动态规划1.
     * */
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int ret = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] - '0';
            if (dp[i][0] == 1) {
                ret = 1;
            }
        }
        for (int i = 0; i < matrix[0].length;i++) {
            dp[0][i] = matrix[0][i] - '0';
            if (dp[0][i] == 1) {
                ret = 1;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (dp[i - 1][j - 1] == 0) {
                        dp[i][j] = 1;
                    } else {
                        int num = dp[i - 1][j - 1];
                        for (int k = 1; k <= dp[i - 1][j - 1]; k++) {
                            if (matrix[i - k][j] == '0' || matrix[i][j - k] == '0') {
                                num = k - 1;
                                break;
                            }
                        }
                        dp[i][j] = num + 1;
                    }
                    ret = Math.max(dp[i][j], ret);
                }
            }
        }
        return ret * ret;
    }
}
