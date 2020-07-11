package 牛客;

import java.util.Scanner;

/**
 * 牛牛和妞妞去海边捡了一大袋美丽的贝壳，千辛万苦地运回家后，牛牛和妞妞打算分掉这些贝壳。
 * 牛牛提出，他和妞妞轮流从还没有分配的贝壳中取一定数量的贝壳，直到贝壳分完为止。
 * 分配规则是牛牛每次取剩余贝壳的1/10（向下取整），妞妞每次固定取m个贝壳，妞妞先取。
 * 妞妞想要得到不少于一半的贝壳，又不想太过分，那么她一次最少取多少个贝壳才能得到不少于一半的贝壳呢？
 * <p>
 * 输入描述：一个正整数n，表示贝壳的总数量，1<=n<=1000000000000000000。
 * 输出描述：一个正整数m，表示妞妞一次最少取的贝壳数量。
 * <p>
 * 输入10   输出1
 * 输入70   输出3
 */
public class 分贝壳 {
    // 二分法
    public static void main(String[] args) {
        // 构建输入输出
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();    // 贝壳数
        long l = 1, r = n;
        long mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (isOk(n, mid)) {
                r = mid - 1;    // true
            } else {
                l = mid + 1;    // false
            }
        }
        System.out.println(l);
    }

    private static boolean isOk(long n, long mid) {
        long count = 0;
        long cur = n;    // 贝壳数
        while (cur > 0) {
            if (cur <= mid) {   // 当只有一个贝壳的情况
                count += cur;
                cur = 0;
            } else {
                count += mid;
                cur -= mid;
            }
            cur -= cur / 10;
        }
        return count >= n / 2;
    }
}
