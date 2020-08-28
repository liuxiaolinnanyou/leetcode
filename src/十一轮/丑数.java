package 十一轮;

import java.util.Scanner;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * <p>
 * 说明:
 * 1 是丑数。
 * n 不超过1690。
 */
public class 丑数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(nthUglyNumber(n));
    }

    // 定义三个指针 p2 , p3 , p5，p2 指向的数字永远乘 2，p3 指向的数字永远乘 3，p5 指向的数字永远乘 5
    // 初始化所有指针都指向第一个丑数，即 1
    // 我们从2*dp[p2], 3*dp[p3], 5*dp[p5]选取最小的一个数字，作为新的丑数。这边新的丑数就是2*dp[p2]=2*1=2，然后 p2++
    // 此时 p3 和 p5 指向第 1 个丑数，p2 指向第 2 个丑数。然后重复上一步
    // 这里基于的一个事实是，丑数数列是递增的，当 p5 指针在当前位置时，后面的数乘以 5 必然比前面的数乘以 5 大，
    // 所以下一个丑数必然是先考虑前面的数乘以 5。 p2 , p3 同理，所以才可以使用指针
    public static int nthUglyNumber(int n) {
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if (dp[i] == dp[p2] * 2) {
                p2++;
            }
            if (dp[i] == dp[p3] * 3) {
                p3++;
            }
            if (dp[i] == dp[p5] * 5) {
                p5++;
            }
        }
        return dp[n - 1];
    }
}
