package com.Solutions;


/**
 * 剑指03 二维数组查找数
 *
 */
public class solution1823 {

    // 暴力 O（NM）时间复杂度查找
    // 空间复杂度 1
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // 由于数组是行、列均是递增的，当查找到了不符合的时候，就可以跳过剩余的，进行下一轮查找，甚至是把不查找了
    public boolean findNum(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                --column;
            } else{
                ++row;
            }
        }
        return  false;
    }
}
