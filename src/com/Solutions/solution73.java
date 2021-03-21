package com.Solutions;

import java.util.HashSet;
import java.util.Set;

public class solution73 {

    /**
     * 标记数组法：
     * 时间 mn
     * 空间 m+n
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> row = new HashSet<>();
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (row.contains(i) || col.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


    /**
     * 使用两个标记变量，用矩阵的第一行和第一列来标记数组，从而减少额外空间的使用。
     * 但是这样会导致原数组的第一行和第一列被修改，无法记录他们原本是否包含0
     * 需要两个额外的标记变量记录第一行和第一列是否包含0
     * 时间复杂度 mn
     * 空间 1
     * @param matrix
     */
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }
        // 如果第一列有 0 ，标记下来
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }
        // 如果第一行有0 ，标记下来
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 使用第一行 和 第一列来标记 0
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // set 0
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }


    /**
     * 仅使用一个标记变量。
     * 标记记录第一列是否存在0。
     * 这样，第一列的第一个元素既可以标记第一行是否出现0。
     * 防止第一列元素被提前更新，需要从最后一行开始，倒序处理矩阵元素
     * @param matrix
     */
    public void setZeroes3(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flagCol0 = false;
        for (int i = 0; i < m; ++i) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; --i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }
    }

}
