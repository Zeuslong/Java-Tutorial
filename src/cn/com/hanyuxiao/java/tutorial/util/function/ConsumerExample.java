package cn.com.hanyuxiao.java.tutorial.util.function;

import java.util.function.Consumer;

/**
 * {@link java.util.function.Consumer} 的使用方法。
 *
 * Consumer 是 java 函数式编程的四大接口之一，也就是 lambda 的具体类型之一。
 *
 * Consumer<T>当中，T 表示入参，没有出参，反映到具体方法当中就是 void accept(T t)。
 */
public class ConsumerExample {

    public static void main(String[] args) {
        ConsumerExample example = new ConsumerExample();
        example.accept();
    }

    /**
     * Consumer 的构造与 Function 的构造一样都是通过 lambda 表达式来构造。
     *
     * lambda 表达式 -> 左边的表示传入的参数，必须与 Consumer<T> 中的 T 类型一样。
     */
    private void accept() {
        Consumer<String> consumer = param -> System.out.println("hello " + param);
        consumer.accept("world");
    }
}