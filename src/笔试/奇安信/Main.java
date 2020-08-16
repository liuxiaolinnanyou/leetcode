package 笔试.奇安信;

import java.util.Scanner;

/**
 * 发工资问题。
 * 输入：2
 * 输出：2
 * <p>
 * 输入：3
 * 输出：4
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(calulateMethodCount(sc.nextInt()));
        }
    }

    public static int calulateMethodCount(int num_money) {
        int[] dp = new int[num_money + 1];
        dp[0] = 1;
        for (int i = 1; i <= num_money; i++) {
            for (int j = 1; j <= num_money; j++) {
                if (i >= j) {
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[num_money];
    }
}