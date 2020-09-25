package 测试5;

public class Test5 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                pong();
            }
        };
        t.run();
        System.out.print("ping");
    }

    static void pong() {
        System.out.println("pong");
    }
}