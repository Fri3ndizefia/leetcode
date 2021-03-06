package com.Solutions;

/**
 * 交替位的二进制数
 * 位运算的知识
 * 保存几个重要的
 * 0xaaaaaaaa = 10101010101010101010101010101010 (偶数位为1，奇数位为0）
 * 0x55555555 = 1010101010101010101010101010101 (偶数位为0，奇数位为1）
 * 0x33333333 = 110011001100110011001100110011 (1和0每隔两位交替出现)
 * 0xcccccccc = 11001100110011001100110011001100(0和1每隔两位交替出现)
 * 0x0f0f0f0f = 00001111000011110000111100001111(1和0每隔四位交替出现)
 * 0xf0f0f0f0 = 11110000111100001111000011110000(0和1每隔四位交替出现)
 */
public class solution693 {

    public static boolean hasAlternatingBits(int num) {
        /*
        异或 然后 再 与 操作，结果是0 ，就是交替位二进制数
         */
        int changedNum = num ^ (num >> 1);
        return (changedNum & changedNum+1) == 0;
    }

    public static void main(String[] arg) {
        System.out.println(hasAlternatingBits(7));
    }
}
