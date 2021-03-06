package com.Search;
/*
1. Sequential
2. Ordered by increasing
必须是排列好的，不然不能用
 */

public class BinarySearch {
    // Using recursion
    public static int bSearch(int array[], int value, int low, int high){

        if (low > high) {return -1;}

        int mid = low + (high - low ) / 2;
        if (array[mid] == value) {
            return mid;
        }else if(array[mid] > value){
            return bSearch(array, value, low , mid-1);
        }else if(array[mid] < value){
            return bSearch(array, value, mid+1, high);
        }
        return -1;
    }

    //Not recursion
    public static int binarySearch(int[] array, int key){
        int low = 0;
        int high = array.length - 1;
        while(low <= high){
            int mid = low + ((high-low)) >> 1;
            if( key == array[mid])
            {
                return mid;
            }
            else if( key > array[mid]){
                low = mid + 1;
            }else if( key < array[mid]){
                high = mid - 1;
            }
        }
        return -1;
    }


}
