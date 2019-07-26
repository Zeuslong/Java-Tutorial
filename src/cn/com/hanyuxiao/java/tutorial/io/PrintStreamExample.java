package cn.com.hanyuxiao.java.tutorial.io;

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
        example.printf_b();
        example.printf_d();
        example.printf_length();
        example.printf_t();
    }

    /**
     * 主要是在 System.out.printf() 当中使用 %s 的一些技巧。
     */
    public void printf_s() {
        String name = "world";
        // 输出 hello world
        System.out.printf("hello %s\n", name);
    }

    /**
     * 输出 boolean 类型的符号。
     */
    public void printf_b() {
        System.out.printf("%b\n", true);
    }

    /**
     * 输出整数。
     */
    public void printf_d() {
        System.out.printf("%d\n", 100);
    }

    /**
     * 输出固定长度为 10 的整数。
     */
    public void printf_length() {
        System.out.printf("%10d\n", 100);
    }

    /**
     * 输出一个缩进符。
     */
    public void printf_t() {
        System.out.printf("\thello world\n");
    }
}
