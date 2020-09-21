package sort_排序算法;

import java.util.Arrays;

/**
 * 输入：2
 * 输出：[0,1,1]    0,1,2    对应二进制中的 1 的个数
 */
public class 二进制 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(0)));
        System.out.println(Arrays.toString(solution(2)));
        System.out.println(Arrays.toString(solution(8)));
    }

    public static int[] solution(int n) {
        if (n == 0) {
            return new int[]{0};
        }
        int temp = 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i == temp * 2) {
                temp *= 2;
                dp[i] = 1;
            } else {
                dp[i] = 1 + dp[i - temp];
            }
        }
        return dp;
    }
}