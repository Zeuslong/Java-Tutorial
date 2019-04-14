package cn.com.hanyuxiao.sample.java.io;

/**
 * 这里主要是非常常见的 System.out.println() 的一些用法的记录。这里的方法可能命名非常不规范，但是
 * 确实非常容易被查找到。
 *
 * @author hanyuxiao
 * @since 1.0
 */
public class PrintStreamExample {

    public static void main(String[] args) {
        PrintStreamExample example = new PrintStreamExample();
        example.printf_s();
    }

    /**
     * 主要是在 System.out.printf() 当中使用 %s 的一些技巧
     */
    public void printf_s() {
        String name = "world";
        // 输出 hello world
        System.out.printf("hello %s", name);
    }
}
