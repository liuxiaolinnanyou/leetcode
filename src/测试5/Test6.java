package 测试5;

public class Test6 {
    public static void main(String[] args) {
        Test6 a = new Test6();
        a.method(8);   // int 类型可以直接赋值给 long
        a.method(1.2f);
    }

    void method(float i) {
        System.out.println("float:" + i);
    }

    void method(long i) {
        System.out.println("long:" + i);
    }
}