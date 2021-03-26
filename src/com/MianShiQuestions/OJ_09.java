package com.MianShiQuestions;

import java.io.*;
import java.util.*;

public class OJ_09 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<String>();
        String str;
        StringBuilder res = new StringBuilder();
        while ((str = br.readLine()) != null) {
            for(String s : str.split(" ")) list.add(s);
            Collections.sort(list);
            for (int i = 0; i < list.size(); ++i) {
                res.append(list.get(i) + " ");
            }
            res.deleteCharAt(res.length() - 1);
            System.out.println(res.toString());
            res.delete(0,res.length());
            list.clear();
        }
    }
}
