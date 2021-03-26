package com.MianShiQuestions;

import java.io.*;

public class OJ_02 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; ++i) {
            String[] strs = br.readLine().split(" ");
            System.out.println(Integer.parseInt(strs[0]) + Integer.parseInt(strs[1]));
        }
    }
}
