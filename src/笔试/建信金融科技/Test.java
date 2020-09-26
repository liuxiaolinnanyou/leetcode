package 笔试.建信金融科技;

public class Test {
    public static void main(String[] args) {
        byte a = 1;
        byte b = 127;
        b += a;
        System.out.println(b);
        System.out.println((byte) 128);
        System.out.println((byte) 129);
    }
}