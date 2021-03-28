package JavaLearning.SingletonPattern;

public class Test {
    private volatile static Test INSTANCE;

    private Test() {}

    public static Test getInstance() {
        if (INSTANCE == null) {
            synchronized (Test.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Test();
                }
            }
        }
        return INSTANCE;
    }
}
