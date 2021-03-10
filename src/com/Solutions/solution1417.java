package com.Solutions;

import java.util.ArrayList;
import java.util.List;

public class solution1417 {
    public String reformat(String s){
        if (s.length() == 1) {
            return s;
        }
        List<Character> letters = new ArrayList<Character>();
        List<Character> numbers = new ArrayList<Character>();
        String formattedString = "";
        for (char c : s.toCharArray()) {
            if (c <= 122 && c >= 97) {
                letters.add(c);
            } else if (c >= 48 && c <= 57) {
                numbers.add(c);
            }
        }
        if (Math.abs(letters.size() - numbers.size()) >= 2) {
            return "";
        }else{
            if (letters.size() == numbers.size()) {
                for (int i = 0; i < letters.size(); ++i) {
                    formattedString += letters.get(i);
                    formattedString += numbers.get(i);
                }
            } else if (letters.size() > numbers.size()) {
                for (int i = 0; i < numbers.size(); ++i) {
                    formattedString += letters.get(i);
                    formattedString += numbers.get(i);
                }
                formattedString += letters.get(letters.size());
            } else if (letters.size() < numbers.size()) {
                for (int i = 0; i < letters.size(); ++i) {
                    formattedString += numbers.get(i);
                    formattedString += letters.get(i);
                }
                formattedString += numbers.get(numbers.size());
            }
        }
        return formattedString;
    }


    /**
     * 计算一下字母和数字的分别的数量
     * 根据数量判断能否重新格式化，
     * 插入每次的字母/数字的时候，对应的索引加2，就能保证空位是留给对方的
     */

    public String reformattedString(String s) {
        if (s.length() == 1) {
            return s;
        }

        int letters = 0, numbers = 0;
        char[] reformatted = s.toCharArray();
        for (char c : s.toCharArray()) {
            if(c >= '0' && c <= '9'){
                ++numbers;
            }else{
                ++letters;
            }
        }
        if (Math.abs(numbers - letters) > 1) {
            return "";
        }
        if(numbers > letters){
            numbers = 0;
            letters = 1;
        }else{
            numbers = 1;
            letters = 0;
        }
        for (char c : s.toCharArray()) {
            if(c >= '0' && c <= '9'){
                reformatted[numbers] = c;
                numbers += 2;
            }else{
                reformatted[letters] = c;
                letters += 2;
            }
        }
        return new String(reformatted);
    }
}
