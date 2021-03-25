package javaLearning.SingletonPattern;

/**
 * 单例模式的 DCL
 * double-checked Locking
 * 双重检验锁机制
 *
 * 对比普通的加锁模式 Safe
 * 这里只在第一次创建实例的时候实现了加锁，保证线程的安全性
 * 在以后的读实例的时候没有加锁影响。而且volatile保证了变量的内存可见性
 * 实现了多线程安全。
 */
public class SingletonObjectDCL {

    /**
     * volatile保证了instance在内存的可见性。
     */
    private volatile static SingletonObjectDCL instance;

    private SingletonObjectDCL() {

    }

    /**
     * synchronized保证了创建实例的时候是线程安全的
     * 同时有了volatile，就不需要在读实例的时候加锁了
     * 大大提高了效率，并行了安全性.
     * @return
     */
    public static SingletonObjectDCL getInstance() {
        if(instance == null) {
            synchronized (SingletonObjectDCL.class) {
                if (instance == null) {
                    instance = new SingletonObjectDCL();
                }
            }
        }
        return instance;
    }
}
