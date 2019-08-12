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
        example.add();
        example.subtract();
        example.multiply();
        example.divide();
        example.setScale();
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

    /**
     * 提供了 BigDecimal 这个类如何让其与其它的数相加。
     * base 是被加数，factor 是加数。
     */
    private void add() {
        BigDecimal base   = new BigDecimal(String.valueOf(1.2));
        BigDecimal factor = new BigDecimal(String.valueOf(1.3));
        System.out.println(base + "+" + factor + "=" + base.add(factor));
    }

    /**
     * 提供了 BigDecimal 这个类的减法使用方式。
     * base 是被减数，factor 是减数。
     */
    private void subtract() {
        BigDecimal base = new BigDecimal(String.valueOf(1.2));
        BigDecimal factor = new BigDecimal(String.valueOf(1.3));
        System.out.println(base + "-" + factor + "=" + base.subtract(factor));
    }

    /**
     * 提供了 BigDecimal 这个类的乘法使用方法。
     * base 是被乘数，factor 是乘数。
     */
    private void multiply() {
        BigDecimal base = new BigDecimal(String.valueOf(1.2));
        BigDecimal factor = new BigDecimal(String.valueOf(1.3));
        System.out.println(base + "*" + factor + "=" + base.multiply(factor));
    }

    /**
     * 提供了 BigDecimal 这个类的除法使用方法。
     * base 是被除数，factor 是除数。
     */
    private void divide() {
        BigDecimal base = new BigDecimal(String.valueOf(1.2));
        BigDecimal factor = new BigDecimal(String.valueOf(0.6));
        System.out.println(base + "/" + factor + "=" + base.divide(factor));
    }

    /**
     * 提供了 BigDecimal 精确到几位小数的使用方法。
     *
     * setScale(int, int); 提供了两个参数，第一个是保留的小数的位数；第二个是如何处理多余的数字。
     *
     * @see BigDecimal#ROUND_UP 表示之后需要保留的小数点后面不全部为 0，那么保留的小数点的末尾就会加 1.
     * @see BigDecimal#ROUND_DOWN 不管怎么样，小数点末尾都不会加 1，也就是相当于直接舍去。
     * @see BigDecimal#ROUND_CEILING 接近正无穷大的舍入模式。如果该 BigDecimal 为正数，那就表现和 ROUND_UP 一样，
     * 如果为负数就和 ROUND_DOWN 一样。
     * @see BigDecimal#ROUND_FLOOR 接近负无穷大的舍入模式。如果 BigDecimal 为正数，那就表现和 ROUND_DOWN 一样，
     * 如果为负数就和 ROUND_UP 一样。
     * @see BigDecimal#ROUND_HALF_UP 四舍五入。
     * @see BigDecimal#ROUND_HALF_DOWN 五舍六入，即五以及五以下就舍去。
     * @see BigDecimal#ROUND_HALF_EVEN 银行家舍入法。当舍去位的数值小于5时，直接舍去该位；当舍去位的数值大于等于6时，在舍
     * 去该位的同时向前位进一；当舍去位的数值等于5且（5后不为空且非全0）时，在舍去该位的同时向前位进一；当舍去的数值
     * 等于5且（5后为空或全0）时，如果前位数值为奇，则在舍去该位的同时向前位进一，如果前位数值为偶，则直接舍去该位。
     * PS： 大部分软件工程计算钱使用的都是这种方法。
     * @see BigDecimal#ROUND_UNNECESSARY 判断是否是一个精确的舍入模式，如果不需要舍入，那么就不会产生异常，如果需要进行
     * 舍入计算就会抛出 {@code ArithmeticException} 异常。
     */
    private void setScale() {
        BigDecimal base = new BigDecimal(String.valueOf(1.3456789));
        BigDecimal newBase = base.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(newBase);
    }
}
