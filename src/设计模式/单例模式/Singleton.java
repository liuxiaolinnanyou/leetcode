package 设计模式.单例模式;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 简单点说，就是一个应用程序中，某个类的实例对象只有一个，你没有办法去new，因为构造器是被private修饰的，
 * 一般通过getInstance()的方法来获取它们的实例。
 * <p>
 * getInstance()的返回值是一个对象的引用，并不是一个新的实例，所以不要错误的理解成多个对象。
 * 单例模式实现起来也很容易，直接看demo吧
 */
public class Singleton {
    // 懒汉式 (线程不安全)
    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }


    // 测试
    // 并发引起现有的单例模式失败
    public static void main(String[] args) throws InterruptedException {
        // 使用set去重
        Set<Singleton> set = new HashSet<>();
//        Collections.synchronizedSet(set);
        // windows 每个进程最多 1000 个线程
        for (int i = 0; i < 1000; i++) {
            // 并发获取我们的实例
            new Thread(() -> {
                // 向set添加实例
                set.add(Singleton.getInstance());
            }).start();
        }

        // 等待10秒
        Thread.sleep(10000);
        System.out.println("-----单例模式测试-----");
        // 循环打印实例，小几率会出现2个实例或多个实例
        for (Singleton singleton : set) {
            System.out.println(singleton);
        }
    }
}