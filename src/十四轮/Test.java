package 十四轮;

// 阿里面试题
// 编写 10 个线程，第一个线程从 1 加到 10，第二个线程从 11 加到 20 …… 第十个线程从 91 加到 100，
// 最后再将 10 个线程结果相加
public class Test {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Add add = new Add(i * 10 + 1, i * 10 + 10);
            add.start();
        }
        Thread.sleep(50);
        System.out.println("总和：" + Add.sum);
    }
}

class Add extends Thread {
    static Object object = new Object();
    static int sum;

    private int begin;    // 首
    private int over;     // 尾

    public Add(int begin, int over) {
        this.begin = begin;
        this.over = over;
    }

    private int temp;

    public void run() {
        for (int i = begin; i <= over; i++) {
            temp += i;
        }
        // 同步代码块
        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + "----" + temp);
            sum += temp;
        }
    }
}