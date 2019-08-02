package cn.com.hanyuxiao.java.tutorial.base;

/**
 * 这个是 Java 基本语法当中 enum 类的书写规范
 *
 * 在这里定义一个 Human 的枚举类型，其中包括了 男人-man 女人-woman 两种枚举类型，并且在
 * 给枚举类型定义一个 String 的变量，用来表示书面含义，例如 Human.man 是男人的意思，那么
 * Human.man 的书面含义就是 "男人"，另外定义了一个 get 方法来获取枚举变量的书面含义。
 *
 * 在 main 方法当中作如下三件事情：
 *     1. 直接输出 Human.man 与 Human.woman
 *     2. 通过 get 方法输出 Human.man 与 Human.woman 的书面含义
 *     3. 通过 equals 看 Human 枚举类型的相等判断
 *
 * @author hanyuxiao
 */
public class EnumExample {
    enum Human {
        /**
         * 表示男人这一种性别类型
         */
        man("男人"),
        /**
         * 表示女人这一种性别类型
         */
        woman("女人");

        /**
         * 定义了这个枚举类型持有的一个变量，用来描述枚举类型的书面含义
         */
        private final String description;

        /**
         * 构造方法
         */
        Human (String description) {
            this.description = description;
        }

        /**
         * 获取枚举类型的书面含义
         */
        String getDescription() {
            return this.description;
        }

        @Override
        public String toString() {
            return name() + ":" + getDescription();
        }
    }

    public static void main(String[] args) {
        EnumExample example = new EnumExample();
        example.forEach();
        example.equals();
        example.customMethod();
        example.toStringE();
    }

    /**
     * 该方法演示了如何遍历枚举类当中定义的所有枚举。
     */
    private void forEach () {
        for (Human e : Human.values()) {
            System.out.println(e);
        }
    }

    /**
     * 展示了判断两个枚举是否相等的示例代码。
     * 在第一种方法是因为所有的枚举都继承了 {@link java.lang.Enum} 这个类
     * 第二个方法是因为所有的枚举在内存当中是单一的，所以可以直接用 == 判断
     */
    @SuppressWarnings({"ConstantConditions", "EqualsWithItself"})
    private void equals() {
        System.out.println(Human.man.equals(Human.man));
        System.out.println(Human.man == Human.man);
    }

    /**
     * 调用枚举当中自定义的方法。
     */
    private void customMethod() {
        System.out.println(Human.man.getDescription());
        System.out.println(Human.woman.getDescription());
    }

    /**
     * 分别输出 Human 枚举当中的枚举，这里默认会调用枚举的 toString() 方法。
     */
    private void toStringE() {
        System.out.println(Human.man);
        System.out.println(Human.woman);
    }
}
