package Algorithms.Sort;

import java.util.Arrays;

/**
 * 归并排序的时间复杂度是 nlogn
 * 需要用到外部空间，且空间复杂度是 n
 * 是一个稳定的排序方法
 */
public class MergeSort_RUNOOB {
    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];

        sort(arr, 0, arr.length - 1, temp);
    }

    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + right >> 1;
            // 分 ： 分左边的数组 和 右边的数组
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            // 治 ： 解决问题，同时进行合并。
            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0; // 为了临时数组的指针
        // 每次都是左数组指针0，右数组指针mid+1
        // 意思就是将两个有序数组（在同一个数组里）合并罢了
        // 把合并后的数组再复制还给arr，即可完成操作
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            }else{
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
