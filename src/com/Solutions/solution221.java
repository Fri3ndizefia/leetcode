package com.Solutions;

/**
 * 动态规划
 *
 */

public class solution221 {

    /**动态规划法
     * 将正方形的右下角作为每次的动规
     * dp[i][j] = MIN(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
     * 核心代码是寻找上方，左方和左上方的最小动规值
     *
     * 注意边界情况，边界下，无法发生这种检验操作（出界），所以默认是最小1
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(dp[i - 1][j],Math.min( dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide*maxSide;
    }


}
