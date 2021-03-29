package com.Solutions;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarEntry;

public class solution1291 {
    public List<Integer> sequentialDigist(int low, int high) {
        List<Integer> res = new LinkedList<>();
        for (int i = 1; i <= 9; ++i) {
            int num = i;
            for (int j = i + 1; j <= 9; ++j) {
                num = num * 10 + j;
                if (num >= low && num <= high) {
                    res.add(num);
                }
            }
        }
        Collections.sort(res);
        return res;
    }

}
