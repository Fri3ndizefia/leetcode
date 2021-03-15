package Concurrent.Chapter4_Thread;

import java.util.concurrent.TimeUnit;

public class Interrupted {

    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
        SleepUtils.second(2);

    }

    static class SleepRunner implements Runnable{
        @Override
        public void run() {
            while (true) {
                /**
                 * 使用了 sleep 方法，在抛出InterruptedException之前，JVM会将该线程的 中断标志符 给清除掉，然后抛出InterruptedException，
                 * 此时调用 isInterrupted，将会返回false
                 */
                SleepUtils.second(10);
            }
        }
    }

    static class BusyRunner implements Runnable{
        @Override
        public void run() {
            while (true) {

            }
        }
    }
}
