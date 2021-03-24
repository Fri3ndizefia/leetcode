package Concurrent.Chapter7_Atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {
    static int[] value = new int[]{1, 2,};
    static AtomicIntegerArray ai = new AtomicIntegerArray(value);
    // 实际上AtomicIntegerArray将传递进构造方法的value 复制了一份。所以不会影响传入的数组；
    public static void main(String[] args) {
        ai.getAndSet(0, 3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }
}
