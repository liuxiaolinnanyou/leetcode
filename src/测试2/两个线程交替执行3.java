package 测试2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

// 第3种使用堵塞队列结合线程使用
public class 两个线程交替执行3 {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> blockingDeque = new ArrayBlockingQueue<Integer>(10);
        ArrayBlockingQueue<Integer> blockingDeque1 = new ArrayBlockingQueue<Integer>(10);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    try {
                        blockingDeque.put(i);
                        System.out.println(blockingDeque1.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 6; i <= 10; i++) {
                    try {
                        System.out.println(blockingDeque.take());
                        blockingDeque1.put(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
