package Algorithms.Search;
/*
Based on binary search
Improved binary search actually.
binary search :
    mid = (low+high)/2 => low + (high-low)/2
after improved :
    mid = low + (key - a[low]) *(high-low) / (a[high] - a[low]);
 */

public class InterpolationSearch {
    public static int insertionSearch(int[] array, int value, int low, int high){
        if (low > high){
            return -1;
        }
        int mid = low + (value-array[low])*(high-low)/(array[high] - array[low]);
        if(array[mid] == value){
            return mid;
        }else if (array[mid] > value){
            return insertionSearch(array,value, low, mid-1);
        }else if (array[mid] < value){
            return insertionSearch(array, value, mid + 1, high);
        }
        return -1;
    }
}
