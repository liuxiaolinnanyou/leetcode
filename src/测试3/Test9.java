package 测试3;

public class Test9 {
    public static void main(String[] args) {
        String A = "helloworld";
        String B = new String("helloworld");
        String C = B.intern();
        System.out.println("================================");
        System.out.println(B == C);
        System.out.println(A == C);
        System.out.println(B == A);
    }
}