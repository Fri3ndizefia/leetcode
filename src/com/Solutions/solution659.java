package com.Solutions;
import java.util.HashMap;

public class solution659 {

    public static void main(String []args){
        HashMap<Integer, Integer> freq = new HashMap<>(), appendfreq = new HashMap<>();
        int[] nums = {1, 2,3, 3, 4,5};
        for(int i : nums) freq.put(i, freq.getOrDefault(i,0) +1);
        System.out.println(freq);
        System.out.println(freq.get(1));
        System.out.println(appendfreq.getOrDefault(1,0));
        for (int i : nums) {
            System.out.println("One for loop");
            System.out.println(i);
            System.out.println("the appendfreq getOrDefault is");
            System.out.println(appendfreq.getOrDefault(i,0));
            System.out.println(appendfreq.getOrDefault(i+1,0));
            System.out.println(appendfreq.getOrDefault(i+2,0));

            if (freq.get(i) == 0) {
                System.out.println('0');
                continue;
            }
            else if (appendfreq.getOrDefault(i,0) > 0) {
                System.out.println("1 else run");
                appendfreq.put(i, appendfreq.get(i) - 1);
                appendfreq.put(i+1, appendfreq.getOrDefault(i+1,0) + 1);
            }
            else if (freq.getOrDefault(i+1,0) > 0 && freq.getOrDefault(i+2,0) > 0) {
                System.out.println("2 else run");

                freq.put(i+1, freq.get(i+1) - 1);
                freq.put(i+2, freq.get(i+2) - 1);
                appendfreq.put(i+3, appendfreq.getOrDefault(i+3,0) + 1);
            }
            else System.out.println('f');
            freq.put(i, freq.get(i) - 1);
            System.out.println(freq);
            System.out.println("run here");
        }
    }
}
