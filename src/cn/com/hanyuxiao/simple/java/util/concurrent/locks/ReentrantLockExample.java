package cn.com.hanyuxiao.simple.java.util.concurrent.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * {@link java.util.concurrent.locks.ReentrantLock} 的使用示例。
 */
public class ReentrantLockExample {

    /**
     * 这是标准的锁申明的方法。
     */
    private final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        ReentrantLockExample reentrantLockExample = new ReentrantLockExample();
        reentrantLockExample.lock();
    }

    /**
     * 锁的一个非常基本的用法，也是使用的一个最佳实践。
     */
    private void lock() {
        // 上锁。
        lock.lock();
        try {
            // 在 try 模块当中写业务代码。
            System.out.println("hello world");
        } finally {
            // 释放锁的位置。
            lock.unlock();
        }
    }
}