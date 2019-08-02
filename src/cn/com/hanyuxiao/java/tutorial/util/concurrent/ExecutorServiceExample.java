package cn.com.hanyuxiao.java.tutorial.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * {@link java.util.concurrent.ExecutorService} 的简单使用，由于它是一个接口，所以
 * 这里具体的线程池使用 {@link Executors#newCachedThreadPool()}
 *
 * @see ExecutorsExample
 * @author hanyuxiao
 * @since 1.8
 */
class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorServiceExample executorServiceExample = new ExecutorServiceExample();
        executorServiceExample.submit();
    }

    /**
     * {@link ExecutorService#submit(Runnable)} 的一个简单的使用示例，在这个示例当中，创建了一个
     * 线程池，然后往线程池当中提交了 10 个任务让线程池执行
     */
    private void submit() {
        class Task implements Runnable {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }

        ExecutorService pool = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i ++) {
            pool.submit(new Task());
        }
    }
}
