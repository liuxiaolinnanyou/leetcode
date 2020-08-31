package 笔试.中兴;

import java.util.*;

/**
 * 现有一个长度为 n 的数列 a ，你可以对其中每个元素最多增加或减少 1 ，也可以不操作，牛牛想知道他最少要改变多少个元素，使得数列
 * a 是一个等差数列，若无法使数列 a 变成等差数列，输出 -1。
 * <p>
 * 第一行：一个正整数，代表测试的组数。
 * 一个正整数 n
 * n 个正整数    范围1-10^9
 * <p>
 * 输入：
 * 1
 * 4
 * 1 5 6 7
 * 输出：
 * 3
 * 可以改变为 [2,4,6,8]
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            T--;
            int n = sc.nextInt();
            int[] a = new int[n + 5];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            int ans = 1000000;
            if (n > 2) {
                for (int x = -1; x <= 1; x++)
                    for (int y = -1; y <= 1; y++) {
                        int cnt = Math.abs(x) + Math.abs(y);
                        int d = (a[1] + y) - (a[0] + x);
                        int a0 = a[0] + x;
                        boolean flag = true;
                        for (int i = 2; i < n; i++) {
                            int v = Math.abs(a0 + i * d - a[i]);
                            if (v > 1) {
                                flag = false;
                                break;
                            } else {
                                cnt += v;
                            }
                        }
                        if (flag) ans = Math.min(ans, cnt);
                    }
                System.out.println(ans == 1000000 ? -1 : ans);
            } else {
                System.out.println(0);
            }
        }
    }
}
