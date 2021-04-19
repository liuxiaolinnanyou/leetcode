package 笔试.招银网络春招;

public class Test {
    public static void main(String[] args) {
        String value1 = "CMB";
        String value2 = new String(value1);
        String value3 = "CMB" + "";
        String value4 = "CMB";

        System.out.println((value1 == value2) + "," + (value3 == value4));
    }
}