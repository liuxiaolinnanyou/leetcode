package Test;

public class Test {
    public static void main(String[] args) {
        boolean flag1 = (4 * 0.1) == 0.4;
        boolean flag2 = (3 * 0.1) == 0.3;
        System.out.println(flag1);
        System.out.println(flag2);
        System.out.println("--------------------------");
        System.out.println(4 * 0.1);
        System.out.println(3 * 0.1);

        String str = "a\\b\\c\\d";
        System.out.println(str);
        String[] split = str.split("\\\\");
        for (String s : split) {
            System.out.println(s);
        }
    }
}