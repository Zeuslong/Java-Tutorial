package cn.com.hanyuxiao.java.tutorial.util.regex;

import java.util.regex.Pattern;

/**
 * {@link java.util.regex.Pattern} 使用示例，这个使用示例与其它的示例不太相同，这里要分做两块
 * 来做介绍：1.正则表达式在 Java 当中基本使用的方法。2.{@link java.util.regex.Pattern} 的一些
 * 方法的使用。
 *
 * 有一些值得参考的网站：
 *   1. http://www.runoob.com/java/java-regular-expressions.html
 *   2. http://tool.oschina.net/uploads/apidocs/jquery/regexp.html
 *
 * @since 1.8
 */
public class PatternExample {

    public static void main(String[] args) {
        PatternExample example = new PatternExample();
        example.hello();
        example.re_1();
        example.re_2();
        example.re_3();
        example.re_4();
    }

    /**
     * 写的一个类似于 hello world 的程序。这个程序给了一个 hello world 字符串，然后
     * 通过一个正则表达式来匹配查找 hello world 字符串当中是否包含了 hello 这个子字符串。
     */
    private void hello() {
        System.out.println("method: hello");
        String context = "hello world";
        String regex = ".*hello.*";
        System.out.println(context + " 当中包含了 hello ? " + Pattern.matches(regex, context));
        System.out.println();
    }

    /*
      以下都是示例，为了能够展示清楚，方法的命名非常的不规范，每一个示例都会有详尽的说明，通过示例来入门是
      一种非常好的方式。
     */

    /**
     * 最简单的正则表达式，安全匹配。
     */
    private void re_1() {
        System.out.println("method: re 1");
        String context = "Hello world";
        String regex = "Hello world";
        System.out.println(context + " 与 " + regex + " 是否完全匹配 ？ " + Pattern.matches(regex, context));
        regex = "world";
        System.out.println(context + " 与 " + regex + " 是否完全匹配 ？ " + Pattern.matches(regex, context));
        System.out.println();
    }

    /**
     * 元字符 .。
     * . 可以匹配任何的一个字符，比如：'a' 和 '1'，且只能匹配字符。
     */
    private void re_2() {
        System.out.println("method: re 2");
        String context = "a";
        String regex = ".";
        System.out.printf("%s 匹配上了 ？ %b\n", context, Pattern.matches(regex, context));
        context = "aa";
        System.out.printf("%s 匹配上了 ？ %b\n", context, Pattern.matches(regex, context));
        System.out.println();
    }

    /**
     * 通配符（wildcard）：* + ?
     *
     * 如果你想查找某个目录下的所有的 Word 文档的话，你会搜索 doc 格式的文件在这里，* 会被解释成任意的字符串，
     * * 通常表示一次匹配或多次匹配其之后的字符串。
     *
     *
     */
    private void re_3() {
        System.out.println("method: re 3");
        String[] args = {"context.text", "context.doc", "context.txt", "d.doc", ".doc"};
        // * 的使用方法，表示 .doc 之前出现任意个字符，或者没有字符。
        String regex = ".*.doc";
        for (String arg : args) {
            if (Pattern.matches(regex, arg)) {
                System.out.printf("%s  ", arg);
            }
        }
        System.out.print("\n");
        // ? 的使用方法，表示 .doc 前只出现一个任意字符，或没有字符。
        regex = ".?.doc";
        for (String arg : args) {
            if (Pattern.matches(regex, arg)) {
                System.out.printf("%s  ", arg);
            }
        }
        System.out.print("\n");
        // + 的使用方法，表示 .doc 前只出现一个字符或任意多个字符。
        regex = ".+.doc";
        for (String arg : args) {
            if (Pattern.matches(regex, arg)) {
                System.out.printf("%s  ", arg);
            }
        }
        System.out.print("\n\n");
    }

    /**
     * 匹配次数
     * a{n} 表示 a 字符出现了 n 次。
     * a{n,} 表示 a 出现了 n 次或 n 次以上，或者说至少出现了 n 次。
     * a{n,m} 表示 a 至少出现了 n 次，但是最多 m 次。
     */
    private void re_4() {
        System.out.println("method: re 4");
        // 共 14 个字符 a
        String context = "aaaaaaaaaaaaaa";
        // 匹配 a 字符出现 14 次。
        String regex = "a{14}";
        System.out.printf("是否出现了 14 次 ？ %b\n", Pattern.matches(regex, context));
        // 匹配至少出现了 14 次。
        regex = "a{14,}";
        System.out.printf("是否至少出现了 14 次 ？ %b\n", Pattern.matches(regex, context));
        // 匹配
        regex = "a{12,14}";
        System.out.printf("出现的次数是否在 12 次与 14 次之间 ？ %b\n", Pattern.matches(regex, context));
        System.out.println();
    }
}
