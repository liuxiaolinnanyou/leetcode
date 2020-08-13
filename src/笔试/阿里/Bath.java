package 笔试.阿里;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Bath {
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
            flag.getAndIncrement();
            Random random = new Random();
            int time = random.nextInt(10);
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
            int time = random.nextInt(10);
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