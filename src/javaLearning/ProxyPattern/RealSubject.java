package javaLearning.ProxyPattern;

/**
 * 真实对象，实现了接口方法
 */
public class RealSubject implements Subject {
    @Override
    public int sellBooks() {
        System.out.println("Selling Books");
        return 1;
    }

    @Override
    public String speak() {
        System.out.println("Speaking");
        return "Fri3nd";
    }

}
