package com.MianShiQuestions;

import java.io.*;

public class OJ_05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum;
        for (int i = 0; i < n; ++i) {
            sum = 0;
            String[] input = br.readLine().split(" ");
            for (String s : input) {
                sum += Integer.parseInt(s);
            }
            sum -= Integer.parseInt(input[0]);
            System.out.println(sum);
        }
    }
}