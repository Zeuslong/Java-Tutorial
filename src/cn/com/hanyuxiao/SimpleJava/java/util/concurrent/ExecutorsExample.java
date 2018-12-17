package cn.com.hanyuxiao.SimpleJava.java.util.concurrent;

import java.util.concurrent.*;

/**
 * {@link java.util.concurrent.Executors} 使用帮助
 *
 * 使用这个工具类创建线程池的好处是很方便，不需要了解太多与线程池相关的类就可以创建一个可立即使用的
 * 线程池，缺点是不灵活，很多地方的参数设置很不合理，例如在创建 FixedThreadPool 的时候，线程不会被
 * 自动回收，因为线程的核心线程数量等于最大线程数量；在创建 CacheThreadPool 的时候，没有办法指定
 * 核心线程数量与最大线程数量。
 *
 * 核心线程数量可以理解为线程池的一个阀值，如果超过了这个阀值，那么空闲一定时间的
 *
 * @author hanyuxiao
 * @since 1.8
 */
public class ExecutorsExample {
    public static void main(String[] args) {
        ExecutorsExample executorsExample = new ExecutorsExample();
        executorsExample.newSingleThreadExecutor();
        executorsExample.newFixedThreadPool();
        executorsExample.newCachedThreadPool();
        executorsExample.newScheduledThreadPool();
    }

    /**
     * 单线程线程池，在这个线程池当中只会有一个线程在工作。也就相当于单线程串行执行所有任务。
     * 尽管只有一个线程串行执行，单线程线程池也是有意义的，因为是将这个单线程的生命周期委托
     * 给了线程池管理。
     *
     * 使用的线程池是 Executors.FinalizableDelegatedExecutorService
     *
     * Executors 提供了两种 SingleThreadExecutor 的创建方式。
     */
    private void newSingleThreadExecutor() {
        // 无参创建方式
        ExecutorService singleExecutorServiceDefault = Executors.newSingleThreadExecutor();

        // 创建时指定 ThreadFactory 创建
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ExecutorService singleExecutorServiceByThreadFactory = Executors.newSingleThreadExecutor(threadFactory);
    }

    /**
     * 固定线程数量的可复用线程池，这个线程池当中的线程会一直保持存活状态，只有当线程
     * 被显示的中断才会被回收。
     *
     * 使用的线程池是 {@link ThreadPoolExecutor}
     *
     * Executors 提供了两种 FixedThreadPool 的创建方式
     */
    private void newFixedThreadPool() {
        int threadNumber = 10;

        // 无参创建方式
        ExecutorService fixedThreadPoolDefault = Executors.newFixedThreadPool(threadNumber);

        // 创建时指定 ThreadFactory 创建方式
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ExecutorService fixedThreadPoolByThreadFactory = Executors.newFixedThreadPool(threadNumber, threadFactory);
    }

    /**
     * 创建一个可缓存的线程池。如果线程池的大小超过了核心线程数量(默认为 0)，那么就会回收部分空闲（60秒不执行任务）的线程，
     * 当任务数增加时，此线程池又可以创建新线程来处理任务。
     *
     * 使用的线程池是 {@link ThreadPoolExecutor}
     *
     * Executors 提供了两种 CachedThreadPool 创建方式
     */
    private void newCachedThreadPool() {
        // 无参创建方式
        ExecutorService cachedThreadPoolDefault = Executors.newCachedThreadPool();

        // 创建时指定 ThreadFactory 创建方式
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ExecutorService cacheThreadPoolByThreadFactory = Executors.newCachedThreadPool(threadFactory);
    }

    /**
     * 支持定时以及周期性执行任务的线程池，在获取线程池之后要自己指定线程池的执行周期与定时时间。
     *
     * 使用的线程池是 {@link ScheduledThreadPoolExecutor}
     *
     * Executors 提供了两种创建方式
     */
    private void newScheduledThreadPool() {
        int corePoolSize = 10;

        // 无参创建方式
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(corePoolSize);

        // 创建时指定 ThreadFactory 创建方式
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ScheduledExecutorService scheduledThreadPoolByThreadFactory = Executors.newScheduledThreadPool(corePoolSize, threadFactory);
    }
}
