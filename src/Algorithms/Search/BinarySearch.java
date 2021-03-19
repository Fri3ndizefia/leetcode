package Algorithms.Search;
/**
1. Sequential
2. Ordered by increasing
必须是排列好的，不然不能用
 */

public class BinarySearch {
    // Using recursion
    public static int bSearch(int array[], int value, int low, int high){

        if (low > high) {return -1;}

        //int mid = low + (high - low ) / 2;
        int mid = low + high + 1 >>> 1; // 数字 >>> 1  就是 [n/2] 向下取整
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
            // int mid = low + (hight - low) / 2
            int mid = low + high + 1 >>> 1; // 数字 >>> 1  就是 [n/2] 向下取整
            if( key == array[mid]) {
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

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySearch(array,4));
    }


}
