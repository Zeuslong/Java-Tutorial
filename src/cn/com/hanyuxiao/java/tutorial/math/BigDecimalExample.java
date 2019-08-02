package cn.com.hanyuxiao.java.tutorial.math;

import java.math.BigDecimal;

/**
 * 由于 float 和 double 只能用来做科学计算或者是工程计算，而不能对小数点进行精密的加减，
 * 所以需要一种用来对超过16位有效位的数进行精确的运算的类，也就是 {@link java.math.BigDecimal}。
 *
 * 其实研究不是很多，以至于其与 float 还有 double 的细微却别也不是很清楚，但是我们在处理
 * 交易时需要对钱做运算的时候，一般都是使用这个类。
 */
public class BigDecimalExample {

    public static void main(String[] args) {
        BigDecimalExample example = new BigDecimalExample();
        example.construct();
    }

    /**
     * 此方法主要是演示了几种用的比较多的构造方法。
     *
     * 一下的几种构造方法当中，不推荐直接通过 float 传入构造方法的方式来构造 {@link java.math.BigDecimal}
     * 对象，是因为 float 到目前为止是没有办法用一个很精确的方式来描述 1.2 这一个值，所以当传入的时候，会找一个
     * 无限接近于 1.2 的值来构造 BigDecimal。所以通过 float 方式来构造 BigDecimal 方式是一个不稳定的构造方法。
     * 但通过 String 来构造的这一种方式是很稳定的。
     */
    private void construct() {
        // 通过 int 来进行构造
        BigDecimal fromInt = new BigDecimal(1);
        // 通过 float 老进行构造
        BigDecimal fromFloat = new BigDecimal(1.2);
        // 通过 String 来构造
        BigDecimal fromString = new BigDecimal("1.3");
        // 通过 float 转 String 来构造
        BigDecimal fromStringOfFloat = new BigDecimal(String.valueOf(1.2));
        System.out.println("int 来构造 ： " + fromInt);
        System.out.println("float 来构造 ： " + fromFloat);
        System.out.println("String 来构造： " + fromString);
        System.out.println("float 转 String 来构造 ： " + fromStringOfFloat);
    }
}
