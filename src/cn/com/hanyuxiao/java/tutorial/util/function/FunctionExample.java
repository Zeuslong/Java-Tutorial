package cn.com.hanyuxiao.java.tutorial.util.function;

import java.util.function.Function;

/**
 * {@link java.util.function.Function} 的使用方法示例。
 *
 * Function 是 java 函数式编程的四大接口之一，也就是 lambda 的具体类型之一。
 *
 * Function<T, R> 当中，T 表示入参，R 表示出参，反映到具体方法当中就是 R apply(T t)。
 *
 * Function 当中最主要的方法就是 apply 方法，其它的也就不列举了。
 */
public class FunctionExample {

    public static void main(String[] args) {
        FunctionExample example = new FunctionExample();
        example.apply();
    }

    /**
     * Function 的构造与其它的接口构造有一些不一样，它可以通过 lambda 表达式来进行构造，
     * 表达式 -> 左边的 param 指的就是调用 apply 方法时传入的参数，返回时也一定只能返回
     * Function<T, R> 当中的 R 类型。
     */
    private void apply() {
        Function<Integer, String> func = param -> {
            return String.valueOf(param);
        };
        System.out.printf("99 传入 function 的结果是 %s", func.apply(100));
    }
}
