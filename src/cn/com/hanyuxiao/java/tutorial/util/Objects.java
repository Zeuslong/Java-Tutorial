package cn.com.hanyuxiao.java.tutorial.util;

/**
 * 在项目当中偶尔使用 {@link java.util.Objects} 当中的方法不是一个非常好的选择。
 * 例如：{@link java.util.Objects#equals(Object, Object)} 与运算符 == 相比，运算符
 * 天然就有 Runtime Compiler 的优化，同时如果使用 {@link java.util.Objects#equals(Object, Object)}
 * 还会增加调用栈与静态方法对内存的占用，从而使得内存的使用变大 CPU 计算步骤增加。
 *
 * {@link java.util.Objects} 的设计是为了在不需要极限性能优化时，便于程序的阅读，同时
 * 增加了一些关于空指针异常的防范。
 */
public class Objects {
}
