package 十二轮;

/**
 * 队列（Queue），是一种线性存储的数据结构。它有以下几个特点：
 * 队列中数据是按照"先进先出（FIFO, First-In-First-Out）"方式进出队列的。
 * 队列只允许在"队首"进行删除操作，而在"队尾"进行插入操作。
 * 队列通常包括的两种操作：入队列 和 出队列。
 */
public class 使用数组实现一个队列 {
    // 声明一个数组
    private int[] array;

    // 声明队中元素的数量
    private int count;

    // 初始化队列使用，传入一个初始长度
    public 使用数组实现一个队列(int size) {
        array = new int[size];
        count = 0;
    }

    // 入队列，向队列的尾部添加元素，同时队列的长度加 1
    public void push(int val) {
        array[count++] = val;
    }

    // 返回队首的元素
    public int front() {
        return array[0];
    }

    // 返回队首元素的同时从队列中移除该元素
    public int pop() {
        int ret = array[0];
        count--;
        for (int i = 1; i <= count; i++) {
            array[i - 1] = array[i];
        }
        return ret;
    }

    // 返回队列的长度
    public int size() {
        return count;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return size() == 0;
    }


    public static void main(String[] args) {
        使用数组实现一个队列 myQueue = new 使用数组实现一个队列(5);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.push(5);
        System.out.println(myQueue.size());
        System.out.println(myQueue.front());
        myQueue.pop();
        System.out.println(myQueue.front());
        System.out.println(myQueue.size());
    }
}