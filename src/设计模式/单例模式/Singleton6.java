package 设计模式.单例模式;

/**
 * 反射和反序列化破坏单例
 */
public class Singleton6 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        // 反射获取实例
        Singleton singleton = Singleton.class.newInstance();
        Singleton singletontwo = Singleton.getInstance();
        System.out.println(singleton + "\n" + singletontwo);
    }
}
