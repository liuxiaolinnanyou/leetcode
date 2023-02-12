package 多线程编程.当前线程名;

/**
 * 运行结果可以发现：构造函数是被main线程调用的，而run方法是被名称为Thread-0的线程调用的。
 */
public class MyThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
//        myThread.run();
    }
}