package Concurrent.Chapter8;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest {
    private static final Exchanger<String> exgr = new Exchanger<String>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A = " Banking Sheet A";
                    exgr.exchange(A);
                } catch (InterruptedException e) {

                }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B = " Banking Sheet B";
                    String A = exgr.exchange(B);
                    System.out.println("A equals to B?" + A.equals(B) + "A is " + A + " B is" + B);
                } catch (InterruptedException e) {

                }
            }
        });
        threadPool.shutdown();
    }
}
