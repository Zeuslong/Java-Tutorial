package cn.com.hanyuxiao.SimpleJava.java.util.stream.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * {@link java.util.stream.Stream#filter} 方法使用示例
 *
 * filter 方法是一个过滤不符合某些条件的元素的一个方法，它通过传入的 lambda 表达来
 * 对元素进行判断，然后把符合条件的元素封装成一个新的 {@link java.util.stream.Stream}
 * 并返回。
 *
 * @since 1.8
 * @author hanyuxiao
 */
public class filter {
    /**
     * 通过 {@link java.util.stream.Stream#filter} 这样一个方法来筛选出一个 list 当中
     * 所有大于 5 的数据，并且用这个方法返回的 {@link java.util.stream.Stream#forEach}
     * 方法来遍历塞选过后的结果
     */
    public static void main(String[] args) {
        Integer[] intArray = {1,2,3,4,5,6,7,8,9};
        List<Integer> listOfInteger = new ArrayList<>(Arrays.asList(intArray));

        // 筛选出大于 5 的数据
        Stream<Integer> resultOfFilter = listOfInteger.stream().filter(integer -> integer > 5);

        resultOfFilter.forEach(integer -> System.out.printf("%d ", integer));
    }
}
