package cn.com.hanyuxiao.java.tutorial.util;

import java.util.StringJoiner;

/**
 * {@link java.util.StringJoiner} 的简单介绍。
 *
 * StringJoiner 当中提供了一种简单的用特定标识符来分割或组织元素的方法。
 *
 * StringJoiner 的出现其实是为了简化我们对 {@link StringBuilder} 在某些方面的使用，同时也是
 * 支撑 Stream 操作的一个渐变实现，可以参考 {@link java.util.stream.Collectors#joining()} 方法。
 */
class StringJoinerExample {

    public static void main(String[] args) {
        StringJoinerExample example = new StringJoinerExample();
        example.add();
    }

    /**
     * 现在有一个 String 的数组：a b c d，要把它处理成 "[a,b,c,d]" 这样的字符串。
     */
    private void add() {
        String[] args = {"a", "b", "c", "d"};
        // 构造方法的三个参数含义分别是：分隔符用来分隔元素、[ 是整个字符串开头的部分、 ] 是整个字符串结尾的部分
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        for (String str : args) {
            joiner.add(str);
        }
        System.out.println(joiner.toString());
    }

}
