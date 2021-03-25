package javaLearning.SingletonPattern;

import com.sun.org.apache.bcel.internal.util.ClassLoader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class SingletonPatternDemo {
    public static void main(String[] args) throws Exception {

        // 获取唯一的可用的对象
        // 由于构造方法是私有的，所以无法new一个对象
        SingletonPattern object = SingletonPattern.getInstance();
//        Class obi = object.getClass();
//        Constructor constructor = obi.getDeclaredConstructor(null);
//        constructor.setAccessible(true);
//        SingletonPattern s1 = (SingletonPattern) constructor.newInstance();
//        s1.showMessage();
//        System.out.println(obi);
        object.showMessage();
    }
}
