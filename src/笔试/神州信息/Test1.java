package 笔试.神州信息;

public class Test1 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                continue;
            }
            sum += i;
        }
        System.out.println(sum);
    }
}