package cn.com.hanyuxiao.java.tutorial.util.concurrent.locks;

/**
 * @author linglong
 * @date 2019/9/16
 * @Description  可重入锁的简单实现【Java自带的ReentrantLock也是以类似的方式实现的】
 **/
public class OnReentrantLockExample {
    boolean isLocked = false;
    Thread lockedBy = null;
    int lockedCount = 0;

    public static void main(String[] args) {
        Count count=new Count();
        count.print();
    }


    public synchronized void lock()
            throws InterruptedException {
        Thread thread = Thread.currentThread();
           /*
           *此处精髓，不仅判断是否上锁isLocked，
           *还增加了对当前线程的判断,同一线程 即直接改变LockedBy线程为当前线程；
           *不同线程,则进行wait()，等待操作。
           */
        while (isLocked && lockedBy != thread) {
            wait();
        }
        isLocked = true;
        lockedCount++;
        lockedBy = thread;
    }

    public synchronized void unlock() {
        if (Thread.currentThread() == this.lockedBy) {
            lockedCount--;
            if (lockedCount == 0) {
                isLocked = false;
                notify();
            }
        }
    }

    //使用
    static class Count{
        OnReentrantLockExample lock = new OnReentrantLockExample();
        public void print(){
            try {
                lock.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //可执行
            doAdd();
            lock.unlock();
        }
        public void doAdd(){
            try {
                lock.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //do something
            lock.unlock();
        }
    }
}

