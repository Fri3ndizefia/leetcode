package javaLearning.SingletonPattern;

public class SingletonPatternDemo {
    public static void main(String[] args) {

        // 获取唯一的可用的对象
        // 由于构造方法是私有的，所以无法new一个对象
        SingletonPattern object = SingletonPattern.getInstance();
        object.showMessage();
    }
}
