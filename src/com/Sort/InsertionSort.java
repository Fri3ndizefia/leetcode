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
        for (int i = 0; i < sourceArray.length - 1; i++) {
            current = sourceArray[i+1];
            int preIndex = i;
            while (preIndex > 0 && current < sourceArray[preIndex]) {
                sourceArray[preIndex + 1] = sourceArray[preIndex]; // 往前进一位，因为有个数字要插进来前面了 那个数字就是current
                preIndex--;
            }
            sourceArray[preIndex] = current;
        }
        return sourceArray;
    }

    public static void main(String[] args) {
        int[] array = {3,4,5,2,6,2,1,1,7};
        for (int i : insertionSort(array)) {
            System.out.println(i);
        }
    }
}
