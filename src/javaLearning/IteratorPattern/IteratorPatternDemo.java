package javaLearning.IteratorPattern;

public class IteratorPatternDemo {
    public static void main(String[] args) {
        /**
         * 使用创建好的NameRepository来获取迭代器
         */
        NameRepository nameRepository = new NameRepository();
        for (Iterator iter = nameRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name: " + name);
        }
    }
}
