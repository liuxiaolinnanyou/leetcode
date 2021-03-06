package 设计模式.单例模式;

/**
 * 单例模式 懒汉式   双重检验锁
 */
public class Singleton4 {
    private static volatile Singleton4 singleton4;

    private Singleton4() {
    }

    /**
     * 双重检查获取单例实例
     */
    public static Singleton4 getInstance() {
        // 多线程直接访问，不做控制，不影响性能
        if (singleton4 == null) {
            // 此时，如果有多个线程进入，则进入同步块，其余线程等待
            synchronized (Singleton4.class) {
                // 此时，第一个进入的线程判断为null，但第二个线程进来时已经不是null了
                if (singleton4 == null) {
                    // 第一个线程实例化此对象
                    singleton4 = new Singleton4();
                }
            }
        }
        // 如果不为null，不会影响性能，只有第一次才会影响性能
        return singleton4;
    }
}

/**
 * 我们继续分析一下代码：首先看getInstance方法，我们在方法声明上去除了synchronized关键字，多线程进入方法内部，判断是否为null，
 * 如果为null，多个线程同时进入if块内，此时，我们是用Single4 Class对象同步一段方法。保证只有一个线程进入该方法。
 * 并且判断是否为null，如果为null，就进行初始化。我们想象一下，如果第一个线程进入进入同步块，发现该实例为null，
 * 于是进入if块实例化，第二个线程进入同步内则发现实例已经不是null，直接就返回了，从而保证了并发安全。
 * 那么这个和第三种方式又什么区别呢？第三种方式的缺陷是：每个线程每次进入该方法都需要被同步，成本巨大。
 * 而第四种方式呢？每个线程最多只有在第一次的时候才会进入同步块，也就是说，只要实例被初始化了，那么之后进入该方法的线程就不必进入同步块了。
 * 就解决并发下线程安全和性能的平衡。虽然第一次还是会被阻塞。但相比较于第三种，已经好多了。
 *
 * 我们还对一个东西感兴趣，就是修饰变量的volatile关键字，为什么要用volatile关键字呢？这是个有趣的问题。我们好好分析一下：
 * 首先我们看，Java虚拟机初始化一个对象都干了些什么？总的来说，3件事情：
 *
 * 在堆空间分配内存
 * 执行构造方法进行初始化
 * 将对象指向内存中分配的内存空间，也就是地址
 *
 * 但是由于当我们编译的时候，编译器在生成汇编代码的时候会对流程进行优化（这里涉及到happen-before原则和Java内存模型和CPU流水线
 * 执行的知识，就不展开讲了），优化的结果式有可能式123顺序执行，也有可能式132执行，但是，如果是按照132的顺序执行，
 * 走到第三步（还没到第二步）的时候，这时突然另一个线程来访问，走到if(single4 == null)块，会发现single4已经不是null了，
 * 就直接返回了，但是此时对象还没有完成初始化，如果另一个线程对实例的某些需要初始化的参数进行操作，就有可能报错。
 * 使用volatile关键字，能够告诉编译器不要对代码进行重排序的优化。就不会出现这种问题了。
 *
 * 我们看到，小小的单例模式被我们弄得很复杂。但这就是一个程序员的追求，追求最好的性能，追求最好的代码。
 *
 * 那还有没有别的更好的办法呢？这个代码也太多了，代码可读性也不好。而且线程第一次进入还会阻塞，还能更完美吗？
 */
