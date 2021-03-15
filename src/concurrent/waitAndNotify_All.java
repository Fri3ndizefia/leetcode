package concurrent;

public class waitAndNotify_All {
    private static volatile Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {

        // 创建线程A
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {

                    System.out.println("threadA get resourceA lock");
                    try{

                        System.out.println("threadA begin wait");
                        resourceA.wait();
                        System.out.println("threadA end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // 创建线程B
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {

                    System.out.println("threadB get resourceA lock");
                    try {

                        System.out.println("threadB begin wait");
                        resourceA.wait();
                        System.out.println("threadB end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // 创建 notify 线程C
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {

                    System.out.println("threadC get resourceA lock");
//                    resourceA.notify();
                    /**
                     * 使用 notify 的话，会在A和B中随便一个线程激活，另外一个仍然处于堵塞状态，导致程序没法停止
                     */
                    resourceA.notifyAll();
                    /**
                     * 使用 notifyAll 的话， A和B的线程都会被唤醒。先后顺序随机。
                     */
                }
            }
        });

        threadA.start();
        threadB.start();

        Thread.sleep(1000);
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("main over");
    }
}
