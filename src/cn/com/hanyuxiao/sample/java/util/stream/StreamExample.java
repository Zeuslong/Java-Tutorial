package cn.com.hanyuxiao.sample.java.util.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Stream;

/**
 * {@link java.util.stream.Stream} 使用方法示例
 *
 * @since 1.8
 * @author hanyuxiao
 */
public class StreamExample {

    /**
     * 参考代码的启动类
     */
    public static void main(String[] args) {
        StreamExample streamExample = new StreamExample();
        streamExample.filter();
        streamExample.map();
        streamExample.toArray();
    }

    /**
     * {@link java.util.stream.Stream#filter} 方法使用示例
     *
     * Filter 方法是一个过滤不符合某些条件的元素的一个方法，它通过传入的 lambda 表达来
     * 对元素进行判断，然后把符合条件的元素封装成一个新的 {@link java.util.stream.Stream}
     * 并返回。
     *
     * @since 1.8
     * @author hanyuxiao
     */
    private void filter() {
        /**
         * 通过 {@link java.util.stream.Stream#filter} 这样一个方法来筛选出一个 list 当中
         * 所有大于 5 的数据，并且用这个方法返回的 {@link java.util.stream.Stream#forEach}
         * 方法来遍历塞选过后的结果
         */
        Integer[] intArray = {1,2,3,4,5,6,7,8,9};
        List<Integer> listOfInteger = new ArrayList<>(Arrays.asList(intArray));

        // 筛选出大于 5 的数据
        Stream<Integer> resultOfFilter = listOfInteger.stream().filter(integer -> integer > 5);

        resultOfFilter.forEach(integer -> System.out.printf("%d ", integer));
    }

    /**
     * {@link java.util.stream.Stream#map(Function)} 使用方法示例
     *
     * Map 的作用是可以对 {@link java.util.stream.Stream} 当中的元素做修改，并且把修改之后的结果
     * 生成新的对象，再把这些对象加入到一个新的 {@link java.util.stream.Stream} 对象当中去。
     *
     * @since 1.8
     * @author hanyuxiao
     */
    private void map() {
        String[] lowerCaseArray = {"hello", "world"};
        List<String> lowerCaseStr = new ArrayList<>(Arrays.asList(lowerCaseArray));

        // 通过 Map 方法把字符串都不修改成大写
        // 这里可以写成：Stream<String> upperCaseStr = lowerCaseStr.stream().Map(String::toUpperCase);
        Stream<String> upperCaseStr = lowerCaseStr.stream().map(str -> str.toUpperCase());

        upperCaseStr.forEach(str -> System.out.printf("%s ", str));
    }

    /**
     * {@link java.util.stream.Stream#toArray()} 使用方法的参考
     *
     * ToArray 方法会把一个 {@link java.util.stream.Stream} 对象当中包含的所有元素
     * 都转化成一个数组对象。
     *
     * @since 1.8
     * @author hanyuxiao
     */
    private void toArray() {
        /**
         * 通过 {} 的方式来构建一个数组，然后再通过 {@link java.util.Arrays#asList(Object[])}
         * 构建一个 {@link java.util.List}，再通过 {@link java.util.List} 对象获取到
         * {@link java.util.stream.Stream}，并通过 {@link java.util.stream.Stream#toArray(IntFunction)}
         * 还原之前我们得到的那个数组。
         */
        Integer[] intArray = {1,2,3,4,5,6,7,8,9};
        List<Integer> listOfInteger = new ArrayList<>(Arrays.asList(intArray));

        Integer[] newArray = listOfInteger.stream().toArray(Integer[]::new);

        for (Integer integer : newArray) {
            System.out.printf("%d ", integer);
        }
    }
}
