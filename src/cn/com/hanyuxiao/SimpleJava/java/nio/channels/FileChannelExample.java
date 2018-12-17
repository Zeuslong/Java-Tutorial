package cn.com.hanyuxiao.SimpleJava.java.nio.channels;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * {@link java.nio.channels.FileChannel} 使用的方法
 *
 * @author hanyuxiao
 * @since 1.8
 */
public class FileChannelExample {

    public static void main(String[] args) {
        FileChannelExample example = new FileChannelExample();
        example.create();
        example.writeSingleBuffer();
    }

    /**
     * 此方法演示如何创建一个 FileChannel。创建 FileChannel 首先要指定 FileChannel 对目标
     * 文件执行操作的一个权限，然后使用实现了 Path 接口的对象打开一个 FileChannel。
     *
     * 开头的一段代码，是负责定位文件写入的数据的，可以参考 {@link ClassLoader#getResource(String)}
     * 这个方法的说明文档。
     */
    private void create() {
        try {
            // 查找文件路径
            String pathStr = Objects.requireNonNull(FileChannelExample.class.getClassLoader()
                            .getResource("cn/com/hanyuxiao/SimpleJava/java/nio/channels/FileChannelExample.class"))
                                     .getPath();
            Path target = FileSystems.getDefault().getPath(pathStr);

            // 创建权限
            Set<OpenOption> permission = new HashSet<>();
            permission.add(StandardOpenOption.CREATE);
            permission.add(StandardOpenOption.CREATE_NEW);
            permission.add(StandardOpenOption.WRITE);

            // 创建 FileChannel
            FileChannel channel = FileChannel.open(target, permission);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向一个文件当中写入 Hello World 这样的字符，文件所在的路径会在打印在控制台上。
     *
     * 开头的一段代码，是负责定位文件写入的数据的，可以参考 {@link ClassLoader#getResource(String)}
     * 这个方法的说明文档。
     */
    private void writeSingleBuffer() {

        String pathRoot = Objects.requireNonNull(FileChannelExample.class.getClassLoader().getResource("")).getPath();
        Path target = FileSystems.getDefault().getPath(pathRoot + "cn/com/hanyuxiao/SimpleJava/java/nio/channels/hello.txt");

        FileChannel channel = null;

        try {
            // 创建权限
            Set<OpenOption> permission = new HashSet<>();
            permission.add(StandardOpenOption.CREATE);
            permission.add(StandardOpenOption.CREATE_NEW);
            permission.add(StandardOpenOption.WRITE);

            // 创建 FileChannel
            channel = FileChannel.open(target, permission);

            // 写入数据
            String args = "Hello World";
            channel.write(ByteBuffer.wrap(args.getBytes()));
            System.out.printf("数据已写入到：%s\n", target.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
