package cn.com.hanyuxiao.SimpleJava.java.lang;

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
    }

    /**
     * 在这个方法当中利用 {@link java.lang.Runnable} 来启动一个线程
     * 1. 类 Example 实现 {@link java.lang.Runnable} 当中的 run 方法
     * 2. 新创建 Example 的对象
     * 3. 创建 Thread 对象，并用 Example 对象进行初始化
     * 4. 启动线程对象
     */
    public void run() {
        // 实现 Runnable 接口的 run 方法
        class Example implements Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 100; i ++) {
                    System.out.printf("%d ",i);
                }
            }
        }

        Example runnable = new Example();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
