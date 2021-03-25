package javaLearning.SingletonPattern;

/**
 * 枚举法
 */
public class SingletonObject_Enum {
    private SingletonObject_Enum() {

    }

    static enum SingletonEnum{
        // 创建一个枚举对象，该对象天生为单例
        INSTANCE;
        private SingletonObject_Enum instance;
        //私有化枚举的构造函数
        private SingletonEnum() {
            instance = new SingletonObject_Enum();
        }
        public SingletonObject_Enum getInstance() {
            return instance;
        }
    }

    public static SingletonObject_Enum getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }
}
