package Concurrent.Chapter6_Concurrent;

import java.util.concurrent.*;

public class CountTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 2; // 任务阈值
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; ++i) {
                sum += i;
            }
        }else{
            /**
             * 分割到足够小，足够小的可以执行任务 ⬆️
             * 否则继续分割。
             * 最后再把任务结果join起来
             *
             */
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            leftTask.fork();
            rightTask.fork();
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(1, 100);
        Future<Integer> result = forJoinPool.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {

        }
    }
}
