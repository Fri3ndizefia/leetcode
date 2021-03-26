package com.MianShiQuestions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OJ_04 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int sum;
        while ((str = br.readLine()) != null && !str.equals("0")) {
            sum = 0;
            String[] input = str.split(" ");
            for (int i = 1; i <= Integer.parseInt(input[0]); ++i) {
                sum += Integer.parseInt(input[i]);
            }
            System.out.println(sum);

            /**
             *            for(String s:input) sum += Integer.parseInt(s);
             *             sum -= Integer.parseInt(input[0]);
             */
        }
    }
}
