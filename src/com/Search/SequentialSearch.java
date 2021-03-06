package com.Search;

public class SequentialSearch {
    public static int orderSearch(int key, int[] array){
        if(array == null || array.length < 1){
            return -1;
        }
        for( int i = 0; i < array.length ; i ++){
            if (array[i] == key)
            {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(orderSearch(2, new int[]{1, 2, 3, 4, 5}));
    }
}
