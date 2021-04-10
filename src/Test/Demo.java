package Test;

public class Demo {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            public void run() {
                show();
            }
        };
        thread.run();
        System.out.println("run");
    }

    static void show() {
        System.out.println("show");
    }
}
