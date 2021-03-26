package com.MianShiQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Vivo_1 {
    public static String compileSeq (String input) {
        // write code here
        List<Integer> array = new ArrayList<Integer>();
        for(String c : input.split(",")){
            array.add(Integer.parseInt(c));
        }
        List<Integer> compiled = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < array.size(); ++i){
            if(array.get(i) == -1){
                compiled.add(i);
                queue.add(i);
                array.set(i, -2);
            }
        }
        while(!array.isEmpty() && !queue.isEmpty()){
            int preCompiled = queue.poll();
            for(int i = 0 ; i < array.size();++i){
                if(array.get(i) == preCompiled){
                    compiled.add(i);
                    array.set(i, -2);
                    queue.add(i);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i : compiled){
            sb.append(i + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(compileSeq("1,2,-1,1"));
    }
}
