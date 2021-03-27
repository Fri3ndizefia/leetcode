package JavaLearning.SingletonPattern;

/**
 * 单例模式
 * <p>
 * 核心关键：构造函数是私有的
 */
public class SingletonPattern {

    /**
     * 创建唯一的 SingletonPattern对象
     */
    private static SingletonPattern instance = new SingletonPattern();

    /**
     * 通过私有构造函数，这个类就不会被实例化
     */
    private SingletonPattern() {}


    // 提供方法可以获取唯一对象
    public static SingletonPattern getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World");
    }
}
