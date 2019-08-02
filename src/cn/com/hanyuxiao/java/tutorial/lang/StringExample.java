package cn.com.hanyuxiao.java.tutorial.lang;

/**
 * {@link java.lang.String} String 的认知要分作两个方面：1. 引用对象；2. 字面量。如下：
 * String a = new String("hello world");
 * String b = new String("hello world");
 * 其中 a b 两个引用可以理解为 String 的具体对象，他们被分配在堆上面，并且两者是不相同的；
 * 而构造方法当中的 hello world 则是我们所说的字面量，以二进制数组的方式被存储在字符串常
 * 量池（元数据空间）当中。JVM 在处理字面量的时候会保证字符串常量池当中不会产生多个相同
 * 的数据，也就是相同值的字面量在常量池当中就是同一个东西。
 * 所以上面的代码含义就是创建了 a b 两个字符串对象，并且这两个对象当中都有存储在字符串
 * 常量池中的 hello world 这一个字面量。
 *
 * 字面量创建会先在常量池中查找是否存在相同的字符串，若存在，则将栈中的引用直接指向该字符
 * 串；若不存在，则在常量池中生成一个字符串，再将栈中的引用指向该字符串。
 *
 * 字符串也是有办法不创建对象直接使用常量池当中的字面量，如下：
 * String a = "hello world";
 * String b = "hello world";
 * 这个时候，由于 a b 现在只有字面量，所以这时候如果进行 == 运算，那么会返回 true。
 *
 * 对于 Java 来讲，字符串的编码是性能的一大杀手，因为在 String 转换成 byte[] 的时候，JVM 会
 * 对 String 当中的 char[] 中的 char 依次进行查表操作并转化成为 byte，这也就导致了 CPU 的负荷
 * 较大，所以在性能要求比较高的情况下，可以提前缓存由 String 解码成为的 byte[] 用于复用。
 */
class StringExample {

    public static void main(String[] args) {
        StringExample example = new StringExample();
        example.equals();
        example.format();
    }

    /**
     * 字符串的比较要注意比较的是字符串的对象还是字符串的字面量，如果只需要比较字符串的
     * 字面量，建议始终使用 equals 方法； == 运算符会验证是否是同一个对象。
     *
     * 下面有 A B 两组字符串申明的方式，A 组测试当中，a b 都是创建了字符串对象并且也在
     * 常量池当中创建了 hello world 字面量对象，所以会有 a b 两个对象和字面量对象这三个
     * 对象被创建出来；而 B 组测试当中，没有创建字符串对象，直接使用了字面量，而两者的
     * 字面量对象是常量池当中同一个对象，所以 == 会返回 true。
     *
     * C 组测试中，通过 new 创建一个字符串对象，另外通过直接用字面量方式获得字符串，所以
     * 两者 == 返回 false。
     */
    @SuppressWarnings({"StringOperationCanBeSimplified", "ConstantConditions", "StringEquality"})
    private void equals() {
        // A 组测试。
        String a = new String("hello world");
        String b = new String("hello world");
        System.out.printf("equals : %b, == : %b\n", a.equals(b), a == b);
        // B 组测试。
        String c = "hello world";
        String d = "hello world";
        System.out.printf("equals : %b, == : %b\n", c.equals(d), c == d);
        // C 组测试。
        String e = new String("hello world");
        String f = "hello world";
        System.out.printf("equals : %b, == : %b\n", e.equals(f), e == f);
    }

    /**
     * format 可以把字符串当中一些格式化的占位符进行填充，例如 hello %s 中的 %s 就可以被填充。
     */
    private void format() {
        String str = "hello %s";
        System.out.println(String.format(str, "world"));
    }
}
