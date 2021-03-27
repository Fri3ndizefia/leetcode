package JavaLearning.ProxyPattern;

import java.lang.reflect.Proxy;

/**
 * JDK 自带的动态代理Proxy示例
 * 每次通过Proxy生成的代理类对象都要指定对应的处理器对象
 */
public class Main {
    public static void main(String[] args) {
        // 真实实例一个对象
        Subject realSubject = new RealSubject();

        // 调用 invocationHandler
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(realSubject);

        // 处理对象
        Subject proxyClass = (Subject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Subject.class}, myInvocationHandler);

        proxyClass.sellBooks();
        proxyClass.speak();
    }
}
