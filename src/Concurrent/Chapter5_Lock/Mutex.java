package Concurrent.Chapter5_Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Mutex implements Lock {

    private final Sync sync = new Sync();
    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean isLocked(){
        return sync.isHeldExclusively();
    }

    public boolean hasQueuedThreads() {
        return sync.hasQueuedThreads();
    }

    // 静态内部类，自定义同步器
    private static class Sync extends AbstractQueuedSynchronizer{

        @Override
        // 是否处于占用状态
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        // 当状态是0的时候 获取锁。
        public boolean tryAcquire(int acquires){
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        //释放锁，状态设置为0
        protected boolean tryRelease(int releases) {
            if(getState() == 0) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);

            setState(0);
            return true;
        }
        // 返回一个Condition，每个condition都包含类一个condition队列
        Condition newCondition() {
            return new ConditionObject();

        }
    }
}
