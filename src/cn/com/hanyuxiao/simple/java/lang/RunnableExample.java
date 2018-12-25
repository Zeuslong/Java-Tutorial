package cn.com.hanyuxiao.simple.java.lang;

import java.io.PrintStream;

/**
 * {@link java.lang.Runnable} 的使用示例
 *
 * @author hanyuxiao
 * @since 1.8
 */
public class RunnableExample {
    public static void main(String[] args) {
        RunnableExample runnableExample = new RunnableExample();
        runnableExample.run();
        runnableExample.runWithRunnable();
        runnableExample.runWithLambda();
    }

    /**
     * 在这个方法当中利用 {@link java.lang.Runnable} 来启动一个线程
     * 1. 类 Example 实现 {@link java.lang.Runnable} 当中的 run 方法
     * 2. 新创建 Example 的对象
     * 3. 创建 Thread 对象，并用 Example 对象进行初始化
     * 4. 启动线程对象
     */
    private void run() {
        // 实现 Runnable 接口的 run 方法
        class Example implements Runnable {
            @Override
            public void run() {
                printInfo();
                // 换行
                System.out.println();
            }
        }

        Example runnable = new Example();
        Thread thread = new Thread(runnable);
        thread.start();
    }

    /**
     * 这种使用 {@link java.lang.Runnable} 的方法是一种简便的写法，但是
     * 不是很适合在复杂的环境当中使用，适合于在一次性任务当中使用。
     */
    private void runWithRunnable() {
        // 在创建线程的时候，直接把 Runnable 当作参数传入，并在其中实现 run 方法
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                printInfo();
                // 换行
                System.out.println();
            }
        });

        // 启动线程
        thread.start();
    }

    /**
     * 这里使用了一种更简单的方式，使用 lambda 的语法来传入函数体。
     */
    private void runWithLambda() {
        // 在创建线程的时候，使用来 lambda 的语法方式传入函数体，与 runWithRunnable() 效果
        Thread thread = new Thread(() -> {
            printInfo();
            // 换行
            System.out.println();
        });

        // 启动线程
        thread.start();
    }

    /**
     * 这是输出一个 0-100 的数字矩阵的输出，有一点必须要注意的是在这个方法上使用了 synchronized 关键字。
     *
     * 因为上面有三个方法都调用本方法，又因为上面三个方法又是以新建线程的方式来调用的，那么就有可能在输出的
     * 时候让输出的结果出现混乱，例如：runWithRunnable 在输出 55 的时候，被 runWithLambda 打断，然后
     * runWithLambda 从 0 开始输出，这是有可能的。
     *
     * {@link PrintStream#printf(java.lang.String, java.lang.Object...)} 方法本身有锁，为什么锁没有
     * 膨胀到 for 循环之外，这个问题还不是很清楚。
     *
     * 另外，为了减少困扰程度，并且展示这个打断现象的问题，把换行这个操作从 printInfo 方法当中提取出来放到了
     * 调用本方法的那些线程当中，在运行的时候大概率会出现这些打断现象。
     */
    private synchronized void printInfo() {
        for (int i = 0; i < 100; i ++) {
            if (i % 10 == 0) {
                System.out.print("\n");
            }
            System.out.printf("%2d ",i);
        }
    }

}
