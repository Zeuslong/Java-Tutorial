package cn.com.hanyuxiao.java.tutorial.util.concurrent.locks;

/**
 * @author linglong
 * @date 2019/9/16
 * @Description 测试一个不可重入锁【某个线程只能获取一次该锁(可获取后释放，然后再次获取)】
 **/
public class NonReentrantLockExample {

    private boolean isLocked = false;

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread thread = new Count();
            System.out.println("当前线程是："+Thread.currentThread().getName());
            thread.run();
            /*
             *不可重入锁：即  当前线程执行某个方法 已经获取了该锁，便无法再次获取该锁。
             *
             * eg：当Count().run执行时，会获取一次锁；
             * 在之后 执行doAdd()方法时，便无法再获取该锁了;
             *
             *
             */

        }

    }

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }


    static class Count extends Thread {
        NonReentrantLockExample lock = new NonReentrantLockExample();

        @Override
        public void run() {
            System.out.println("当前的线程是："+Thread.currentThread().getName());
            try {
                lock.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //do  something--->不可执行
            doAdd();
            lock.unlock();
        }

        public void doAdd() {
            try {
                lock.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //do something
            System.out.println("执行doAdd  方法操作了");
            lock.unlock();
        }
    }

}