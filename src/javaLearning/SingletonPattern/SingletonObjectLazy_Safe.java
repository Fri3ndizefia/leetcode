package javaLearning.SingletonPattern;

/**
 * 懒汉式，线程安全
 * 在线程不安全的基础上增加了锁
 * 但是降低了效率
 */
public class SingletonObjectLazy_Safe {
    private SingletonObjectLazy_Safe() {

    }

    private static SingletonObjectLazy_Safe instance;

    public static synchronized SingletonObjectLazy_Safe getInstance() {
        if (instance == null) {
            instance = new SingletonObjectLazy_Safe();
        }
        return instance;
    }
}
