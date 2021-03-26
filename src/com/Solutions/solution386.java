package com.Solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 字典序输出 从 1 到 n 的数字;
 */

public class solution386 {

    /**
     * 方法1，转换String，调用Collections.sort 进行自带的字典序
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder(int n) {
        List<String> list = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            list.add(String.valueOf(i + 1));
        }
        Collections.sort(list);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            res.add(Integer.parseInt(list.get(i)));
        }
        return res;
    }


}
