package cn.com.hanyuxiao.java.tutorial.util.function;

import java.util.function.Predicate;

/**
 * {@link java.util.function.Predicate} 的使用方法。
 *
 * Predicate 是 java 函数式编程的四大接口之一，也就是 lambda 的具体类型之一。
 *
 * Predicate<T> T 表示入参，出参固定位 boolean。所以一般用作判断会比较多一点
 */
public class PredicateExample {

    public static void main(String[] args) {
        PredicateExample example = new PredicateExample();
        example.test();
    }

    /**
     * Predicate 的构造与 Function 的构造是一样的，使用 lambda 来进行构造。
     *
     * lambda 表达式左边 param 要和 Predicate<T> 的类型一样，返回类型一定要是 boolean 类型。
     */
    private void test() {
        Predicate<String> predicate = param -> {
            return "hello world".equals(param);
        };
        System.out.printf("运算结果 %b\n", predicate.test("hello world"));
    }
}