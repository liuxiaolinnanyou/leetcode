package 笔试.达达集团;

public class Test {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        int c = a++ + b;
        int d = a++ + b;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}