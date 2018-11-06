package cn.com.hanyuxiao.SimpleJava.java.base;

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
        private String description;

        /**
         * 构造方法
         */
        Human (String description) {
            this.description = description;
        }

        /**
         * 获取枚举类型的书面含义
         */
        public String getDescription () {
            return this.description;
        }

        @Override
        public String toString() {
            return name() + ":" + getDescription();
        }
    }

    public static void main(String[] args) {
        // 输出枚举类型-男人的 toString 方法
        System.out.println(Human.man);
        // 输入枚举类型-男人的书面含义
        System.out.println(Human.man.getDescription());
        // 输出枚举类型-女人的 toString 方法
        System.out.println(Human.woman);
        // 输入枚举类型-女人的书面含义
        System.out.println(Human.woman.getDescription());

        // 相等性判断
        System.out.println(Human.man.equals(Human.man));
        System.out.println(Human.man == Human.man);
    }
}
