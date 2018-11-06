package cn.com.hanyuxiao.SimpleJava.java.util.stream.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

/**
 * {@link java.util.stream.Stream#toArray()} 使用方法的参考
 *
 * ToArray 方法会把一个 {@link java.util.stream.Stream} 对象当中包含的所有元素
 * 都转化成一个数组对象。
 *
 * @since 1.8
 * @author hanyuxiao
 */
public class ToArray {
    /**
     * 通过 {} 的方式来构建一个数组，然后再通过 {@link java.util.Arrays#asList(Object[])}
     * 构建一个 {@link java.util.List}，再通过 {@link java.util.List} 对象获取到
     * {@link java.util.stream.Stream}，并通过 {@link java.util.stream.Stream#toArray(IntFunction)}
     * 还原之前我们得到的那个数组。
     */
    public static void main(String[] args) {
        Integer[] intArray = {1,2,3,4,5,6,7,8,9};
        List<Integer> listOfInteger = new ArrayList<>(Arrays.asList(intArray));

        Integer[] newArray = listOfInteger.stream().toArray(Integer[]::new);

        for (int i = 0; i < newArray.length; i++) {
            System.out.printf("%d ", newArray[i]);
        }
    }
}
