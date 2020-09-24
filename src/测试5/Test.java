package 测试5;

public class Test {
    public static void main(String[] args) {
        Integer i = 10;
        Integer j = 5 + (i++);
        j += i;
        System.out.println(j++);
        System.out.println("----------------------------");
        System.out.println(j);
    }
}