package JavaLearning.SingletonPattern;

public class ProtectCrackingSingleton {
    private static final ProtectCrackingSingleton instance = new ProtectCrackingSingleton();

    /**
     * 增加一个逻辑判断，多次调用抛出异常。
     * 不允许反射机制进行破解
     */
    private ProtectCrackingSingleton() {
        if (instance != null) {
            throw new RuntimeException();
        }
    }

    public static ProtectCrackingSingleton getInstance() {
        return instance;
    }
}
