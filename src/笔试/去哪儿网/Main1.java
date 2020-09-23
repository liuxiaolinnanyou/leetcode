package 笔试.去哪儿网;


import java.util.Scanner;

/**
 * 两个排序序列：
 * 把意见一致的先放上去。
 * <p>
 * 输入：
 * 7
 * a b c d e f g
 * b d a c f g e
 * 输出：
 * 4      4(b d f g)
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] str1 = sc.nextLine().split(" ");
        String[] str2 = sc.nextLine().split(" ");
        if (str1.length == 0 || str2.length == 0) {
            System.out.println(0);
            return;
        }
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int[][] dp = new int[n][n];
        dp[0][0] = str1[0].equals(str2[0]) ? 1 : 0;
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], str1[0].equals(str2[i]) ? 1 : 0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    if (str1[i].equals(str2[j])) {
                        dp[i][j] = 1;
                    }
                } else {
                    if (str1[i].equals(str2[j])) {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j] + 1);
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }
}