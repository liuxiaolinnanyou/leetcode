package 测试;

public class DeadLock implements Runnable {
    // flag=1，占有对象o1，等待对象o2
    // flag=0，占有对象o2，等待对象o1
    public int flag = 1;

    // 定义两个Object对象，模拟两个线程占有的资源
    // 因为如果 01 02 不是static的，DeadLock 对象每次new出来，
    // 都是自己的对象，不是共享对象，当然也就没有死锁这回事了
    public static Object o1 = new Object();
    public static Object o2 = new Object();

    @Override
    public void run() {
        System.out.println("flag:" + flag);
        // deadLock2占用资源o1，准备获取资源o2
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("1");
                }
            }
        } else if (flag == 0) {    // deadLock1占用资源o2，准备获取资源o1
            synchronized (o2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("0");
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock1 = new DeadLock();
        DeadLock deadLock2 = new DeadLock();

        deadLock1.flag = 0;
        deadLock2.flag = 1;

        Thread thread1 = new Thread(deadLock1);
        Thread thread2 = new Thread(deadLock2);

        thread1.start();
        thread2.start();
    }
}