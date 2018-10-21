package cn.com.hanyuxiao.SimpleJava.java.util.stream.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * {@link java.util.stream.Stream#map(Function)} 使用方法示例
 *
 * map 的作用是可以对 {@link java.util.stream.Stream} 当中的元素做修改，并且把修改之后
 * 会生成新的对象，把这些对象加入到一个新的 {@link java.util.stream.Stream} 对象当中去。
 *
 * @since 1.8
 * @author hanyuxiao
 */
public class map {
    public static void main(String[] args) {
        String[] lowerCaseArray = {"hello", "world"};
        List<String> lowerCaseStr = new ArrayList<>(Arrays.asList(lowerCaseArray));

        // 通过 map 方法把字符串都不修改成大写
        // 这里可以写成：Stream<String> upperCaseStr = lowerCaseStr.stream().map(String::toUpperCase);
        Stream<String> upperCaseStr = lowerCaseStr.stream().map(str -> str.toUpperCase());

        upperCaseStr.forEach(str -> System.out.printf("%s ", str));
    }
}
