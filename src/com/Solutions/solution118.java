package com.Solutions;

import java.util.ArrayList;
import java.util.List;

public class solution118 {
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> triangles = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                }else {
                    row.add(triangles.get(i - 1).get(j) + triangles.get(i - 1).get(j - 1));
                }
            }
            triangles.add(row);
        }
        return triangles;
    }


}
