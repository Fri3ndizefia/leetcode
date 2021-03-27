package JavaLearning.ProxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    Subject realSubject;
    

    public MyInvocationHandler(Subject realSubject) {
        this.realSubject = realSubject;
    }

    /**
     *
     * @param proxy 代理的类
     * @param method 正在调用的方法
     * @param args 方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoking the proxy class");
        if (method.getName().equals("sellBooks")) {
            int invoke = (int) method.invoke(realSubject, args);
            System.out.println("The invoked method is Sell Books");
            return invoke;
        }else{
            String string = (String) method.invoke(realSubject, args);
            System.out.println("The invoked method is Speaking");
            return string;
        }
    }
}
