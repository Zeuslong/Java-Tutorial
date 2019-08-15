package cn.com.hanyuxiao.java.tutorial.util;

import java.util.Optional;

/**
 * {@link java.util.Optional} 的使用示例。
 *
 * Optional 是一个对 null 进行封装了的类，它可以简化我们在使用的时候对 null 的一些判断操作。
 *
 * Optional 其中使用了一个 value 来持有传入的对象。
 */
public class OptionalExample {

    public static void main(String[] args) {
        OptionalExample example = new OptionalExample();
        example.construct();
        example.isPresent();
        example.ifPresent();
    }

    /**
     * Optional 一共提供了 3 种构造的方法，分别如下：
     * 方法 1 的构造方法会返回一个 value 为 null 的 Optional 对象。
     * 方法 2 会要求传入的对象不能为 null 否则会抛出 NullPointException 异常。
     * 方法 3 传入的对象如果为 null 则使用 empty() 来构造 Optional 对象，如果不为 null 则使用 of 来构造对象。
     */
    private void construct() {
        // 方法 1
        Optional<Object> emptyOptional = Optional.empty();
        // 方法 2
        Optional<Object> ofOptional = Optional.of(new Object());
        // 方法 3
        Optional<Object> nullableOptional = Optional.ofNullable(new Object());
    }

    /**
     * 如果 Optional 当中的 value 是持有一个 null，那么就会返回一个 false，如果持有的对象
     * 是存在也就是不为 null，那么就会返回 true。
     */
    private void isPresent() {
        Optional<Object> optional = Optional.of(new Object());
        System.out.printf("这个对象是否不为 null ： %b\n", optional.isPresent());
    }

    /**
     * ifPresent 表示如果 Optional 当中 value 不为空，那么就会执行 Consumer 方法。
     */
    private void ifPresent() {
        Optional<Object> optional = Optional.ofNullable(new Object());
        optional.ifPresent(param -> System.out.println(param));
    }
}