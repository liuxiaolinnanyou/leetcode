package 设计模式.单例模式;

public enum Singleton7 {
    // 实例
    SINGLETON_7;

    /**
     * 获取实例
     * 不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象
     */
    public Singleton7 getSingleton7() {
        return SINGLETON_7;
    }
}
