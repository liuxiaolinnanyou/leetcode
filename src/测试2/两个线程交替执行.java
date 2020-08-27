package 测试2;

// 第一种使用synchronized，notify，wait
public class 两个线程交替执行 {
    public static void main(String[] args) {
        final Object object = new Object();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    synchronized (object) {
                        object.notify();
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 6; i <= 10; i++) {
                    synchronized (object) {
                        object.notify();
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        new Thread(runnable).start();
        new Thread(runnable1).start();
    }
}
