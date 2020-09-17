package 测试3;

public class Test6 {
    public static void main(String[] args) {
        System.out.println("A");
        new Test6();
        new Test6();
    }

    public Test6() {
        System.out.println("B");   // 构造方法
    }

    {
        System.out.println("C");   // 构造代码块
    }

    static {
        System.out.println("D");   // 静态代码块
    }
}