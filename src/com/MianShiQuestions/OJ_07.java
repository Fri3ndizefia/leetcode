package com.MianShiQuestions;

import java.io.*;

public class OJ_07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int sum;
        while ((str = br.readLine()) != null) {
            sum = 0;
            String[] input = str.split(" ");
            for(String s: input) sum += Integer.parseInt(s);
            System.out.println(sum);
        }
    }
}
