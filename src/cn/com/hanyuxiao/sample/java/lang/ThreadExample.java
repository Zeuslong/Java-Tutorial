package cn.com.hanyuxiao.sample.java.lang;

/**
 * {@link java.lang.Thread} 的使用示例
 *
 * @author hanyuxiao
 * @since 1.8
 */
public class ThreadExample {
    public static void main(String[] args) {
        ThreadExample threadExample = new ThreadExample();
        threadExample.start();
    }

    /**
     * 在这个方法当中来启动一个线程
     * 1. 类 Example 继承 {@link java.lang.Thread} 并重写它的 run() 方法
     * 2. 新创建 Example 的对象
     * 3. 调用 Example 对象的 start() 方法
     */
    private void start() {
        // 继承线程
        class Example extends Thread {
            // 重写 run() 方法
            @Override
            public void run() {
                for (int i = 0; i < 100; i ++) {
                    System.out.printf("%d ",i);
                }
            }
        }

        // 创建对象，并启动线程
        Example e = new Example();
        e.start();
    }
}
