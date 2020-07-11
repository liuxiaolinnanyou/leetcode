package 设计模式.观察者模式;

public interface Person {
    // 小王和小李通过这个接口可以接收到小美发过来的消息
    // 这个接口相当于小王和小李的电话号码，小美发送通知的时候就会拨打getMessage这个电话，拨打电话就是调用接口
    void getMessage(String s);
}
