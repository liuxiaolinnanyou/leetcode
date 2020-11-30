package 多线程.demo04;

// 合并线程  待此线程执行完成后，再执行其他线程，其他线程阻塞   可以想象成插队
// 测试join方法
// 电脑为多核的可能效果不明显
public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程vip来了" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 启动我们的线程
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        // 主线程
        for (int i = 0; i < 1000; i++) {
            if (i == 200) {
                thread.join();  // 插队
            }
            System.out.println("main" + i);
        }
    }
}