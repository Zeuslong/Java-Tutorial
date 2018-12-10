package cn.com.hanyuxiao.SimpleJava.java.lang;

/**
 * 这里是 {@link java.lang.Class} 这个类的一个获取与使用的方法
 *
 * @author hanyuxiao
 * @since 1.8
 */
public class ClassExample {
    public static void main(String[] args) {
        ClassExample classExample = new ClassExample();
        classExample.createClassObject();
    }

    /**
     * 这个方法为创建 Class 这个类的对象提供参考，这里创建一个 Person
     * 类的 Class 对象。这三个方法创建出来的 Class 对象是同一个对象。
     */
    public void createClassObject() {
        // 通过类创建
        Class personClassA = Person.class;

        // 通过一个实体对象创建
        Class personClassB = new Person().getClass();

        Class personClassC = null;

        try {
            // 通过 Class.forName(String className)  方法创建，可能会产生异常
            personClassC = Class.forName("cn.com.hanyuxiao.SimpleJava.java.lang.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 比较一下这三个对象是否相等
        System.out.printf("personClassA == personClassB ? %b\n", personClassA == personClassB);
        System.out.printf("personClassB == personClassC ? %b\n", personClassB == personClassC);
        System.out.printf("personClassA == personClassC ? %b\n", personClassA == personClassC);
    }



}

/**
 * 这个类用来提供给 ClassExample 做示例使用
 */
class Person{
    /**
     * 人的名称
     */
    private String name;
    /**
     * 人的年龄
     */
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
