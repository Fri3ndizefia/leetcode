package javaLearning.DeadLock;

public class DeadLockDemo {
    public static void main(String[] args) {
        Thread td1 = new Thread(new Runnable() {
            @Override
            public void run() {
                DeadLockDemo.method1();
            }
        });

        Thread td2 = new Thread(new Runnable() {
            @Override
            public void run() {
                DeadLockDemo.method2();
            }
        });

        td1.start();
        td2.start();

    }

    public static void method1(){
        synchronized (String.class){
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Now thread a is trying to use integer.class");
            synchronized (Integer.class) {

            }
        }
    }

    public static void method2() {
        synchronized (Integer.class) {
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Now thread b is trying to use String.class");
            synchronized (String.class) {

            }
        }
    }
}
