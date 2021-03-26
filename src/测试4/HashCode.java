package 测试4;

public class HashCode {
    public static void main(String[] args) {
        Integer a = new Integer(96354);
        String b = "abc";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(a.equals(b));
    }
}