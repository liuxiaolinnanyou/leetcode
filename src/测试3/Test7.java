package 测试3;

public class Test7 {
    public static void main(String[] args) {
        Integer a1 = 17;
        Integer a2 = 17;
        Integer b1 = 2017;
        Integer b2 = 2017;
        Integer c1 = new Integer(17);
        Integer c2 = new Integer(17);
        Integer d1 = new Integer(2017);
        int d2 = 2017;

        System.out.println(a1 == a2);
        System.out.println(b1 == b2);
        System.out.println(c1 == c2);
        System.out.println(d1 == d2);
    }
}