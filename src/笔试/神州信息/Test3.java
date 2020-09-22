package 笔试.神州信息;

public class Test3 {
    public static void main(String[] args) {
        B b = new B();
        b.test();
    }

    void test() {
        System.out.print("A");
    }
}

class B extends Test3 {
    void test() {
        super.test();
        System.out.print("B");
    }
}