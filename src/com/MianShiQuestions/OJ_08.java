package com.MianShiQuestions;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class OJ_08 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        for (String s : br.readLine().split(" ")) {
            list.add(s);
        }
        Collections.sort(list);
        String res = "";
        for (int i = 0; i < list.size() - 1; ++i) {
            res += list.get(i);
            res += " ";
        }
        res += list.get(list.size() - 1);
        System.out.println(res);
    }
}
