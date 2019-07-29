package cn.com.hanyuxiao.java.tutorial.lang;

/**
 * {@link java.lang.Comparable} 的使用。
 */
public class ComparableExample {

    public static void main(String[] args) {
        Obj little = new Obj(1);
        Obj bigger = new Obj(2);
        System.out.printf("小于？ : %d\n", little.compareTo(bigger));
    }
}

/**
 * 要使对象之间能够进行比较就需要实现这个接口。
 */
class Obj implements Comparable<Obj> {

    private int number;

    public Obj(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * 实现的时候要注意判断是否是空指针、是否是和比较的类是同一个类。
     * @return 负数表示这个对象小于传进来的参数对象，0表示等于，整数表示这个对象大于传进来的参数对象。
     */
    @Override
    public int compareTo(Obj o) {
        if (o == null) {
            return -1;
        }
        return Integer.compare(this.number, o.getNumber());
    }
}
