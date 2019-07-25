package cn.com.hanyuxiao.java.tutorial.nio.file;

import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * {@link java.nio.file.Path} 接口的一些使用方式
 *
 * @author hanyuxiao
 * @since 1.8
 */
public class PathExample {

    public static void main(String[] args) {
        PathExample example = new PathExample();
        example.create();
    }

    /**
     * 这里展示把一个 String 转化成 实现了 Path 接口的方法
     */
    private void create() {
        String str = "/hello.txt";
        Path path = FileSystems.getDefault().getPath(str);
        System.out.printf("文件地址为 %s", path);
    }
}
