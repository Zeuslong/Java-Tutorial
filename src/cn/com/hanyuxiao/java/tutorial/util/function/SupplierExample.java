package cn.com.hanyuxiao.java.tutorial.util.function;

import java.util.function.Supplier;

/**
 * {@link java.util.function.Supplier} 的使用方法。
 *
 * Supplier 是 java 函数式编程的四大接口之一，也就是 lambda 的具体类型之一。
 *
 * Supplier<T> 当中没有入参，T 表示出参，所以一般用作工厂方法会比较多一点，或者使用在某个特定条件下获取特定结果。
 */
public class SupplierExample {

    public static void main(String[] args) {
        SupplierExample example = new SupplierExample();
        example.get();
    }

    /**
     * Supplier 的构造方法和 Function 的构造方法一样，都是使用 lambda 来构建。
     *
     * lambda 表达式返回的值必须要与 Supplier<T> 当中的 T 类型相同。
     */
    private void get() {
        Supplier<String> supplier = () -> {
            return "hello world";
        };
        System.out.println(supplier.get());
    }
}
