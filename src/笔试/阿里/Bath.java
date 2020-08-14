package 笔试.阿里;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 一个浴室有3个淋浴间，现在有10个人需要洗澡，5男5女。要求模拟10个线程，随机去浴室洗澡，确保每个人都洗澡了，
 * 并且避免男女同时使用浴室，每个人洗澡的时间为1s到10s之间的一个随机数。按照上面的逻辑完成。
 * <p>
 * 就是锁的思想嘛，10个线程，都是随机时间点去洗澡，准备个标记性别的变量mutex，0为女，1为男，-1为没人，准备一个计数变量count=0，
 * 进去一个男的就count+1，同时mutex置1，出来就count-1同时看count是否等于0，为0就把mutex改-1，
 * 一个人进去之前判断mutex是否符合要求，看count是否小于3，满足就是能进，能进就进，
 * 不能进就拿两个队列存（一个存男，一个存女），有人出来，看他是男的还是女的，对应队列出来一个人进去
 */
public class Bath {
    // 高并发的情况下，i++无法保证原子性，往往会出现问题，所以引入AtomicInteger类。
    private volatile static AtomicInteger flag = new AtomicInteger(0);

    class Man implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (Bath.class) {
                    if (flag.get() >= 0 && flag.get() < 3) {
                        break;
                    }
                }
            }
            flag.getAndIncrement();    // 以原子方式将当前值加 1。
            Random random = new Random();
            int time = random.nextInt(10) + 1;
            try {
                Thread.sleep(time * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "我是男人，我洗了" + time + "秒");
            flag.getAndDecrement();
        }
    }

    class Woman implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (Bath.class) {
                    if (flag.get() <= 0 && flag.get() > -3) {
                        break;
                    }
                }
            }
            flag.getAndDecrement();
            Random random = new Random();
            int time = random.nextInt(10) + 1;
            try {
                Thread.sleep(time * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "我是女人，我洗了" + time + "秒");
            flag.getAndIncrement();
        }
    }

    public void takeShower() {
        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
            if (i % 2 == 0) {
                new Thread(new Man()).start();
            } else {
                new Thread(new Woman()).start();
            }
        }
    }

    public static void main(String[] args) {
        new Bath().takeShower();
    }
}