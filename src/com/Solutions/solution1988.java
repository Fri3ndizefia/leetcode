package com.Solutions;

public class solution1988 {
    public int findClosest(String[] words, String word1, String word2) {
        Integer indexA = null;
        Integer indexB = null;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; ++i) {
            if (words[i].equals(word1)) {
                indexA = i;
            } else if (words[i].equals(word2)) {
                indexB = i;
            }
            if (indexA != null && indexB != null) {
                min = Math.min(min, Math.abs(indexA - indexB));
            }
        }
        return min;
    }
}
