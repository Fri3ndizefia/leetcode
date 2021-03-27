package JavaLearning.IteratorPattern;

/**
 * 步骤一，创建接口
 * Container用于创建迭代器
 */
public interface Container {
    public Iterator getIterator();
}
