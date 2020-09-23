package 笔试.最右;

public class Test {
    public static void main(String[] args) {
        int sum = 20;
        int n = 3;
        while (n >> 1 < 9) {
            sum = sum - n;
            n++;
        }
        System.out.printf("%d,%d", n, sum);
    }
}
