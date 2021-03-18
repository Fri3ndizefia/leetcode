package com.Solutions;

/** 旋转矩阵
 *
 */
public class solution1901 {

    /**
     * 第一种方法，违背题意，创建一个新的数组，并且找到相关对应信息，进行复制
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                newMatrix[i][j] = matrix[matrix.length - 1 - j ][i];
            }
        }
        System.arraycopy(newMatrix, 0, matrix, 0, matrix.length);
    }

    /**
     * 推导原地旋转公式
     * 枚举两次
     *
     * 很心把
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }


    /**
     * 上下的，水平翻转一次后，再对角线翻转，就是通过翻转完成一次矩阵的顺时针旋转了。
     * @param matrix
     */
    public void rotate3(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int  temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }

        //主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
