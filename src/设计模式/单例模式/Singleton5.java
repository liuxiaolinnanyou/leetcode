package 设计模式.单例模式;

// 静态内部类
// 既要懒汉式加载，又要线程安全：静态内部类
public class Singleton5 {
    private static Singleton5 singleton5;

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        return InnerClass.singleton5;
    }

    /**
     * 使用静态内部类，既能保证懒加载，又能保证线程安全
     */
    private static class InnerClass {
        private static final Singleton5 singleton5 = new Singleton5();
    }
}

/**
 * 相比较饿汉式（也就是第二种），我们增加了一个内部类，内部类中有一个外部类的实例，并且已经初始化了。
 * 我们回忆一下饿汉式有什么问题，饿汉式的问题是：在你没有使用该单例的时候，该单例却被加载了，
 * 如果该单例很大的话，将会浪费很多的内存.但是，我们现在引入了内部类的方式，虚拟机的机制是，
 * 如果你没有访问一个类，那么是不会载入该类进入虚拟机的。当我们使用外部类的时候其他属性的时候，
 * 是不会浪费内存载入内部类中的单例的。从而也就保证了并发安全和防止内存浪费。
 */
