package com.Solutions;

import java.util.*;

public class solution1640 {
    public  boolean canFormArray(int[] arr, int[][] pieces) {
        int[] map = new int[101];
        Arrays.fill(map, -1);

        for (int i = 0; i < pieces.length; ++i) {
            map[pieces[i][0]] = i;
        }
        int i = 0;
        while (i < arr.length) {
            int pieceIndex = map[arr[i]];
            if (pieceIndex != -1) {
                int[] piece = pieces[pieceIndex];
                i++;
                for (int j = 1; j < piece.length; ++j) {
                    if (arr[i] != piece[j]) {
                        return false;
                    }else{
                        ++i;
                    }
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
