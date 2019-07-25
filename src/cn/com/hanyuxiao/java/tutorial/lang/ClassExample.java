package cn.com.hanyuxiao.java.tutorial.lang;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 这里是 {@link java.lang.Class} 这个类的一个获取与使用的方法，其中包括了大部分最常见的方法的使用。
 *
 * @author hanyuxiao
 * @since 1.8
 */
public class ClassExample {

    /**
     * helloStr 字符串，用于支持 getFieldObject() 与 getFieldObjectList() 方法展示示例
     */
    private String helloStr = "Hello";
    /**
     * worldStr 字符串，用于支持 getFieldObjectList() 方法展示示例
     */
    private String worldStr = "World";

    public static void main(String[] args) {
        ClassExample classExample = new ClassExample();
        classExample.createClassObject();
        classExample.getMethodObject();
        classExample.getMethodObjectList();
        classExample.getFieldObject();
        classExample.getFieldObjectList();
    }

    /**
     * 这个方法为创建 Class 这个类的对象提供参考，这里创建一个 Person
     * 类的 Class 对象。这三个方法创建出来的 Class 对象是同一个对象。
     */
    private void createClassObject() {
        // 通过类创建
        Class<ClassExample> classA = ClassExample.class;

        // 通过一个实体对象创建
        Class classB = new ClassExample().getClass();

        Class classC = null;

        try {
            // 通过 Class.forName(String className)  方法创建，可能会产生异常
            classC = Class.forName("cn.com.hanyuxiao.java.tutorial.lang.ClassExample");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 比较一下这三个对象是否相等
        System.out.printf("personClassA == personClassB ? %b\n", classA == classB);
        System.out.printf("personClassB == personClassC ? %b\n", classB == classC);
        System.out.printf("personClassA == personClassC ? %b\n", classA == classC);
    }

    /**
     * 获取这个类当中的某一个方法，获取一个 Method 对象的时候，通常要指定这个 Method 方法名称与方法参数的
     * 类型，指定方法名称是为了能够找到正确的方法，指定方法参数是为了在重载的方法当中去找到特定的方法。
     *
     * 通常在获取 Method 对象的时候，推荐使用 {@link Class#getDeclaredMethod(String, Class[])} 这样
     * 一个方法，因为 getDeclaredMethod 方法会获取所有在类当中声明的方法，包括：public、protect、private
     * 以及没有使用权限符修饰的方法。
     */
    private void getMethodObject() {
        String methodName = "demoMethod";
        // 获取 ClassExample 的类对象
        Class<ClassExample> targetClass = ClassExample.class;

        try {
            // 获取 demoMethod() 方法
            Method methodA = targetClass.getDeclaredMethod(methodName);
            Method methodB = targetClass.getDeclaredMethod(methodName, String.class);
            // 输入方法的描述
            System.out.println(methodA);
            System.out.println(methodB);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取 ClassExample 当中所有的方法列表。通常也是建议使用 getDeclaredMethods() 这个方法获取到这个类
     * 当中的所有的方法。
     */
    private void getMethodObjectList() {
        // 获取 class 对象
        Class<ClassExample> targetClass = ClassExample.class;
        // 获取所有的 Method 对象
        Method[] methods = targetClass.getDeclaredMethods();

        // 建议会有一个判空的操作，避免空指针异常
        if (methods == null || methods.length == 0) {
            System.out.println("methods is null or empty");
            return;
        }
        // 遍历
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    /**
     * 获取 ClassExample 当中的 helloStr 的 Field 对象，在获取的时候需要得到属性名称。
     *
     * 在获取 Field 属性的时候， getDeclaredField() 可以获取到所有权限修饰符修饰的属性
     * 包括：public、protect、private与默认修饰符。
     */
    private void getFieldObject() {
        String fieldName = "helloStr";
        Class<ClassExample> targetClass = ClassExample.class;

        try {
            Field field = targetClass.getDeclaredField(fieldName);
            System.out.println(field);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取 ClassExample 当中所有的属性列表。通常也是建议使用 getDeclaredFields 这个方法获取到这个类
     * 当中的所有的属性。
     */
    private void getFieldObjectList() {
        Class<ClassExample> targetClass = ClassExample.class;

        Field[] fields = targetClass.getDeclaredFields();

        if (fields == null || fields.length == 0) {
            System.out.println("fields is null or empty");
            return;
        }

        for (Field field : fields) {
            System.out.println(field);
        }
    }

    /**
     * 展示方法，用来支持通过 Class 对象获取方法的示例方法
     */
    private void demoMethod() {
        System.out.println("Hello world");
    }

    /**
     * 展示方法，用来支持通过 Class 对象获取方法的示例方法
     */
    private void demoMethod(String name) {
        System.out.println("Hello" + name);
    }

}
