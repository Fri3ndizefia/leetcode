package com.MianShiQuestions;

/**
 * 疫情逐步缓和后，体育馆终于迎来了第一场篮球比赛，为了保持距离，篮球迷小杰选定某圈座位后，想尽量选择一个远离人群的位置。
 * 已知由0和1组成的环形数组表示当前排的座位情况其中1表示已被选座，0表示空座请问小杰所选座位和最近人的座位距离数最大是多少?有如下假设:至少有一个人已选座，至少有一个空座位，定义:相邻座位的座位距离数为1
 *
 * 输入：第一行是一个正整数N(2<-N<-1000)，表示数组长度第二行是N个数K1, K2...Kn组成的环形数组，Kn为0或1
 * 提示：因为数组是环形的，所以可以假设最后一个元素的下一个元素是第一个元素，而第一个元素的前一个元素是最后一个元素。
 *
 * 拼接数组处理环
 */

import java.io.*;
import java.util.*;

public class ByteDance_March_01 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N*2];
        int index = 0;
        for (String s : br.readLine().split(" ")) {
            array[index + N] = array[index] = Integer.parseInt(s);
            index++;
        }
        int preIndex = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == 1 && preIndex != 0) {
                res = Math.max(res, (i - preIndex) / 2);
                preIndex = i;
            } else if (array[i] == 1) {
                preIndex = i;
            }
        }
        System.out.println(res);
    }
}
