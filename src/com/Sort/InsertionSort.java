package com.Sort;

/*
插入排序

5 2 3 4 6
第一次不变
5 2 3 4 6
第二次开始， index为1 的数，一个一个和前面进行对比，小的话，交换
2 5 3 4 6
第三次开始， index为2 的数，插入到比它小的前面，比它大的后面
2 3 5 4 6
2 3 4 5 6
2 3 4 5 6

 */
public class InsertionSort {

    public static int[] insertionSort(int[] sourceArray) {

        if (sourceArray.length == 0) {
            return sourceArray;
        }
        int current;
        for (int i = 1; i < sourceArray.length; ++i) {
            current = sourceArray[i];
            int j = i - 1;
            while (j >= 0 && sourceArray[j] > current) {
                sourceArray[j + 1] = sourceArray[j];
                --j;
            }
            if (j != i - 1) {
                sourceArray[j + 1] = current;
            }
        }
        return sourceArray;
    }

    public static void main(String[] args) {
        int[] array = {2,3,4,5,2,6,2,1,1,7};
        for (int i : insertionSort(array)) {
            System.out.println(i);
        }
    }
}
