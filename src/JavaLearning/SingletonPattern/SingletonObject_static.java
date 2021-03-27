package JavaLearning.SingletonPattern;

/**
 * 登记式/静态内部类
 *
 * 利用了classloader的机制，保证初始化instance只有一个线程
 * 只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
 */
public class SingletonObject_static {
    private static class SingletonObject_staticHolder {
        private static final SingletonObject_static instance = new SingletonObject_static();
    }

    private SingletonObject_static() {

    }
    public static final SingletonObject_static getInstance() {
        return SingletonObject_staticHolder.instance;
    }
}
