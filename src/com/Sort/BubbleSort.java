package com.Sort;


/*
经典冒泡排序
平均时间复杂度 n^2
最好 n 最坏 n^2
空间复杂度 1
思路反过来，数组长多少，就"整理"多少次
每次都把最大的"泡泡"放到最后
第一次，就一个一个比，直到把 最大 泡泡放在 n   处
第二次，同理，直到把 第二大 泡泡放在      n-1 处
-----------------第三大 ---------    n-2 处
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] sourceArray) {

        for (int i = 0; i < sourceArray.length; i++) {
            for (int j = 0; j < sourceArray.length - 1 - i; j++) {
                if (sourceArray[j + 1] < sourceArray[j]) {
                    int temp = sourceArray[j];
                    sourceArray[j] = sourceArray[j + 1];
                    sourceArray[j+1] = temp;
                }
            }
        }
        return sourceArray;
    }

    public static void main(String[] args) {
        int[] array = {3,4,5,2,6,2,1,1,7};
        for (int i : bubbleSort(array)) {
            System.out.println(i);
        }
    }
}
