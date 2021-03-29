package com.Solutions;

/**
 * 位运算做到加法
 */
public class M_17_01 {
    /**
     * 不考虑进位的加法 + 仅考虑进位的加法 = 真正的加法
     * 异或运算          与运算并左移1位
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return add(sum, carry);
    }

    /**
     * 迭代的写法
     * @param num1
     * @param num2
     * @return
     */
    public int add_(int num1, int num2) {
        int sum = num1 ^ num2;
        int carry = (num1 & num2) << 1;
        while(carry != 0){
            int a = sum;
            int b = carry;
            sum = a ^ b;
            carry = (a & b) << 1;
        }
        return sum;
    }

    public int substract(int a, int b) {
        int substractor = add(~b, 1);
        int result = add(a, substractor);
        return substractor;
    }
}
