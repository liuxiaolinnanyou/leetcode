package 设计模式.单例模式;

public class Singleton3 {
    // 饿汉式
    // 当你调用getInstance方法的时候，就会直接返回，不必做任何判断，
    // 这样做的好处是代码量明显减少了，坏处是，在你没有使用该单例的时候，
    // 该单例却被加载了，如果该单例很大的话，将会浪费很多的内存。
    private static final Singleton3 instance = new Singleton3();

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        return instance;
    }
}
