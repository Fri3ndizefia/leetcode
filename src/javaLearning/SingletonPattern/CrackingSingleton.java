package javaLearning.SingletonPattern;

import java.lang.reflect.Constructor;
/**
 * 破解单例模式
 */
public class CrackingSingleton {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("javaLearning.SingletonPattern.SingletonPattern");
        Constructor c = clazz.getDeclaredConstructor(null);

        c.setAccessible(true);

        SingletonPattern s1 = (SingletonPattern) c.newInstance();
        SingletonPattern s2 = (SingletonPattern) c.newInstance();

        s1.showMessage();
        s2.showMessage();
        /**
         * 通过反射机制成功的实现了两个单例
         */
    }
}
