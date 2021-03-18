package com.Solutions;

/**
 * 旋转矩阵二维数组
 *
 * 不占用空间能做到吗？
 */
public class solution48 {
    public void rotate(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                newMatrix[i][j] = matrix[matrix.length - 1 - j ][i];
            }
        }
        System.arraycopy(newMatrix, 0, matrix, 0, matrix.length);
    }

}
