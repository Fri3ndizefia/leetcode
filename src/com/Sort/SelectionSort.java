package com.Sort;

/**
表现最稳定的 选择排序
时间复杂度一直是 n^2
空间复杂度 1
第一次 遍历一遍，得到最小值，和 index 0 进行交换
第二次 遍历剩下的一遍，得到第二小值，和 index 1 进行交换
……
 */

public class SelectionSort {
    public static int[] selectionSort(int[] sourceArray) {
        if (sourceArray.length == 0) {
            return sourceArray;
        }

        int minIndex= 0;
        for (int i = 0; i < sourceArray.length; i++) {
            int minElement = sourceArray[i];
            for (int j = i; j < sourceArray.length; j++) {
                if (sourceArray[j] < minElement) {
                    minElement = sourceArray[j];
                    minIndex = j;
                }
            }
            int temp = sourceArray[i];
            sourceArray[i] = sourceArray[minIndex];
            sourceArray[minIndex] = temp;
        }
        return sourceArray;
    }

    public static void main(String[] args) {
        int[] array = {3,4,5,2,6,2,1,1,7};
        for (int i : selectionSort(array)) {
            System.out.println(i);
        }    }
}
