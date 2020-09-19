package 测试3;

public class Test8 {
    public static Test8 t1 = new Test8();
    public static Test8 t2 = new Test8();

    {
        System.out.println("构造块");
    }

    static {
        System.out.println("静态块");
    }

    public static void main(String[] args) {
        Test8 t = new Test8();
    }
}