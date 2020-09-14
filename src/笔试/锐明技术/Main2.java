package 笔试.锐明技术;

import java.util.Scanner;

public class Main2 {
    public static int coinChange(int[] coins, int amount) {
        if (coins.length <= 0 || amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int dp[] = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            int num = 0;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && dp[i - coins[j]] != -1) {
                    num++;
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
            if (num == 0) {
                dp[i] = -1;
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int[] num = new int[s1.length - 1];
        for (int i = 0; i < s1.length - 1; i++) {
            num[i] = Integer.parseInt(s1[i]);
        }
        int n = Integer.parseInt(s1[s1.length - 1]);
        System.out.println(coinChange(num, n));
    }
}
