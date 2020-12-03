package JUC并发编程.demo01;

public class Test {
    public static void main(String[] args) {
        // 获取cpu的核数
        // cpu密集型   IO密集型
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}