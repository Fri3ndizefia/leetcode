package com.MianShiQuestions;

import java.io.*;

/**
 * A+B
 *
 */

public class OJ_01 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string;
        while ((string = br.readLine()) != null) {
            String[] input = string.split(" ");
            System.out.println(Integer.parseInt(input[0]) + Integer.parseInt(input[1]));
        }
    }

}
