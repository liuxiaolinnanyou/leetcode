package 笔试.去哪儿网;

public class Test {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "a";
        String s3 = s2 + "bc";
        String s4 = "a" + "bc";
        String s5 = s3.intern();
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        System.out.println(s1 == s5);
    }
}