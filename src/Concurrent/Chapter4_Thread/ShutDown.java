package Concurrent.Chapter4_Thread;

import java.util.concurrent.TimeUnit;

public class ShutDown {
    public static void main(String[] args) throws InterruptedException {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "oneThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();
        Runner two = new Runner();
        countThread = new Thread(two, "twoThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }

    private static class Runner implements Runnable {
        private long i =0;
        private volatile boolean on = true;
        @Override
        public void run() {
            while (on & !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count is " + i);
        }

        public void cancel() {
            on = false;
        }
    }
}
