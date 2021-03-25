package javaLearning.SingletonPattern;

/**
 * 饿汉式
 * 这种方式最简单，最常用
 * 但是不能保证创建出来的这个实例被使用，也就是创建了垃圾对象
 * 没有加锁，效率高。但是类加载的时候就初始化了，造成开销浪费。
 */

public class SingletonObjectHungry {
    private static SingletonObjectHungry instance = new SingletonObjectHungry();

    private SingletonObjectHungry() {

    }

    public static SingletonObjectHungry getInstance() {
        return instance;
    }
}
