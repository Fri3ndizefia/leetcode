package Concurrent.Chapter4_Thread;

public class Daemon {

    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
        /**
         * 启动了 daemon线程之后，main线程就终止了，结束了。
         * 此时JVM中没有 非Daemon线程，所以JVM退出，所有Daemon线程结束。
         * 因此DaemonRunner也终止了，但是finally块并没有执行，
         * Daemon线程只做支持性工作
         */
    }

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try{
                SleepUtils.second(10);
            }finally {
                System.out.println("DaemonThread finally run");
            }
        }
    }

}
