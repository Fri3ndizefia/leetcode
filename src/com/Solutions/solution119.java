package com.Solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 */
public class solution119 {
    public List<Integer> getRow(int rowIndex){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < rowIndex; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                }else{
                    row.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
            list.add(row);
        }
        return list.get(rowIndex);
    }

    /**
     * 用滚动数组方法做一下
     * 因为每次都只是用了上一行的数据进行计算。
     * 滚动数组每次也只是对上一次的数组进行刷新
     * <p>
     * 第 n 行的杨辉三角，刚好有 n+1 个数
     */
    public List<Integer> getRowByArray(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 0; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }
}
