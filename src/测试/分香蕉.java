package 测试;

/**
 * 一堆香蕉，分成5份剩一个，第一个人吃掉剩下那个，拿走一份，5个人最少需要多少个香蕉。
 */
public class 分香蕉 {
    private static int m = 0;

    public static void main(String[] args) {
        int m = part(1, 1);
        System.out.println(m);
    }

    private static int part(int n, int k) {
        if ((n % 5 == 1) && k <= 5) {
            if (k == 5) {
                return m;
            }
            k++;
            return part((n - 1) / 5 * 4, k);
        } else {
            m++;
            return part(m, 1);
        }
    }
}