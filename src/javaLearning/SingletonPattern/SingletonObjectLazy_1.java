package javaLearning.SingletonPattern;


/**
 * 懒汉启动，线程不安全
 * 检测instance空就新建，否则直接返回
 *
 * 多线程下可能突然新建了好几个，并不是严格的单例模式
 */
public class SingletonObjectLazy_1 {
    private SingletonObjectLazy_1() {
    }

    private static SingletonObjectLazy_1 instance;

    public static SingletonObjectLazy_1 getInstance() {
        if (instance == null) {
            instance = new SingletonObjectLazy_1();
        }
        return instance;
    }
}
