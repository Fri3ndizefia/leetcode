package com.MianShiQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 找零钱
 * 1，4，16，64，1024种面值
 * 用1024元买 N 元的东西，求最少找零个数
 * 0<= N <= 1024
 */

public class ByteDance_ZJ23 {

    /**
     * 贪心思路
     * @param args
     */
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        try{
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int input = 1024 - Integer.parseInt(line);
        int cnt = 0;
        for (int i : new int[]{64, 16, 4, 1}) {
            cnt += input/i;
            input = input % i;
        }
        System.out.println(cnt);
    }
}
