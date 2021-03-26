package com.MianShiQuestions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OJ_03 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null && !str.equals("0 0")) {
            String[] input = str.split(" ");
            System.out.println(Integer.parseInt(input[0]) + Integer.parseInt(input[1]));
        }
    }
}
