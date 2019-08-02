package cn.com.hanyuxiao.java.tutorial.nio;

import java.nio.ByteBuffer;

/**
 * {@link java.nio.ByteBuffer} 的 example。
 *
 * ByteBuffer 有两个实现子类：{@see java.nio.HeapByteBuffer} 与 {@see java.nio.DirectByteBuffer} 两个，
 * 两者的区别在于：HeapByteBuffer 是分配在堆上面的 ByteBuffer，而 DirectByteBuffer 是分配在对外内村上的不受 GC
 * 来控制；其次 DirectByteBuffer 创建于销毁的代价比较大；但是 DirectByteBuffer 的读写速度又会快于 HeapByteBuffer。
 *
 * 在这里，不对子类做太多详细的解释，只是写一些 ByteBuffer 当中定义的方法的使用。
 */
class ByteBufferExample {

    public static void main(String[] args) {
        ByteBufferExample example = new ByteBufferExample();
        example.allocate();
        example.allocateDirect();
        example.put();
        example.get();
    }

    /**
     * 创建 ByteBuffer 的方法，在 ByteBuffer 当中定义了两种创建方法，这种创建方法返回的是 {@see java.nio.HeapByteBuffer}
     * 这个子类。在 HeapByteBuffer 当中，存储数据的是一个数组，也就是继承了 ByteBuffer 当中的数组属性。
     */
    private void allocate() {
        // 其中传入的参数是 Buffer 的大小，数组的长度。
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer);
    }

    /**
     * 创建 ByteBuffer 的方法，这种创建方法返回的是 {@see java.nio.DirectByteBuffer} 子类。
     * 在 DirectByteBuffer 当中的构造方法当中会用 {@link sun.misc.Unsafe} 在对外内存分配空间，
     * 然后存放于查询操作都是通过这个类来做的。
     */
    private void allocateDirect() {
        // 其中传入的参数是 Buffer 的大小，数组的长度。
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        System.out.println(byteBuffer);
    }

    /**
     * 向 ByteBuffer 当中写入数据。 ByteBuffer 被创建好之后，默认是写入数据的状态的。
     * Buffer 设计为将读和写区分为两个状态，也就是在某一个时刻 Buffer 只能写入数据或者读出数据，如果当前
     * 这个 Buffer 处于读的状态，强行写入数据，是会产生异常的，如果需要写的话，就需要将读的状态改为写状态。
     */
    private void put() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("abc".getBytes());
        System.out.println(byteBuffer);
    }

    /**
     * 想 ByteBuffer 当中读取数据，在读取数据的时候需要调转 ByteBuffer 的状态。
     * 需要注意的是，读出的数据是 byte 类型的，每读取一次就会指向存放的数据的下一个位置，也就是 position 会加 1。
     */
    private void get() {
        // 创建模拟数据
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("abc".getBytes());
        // 从读状态改为写状态
        byteBuffer.flip();
        // 读出数据，每读取一次，就会指向下一个需要读取的位置，读取到末尾了如果还继续读取那么就会抛出异常 BufferUnderflowException
        // limit 可以理解为读取个数的上线
        int limit = byteBuffer.limit();
        for (int i = 0; i < limit; i++) {
            System.out.printf("%c", byteBuffer.get());
        }
        // 读出全部数据，直接返回了其中保存的数组
        System.out.println("\n" + new String(byteBuffer.array()));
    }
}
