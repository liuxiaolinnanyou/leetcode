package 测试5;

public class Test4 {
    public static void main(String[] args) {
        int sn = 22;
        int n = 0;
        while (true) {
            if (sn-- < 0) {
                n++;
                break;
            }
        }
        System.out.println(n);
    }
}