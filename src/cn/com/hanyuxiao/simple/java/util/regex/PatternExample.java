package cn.com.hanyuxiao.simple.java.util.regex;

import java.util.regex.Pattern;

/**
 * {@link java.util.regex.Pattern} 使用示例，这个使用示例与其它的示例不太相同，这里要分做两块
 * 来做介绍：1.正则表达式在 Java 当中基本使用的方法。2.{@link java.util.regex.Pattern} 的一些
 * 方法的使用。
 *
 * 有一些值得参考的网站：
 *   1. http://www.runoob.com/java/java-regular-expressions.html
 *
 * @since 1.8
 */
public class PatternExample {

    public static void main(String[] args) {
        PatternExample example = new PatternExample();
        example.hello();
    }

    /**
     * 写的一个类似于 hello world 的程序。这个程序给了一个 hello world 字符串，然后
     * 通过一个正则表达式来匹配查找 hello world 字符串当中是否包含了 hello 这个子字符串。
     */
    public void hello() {
        String context = "hello world";
        String pattern = ".*hello.*";
        System.out.println(context + " 当中包含了 hello ? " + Pattern.matches(pattern, context));
    }

}
