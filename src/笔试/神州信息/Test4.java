package 笔试.神州信息;

public class Test4 {
    public static void throwit() {
        System.out.print("throwit ");
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        try {
            System.out.print("hello ");
            throwit();
        } catch (Exception e) {
            System.out.print("caught ");
        } finally {
            System.out.print("finally ");
        }
        System.out.print("after");
    }
}