package cn.com.hanyuxiao.java.tutorial.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * {@link java.util.Queue} 的使用，其实它只是一个接口，这个接口有很多具体的实现类，
 * 在这里只举例，有可用于并发的队列也有基本的数据结构队列。
 *
 * 在这个例子当中，使用 {@link java.util.LinkedList} 作为接口的底层实现进行具体的操作。
 *
 *  @see java.util.LinkedList
 *  @see java.util.PriorityQueue
 *  @see java.util.concurrent.LinkedBlockingQueue
 *  @see java.util.concurrent.BlockingQueue
 *  @see java.util.concurrent.ArrayBlockingQueue
 *  @see java.util.concurrent.LinkedBlockingQueue
 *  @see java.util.concurrent.PriorityBlockingQueue
 */
class QueueExample {
    public static void main(String[] args) {
        QueueExample example = new QueueExample();
        example.addE();
        example.offerE();
        example.removeE();
        example.pollE();
        example.elementE();
        example.peekE();
    }

    /**
     * 在不违反容量限制的前提下，把元素立即插入到队列当中。
     *
     * 如果元素由于容量原因没有成功插入，那么就会抛出异常 {@link IllegalStateException}。
     */
    private void addE() {
        Queue<String> queue = new LinkedList<>();
        // 使用 add 插入元素
        queue.add("hello world");
        // 由于只插入了一个元素，那么获取顶部元素一定是我们刚刚插入的
        System.out.printf("使用 add 方法插入了一个元素 %s \n", queue.peek());
    }

    /**
     * 在不违反容量限制的前提下，把元素立即插入到队列当中。
     *
     * 与 add 方法的区别在于，如果插入失败不会抛出异常，而是会返回 false。
     */
    private void offerE() {
        Queue<String> queue = new LinkedList<>();
        // 使用 offer 插入元素
        queue.offer("hello world");
        // 由于只插入了一个元素，那么获取顶部元素一定是我们刚刚插入的
        System.out.printf("使用了 offer 方法插入了一个元素 %s \n", queue.peek());
    }

    /**
     * 移除队列顶端的元素，并返回这个元素。
     *
     * 如果队列为空，那么执行这个方法的时候就会抛出一个异常 {@link NoSuchElementException}。
     */
    private void removeE() {
        // 初始化
        Queue<String> queue = new LinkedList<>(Arrays.asList("hello", "world"));
        // 移除顶端的元素
        System.out.printf("删除顶端的 %s 元素 \n", queue.remove());
        // 再查看顶端元素
        System.out.printf("现在顶端的元素为 %s \n", queue.peek());
        // 再删除让它抛出异常
        queue.remove();
        try {
            queue.remove();
        } catch (NoSuchElementException e) {
            System.out.println("由于顶端没有元素所以 remove 方法会抛出异常");
        }
    }

    /**
     * 移除队列顶端的元素，并返回这个元素。
     *
     * 如果队列为空，那么执行这个方法的时候不会抛出异常，而是返回 null。
     */
    private void pollE() {
        // 初始化一个队列
        Queue<String> queue = new LinkedList<>(Arrays.asList("hello", "world"));
        // 移除顶端的元素
        System.out.printf("删除顶端的 %s 元素 \n", queue.poll());
        // 再查看顶端元素
        System.out.printf("现在顶端的元素为 %s \n", queue.peek());
        // 移除顶端的元素一直到它没有了
        System.out.printf("删除顶端的 %s 元素 \n", queue.poll());
        System.out.printf("删除顶端的 %s 元素 \n", queue.poll());
    }

    /**
     * 获取队列顶端的元素，但是不从队列当中删除。
     *
     * 如果队列为空，获取失败的时候会抛出一个异常 {@link NoSuchElementException}。
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void elementE() {
        Queue<String> queue = new LinkedList<>(Collections.singleton("hello world"));
        // 查看顶端元素
        System.out.printf("顶端元素为 %s \n", queue.element());

        // 初始化为空的一个元素
        queue = new LinkedList<>();
        try {
            queue.element();
        } catch (NoSuchElementException e) {
            System.out.println("由于队列为空，所以 element 方法会抛出异常");
        }
    }

    /**
     * 获取队列顶端的元素，但是不从队列当中删除。
     *
     * 如果队列为空，获取失败的时候，会返回 null。
     */
    @SuppressWarnings("ConstantConditions")
    private void peekE() {
        Queue<String> queue = new LinkedList<>(Collections.singleton("hello world"));
        // 查看顶端元素
        System.out.printf("顶端元素为 %s \n", queue.peek());

        // 初始化为空的队列
        queue = new LinkedList<>();
        System.out.printf("顶端元素为 %s \n", queue.peek());
    }

}
