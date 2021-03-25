package javaLearning.IteratorPattern;

/**
 * 步骤一，创建接口
 * 关键方法 next 和 hasNext
 */
public interface Iterator {
    public boolean hasNext();
    public Object next();
}
