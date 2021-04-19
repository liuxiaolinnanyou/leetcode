package JUC并发编程.多线程;

public class TestThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我在写代码--" + i);
        }
    }

    public static void main(String[] args) {
        TestThread1 testThread1 = new TestThread1();
        testThread1.start();
//        testThread1.run();

        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程--" + i);
        }
    }
}